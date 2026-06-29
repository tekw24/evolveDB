package de.thm.evolvefb.openai.connector;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import java.nio.file.Files;
import java.nio.file.Path;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.osgi.framework.FrameworkUtil;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import com.openai.models.chat.completions.ChatCompletionMessageParam;
import com.openai.models.chat.completions.ChatCompletionSystemMessageParam;
import com.openai.models.chat.completions.ChatCompletionUserMessageParam;
import java.lang.reflect.InvocationTargetException;

import de.thm.evolvedb.openai.preferences.OpenAIPreferencePage;

public class OpenAIConnect {

	private final OpenAIClient client;
	private final String systemPrompt;

	public OpenAIConnect() {
		this.systemPrompt = PromptLoader.loadSystemPrompt();
		String key = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				String.valueOf(FrameworkUtil.getBundle(getClass()).getBundleId()))
				.getString(OpenAIPreferencePage.PREF_API_KEY);
		

		this.client = OpenAIOkHttpClient.builder()
	            .apiKey(key)
	            .build();

	}

//	public String compareModels(Resource modelA, Resource modelB) {
//		String userPrompt = ModelPromptHelper.buildComparisonPrompt(modelA, modelB);
//		System.out.println(userPrompt);
//
//		String jsonResult = askOpenAi(systemPrompt, userPrompt);
//
//		saveJsonResultWithDialog(modelA, jsonResult);
//
//		return jsonResult;
//	}
	
	public String compareModels(Resource modelA, Resource modelB) {
		Shell shell = getActiveShell();

		final String[] resultHolder = new String[1];
		final Exception[] exceptionHolder = new Exception[1];

		ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);

		try {
			dialog.run(true, true, new IRunnableWithProgress() {

				@Override
				public void run(IProgressMonitor monitor) {
					try {
						monitor.beginTask("Compare models with OpenAI", 100);

						monitor.subTask("Loading models...");
						if (monitor.isCanceled()) {
							return;
						}
						monitor.worked(10);

						monitor.subTask("Creating prompt...");
						String userPrompt = ModelPromptHelper.buildComparisonPrompt(modelA, modelB);
						System.out.println(userPrompt);
						monitor.worked(20);

						if (monitor.isCanceled()) {
							return;
						}

						monitor.subTask("Sending request to OpenAI...");
						String jsonResult = askOpenAi(systemPrompt, userPrompt);
						monitor.worked(60);

						if (monitor.isCanceled()) {
							return;
						}

						monitor.subTask("Preparing JSON result...");
						resultHolder[0] = jsonResult;
						monitor.worked(10);

					} catch (Exception e) {
						exceptionHolder[0] = e;
					} finally {
						monitor.done();
					}
				}
			});
		} catch (InvocationTargetException | InterruptedException e) {
			showError(shell, "OpenAI comparison failed", e.getMessage());
			return "";
		}

		if (exceptionHolder[0] != null) {
			showError(shell, "OpenAI comparison failed", exceptionHolder[0].getMessage());
			return "";
		}

		String jsonResult = resultHolder[0];

		if (jsonResult == null || jsonResult.isBlank()) {
			showError(shell, "No result", "The OpenAI response was empty or the operation was cancelled.");
			return "";
		}

		saveJsonResultWithDialog(modelA, jsonResult);

		return jsonResult;
	}

	public String askOpenAi(String systemPrompt, String userPrompt) {

		ChatCompletionCreateParams params = ChatCompletionCreateParams.builder().model(ChatModel.GPT_5_1).maxCompletionTokens(50000)
				.messages(List.of(
						ChatCompletionMessageParam
								.ofSystem(ChatCompletionSystemMessageParam.builder().content(systemPrompt).build()),
						ChatCompletionMessageParam
								.ofUser(ChatCompletionUserMessageParam.builder().content(userPrompt).build())))
				.build();

		ChatCompletion completion = client.chat().completions().create(params);

		Optional<String> response = completion.choices().get(0).message().content();
		String res = "";
		if (response.isPresent()) {
			res = response.get();
			System.out.println(res);
		} else {
			System.out.println("No Response");
		}

		return res;
	}
	
	
	private void saveJsonResultWithDialog(Resource modelA, String jsonResult) {
		if (jsonResult == null || jsonResult.isBlank()) {
			throw new IllegalStateException("Cannot save JSON result because the OpenAI response is empty.");
		}

		Display display = PlatformUI.getWorkbench().getDisplay();

		display.syncExec(() -> {
			Shell shell = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow()
					.getShell();

			FileDialog dialog = new FileDialog(shell, SWT.SAVE);
			dialog.setText("Save Model Difference as JSON");
			dialog.setFilterExtensions(new String[] { "*.json", "*.*" });
			dialog.setFilterNames(new String[] { "JSON Files (*.json)", "All Files (*.*)" });
			dialog.setFileName(createDefaultJsonFileName(modelA));

			String selectedPath = dialog.open();

			if (selectedPath == null) {
				System.out.println("Saving JSON result was cancelled by the user.");
				return;
			}

			Path outputPath = Path.of(ensureJsonExtension(selectedPath));

			try {
				Files.writeString(outputPath, jsonResult, StandardCharsets.UTF_8);
				System.out.println("JSON result written to: " + outputPath.toAbsolutePath());
			} catch (IOException e) {
				throw new IllegalStateException("Could not write JSON result to: " + outputPath, e);
			}
		});
	}

	private String createDefaultJsonFileName(Resource modelA) {
		if (modelA == null || modelA.getURI() == null) {
			return "model_diff.json";
		}

		String lastSegment = modelA.getURI().lastSegment();

		if (lastSegment == null || lastSegment.isBlank()) {
			return "model_diff.json";
		}

		int lastDot = lastSegment.lastIndexOf('.');
		String baseName = lastDot > 0 ? lastSegment.substring(0, lastDot) : lastSegment;

		return baseName + "_diff.json";
	}

	private String ensureJsonExtension(String path) {
		if (path.toLowerCase().endsWith(".json")) {
			return path;
		}

		return path + ".json";
	}
	
	private Shell getActiveShell() {
		Display display = PlatformUI.getWorkbench().getDisplay();

		if (display.getThread() == Thread.currentThread()) {
			return PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow()
					.getShell();
		}

		final Shell[] shellHolder = new Shell[1];

		display.syncExec(() -> shellHolder[0] = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow()
				.getShell());

		return shellHolder[0];
	}

	private void showError(Shell shell, String title, String message) {
		Display display = PlatformUI.getWorkbench().getDisplay();

		display.asyncExec(() -> {
			Shell activeShell = shell != null ? shell : getActiveShell();
			MessageDialog.openError(activeShell, title, message != null ? message : "Unknown error.");
		});
	}
	
	
	
	
	
	
}

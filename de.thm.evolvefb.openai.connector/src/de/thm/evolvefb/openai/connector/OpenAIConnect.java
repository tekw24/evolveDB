package de.thm.evolvefb.openai.connector;

import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.resource.Resource;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import com.openai.models.chat.completions.ChatCompletionMessageParam;
import com.openai.models.chat.completions.ChatCompletionSystemMessageParam;
import com.openai.models.chat.completions.ChatCompletionUserMessageParam;

public class OpenAIConnect {

	private final OpenAIClient client;
	private final String systemPrompt;
	
    public OpenAIConnect() {
        this.systemPrompt = PromptLoader.loadSystemPrompt();
        this.client = OpenAIOkHttpClient.fromEnv();
    }

    public String compareModels(Resource modelA, Resource modelB) {
        String userPrompt = ModelPromptHelper.buildComparisonPrompt(modelA, modelB);
        return askOpenAi(systemPrompt, userPrompt);
    }
    
    public String askOpenAi(String systemPrompt, String userPrompt) {

        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(ChatModel.GPT_5_1)
                .messages(List.of(
                        ChatCompletionMessageParam.ofSystem(ChatCompletionSystemMessageParam.builder().content(systemPrompt).build()),
                        ChatCompletionMessageParam.ofUser(ChatCompletionUserMessageParam.builder().content(userPrompt).build())
                ))
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
}






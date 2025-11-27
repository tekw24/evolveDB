package de.thm.evolvefb.openai.connector;

import java.util.Optional;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

public class OpenAIConnect {

	public String askOpenAi(String userPrompt) {
		// Nutzt OPENAI_API_KEY / OPENAI_ORG_ID / OPENAI_PROJECT_ID aus Env oder
		// Systemprops
		OpenAIClient client = OpenAIOkHttpClient.fromEnv();

		ChatCompletionCreateParams params = ChatCompletionCreateParams.builder().addUserMessage(userPrompt)
				.model(ChatModel.GPT_5_1) // oder ein anderes Modell
				.build();

		ChatCompletion completion = client.chat().completions().create(params);

		Optional<String> response = completion.choices().get(0).message().content();
		String res = "";
		if(response.isPresent()) {
			res = response.get();
			System.out.println(res);
		}else 
			System.out.println("No Response");
		
		return res;
	}
}
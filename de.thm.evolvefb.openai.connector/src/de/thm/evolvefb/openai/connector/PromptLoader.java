package de.thm.evolvefb.openai.connector;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class PromptLoader {
	
	public static String loadResource(String path) {
	    try (InputStream is = OpenAIConnect.class.getResourceAsStream(path)) {
	        return new String(is.readAllBytes(), StandardCharsets.UTF_8);
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public static String loadSystemPrompt() {
		return  loadResource("/prompts/systemPrompt.txt");
	}
	
	
	

}

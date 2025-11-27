package de.thm.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import de.thm.evolvefb.openai.connector.OpenAIConnect;

public class ConnectToOpenAiApi extends AbstractHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		OpenAIConnect openAiConnect = new OpenAIConnect();
		String res = openAiConnect.askOpenAi("Dies ist ein Aufruf aus Eclipse als Test über meinen neu erstellten API Key. Sag doch einfach mal etwas nettes.");
		
		System.out.println(res);
		
		return null;
	}

}

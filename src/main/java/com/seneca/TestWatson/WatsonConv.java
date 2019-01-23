package com.seneca.TestWatson;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class WatsonConv {
	
	public Map contxt = new HashMap();
public String mainMethod(String input, Map context )
{
	MessageResponse response = null;
	response = conversationAPI(input,context); 
	System.out.println("Watson Response:"+ response.getText().get(0));
	context = response.getContext();
	System.out.println(context.get("userid"));
	contxt.putAll(context);
	return response.getText().get(0);
}
	public Map rtnContext() { return contxt; }
	
	public static MessageResponse conversationAPI(String input,Map context)
	{
		ConversationService service = new ConversationService("2017-11-17");
		service.setUsernameAndPassword("2e5f4c89-5fc5-4b30-b3d2-bf93b8db72cb", "jRC2zLc0vlyV");
		MessageRequest newMessage = new MessageRequest.Builder()
				.inputText(input).context(context).build();
		String workspaceId = "c0002aee-4fac-4e4a-8f73-2d7526a614bc";
		MessageResponse response = service.message(workspaceId, newMessage).execute();
		return response;
	}
}
package com.seneca.TestWatson;

import java.util.HashMap;
import java.util.Map;

public class CallConversation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WatsonConv wc = new WatsonConv();
		String input = "Can you reset my user id";
		Map context = new HashMap();
		String op = wc.mainMethod(input, context);
		System.out.println(op);
		System.out.println(wc.rtnContext());

		input = "My user id is Danny";
		op = wc.mainMethod(input, wc.rtnContext());
		System.out.println(op);
		System.out.println(wc.rtnContext().get("userid"));
	}

}

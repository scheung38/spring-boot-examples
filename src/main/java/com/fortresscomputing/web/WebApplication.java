package com.fortresscomputing.web;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication implements CommandLineRunner {

	@Autowired
	OpenAiChatModel chatModel;

	@Override
	public void run(String... args) throws Exception {
		Prompt prompt = new Prompt("What is the capital of Hong Kong?");
		ChatResponse response = chatModel.call(prompt);
		System.out.println(response.getResult().getOutput().getText());
	}

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}

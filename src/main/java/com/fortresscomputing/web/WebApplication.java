package com.fortresscomputing.web;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebApplication implements CommandLineRunner {

	@Autowired
	OpenAiChatModel chatModel;

	// http://localhost:8080/joke/dad

	@GetMapping("/joke/{type}")
	public String funnyJokes(@PathVariable String type) {
		String input = String.format("Tell me a random %s joke", type);
		Prompt prompt = new Prompt(input);
		ChatResponse response = chatModel.call(prompt);
		return response.getResult().getOutput().getText();
	}

	// Console display from CommandLineRunner
	@Override
	public void run(String... args) throws Exception {
		Prompt prompt = new Prompt("What is the capital of Thailand?");
		ChatResponse response = chatModel.call(prompt);
		System.out.println(response.getResult().getOutput().getText());
	}

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}

package com.fortresscomputing.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;

@RestController
public class JokesController {

    @Autowired
    private OpenAiChatModel chatModel;

    @GetMapping("/joke/{type}")
    public String funnyJokes(@PathVariable String type) {
        String input = String.format("Tell me a random %s joke", type);
        Prompt prompt = new Prompt(input);
        ChatResponse response = chatModel.call(prompt);
        return response.getResult().getOutput().getText();
    }
}

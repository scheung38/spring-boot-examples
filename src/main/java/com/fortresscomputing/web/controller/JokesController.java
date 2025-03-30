package com.fortresscomputing.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fortresscomputing.web.service.JokesService;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;

@RestController
@RequestMapping("/jokes")
public class JokesController {

    @Value("${spring.ai.openai.api-key}")
    String mykey;

    @Value("#{systemProperties['user.name']}")
    String myname;

    @Autowired
    private OpenAiChatModel chatModel;

    @Autowired
    private JokesService jokesService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return jokesService.greet(name);
    }

    public String funnyJoke() {
        String input = "Tell me a random joke";
        Prompt prompt = new Prompt(input);
        ChatResponse response = chatModel.call(prompt);
        return response.getResult().getOutput().getText();
    }

    @GetMapping("/joke/{type}")
    public String funnyJokes(@PathVariable String type) {
        System.out.println("mykey: " + mykey);
        System.out.println("myname: " + myname);
        String input = String.format("Tell me a random %s joke", type);
        Prompt prompt = new Prompt(input);
        ChatResponse response = chatModel.call(prompt);
        return response.getResult().getOutput().getText();
    }
}

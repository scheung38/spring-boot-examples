package com.fortresscomputing.web.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class JokesService {

    // Test:
    // call localhost:8080/jokes/hello/lucas twice;
    // the second call will use the cache (no console log).
    @Cacheable("greetings")
    public String greet(String name) {
        System.out.println("Calculating greeting for " + name);
        return "Hello, " + name + "!";
    }

}

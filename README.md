# Spring Boot Annotations Learning Project

This project is designed to help you learn and understand various Spring Boot annotations through practical examples. It demonstrates how to use annotations to build a simple web application with RESTful endpoints.

## Key Features

- **Spring Boot Annotations**: Learn how to use annotations like `@SpringBootApplication`, `@RestController`, `@GetMapping`, and `@Autowired`.
- **RESTful Web Services**: Explore how to create RESTful endpoints using Spring Boot.
- **OpenAI Integration**: See how to integrate external APIs like OpenAI for dynamic content generation.
- **Code Organization**: Understand how to structure your code using controllers and services.

## Getting Started

1. Clone the repository.
2. Run the application using `mvn spring-boot:run`.
3. Access the joke selector UI at `http://localhost:8080`.

## Annotations Covered

- `@SpringBootApplication`: Marks the main class of a Spring Boot application.
- `@RestController`: Combines `@Controller` and `@ResponseBody` for RESTful web services.
- `@GetMapping`: Maps HTTP GET requests to specific handler methods.
- `@Autowired`: Automatically injects bean dependencies.
- `@PathVariable`: Binds a method parameter to a URI template variable.

## Example Endpoint

```java
@GetMapping("/joke/{type}")
public String funnyJokes(@PathVariable String type) {
    String input = String.format("Tell me a random %s joke", type);
    Prompt prompt = new Prompt(input);
    ChatResponse response = chatModel.call(prompt);
    return response.getResult().getOutput().getText();
}
```

## Contributing

Feel free to contribute by adding more examples or improving the existing ones. Pull requests are welcome!

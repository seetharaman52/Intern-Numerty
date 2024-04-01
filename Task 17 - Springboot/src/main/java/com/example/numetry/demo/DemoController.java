package com.example.numetry.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class DemoController {
    @RequestMapping("/demo")
    public String hello() {
        return "Hello World";
    }
}

//@SpringBootApplication
//Marks the main class of a Spring Boot application.
//Combines @Configuration, @EnableAutoConfiguration, and @ComponentScan annotations.

//@RestController
//Indicates that a class is a RESTful controller.
//Defines RESTful web services and handles HTTP requests.
//Automatically serializes return objects to JSON/XML.

//@Autowired
//Injects a dependency into a Spring-managed bean.
//Simplifies dependency injection by automatically wiring beans together.

//@Service
//Marks a class as a service component in the business layer.
//Typically used to encapsulate business logic and data manipulation operations.

//@Repository
//Indicates that a class is a repository for data access.
//Used with Spring Data to define data access interfaces, allowing for CRUD operations on entities.

//@Component
//Marks a class as a Spring component.
//Automatically detects and registers the annotated class as a bean in the Spring application context.

//@Configuration
//Indicates that a class provides bean definitions.
//Defines Spring beans and their dependencies, replacing XML-based configuration.

//@RequestMapping
//Maps HTTP requests to handler methods in a controller.
//Defines the URL patterns that trigger specific methods in a controller class.

//@PathVariable
//Extracts values from the URI path in a Spring MVC controller.
//Captures dynamic values from the URL to use as parameters in controller methods.

//@RequestBody
//Binds HTTP request body to a method parameter.
//Used in RESTful web services to map the request body (e.g., JSON) to a Java object.

//@RequestParam
//Binds HTTP request parameters to method parameters.
//Retrieves query parameters from the URL or form data from a POST request.

//@ResponseBody
//Indicates that a method return value should be bound to the HTTP response body.
//Converts method return values to JSON or XML and sends them as the HTTP response.

//@Transactional
//Defines the scope of a single database transaction.
//Ensures that a method executes within a transactional context, supporting ACID properties.
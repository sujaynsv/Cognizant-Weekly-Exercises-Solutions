package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * SpringApplicationBootstrap - Entry point for Spring framework demonstration
 * This class showcases the initialization and utilization of Spring's 
 * Inversion of Control container for dependency management and bean lifecycle.
 */
public class MainApp {
    
    /**
     * Application entry point that establishes Spring context and demonstrates
     * dependency injection through XML configuration-based bean management.
     * 
     * @param args Command line arguments (unused in this demonstration)
     */
    public static void main(String[] args) {
        // Initialize Spring IoC container with XML configuration
        ApplicationContext springContainer = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Retrieve managed bean instance from the container
        BookService libraryService = (BookService) springContainer.getBean("bookService");
        
        // Execute business logic through the injected service
        libraryService.addBook(); 
    }
}
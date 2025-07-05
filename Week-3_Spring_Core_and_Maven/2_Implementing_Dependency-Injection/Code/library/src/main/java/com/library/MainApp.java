package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * DependencyInjectionDemonstrator - Showcases advanced Spring DI capabilities
 * This application demonstrates type-safe bean retrieval and proper resource
 * management with Spring's ApplicationContext including cleanup operations.
 */
public class MainApp {
    
    /**
     * Application launcher demonstrating enhanced dependency injection patterns.
     * Shows type-safe bean retrieval and proper context lifecycle management
     * with resource cleanup to prevent memory leaks.
     * 
     * @param args Command line parameters (not utilized in this demonstration)
     */
    public static void main(String[] args) {
        // Establish Spring IoC container with XML-based configuration
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Retrieve typed bean instance with enhanced type safety
        BookService libraryManagementService = iocContainer.getBean("bookService", BookService.class);

        // Execute core business functionality through injected dependencies
        libraryManagementService.addBook();
        
        // Properly close context to ensure resource cleanup and prevent leaks
        if (iocContainer instanceof ClassPathXmlApplicationContext) {
            ((ClassPathXmlApplicationContext) iocContainer).close();
        }
    }
}
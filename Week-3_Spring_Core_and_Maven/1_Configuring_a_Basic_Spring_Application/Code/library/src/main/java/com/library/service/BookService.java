package com.library.service;

import com.library.repository.BookRepository;

/**
 * BookManagementService - Business logic layer for library book operations
 * This service class encapsulates book-related business operations and
 * demonstrates dependency injection patterns with repository layer integration.
 * Acts as an intermediary between presentation and data access layers.
 */
public class BookService {
    
    // Repository dependency for data persistence operations
    private BookRepository dataAccessLayer;

    /**
     * Setter method for dependency injection of repository component.
     * Spring framework uses this method to inject the repository dependency
     * during bean instantiation and wiring process.
     * 
     * @param repositoryComponent The book repository implementation to inject
     */
    public void setBookRepository(BookRepository repositoryComponent) {
        this.dataAccessLayer = repositoryComponent;
    }

    /**
     * Business method to handle book addition operations.
     * Delegates the actual persistence operation to the injected repository
     * while maintaining separation of concerns between layers.
     */
    public void addBook() {
        dataAccessLayer.save();
    }
}
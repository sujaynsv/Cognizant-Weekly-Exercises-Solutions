package com.library.service;

import com.library.repository.BookRepository;

/**
 * LibraryBookService - Enhanced service layer with sophisticated dependency injection
 * This service component demonstrates advanced Spring DI patterns and provides
 * a clean abstraction for book management operations within the library system.
 * Maintains loose coupling through dependency injection principles.
 */
public class BookService {
    
    // Injected repository dependency for data persistence operations
    private BookRepository persistenceLayer;

    /**
     * Dependency injection setter for repository component.
     * Spring container utilizes this method to inject the appropriate
     * repository implementation during the bean wiring phase.
     * 
     * @param repositoryImplementation The repository instance to be injected
     */
    public void setBookRepository(BookRepository repositoryImplementation) {
        this.persistenceLayer = repositoryImplementation;
    }

    /**
     * Core business operation for adding books to the library collection.
     * Coordinates with the persistence layer to ensure proper data storage
     * while maintaining separation between business logic and data access.
     */
    public void addBook() {
        persistenceLayer.save();
    }
}
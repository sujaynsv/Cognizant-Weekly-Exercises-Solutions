package com.cognizant.orm_learn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Nation Entity - Represents geographical territories in the database
 * This JPA entity maps to the country table and encapsulates 
 * basic nation information including identification codes and names
 */
@Entity 
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "co_code")
    private String countryCode;

    @Column(name = "co_name")
    private String countryName;

    /**
     * Retrieves the nation's identification code
     * @return The country code identifier
     */
    public String getCode() { 
        return countryCode; 
    }
    
    /**
     * Sets the nation's identification code
     * @param code The country code to assign
     */
    public void setCode(String code) { 
        this.countryCode = code; 
    }

    /**
     * Retrieves the nation's display name
     * @return The country name
     */
    public String getName() { 
        return countryName; 
    }
    
    /**
     * Sets the nation's display name
     * @param name The country name to assign
     */
    public void setName(String name) { 
        this.countryName = name; 
    }

    /**
     * Generates string representation of the nation entity
     * @return Formatted string containing country details
     */
    @Override
    public String toString() {
        return "Country{" + "code='" + countryCode + '\'' + ", name='" + countryName + '\'' + '}';
    }
}

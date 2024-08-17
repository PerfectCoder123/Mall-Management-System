package com.shop.entities;

import jakarta.persistence.Entity;

/**
 * Represents a mall administrator, which is a specialized type of user.
 * A mall administrator has administrative responsibilities at the mall level.
 */
@Entity
public class MallAdmin extends User {
    // Inherits properties and methods from the User class
}

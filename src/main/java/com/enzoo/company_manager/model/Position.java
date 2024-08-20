package com.enzoo.company_manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "positions", uniqueConstraints = @UniqueConstraint(name = "UniqueTitle", columnNames = { "title" }))
public class Position {

    // Empty constructor to let Hibernate instantiate an object using reflection
    public Position() {
    }

    public Position(String title, String notes) {
        this.title = title;
        this.notes = notes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String notes;

}

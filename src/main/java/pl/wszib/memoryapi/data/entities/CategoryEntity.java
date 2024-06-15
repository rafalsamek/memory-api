package pl.wszib.memoryapi.data.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Date createdDate;

    public CategoryEntity(String name) {
        this.name = name;
    }

    public CategoryEntity() {
    }

    @PrePersist
    public void prePersist() {
        createdDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
}

package ru.emelkrist.todoapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.Instant;

@Data
@Entity
@Table(name = "todo_items")
/**
 * Класс - сущность в таблице базы данных - todo_items)
 */
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank(message = "Поле с описанием обязательно для заполнения!")
    @Column(name = "description")
    private String description;
    @Column(name = "isComplete")
    private Boolean isComplete;
    @Column(name = "createdAt")
    private Instant createdAt;
    @Column(name = "updatedAt")
    private Instant updatedAt;

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isComplete=" + isComplete +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

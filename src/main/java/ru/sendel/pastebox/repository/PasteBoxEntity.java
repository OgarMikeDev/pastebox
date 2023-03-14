package ru.sendel.pastebox.repository;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "Etity")
@Entity
public class PasteBoxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String data;

    private String hash;

    @Column(name = "life_time")
    private LocalDateTime lifeTime;

    @Column(name = "is_public")
    private boolean isPublic;
}

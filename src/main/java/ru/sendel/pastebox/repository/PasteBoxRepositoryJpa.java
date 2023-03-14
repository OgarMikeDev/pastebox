package ru.sendel.pastebox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasteBoxRepositoryJpa extends JpaRepository<PasteBoxEntity, Integer> {
}

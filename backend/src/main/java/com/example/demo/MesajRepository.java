package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MesajRepository extends JpaRepository<Mesaj, Long> {
    Optional<Mesaj> findTopByOrderByCreatedAtDesc();
}

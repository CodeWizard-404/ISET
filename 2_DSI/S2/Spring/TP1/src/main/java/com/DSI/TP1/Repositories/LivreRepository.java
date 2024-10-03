package com.DSI.TP1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DSI.TP1.Entities.Livre;

public interface LivreRepository extends JpaRepository<Livre, Integer> {

}


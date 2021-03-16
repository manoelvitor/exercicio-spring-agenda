package com.agenda.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenda.api.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}

package com.seeds.neuroapp.repository;

import com.seeds.neuroapp.model.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntasRepository extends JpaRepository<Pergunta, Long> {
}

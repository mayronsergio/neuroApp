package com.seeds.neuroapp.repository;

import com.seeds.neuroapp.model.OpcoesPerguntas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcoesPerguntasRepository extends JpaRepository<OpcoesPerguntas, Long> {
}

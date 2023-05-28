package com.seeds.neuroapp.repository;

import com.seeds.neuroapp.model.AvaliacaoOpcoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoOpcoesRepository extends JpaRepository<AvaliacaoOpcoes, Long> {
}

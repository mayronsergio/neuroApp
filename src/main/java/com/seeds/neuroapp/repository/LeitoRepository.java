package com.seeds.neuroapp.repository;

import com.seeds.neuroapp.model.Leito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeitoRepository extends JpaRepository<Leito, Long> {
}

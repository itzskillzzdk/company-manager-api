package com.enzoo.company_manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enzoo.company_manager.model.Position;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long> {
}

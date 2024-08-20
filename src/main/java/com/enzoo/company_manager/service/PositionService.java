package com.enzoo.company_manager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enzoo.company_manager.model.Position;
import com.enzoo.company_manager.repository.PositionRepository;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    // Create
    public Position savePosition(Position position) {
        return positionRepository.save(position);
    }

    // Read all
    public Iterable<Position> getAllPosition() {
        return positionRepository.findAll();
    }

    // Read by ID
    public Optional<Position> getPositionByID(final Long id) {
        return positionRepository.findById(id);
    }

    // Delete
    public void deletePosition(final Long id) {
        positionRepository.deleteById(id);
    }
}

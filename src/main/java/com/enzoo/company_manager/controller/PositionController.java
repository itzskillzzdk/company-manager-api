package com.enzoo.company_manager.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enzoo.company_manager.model.Position;
import com.enzoo.company_manager.service.PositionService;

@RestController
@RequestMapping("/positions")
public class PositionController {

    @Autowired
    private PositionService positionService;

    // Create
    @PostMapping(consumes = {})
    public Position savePosition(@RequestBody Position position) {
        return positionService.savePosition(position);
    }

    // Get all
    @GetMapping
    public Iterable<Position> getAllPosition() {
        return positionService.getAllPosition();
    }

    // Get by ID
    @GetMapping("/{id}")
    public Position getPositionById(@PathVariable final Long id) {
        Optional<Position> position = positionService.getPositionByID(id);
        return position.orElse(null);
    }

    // Update
    @PutMapping("/{id}")
    public Position updatePosition(@PathVariable final Long id, @RequestBody Position position) {
        Optional<Position> p = positionService.getPositionByID(id);
        return p.map(newPosition -> {
            Optional.ofNullable(position.getTitle()).ifPresent(newPosition::setTitle);
            Optional.ofNullable(position.getNotes()).ifPresent(newPosition::setNotes);
            return positionService.savePosition(newPosition);
        }).orElse(null);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deletePosition(@PathVariable final Long id) {
        positionService.deletePosition(id);
    }

}

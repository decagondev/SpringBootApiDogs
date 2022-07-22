package com.decadev.controllers;

import com.decadev.entities.Cat;
import com.decadev.repositories.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {
    @Autowired
    private CatRepository catRepository;

    @PostMapping
    public Cat save(@RequestBody Cat cat) {
        return catRepository.save(cat);
    }

    @GetMapping("/{id}")
    public Cat findById(@PathVariable(value = "id") String id) {
        return catRepository.findById(id);
    }

    @GetMapping
    public List<Cat> findAll() {
        return catRepository.findAll();
    }

    @PutMapping("{id}")
    public String update(@PathVariable(value = "id") String id, @RequestBody Cat cat) {
        return catRepository.update(id, cat);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable(value = "id") String id) {
        return catRepository.delete(id);
    }

}

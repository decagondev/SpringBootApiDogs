package com.decadev.controllers;

import com.decadev.entities.Dog;
import com.decadev.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {

    @Autowired
    private DogRepository dogRepository;

    @PostMapping
    public Dog save(@RequestBody Dog dog) {
        return dogRepository.save(dog);
    }

    @GetMapping("/{id}")
    public Dog findById(@PathVariable(value = "id") String id) {
        return dogRepository.findById(id);
    }

    @GetMapping
    public List<Dog> findAll() {
        return dogRepository.findAll();
    }

    @PutMapping("{id}")
    public String update(@PathVariable(value = "id") String id, @RequestBody Dog dog) {
        return dogRepository.update(id, dog);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable(value = "id") String id) {
        return dogRepository.delete(id);
    }
}

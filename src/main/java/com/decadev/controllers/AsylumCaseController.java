package com.decadev.controllers;

import com.decadev.entities.AsylumCase;
import com.decadev.repositories.AsylumCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cases")
public class AsylumCaseController {

    @Autowired
    private AsylumCaseRepository acRepository;

    @PostMapping
    public AsylumCase save(@RequestBody AsylumCase ac) {
        return acRepository.save(ac);
    }

    @GetMapping("/{id}")
    public AsylumCase findById(@PathVariable(value = "id") String id) {
        return acRepository.findById(id);
    }

    @GetMapping
    public List<AsylumCase> findAll() {
        return acRepository.findAll();
    }

    @PutMapping("{id}")
    public String update(@PathVariable(value = "id") String id, @RequestBody AsylumCase ac) {
        return acRepository.update(id, ac);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable(value = "id") String id) {
        return acRepository.delete(id);
    }
}

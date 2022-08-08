package com.alexsExample.springboot.service.impl;

import com.alexsExample.springboot.exception.ResourceNotFoundException;
import com.alexsExample.springboot.model.Cat;
import com.alexsExample.springboot.repository.CatRepository;
import com.alexsExample.springboot.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatServiceImplement implements CatService {
    private CatRepository catRepo;

    @Autowired
    public CatServiceImplement(CatRepository catRepo) {
        super();
        this.catRepo = catRepo;
    }

    @Override
    public Cat saveCat(Cat cat) {
        return catRepo.save(cat);
    }

    @Override
    public List<Cat> getAllCats() {
        return catRepo.findAll();
    }

    @Override
    public Cat getCatById(long id) {
        Optional<Cat> cat = catRepo.findById(id);

            return cat.get();

    }

    @Override
    public Cat updateCat(Cat cat, long id) {

        Cat realCat = catRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cat", "Id", id));

        realCat.setName(cat.getName());
        realCat.setImage_url(cat.getImage_url());
        realCat.setDescription(cat.getDescription());
        catRepo.save(realCat);
        return realCat;
    }

    @Override
    public void deleteCat(long id) {
        catRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cat", "Id", id));

        catRepo.deleteById(id);
    }
}

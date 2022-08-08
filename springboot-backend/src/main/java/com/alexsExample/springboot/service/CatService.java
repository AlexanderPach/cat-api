package com.alexsExample.springboot.service;

import com.alexsExample.springboot.model.Cat;

import java.util.List;

public interface CatService {
    Cat saveCat(Cat cat);
    List<Cat> getAllCats();
    Cat getCatById(long id);
    Cat updateCat(Cat cat, long id);
    void deleteCat(long id);
}

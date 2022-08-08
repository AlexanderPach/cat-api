package com.alexsExample.springboot.controller;

import com.alexsExample.springboot.model.Cat;
import com.alexsExample.springboot.service.CatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cats")
public class CatController {

    private CatService catService;

    public CatController(CatService catService) {
        super();
        this.catService = catService;
    }

    //build create CAT (REST API)
    @PostMapping()
    public ResponseEntity<Cat> saveCat(@RequestBody Cat cat){
        return new ResponseEntity<>(catService.saveCat(cat), HttpStatus.CREATED);
    }

    //get all cats REST API
    @GetMapping
    public List<Cat> getAllCats(){
        return catService.getAllCats();
    }

    //get a cat by their iD
    @GetMapping("{id}")
    public ResponseEntity<Cat> getCatById(@PathVariable("id") long catId){
        return new ResponseEntity<Cat>(catService.getCatById(catId), HttpStatus.OK);
    }

    //UPDATE Cat
    @PutMapping("{id}")
    public ResponseEntity<Cat> updateCat(@PathVariable("id") long id,@RequestBody Cat cat){
        return new ResponseEntity<Cat>(catService.updateCat(cat,id), HttpStatus.OK);

    }

    //DELETE Cat
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCat(@PathVariable("id") long id){
        catService.deleteCat(id);

        return new ResponseEntity<String>("Cat Deleted!", HttpStatus.OK);
    }

}

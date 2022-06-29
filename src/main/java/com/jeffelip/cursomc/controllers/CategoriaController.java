package com.jeffelip.cursomc.controllers;

import com.jeffelip.cursomc.models.Categoria;
import com.jeffelip.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import com.jeffelip.cursomc.services.CategoriaService;
import com.jeffelip.cursomc.repositories.CategoriaRepository;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/categoria")
    public ResponseEntity<List<Categoria>> findAllCategorias(){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.listarCategorias());
    }

    @GetMapping("/categoria/{id}")
    public Categoria findByCategoria(@PathVariable(value = "id") Long id){
        return categoriaService.buscarPorCategoria(id);
    }

    @PostMapping("/categoria")
    public ResponseEntity saveCategoria(@RequestBody Categoria categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.salvarCategoria(categoria));
    }

    @DeleteMapping("/categoria/{id}")
    public  void deleteCategoria(@PathVariable(value = "id") Long id){
        categoriaService.deletarCategoria(id);
    }

    @PutMapping("/categoria/{id}")
    public ResponseEntity putCategoria(@PathVariable(value = "id") Long id, @RequestBody Categoria categoria){
        Categoria cat = categoriaService.buscarPorCategoria(id);
        categoria.setId(cat.getId());
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.salvarCategoria(categoria));
    }


}

package com.jeffelip.cursomc.services;

import com.jeffelip.cursomc.models.Categoria;
import com.jeffelip.cursomc.repositories.CategoriaRepository;
import com.jeffelip.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorCategoria(Long id){
        var obj = categoriaRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Categoria não encontrada para id: "+id));
    }

    public Categoria salvarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public  void deletarCategoria(Long id){
        categoriaRepository.deleteById(id);
    }

    public Categoria atualizarCategoria(Long id, Categoria categoria){
        var cat = categoriaRepository.findById(id).get();
        categoria.setId(cat.getId());
        return categoriaRepository.save(categoria);
    }

}

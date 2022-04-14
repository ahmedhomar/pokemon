package com.company.pokemon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static java.lang.Integer.parseInt;

@Service
 public class PokemonService {

    PokemonRepository repository;

    @Autowired
    public PokemonService(PokemonRepository repository) {
        this.repository = repository;
    }


    public Pokemon getPokemonById(@PathVariable String id) {
        for (Pokemon pokemon : repository.findAll()) {
            if (pokemon.getId() == parseInt(id)) {
                return pokemon;
            }
        }
        return null;
    }



     public List<Pokemon> getPokemonByName(String name){
         return repository.findByName(name);
     }

//     Get all

     public List<Pokemon> getAll(){
         return repository.findAll();
     }

//     Post
    public String postPokemon(Pokemon pokemon) {
        repository.save(pokemon);
        return "Greeting added";
    }


//    Delete

    public String deletePokemon(String id) {
        try {
            repository.deleteById(parseInt(id));
            return "Pokemon with id of: " + id + " was deleted";
        } catch (EmptyResultDataAccessException exception) {
            return "Pokemon with the id of :" + id + "doesn't exist, can't delete!";
        }
    }



 }

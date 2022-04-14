package com.company.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;

@RestController
public class PokemonController {
    PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    //    GET
    @GetMapping("/pokemon/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@RequestParam String id) {

        return ResponseEntity.status(HttpStatus.OK).body(pokemonService.getPokemonById(id));

    }


    @GetMapping("/pokemon")
    public ResponseEntity<List<Pokemon>> getAllPokemon() {

        return ResponseEntity.status(HttpStatus.OK).body(pokemonService.getAll());
    }

//    POST

    @PostMapping("/pokemon")
    public ResponseEntity<String> createPokemon(@RequestBody Pokemon pokemon) {

        return ResponseEntity.status(HttpStatus.OK).body(pokemonService.postPokemon(pokemon)) ;
    }

//    DELETE

    @DeleteMapping("/pokemon/{id}")
    public ResponseEntity<String> deletePokemon(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(pokemonService.deletePokemon(id));
    }
 

}

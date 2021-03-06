package com.finalcase.oaks.OaksFinalCase.controller;

import com.finalcase.oaks.OaksFinalCase.entity.Actor;
import com.finalcase.oaks.OaksFinalCase.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @PostMapping
    public ResponseEntity<Actor> saveActor(@RequestBody Actor actor){
        actorService.saveNewActor(actor);
        return ResponseEntity.ok(actor);
    }

    @GetMapping("/all")
    public List<Actor> getAllActors() {
        return actorService.listAllActors();
    }

    @GetMapping("/byGenre")
    public List<Actor> getAllByGenre(@RequestParam String genre){
        return actorService.listAllByGenre(genre);
    }

    @GetMapping("/{id}")
    public Actor GetActorByID(@PathVariable (value="id")Integer id){
        return actorService.getById(id);
    }
}

//    Exemplo de JSON para POST
/*
{
    "name": "Rafael",
    "doc": "30.303.303.3",
    "email": "rafaelferreira.dev3@gmail.com",
    "password": "123456",
    "price": 10,
    "relevance": 0,
    "genre": "Terror"
}
*/

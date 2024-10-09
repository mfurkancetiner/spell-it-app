package com.furkan.spell_it_app.controller;

import com.furkan.spell_it_app.model.Clip;
import com.furkan.spell_it_app.service.ClipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clips")
public class ClipController {

    @Autowired
    private ClipService clipService;


    @PostMapping
    public ResponseEntity<Clip> addClip(@RequestBody @Valid Clip clip){
        return new ResponseEntity<>(clipService.addClip(clip), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Clip>> getAllClips(){
        return new ResponseEntity<>(clipService.getAllClips(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Clip>> getTenUnseenClips(){
        return new ResponseEntity<>(clipService.getTenUnseenClips(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clip> getClip(@PathVariable("id") Long clipId){
        return new ResponseEntity<>(clipService.getClip(clipId), HttpStatus.OK);
    }


}

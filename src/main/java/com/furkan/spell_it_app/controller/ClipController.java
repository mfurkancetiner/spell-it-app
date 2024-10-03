package com.furkan.spell_it_app.controller;

import com.furkan.spell_it_app.model.Clip;
import com.furkan.spell_it_app.repositories.ClipRepository;
import com.furkan.spell_it_app.service.ClipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clips")
public class ClipController {

    @Autowired
    private ClipService clipService;

    @PostMapping
    public Clip addClip(@RequestBody @Valid Clip clip){
        return clipService.addClip(clip);
    }

    @GetMapping("/test")
    public String test(){
        return "hllo";
    }

    @GetMapping
    public List<Clip> getAllClips(){
        return clipService.getAllClips();
    }

    @GetMapping("/{id}")
    public Clip getClip(@PathVariable("id") Long clipId){
        return clipService.getClip(clipId);
    }


}

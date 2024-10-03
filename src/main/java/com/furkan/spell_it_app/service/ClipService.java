package com.furkan.spell_it_app.service;

import com.furkan.spell_it_app.model.Clip;
import com.furkan.spell_it_app.repositories.ClipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClipService {

    @Autowired
    private ClipRepository clipRepository;

    public Clip addClip(Clip clip){
        return clipRepository.save(clip);
    }

    public Clip getClip(Long clipId){
        return clipRepository.findById(clipId).orElseThrow(()->new RuntimeException("Clip not found"));
    }

    public List<Clip> getAllClips(){
        return clipRepository.findAll();
    }

    public void removeClip(Long clipId){
        Clip clip = getClip(clipId);
        clipRepository.deleteById(clipId);
    }

}

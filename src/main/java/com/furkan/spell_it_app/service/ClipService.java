package com.furkan.spell_it_app.service;

import com.furkan.spell_it_app.model.Clip;
import com.furkan.spell_it_app.model.User;
import com.furkan.spell_it_app.repositories.ClipRepository;
import com.furkan.spell_it_app.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClipService {

    @Autowired
    private ClipRepository clipRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private UserRepository userRepository;

    public Clip addClip(Clip clip){
        return clipRepository.save(clip);
    }

    public List<Clip> getTenUnseenClips(){

        // the purpose of this code is I want to get around 10 unseen clips and
        // that equation will on average will give me 10 clips user has not seen
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(username).get();
        long amountClips = clipRepository.count();
        long userAmountSeenClips = user.getAmountSeenClips();

        String sql = "SELECT * FROM clip ORDER BY RANDOM() LIMIT :limit";
        Query query = em.createNativeQuery(sql, Clip.class);
        query.setParameter("limit", 10 * amountClips / (amountClips - userAmountSeenClips));
        List<Clip> result = query.getResultList();
        result.removeAll(user.getSeenClips());
        return result;


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

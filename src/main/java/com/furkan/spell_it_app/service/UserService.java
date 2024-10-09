package com.furkan.spell_it_app.service;

import com.furkan.spell_it_app.model.Clip;
import com.furkan.spell_it_app.model.User;
import com.furkan.spell_it_app.repositories.ClipRepository;
import com.furkan.spell_it_app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClipRepository clipRepository;

    public List<Clip> getViewedClips(){
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(username).get();
        return user.getSeenClips();
    }

    public void markClipViewed(Long clipId){
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(username).get();
        List<Clip> seenClips = user.getSeenClips();
        Clip viewedClip = clipRepository.findById(clipId).get();
        if(seenClips.contains(viewedClip))
            return;
        seenClips.add(clipRepository.findById(clipId).get());
        user.setSeenClips(seenClips);
        user.setAmountSeenClips(user.getAmountSeenClips()+1);
        userRepository.save(user);
        return;
    }
}

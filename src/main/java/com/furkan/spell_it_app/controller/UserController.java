package com.furkan.spell_it_app.controller;

import com.furkan.spell_it_app.model.Clip;
import com.furkan.spell_it_app.model.User;
import com.furkan.spell_it_app.repositories.UserRepository;
import com.furkan.spell_it_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/viewed")
    public ResponseEntity<List<Clip>> getViewedClips(){
        return new ResponseEntity<>(userService.getViewedClips(), HttpStatus.OK);
    }

    @GetMapping("/markViewed/{id}")
    public ResponseEntity<String> markClipViewed(@PathVariable("id") Long clipId){
        userService.markClipViewed(clipId);
        return new ResponseEntity<>("Video marked as viewed", HttpStatus.OK);
    }
}

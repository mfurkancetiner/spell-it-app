package com.furkan.spell_it_app.repositories;

import com.furkan.spell_it_app.model.Clip;
import com.furkan.spell_it_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClipRepository extends JpaRepository<Clip, Long> {
    List<Clip> findByShow(String show);

}

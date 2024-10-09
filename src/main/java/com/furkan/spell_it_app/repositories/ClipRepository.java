package com.furkan.spell_it_app.repositories;

import com.furkan.spell_it_app.model.Clip;
import com.furkan.spell_it_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClipRepository extends JpaRepository<Clip, Long> {

    List<Clip> findByShow(String show);

//    @Query(value = "SELECT * FROM clip ORDER BY RANDOM() LIMIT 20", nativeQuery = true)
//    List<Clip> findRandomClips();


}

package com.example.gameLibrary.repository;

import com.example.gameLibrary.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Game findByName(String name);

    Game findByImageUrl(String imageUrl);
}

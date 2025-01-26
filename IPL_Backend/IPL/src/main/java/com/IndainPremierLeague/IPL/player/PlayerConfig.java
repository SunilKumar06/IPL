package com.IndainPremierLeague.IPL.player;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository playerRepository){
        return args -> {
            Player Dhoni = new Player("MS Dhoni","India","Batsman","Right-Handed Middle Order",42,7,7777,7,"Chennai Super Kings");
            Player Raina = new Player("Suresh Raina","India","Batsman","Left-Handed Top Order",38,3,3333,33,"Chennai Super Kings");
            playerRepository.saveAll(List.of(Dhoni, Raina));
            System.out.println("Success: Player Record Saved");
        };
    }
}

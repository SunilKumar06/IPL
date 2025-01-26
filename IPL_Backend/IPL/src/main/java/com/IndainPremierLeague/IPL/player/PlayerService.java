package com.IndainPremierLeague.IPL.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers()
    {
        return playerRepository.findAll();
    }

    public List<Player> getPlayersFromTeam(String teamName)
    {
        return playerRepository.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayerByName(String searchName)
    {
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(searchName.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByRole(String searchRole)
    {
        return playerRepository.findAll().stream()
                .filter(player -> player.getRole().toLowerCase().contains(searchRole.toLowerCase()))
                .collect(Collectors.toList());
    }

    public  List<Player> getPlayersByNation(String searchNation)
    {
        return playerRepository.findAll().stream()
                .filter(player -> player.getNation().toLowerCase().contains(searchNation.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByTeamandRole(String team, String role)
    {
        return playerRepository.findAll().stream()
                .filter(player -> team.equals(player.getTeam()) && role.equals(player.getRole()))
                .collect(Collectors.toList());
    }

    public Player addPlayer(Player player){
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player updatedPlayer){
        Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());
        if(existingPlayer.isPresent())
        {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setTeam(updatedPlayer.getTeam());
            playerToUpdate.setRole(updatedPlayer.getRole());
            playerToUpdate.setAge(updatedPlayer.getAge());

            playerRepository.save(updatedPlayer);
            return updatedPlayer;
        }
        return null;
    }

    @Transactional
    public void deletePLayer(String playerName)
    {
        playerRepository.deleteByName(playerName);
    }
}

package com.IndainPremierLeague.IPL.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService)
    {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String role,
            @RequestParam(required = false) String nation)
    {
            if(team!= null && role!=null)
            {
                return playerService.getPlayersByTeamandRole(team,role);
            }
            else if(team!=null)
            {
                return playerService.getPlayersFromTeam(team);
            }
            else if(role!=null){
                return playerService.getPlayersByRole(role);
            }
            else if (nation!=null) {
                return playerService.getPlayersByNation(nation);
            }
            else if( name!=null)
            {
                return playerService.getPlayerByName(name);
            }
            else {
                return playerService.getPlayers();
            }
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
        Player updatedPlayer = playerService.updatePlayer(player);
        if(updatedPlayer !=null){
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName)
    {
        playerService.deletePLayer(playerName);
        return new ResponseEntity<>("Player Deleted Successfully", HttpStatus.OK);
    }

}

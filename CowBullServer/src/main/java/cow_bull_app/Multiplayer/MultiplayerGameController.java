package cow_bull_app.Multiplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MultiplayerGameController {

    @Autowired
    private MultiplayerGameServeice multiplayerGameServeice;

    @RequestMapping("/getActiveGames")
    public List<Game> getActiveGames(){
        return multiplayerGameServeice.getActiveGames();
    }

    @RequestMapping("/getGame/{gameId}")
    public Game getGame(@PathVariable String gameId) throws Exception {
        return multiplayerGameServeice.getGame(gameId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createGame")
    public void addGame(@RequestBody Game game){
        multiplayerGameServeice.createGame(game);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateGame/{gameId}")
    public void updateGame(@RequestBody Game game, @PathVariable String gameId){
        multiplayerGameServeice.updateGame(game, gameId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteGame/{gameId}")
    public void deleteGame(@PathVariable String gameId) {
        multiplayerGameServeice.deleteGame(gameId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/startMultiplayerGame2/{playerId}")
    public void StartMultiplayerGame2(@PathVariable String playerId){
        multiplayerGameServeice.createMultiplayerGame2(playerId);
    }

    @RequestMapping("/getMultiplaerGame2/{playerId}")
    public MultiplayerGame2 getMultiplaerGame2(@PathVariable String playerId){
        return multiplayerGameServeice.getMultiplayerGame2ByPlayerId(playerId);
    }

    @RequestMapping("/updateChancesTook/{playerId}/{gameId}")
    public MultiplayerGame2 updateChancesTook(@PathVariable String playerId, @PathVariable String gameId){
        return multiplayerGameServeice.updateChancesTook(playerId, gameId);
    }
}

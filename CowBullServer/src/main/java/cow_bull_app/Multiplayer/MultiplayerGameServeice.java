package cow_bull_app.Multiplayer;

import cow_bull_app.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class MultiplayerGameServeice {

    @Autowired
    private MultiplayerGameRepository multiplayerGameRepository;

    @Autowired
    private MultiplayerGame2Repository multiplayerGame2Repository;

    List<String> waitingUsersMultiplayerGame2;

    public MultiplayerGameServeice(){
        waitingUsersMultiplayerGame2 = new ArrayList<String>();
    }

    public List<Game> getActiveGames(){
        List<Game> gameList = new ArrayList<Game>();
        for(Game game : multiplayerGameRepository.findAll()){
            gameList.add(game);
        }
        return gameList;
    }

    public Game getGame(String gameId){
        return multiplayerGameRepository.findOne(gameId);
    }

    public void createGame(Game game) {
        multiplayerGameRepository.save(game);
    }

    public void updateGame(Game game, String gameId) {
        multiplayerGameRepository.save(game);
    }

    public void deleteGame(String gameId) {
        multiplayerGameRepository.delete(gameId);
    }

    public void createMultiplayerGame2(String playerId) {
        waitingUsersMultiplayerGame2.add(playerId);
        while (waitingUsersMultiplayerGame2.size() > 1){
            String user1 = waitingUsersMultiplayerGame2.get(0), user2 = waitingUsersMultiplayerGame2.get(1);
            waitingUsersMultiplayerGame2.remove(1);
            waitingUsersMultiplayerGame2.remove(0);
            startMultiplayerGame2(user1, user2);
        }
    }

    private void startMultiplayerGame2(String user1, String user2) {
        int b = new Random().nextInt();
        MultiplayerGame2 multiplayerGame2 = new MultiplayerGame2(
                    b, user1, user2, numberGenerator(), 0, 0, true, -1);
        multiplayerGame2Repository.save(multiplayerGame2);
    }

    public static String numberGenerator() {
        Random randy = new Random();
        int[] randArray = {10,10,10,10};

        for(int i=0;i<randArray.length;i++){
            int temp = randy.nextInt(8) + 1;
            while(temp == randArray[0] || temp == randArray[1] || temp == randArray[2] || temp == randArray[3]){
                temp=randy.nextInt(8) + 1;
            }
            randArray[i]=temp;
        }
        String result = "";
        for(int i: randArray){
            result = result + i;
        }
        return result;
    }

    public MultiplayerGame2 getMultiplayerGame2ByPlayerId(String playerId) {
        List<MultiplayerGame2> multiplayerGame2s = multiplayerGame2Repository.getMultiplayerGame2sByuser1(playerId);
        if(multiplayerGame2s.size() == 0)
            multiplayerGame2s = multiplayerGame2Repository.getMultiplayerGame2sByuser2(playerId);
        if(multiplayerGame2s.size() == 0) return null;
        return multiplayerGame2s.get(0);
    }

    public MultiplayerGame2 updateChancesTook(String playerId, String gameId) {
        MultiplayerGame2 multiplayerGame2 = multiplayerGame2Repository.findOne(Integer.parseInt(gameId));
        if(multiplayerGame2.getUser1().equals(playerId)){
            multiplayerGame2.setUser1Entries(multiplayerGame2.getUser1Entries() + 1);
        }else{
            multiplayerGame2.setUser2Entries(multiplayerGame2.getUser2Entries() + 1);
        }
        multiplayerGame2Repository.save(multiplayerGame2);
        return multiplayerGame2;
    }
}



package cow_bull_app.Multiplayer;

import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface MultiplayerGame2Repository extends CrudRepository<MultiplayerGame2, Integer> {
    public List<MultiplayerGame2> getMultiplayerGame2sByuser1(String user1);

    public List<MultiplayerGame2> getMultiplayerGame2sByuser2(String user2);
}

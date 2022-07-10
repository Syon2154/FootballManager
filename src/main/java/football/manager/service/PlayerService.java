package football.manager.service;

import football.manager.model.Player;
import football.manager.repository.PlayerRepository;
import java.util.List;

public interface PlayerService {

    Player save(Player player);

    Player get(Long id);

    List<Player> getAll();

    Player update(Player player);

    void delete(Long id);
}

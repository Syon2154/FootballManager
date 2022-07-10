package football.manager.service;

import football.manager.model.Team;
import java.util.List;

public interface TeamService {
    Team save(Team team);

    Team get(Long id);

    List<Team> getAll();

    Team update(Team team);

    void delete(Long id);
}

package football.manager.mapper;

import football.manager.dto.PlayerRequestDto;
import football.manager.dto.PlayerResponseDto;
import football.manager.model.Player;
import football.manager.model.Team;
import football.manager.service.TeamService;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {
    private final TeamService teamService;

    public PlayerMapper(TeamService teamService) {
        this.teamService = teamService;
    }

    public PlayerResponseDto toDto(Player player) {
        PlayerResponseDto responseDto = new PlayerResponseDto();
        responseDto.setId(player.getId());
        responseDto.setFirstName(player.getFirstName());
        responseDto.setLastName(player.getLastName());
        responseDto.setAge(player.getAge());
        responseDto.setExperience(player.getExperience());
        responseDto.setTeam(player.getTeam());
        return responseDto;
    }

    public Player toModel(PlayerRequestDto requestDto) {
        Player player = new Player();
        player.setFirstName(requestDto.getFirstName());
        player.setLastName(requestDto.getLastName());
        player.setAge(requestDto.getAge());
        player.setExperience(requestDto.getExperience());
        Team team = teamService.get(requestDto.getTeamId());
        player.setTeam(team);
        return player;
    }
}

package football.manager.mapper;

import football.manager.dto.PlayerRequestDto;
import football.manager.dto.PlayerResponseDto;
import football.manager.dto.TeamResponseDto;
import football.manager.model.Player;
import football.manager.model.Team;
import football.manager.service.TeamService;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {
    private final TeamService teamService;
    private final TeamMapper teamMapper;

    public PlayerMapper(TeamService teamService,
                        TeamMapper teamMapper) {
        this.teamService = teamService;
        this.teamMapper = teamMapper;
    }

    public PlayerResponseDto toDto(Player player) {
        PlayerResponseDto responseDto = new PlayerResponseDto();
        responseDto.setId(player.getId());
        responseDto.setFirstName(player.getFirstName());
        responseDto.setLastName(player.getLastName());
        responseDto.setAge(player.getAge());
        responseDto.setExperience(player.getExperience());
        TeamResponseDto teamResponseDto = teamMapper.toDto(player.getTeam());
        responseDto.setTeamResponseDto(teamResponseDto);
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

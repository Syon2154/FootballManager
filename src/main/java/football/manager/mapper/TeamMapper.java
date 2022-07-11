package football.manager.mapper;

import football.manager.dto.TeamRequestDto;
import football.manager.dto.TeamResponseDto;
import football.manager.model.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {
    public TeamResponseDto toDto(Team team) {
        TeamResponseDto responseDto = new TeamResponseDto();
        responseDto.setId(team.getId());
        responseDto.setName(team.getName());
        responseDto.setCountry(team.getCountry());
        responseDto.setCommission(team.getCommission());
        responseDto.setBudget(team.getBudget());
        return responseDto;
    }

    public Team toModel(TeamRequestDto requestDto) {
        Team team = new Team();
        team.setName(requestDto.getName());
        team.setCountry(requestDto.getCountry());
        team.setCommission(requestDto.getCommission());
        team.setBudget(requestDto.getBudget());
        return team;
    }
}

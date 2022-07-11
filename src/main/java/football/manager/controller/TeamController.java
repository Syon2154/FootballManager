package football.manager.controller;

import football.manager.dto.TeamRequestDto;
import football.manager.dto.TeamResponseDto;
import football.manager.mapper.TeamMapper;
import football.manager.model.Team;
import football.manager.service.TeamService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;
    private final TeamMapper teamMapper;

    public TeamController(TeamService teamService, TeamMapper teamMapper) {
        this.teamService = teamService;
        this.teamMapper = teamMapper;
    }

    @PostMapping
    public TeamResponseDto save(@RequestBody @Valid TeamRequestDto requestDto) {
        Team team = teamMapper.toModel(requestDto);
        return teamMapper.toDto(teamService.save(team));
    }

    @GetMapping("/{id}")
    public TeamResponseDto get(@PathVariable Long id) {
        return teamMapper.toDto(teamService.get(id));
    }

    @GetMapping
    public List<TeamResponseDto> getAll() {
        return teamService.getAll().stream()
                .map(teamMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public TeamResponseDto update(@PathVariable Long id,
                                  @RequestBody @Valid TeamRequestDto requestDto) {
        Team team = teamMapper.toModel(requestDto);
        team.setId(id);
        return teamMapper.toDto(teamService.update(team));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        teamService.delete(id);
    }
}

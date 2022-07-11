package football.manager.controller;

import football.manager.dto.PlayerRequestDto;
import football.manager.dto.PlayerResponseDto;
import football.manager.mapper.PlayerMapper;
import football.manager.model.Player;
import football.manager.service.PlayerService;
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
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;
    private final PlayerMapper playerMapper;

    public PlayerController(PlayerService playerService, PlayerMapper playerMapper) {
        this.playerService = playerService;
        this.playerMapper = playerMapper;
    }

    @PostMapping
    public PlayerResponseDto save(@RequestBody @Valid PlayerRequestDto requestDto) {
        Player player = playerMapper.toModel(requestDto);
        return playerMapper.toDto(playerService.save(player));
    }

    @GetMapping("/{id}")
    public PlayerResponseDto get(@PathVariable Long id) {
        return playerMapper.toDto(playerService.get(id));
    }

    @GetMapping
    public List<PlayerResponseDto> getAll() {
        return playerService.getAll().stream()
                .map(playerMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public PlayerResponseDto update(@PathVariable Long id,
                                    @RequestBody @Valid PlayerRequestDto requestDto) {
        Player player = playerMapper.toModel(requestDto);
        player.setId(id);
        return playerMapper.toDto(playerService.update(player));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playerService.delete(id);
    }
}

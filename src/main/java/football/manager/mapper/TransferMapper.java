package football.manager.mapper;

import football.manager.dto.TransferRequestDto;
import football.manager.dto.TransferResponseDto;
import football.manager.model.Player;
import football.manager.model.Team;
import football.manager.model.Transfer;
import football.manager.service.PlayerService;
import football.manager.service.TeamService;
import org.springframework.stereotype.Component;

@Component
public class TransferMapper {
    private final PlayerService playerService;
    private final TeamService teamService;

    public TransferMapper(PlayerService playerService,
                          TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    public TransferResponseDto toDto(Transfer transfer) {
        TransferResponseDto responseDto = new TransferResponseDto();
        responseDto.setId(transfer.getId());
        responseDto.setPlayer(transfer.getPlayer());
        responseDto.setSellerTeam(transfer.getSellerTeam());
        responseDto.setBuyerTeam(transfer.getBuyerTeam());
        responseDto.setPrice(transfer.getPrice());
        return responseDto;
    }

    public Transfer toModel(TransferRequestDto requestDto) {
        Transfer transfer = new Transfer();
        Player player = playerService.get(requestDto.getPlayerId());
        transfer.setPlayer(player);
        Team buyerTeam = teamService.get(requestDto.getBuyerTeamId());
        Team sellerTeam = player.getTeam();
        transfer.setBuyerTeam(buyerTeam);
        transfer.setSellerTeam(sellerTeam);
        return transfer;
    }
}

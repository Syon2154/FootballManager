package football.manager.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class TransferRequestDto {
    @NotNull
    @Positive
    private Long playerId;
    @NotNull
    @Positive
    private Long buyerTeamId;

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getBuyerTeamId() {
        return buyerTeamId;
    }

    public void setBuyerTeamId(Long buyerTeamId) {
        this.buyerTeamId = buyerTeamId;
    }
}

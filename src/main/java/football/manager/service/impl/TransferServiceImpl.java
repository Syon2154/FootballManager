package football.manager.service.impl;

import football.manager.exception.TransferProcessingException;
import football.manager.model.Player;
import football.manager.model.Team;
import football.manager.model.Transfer;
import football.manager.repository.TransferRepository;
import football.manager.service.PlayerService;
import football.manager.service.TeamService;
import football.manager.service.TransferService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {
    private static final BigDecimal PRICE_MULTIPLIER = BigDecimal.valueOf(100000);
    private static final int ROUNDING_NUMBER = 3;
    private final TransferRepository transferRepository;
    private final PlayerService playerService;
    private final TeamService teamService;

    public TransferServiceImpl(
            TransferRepository transferRepository,
            PlayerService playerService,
            TeamService teamService) {
        this.transferRepository = transferRepository;
        this.playerService = playerService;
        this.teamService = teamService;
    }

    @Override
    public Transfer createTransfer(Transfer transfer) {
        Team buyerTeam = transfer.getBuyerTeam();
        BigDecimal price = calculatePrice(transfer);

        price = price.add(calculateCommission(price,
                buyerTeam.getCommission()));
        if (price.compareTo(buyerTeam.getBudget()) > 0) {
            throw new TransferProcessingException("Not enough money");
        }
        Team sellerTeam = transfer.getSellerTeam();
        Player player = transfer.getPlayer();
        buyerTeam.setBudget(buyerTeam.getBudget().subtract(price));
        sellerTeam.setBudget(sellerTeam.getBudget().add(price));
        player.setTeam(buyerTeam);
        teamService.update(buyerTeam);
        teamService.update(buyerTeam);
        playerService.update(player);
        transfer.setPrice(price);
        return transferRepository.save(transfer);
    }

    @Override
    public Transfer get(Long id) {
        return transferRepository.getReferenceById(id);
    }

    @Override
    public List<Transfer> getAll() {
        return transferRepository.findAll();
    }

    private BigDecimal calculatePrice(Transfer transfer) {
        Player player = transfer.getPlayer();
        return BigDecimal.valueOf(player.getExperience())
                .multiply(PRICE_MULTIPLIER)
                .divide(BigDecimal.valueOf(
                                player.getAge()),
                        ROUNDING_NUMBER,
                        RoundingMode.CEILING);
    }

    private BigDecimal calculateCommission(BigDecimal price, double percent) {
        return price.divide(
                BigDecimal.valueOf(100),
                ROUNDING_NUMBER,
                RoundingMode.CEILING)
                .multiply(BigDecimal.valueOf(percent));
    }
}

package football.manager.controller;

import football.manager.model.Player;
import football.manager.model.Team;
import football.manager.model.Transfer;
import football.manager.service.PlayerService;
import football.manager.service.TeamService;
import football.manager.service.TransferService;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataInjector {
    private final PlayerService playerService;
    private final TeamService teamService;
    private final TransferService transferService;

    public DataInjector(PlayerService playerService,
                        TeamService teamService,
                        TransferService transferService) {
        this.playerService = playerService;
        this.teamService = teamService;
        this.transferService = transferService;
    }

    @GetMapping("/inject")
    public String injectData() {
        Team barcelona = new Team();
        barcelona.setName("Barcelona");
        barcelona.setCountry("Spain");
        barcelona.setCommission(8.0);
        barcelona.setBudget(BigDecimal.valueOf(500_000));
        barcelona = teamService.save(barcelona);

        Team bayernMunchen = new Team();
        bayernMunchen.setName("Bayern München");
        bayernMunchen.setCountry("Germany");
        bayernMunchen.setCommission(5.9);
        bayernMunchen.setBudget(BigDecimal.valueOf(470_00));
        bayernMunchen = teamService.save(bayernMunchen);

        Player xaviHernandez = new Player();
        xaviHernandez.setFirstName("Xavi");
        xaviHernandez.setLastName("Hernández");
        xaviHernandez.setAge(42);
        xaviHernandez.setExperience(12);
        xaviHernandez.setTeam(barcelona);
        playerService.save(xaviHernandez);

        Player robertLewandowskii = new Player();
        robertLewandowskii.setFirstName("Robert");
        robertLewandowskii.setLastName("Lewandowskii");
        robertLewandowskii.setAge(33);
        robertLewandowskii.setExperience(8);
        robertLewandowskii.setTeam(bayernMunchen);
        robertLewandowskii = playerService.save(robertLewandowskii);

        Transfer transfer = new Transfer();
        transfer.setPlayer(robertLewandowskii);
        transfer.setSellerTeam(robertLewandowskii.getTeam());
        transfer.setBuyerTeam(barcelona);
        transferService.createTransfer(transfer);

        return "Data successfully injected";
    }
}

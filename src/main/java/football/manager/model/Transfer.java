package football.manager.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transfers")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
    @ManyToOne
    @JoinColumn(name = "seller_team_id")
    private Team sellerTeam;
    @ManyToOne
    @JoinColumn(name = "buyer_team_id")
    private Team buyerTeam;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Team getSellerTeam() {
        return sellerTeam;
    }

    public void setSellerTeam(Team sellerTeam) {
        this.sellerTeam = sellerTeam;
    }

    public Team getBuyerTeam() {
        return buyerTeam;
    }

    public void setBuyerTeam(Team buyerTeam) {
        this.buyerTeam = buyerTeam;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

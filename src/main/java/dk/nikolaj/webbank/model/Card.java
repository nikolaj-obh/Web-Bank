package dk.nikolaj.webbank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "credit_cards")
public class Card {

    // TODO implement maximum limit for credit card (eg. 25.000 dkk a month)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long ID;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "maximum_limit")
    private BigDecimal maximumLimit;
    @Column(name = "expiry_date")
    private Date expiryDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}

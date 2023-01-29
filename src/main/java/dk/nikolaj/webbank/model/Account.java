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
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long ID;
    @Column(name = "account_balance")
    private BigDecimal accountBalance;
    @Column(name = "date_opened")
    private Date dateOpened;

    @OneToOne
    @JoinColumn(name = "account_type")
    private AccountType accountType;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
}

package dk.nikolaj.webbank.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Long ID;
    @Column(name = "duration_in_years")
    private BigDecimal durationInYears;
    @Column(name = "loan_start_date")
    private Date loanStartDate;
    @Column(name = "interest_rate")
    private BigDecimal interestRate;
    @Column(name = "loan_amount_taken")
    private BigDecimal loanAmountTaken;
    @Column(name = "loan_amount_repaid")
    private BigDecimal loanAmountRepaid;
    @Column(name = "loan_type")
    private String loanType;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}

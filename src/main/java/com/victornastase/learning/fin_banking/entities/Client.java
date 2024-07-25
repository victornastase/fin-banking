package com.victornastase.learning.fin_banking.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_client"
    )
    @SequenceGenerator(
            name = "seq_client",
            sequenceName = "seq_client",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name="email", nullable = false)
    private String email;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Loan> loans;

    public void addLoan(Loan loan) {
        this.loans.add(loan);
        loan.setClient(this);
    }

    public void removeLoan(Loan loan) {
        this.loans.remove(loan);
        loan.setClient(null);
    }
}

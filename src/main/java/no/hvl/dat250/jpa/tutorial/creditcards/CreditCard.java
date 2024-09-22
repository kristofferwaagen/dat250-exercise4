package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter @Setter
    private Integer number;
    @Getter @Setter
    private Integer balance;
    @Getter @Setter
    private Integer creditLimit;

    @Getter @Setter
    @ManyToOne(targetEntity = Pincode.class)
    private Pincode pincode;

    @Getter @Setter
    @ManyToOne(targetEntity = Bank.class)
    private Bank owningBank;

}

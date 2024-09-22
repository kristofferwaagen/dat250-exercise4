package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter @Setter
    private String name;

    @Getter @Setter
    @ManyToMany(targetEntity = Address.class)
    private Collection<Address> addresses;

    @Getter @Setter
    @ManyToMany(targetEntity = CreditCard.class)
    private Collection<CreditCard> creditCards;

}

package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter @Setter
    private String street;
    @Getter @Setter
    private Integer number;

    @Getter @Setter
    @ManyToMany(targetEntity = Customer.class)
    private Collection<Customer> owners;

}

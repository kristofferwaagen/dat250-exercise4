package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.*;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    // TODO: Create object world as shown in the README.md.
    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);

    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);

    Bank bank = new Bank();
    bank.setName("Pengebank");

    CreditCard creditCard = new CreditCard();
    creditCard.setNumber(12345);
    creditCard.setBalance(-5000);
    creditCard.setCreditLimit(-10000);
    creditCard.setOwningBank(bank);
    creditCard.setPincode(pincode);

    CreditCard creditCard2 = new CreditCard();
    creditCard2.setNumber(123);
    creditCard2.setBalance(1);
    creditCard2.setCreditLimit(2000);
    creditCard2.setOwningBank(bank);
    creditCard2.setPincode(pincode);

    Customer customer = new Customer();
    customer.setName("Max Mustermann");
    customer.setAddresses(Set.of(address));
    customer.setCreditCards(Set.of(creditCard, creditCard2));
    address.setOwners(Set.of(customer));

    em.persist(address);
    em.persist(pincode);
    em.persist(bank);
    em.persist(creditCard);
    em.persist(creditCard2);
    em.persist(customer);

  }
}

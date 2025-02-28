package fr.epsi.b3devc1.repository;

import fr.epsi.b3devc1.bo.Address;
import jakarta.persistence.EntityManager;

public class AdressRepository {

    private EntityManager em;

    public AdressRepository(EntityManager em) {
        this.em = em;
    }

    // On crée une adresse avec un numéro, une rue, un code postal et une ville
    public void createAddress(String number, String street, String zipCode, String city) {
        Address address = new Address();
        address.setNumber(number);
        address.setStreet(street);
        address.setZipCode(zipCode);
        address.setCity(city);
        em.persist(address);
    }
}
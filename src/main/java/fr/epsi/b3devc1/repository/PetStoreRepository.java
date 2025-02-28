package fr.epsi.b3devc1.repository;

import fr.epsi.b3devc1.bo.PetStore;
import fr.epsi.b3devc1.bo.Address;
import jakarta.persistence.EntityManager;

public class PetStoreRepository {

    private EntityManager em;

    public PetStoreRepository(EntityManager em) {
        this.em = em;
    }

    // On crée un magasin d'animaux avec un nom, un nom de manager et une adresse
    public void createPetStore(String name, String managerName, Address address) {
        PetStore petStore = new PetStore();
        petStore.setName(name);
        petStore.setManagerName(managerName);
        petStore.setAddress(address);
        em.persist(petStore);
    }
}
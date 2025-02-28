package fr.epsi.b3devc1.repository;

import fr.epsi.b3devc1.bo.Animal;
import fr.epsi.b3devc1.bo.PetStore;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class AnimalRepository {

    private EntityManager em;

    public AnimalRepository(EntityManager em) {
        this.em = em;
    }

    // On crée un animal avec une date de naissance, une couleur et un magasin d'animaux
    public void createAnimal(Date birth, String color, PetStore petStore) {
        Animal animal = new Animal();
        animal.setBirth(birth);
        animal.setColor(color);
        animal.setPetstore(petStore);
        em.persist(animal);
    }

    // On récupère la liste des animaux d'un magasin selon son identifiant
    public List<Animal> getAnimalsByPetStoreId(Long petStoreId) {
        TypedQuery<Animal> query = em.createQuery(
                "SELECT a FROM Animal a WHERE a.petstore.id = :petStoreId", Animal.class);
        query.setParameter("petStoreId", petStoreId);
        return query.getResultList();
    }
}
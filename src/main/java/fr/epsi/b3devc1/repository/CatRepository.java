package fr.epsi.b3devc1.repository;

import fr.epsi.b3devc1.bo.Animal;
import fr.epsi.b3devc1.bo.Cat;
import jakarta.persistence.EntityManager;

public class CatRepository {

    private EntityManager em;

    public CatRepository(EntityManager em) {
        this.em = em;
    }

    // On crée un chat avec un identifiant de puce et un animal
    public void createCat(String chipId, Animal animal) {
        Cat cat = new Cat();
        cat.setChipId(chipId);
        cat.setAnimal(animal);
        em.persist(cat);
    }
}
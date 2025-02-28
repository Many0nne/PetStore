package fr.epsi.b3devc1.repository;

import fr.epsi.b3devc1.bo.Animal;
import fr.epsi.b3devc1.bo.Fish;
import fr.epsi.b3devc1.bo.FishLivEnv;
import jakarta.persistence.EntityManager;

public class FishRepository {

    private EntityManager em;

    public FishRepository(EntityManager em) {
        this.em = em;
    }

    // On crée un poisson avec un environnement de vie et un animal
    public void createFish(FishLivEnv livingEnv, Animal animal) {
        Fish fish = new Fish();
        fish.setLivingEnv(livingEnv);
        fish.setAnimal(animal);
        em.persist(fish);
    }
}
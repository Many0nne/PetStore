package fr.epsi.b3devc1;

import fr.epsi.b3devc1.bo.*;
import fr.epsi.b3devc1.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // On crée une instance de EntityManagerFactory qui va nous permettre de créer une instance de EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        // On crée une instance de EntityManager qui va nous permettre de gérer les entités
        EntityManager em = emf.createEntityManager();

        // On commence une transaction
        em.getTransaction().begin();

        try {
            // On insère des enregistrements dans la base de donnée.
            // On utilise les repositories pour effectuer une meilleur séparation des responsabilités

            AdressRepository adressRepository = new AdressRepository(em);
            adressRepository.createAddress("123", "Main St", "12345", "CityA");
            adressRepository.createAddress("456", "Second St", "67890", "CityB");
            adressRepository.createAddress("789", "Third St", "11223", "CityC");

            Address address1 = em.find(Address.class, 1L);
            Address address2 = em.find(Address.class, 2L);
            Address address3 = em.find(Address.class, 3L);

            PetStoreRepository petStoreRepository = new PetStoreRepository(em);
            petStoreRepository.createPetStore("PetStoreA", "ManagerA", address1);
            petStoreRepository.createPetStore("PetStoreB", "ManagerB", address2);
            petStoreRepository.createPetStore("PetStoreC", "ManagerC", address3);

            PetStore petStore1 = em.find(PetStore.class, 1L);
            PetStore petStore2 = em.find(PetStore.class, 2L);
            PetStore petStore3 = em.find(PetStore.class, 3L);

            AnimalRepository animalRepository = new AnimalRepository(em);
            animalRepository.createAnimal(new Date(), "Brown", petStore1);
            animalRepository.createAnimal(new Date(), "Black", petStore2);
            animalRepository.createAnimal(new Date(), "White", petStore3);

            Animal animal1 = em.find(Animal.class, 1L);
            Animal animal2 = em.find(Animal.class, 2L);
            Animal animal3 = em.find(Animal.class, 3L);

            CatRepository catRepository = new CatRepository(em);
            catRepository.createCat("chip123", animal1);
            catRepository.createCat("chip456", animal2);
            catRepository.createCat("chip789", animal3);

            animalRepository.createAnimal(new Date(), "Gold", petStore1);
            animalRepository.createAnimal(new Date(), "Blue", petStore2);
            animalRepository.createAnimal(new Date(), "Red", petStore3);

            Animal animal4 = em.find(Animal.class, 4L);
            Animal animal5 = em.find(Animal.class, 5L);
            Animal animal6 = em.find(Animal.class, 6L);

            FishRepository fishRepository = new FishRepository(em);
            fishRepository.createFish(FishLivEnv.FRESH_WATER, animal4);
            fishRepository.createFish(FishLivEnv.SEA_WATER, animal5);
            fishRepository.createFish(FishLivEnv.FRESH_WATER, animal6);

            ProductRepository productRepository = new ProductRepository(em);
            productRepository.createProduct("P001", "ProductA", ProdType.FOOD, 10.0, petStore1);
            productRepository.createProduct("P002", "ProductB", ProdType.ACCESSORY, 20.0, petStore2);
            productRepository.createProduct("P003", "ProductC", ProdType.CLEANING, 30.0, petStore3);

            Long petStoreId = 1L;
            for (Animal animal : animalRepository.getAnimalsByPetStoreId(petStoreId)) {
                System.out.println(animal.getId() + " - " + animal.getColor());
            }

            // On commit la transaction pour valider les changements
            em.getTransaction().commit();
        } catch (Exception e) {
            // Si une exception est levée, on annule la transaction pour ne pas persister les changements
            em.getTransaction().rollback();
        } finally {
            // On ferme l'EntityManager et l'EntityManagerFactory pour libérer les ressources
            em.close();
            emf.close();
        }
    }
}
package fr.epsi.b3devc1.repository;

import fr.epsi.b3devc1.bo.PetStore;
import fr.epsi.b3devc1.bo.Product;
import fr.epsi.b3devc1.bo.ProdType;
import jakarta.persistence.EntityManager;

public class ProductRepository {

    private EntityManager em;

    public ProductRepository(EntityManager em) {
        this.em = em;
    }

    // On crée un produit avec un code, un label, un type, un prix et un magasin d'animaux
    public void createProduct(String code, String label, ProdType type, double price, PetStore petStore) {
        Product product = new Product();
        product.setCode(code);
        product.setLabel(label);
        product.setType(type);
        product.setPrice(price);
        product.setPetstore(petStore);
        em.persist(product);
    }
}
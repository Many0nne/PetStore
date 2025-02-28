package fr.epsi.b3devc1.bo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date birth;
    private String color;

    @ManyToOne
    @JoinColumn(name = "petstore_id")
    private PetStore petstore;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PetStore getPetstore() {
        return petstore;
    }

    public void setPetstore(PetStore petstore) {
        this.petstore = petstore;
    }
}

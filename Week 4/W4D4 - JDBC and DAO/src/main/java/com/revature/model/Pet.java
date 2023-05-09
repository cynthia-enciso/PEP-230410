package com.revature.model;

import java.util.Objects;

public class Pet {
    
    // state
    private int id;
    private String name;
    private int age;
    private String species;
    private int vetId;

    // constructors
    public Pet() {
    }

    public Pet(int id, String name, int age, String species, int vetId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.species = species;
        this.vetId = vetId;
    }

    // getters and setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return this.species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getVetId() {
        return this.vetId;
    }

    public void setVetId(int vetId) {
        this.vetId = vetId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pet)) {
            return false;
        }
        Pet pet = (Pet) o;
        return id == pet.id && Objects.equals(name, pet.name) && age == pet.age && Objects.equals(species, pet.species) && vetId == pet.vetId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, species, vetId);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            ", species='" + getSpecies() + "'" +
            ", vetId='" + getVetId() + "'" +
            "}";
    }
    
}

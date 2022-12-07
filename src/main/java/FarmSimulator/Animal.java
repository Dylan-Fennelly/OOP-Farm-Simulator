package FarmSimulator;

import com.github.javafaker.Faker;

import java.io.Serializable;
import java.util.UUID;

abstract class Animal implements Serializable
{
    private String animalID;
    private String animalName;
    private String pedigree;
    private double weight;
    private int age;

    public Animal(String animalName, String pedigree, double weight, int age)
    {
        this.animalID = UUID.randomUUID().toString();
        this.animalName = animalName;
        this.pedigree = pedigree;
        this.weight = weight;
        this.age = age;
    }

    public Animal(String pedigree, double weight, int age)
    {
        this.animalID = UUID.randomUUID().toString();
        this.animalName = randomFakeName();
        this.pedigree = pedigree;
        this.weight = weight;
        this.age = age;
    }

    private String randomFakeName()
    {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public String getAnimalID()
    {
        return animalID;
    }

    public String getAnimalName()
    {
        return animalName;
    }

    public String getPedigree()
    {
        return pedigree;
    }

    public double getWeight()
    {
        return weight;
    }

    public int getAge()
    {
        return age;
    }
}

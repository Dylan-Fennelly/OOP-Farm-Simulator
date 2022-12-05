package FarmSimulator;

import java.util.UUID;

abstract class Animal
{
    private String animalID;
    private String animalName;
    private String pedigree;
    private double weight;
    private int age;

    public Animal( String animalName, String pedigree, double weight, int age)
    {
        this.animalID = UUID.randomUUID().toString();
        this.animalName = animalName;
        this.pedigree = pedigree;
        this.weight = weight;
        this.age = age;
    }

}

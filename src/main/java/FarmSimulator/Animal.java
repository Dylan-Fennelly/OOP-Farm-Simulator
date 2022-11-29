package FarmSimulator;

abstract class Animal
{
    private String animalID;
    private String animalName;
    private String pedigree;
    private double weight;
    private int age;

    public Animal(String animalID, String animalName, String pedigree, double weight, int age)
    {
        this.animalID = animalID;
        this.animalName = animalName;
        this.pedigree = pedigree;
        this.weight = weight;
        this.age = age;
    }
}

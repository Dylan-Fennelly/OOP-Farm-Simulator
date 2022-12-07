package FarmSimulator;

import java.util.Random;

public class Goat extends Animal implements IMilkable
{
    private int timesMilkedPerDay;
    private int totalMilkProduction;
    private int udderCapacity;


    public Goat(String animalName, String pedigree, double weight, int age)
    {
        super(animalName, pedigree, weight, age);
        udderCapacity +=generateUdderCapacity();
    }

    public Goat(String pedigree, double weight, int age)
    {
        super(pedigree, weight, age);
    }

    @Override
    public double milk()
    {
        totalMilkProduction+= udderCapacity;
        return udderCapacity;
    }
    private int generateUdderCapacity()
    {
        Random random = new Random();
        return random.nextInt((3-2) +1)+2;
    }

}

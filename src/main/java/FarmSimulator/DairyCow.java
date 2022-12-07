package FarmSimulator;

import java.util.Random;

public class DairyCow extends Animal implements IMilkable
{
    private int timesMilkedPerDay;
    private int totalMilkProduction;
    private int udderCapacity;

    public DairyCow(String animalName, String pedigree, double weight, int age)
    {
        super(animalName, pedigree, weight, age);
        udderCapacity = generateUdderCapacity();
    }

    public DairyCow(String pedigree, double weight, int age)
    {
        super(pedigree, weight, age);
        udderCapacity = generateUdderCapacity();
    }

    public double milk()
    {
        totalMilkProduction += udderCapacity;
        return udderCapacity;
    }

    private int generateUdderCapacity()
    {
        Random random = new Random();
        return random.nextInt(40-20 + 1 )+20;
    }

    public double getCapacity()
    {
        return udderCapacity;
    }
}

package FarmSimulator;

import java.util.Random;

public class Goat extends Animal implements IMilkable,IDailyReset
{
    private boolean milkedToday;
    private int totalMilkProduction;
    private int udderCapacity;


    public Goat(String animalName, String pedigree, double weight, int age)
    {
        super(animalName, pedigree, weight, age);
        udderCapacity +=generateUdderCapacity();
        milkedToday = false;
    }

    public Goat(String pedigree, double weight, int age)
    {
        super(pedigree, weight, age);
        milkedToday = false;
    }

    @Override
    public double milk()
    {
        totalMilkProduction+= udderCapacity;
        milkedToday =true;
        return udderCapacity;
    }
    private int generateUdderCapacity()
    {
        Random random = new Random();
        return random.nextInt((3-2) +1)+2;
    }

    public boolean isMilkedToday()
    {
        return milkedToday;
    }

    public int getTotalMilkProduction()
    {
        return totalMilkProduction;
    }

    @Override
    public void dailyReset()
    {
        udderCapacity = generateUdderCapacity();
        milkedToday = false;
    }
}

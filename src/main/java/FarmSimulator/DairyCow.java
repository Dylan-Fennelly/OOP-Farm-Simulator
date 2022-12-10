package FarmSimulator;

import java.util.Random;

public class DairyCow extends Animal implements IMilkable
{
    private int maxTimesMilkedPerDay;
    private int timesMilkedToday;
    private int totalMilkProduction;
    private int udderCapacity;

    public DairyCow(String animalName, String pedigree, double weight, int age)
    {
        super(animalName, pedigree, weight, age);
        udderCapacity = generateUdderCapacity();
        maxTimesMilkedPerDay = generateMaxTimesMilkedPerDay();
    }

    public DairyCow(String pedigree, double weight, int age)
    {
        super(pedigree, weight, age);
        udderCapacity = generateUdderCapacity();
        maxTimesMilkedPerDay = generateMaxTimesMilkedPerDay();
    }

    public double milk()
    {
        totalMilkProduction += udderCapacity;
        timesMilkedToday ++;
        return udderCapacity;
    }

    private int generateUdderCapacity()
    {
        Random random = new Random();
        return random.nextInt(40-20 + 1 )+20;
    }
    private int generateMaxTimesMilkedPerDay()
    {
        Random random = new Random();
        return random.nextInt(5-2 +1)+2;
    }
    public double getCapacity()
    {
        return udderCapacity;
    }
    public void resetTimeMilked()
    {
        timesMilkedToday = 0;
    }

}

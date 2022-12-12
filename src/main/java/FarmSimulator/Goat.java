package FarmSimulator;

import FarmSimulator.MenuEnums.Pedigree;

import java.util.Random;

public class Goat extends Animal implements IMilkable,IDailyReset
{
    private boolean milkedToday;
    private int totalMilkProduction;
    private int udderCapacity;


    public Goat(String animalName, Pedigree pedigree, double weight, int age)
    {
        super(animalName, pedigree, weight, age);
        udderCapacity +=generateUdderCapacity();
        milkedToday = false;
    }

    public Goat(Pedigree pedigree, double weight, int age)
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
    public int getOverallValue()
    {
        int value = (int) Math.ceil(super.getWeight()* 14.07);
        if(getPedigree()==Pedigree.PURE_BRED)
        {
            value += value*0.1;
        }
        if(super.getAge() >2)
        {
            double percentage = 1- Math.pow(0.95,super.getAge() -2);
            value =(int) Math.ceil(value *percentage);
        }
        return value;
    }
    @Override
    public void dailyReset()
    {
        udderCapacity = generateUdderCapacity();
        milkedToday = false;
    }
}

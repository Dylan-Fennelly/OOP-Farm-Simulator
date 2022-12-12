package FarmSimulator;

import FarmSimulator.MenuEnums.Pedigree;

import java.util.Random;

public class DairyCow extends Animal implements IMilkable, IDailyReset
{
    private int maxTimesMilkedPerDay;
    private int timesMilkedToday;
    private int totalMilkProduction;
    private int udderCapacity;
    private int currentUdderLevel;

    public DairyCow(String animalName, Pedigree pedigree, double weight, int age)
    {
        super(animalName, pedigree, weight, age);
        udderCapacity = generateUdderCapacity();
        currentUdderLevel = udderCapacity;
        maxTimesMilkedPerDay = generateMaxTimesMilkedPerDay();
        totalMilkProduction = 0;
    }

    public DairyCow(Pedigree pedigree, double weight, int age)
    {
        super(pedigree, weight, age);
        udderCapacity = generateUdderCapacity();
        maxTimesMilkedPerDay = generateMaxTimesMilkedPerDay();
        totalMilkProduction = 0;
    }
    @Override
    public double milk()
    {
        double milkDelivered = generateMilkDeliveryAmount();
        if(currentUdderLevel-milkDelivered<=0&&currentUdderLevel!=0)
        {
            double milkToReturn = currentUdderLevel;
            currentUdderLevel =0;
            return milkToReturn;
        }
        currentUdderLevel -= milkDelivered;
        totalMilkProduction += milkDelivered;
        timesMilkedToday ++;
        return milkDelivered;
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
    private int generateMilkDeliveryAmount()
    {
        Random random = new Random();
        return random.nextInt(8-2 +1)+2;
    }

    public double getCapacity()
    {
        return udderCapacity;
    }

    public int getCurrentUdderLevel()
    {
        return currentUdderLevel;
    }

    public int getTotalMilkProduction()
    {
        return totalMilkProduction;
    }

    public int getMaxTimesMilkedPerDay()
    {
        return maxTimesMilkedPerDay;
    }

    public int getTimesMilkedToday()
    {
        return timesMilkedToday;
    }
    @Override
    public int getOverallValue()
    {
        int value = (int) Math.ceil(super.getWeight()* 3.76);
        if(getPedigree()==Pedigree.PURE_BRED)
        {
            value += value*0.1;
        }
        if(super.getAge() >2)
        {
            double percentage = 1- Math.pow(0.95,super.getAge()-2);
            value =(int) Math.ceil(value *percentage);
        }
        return value;
    }

    @Override
    public void dailyReset()
    {
        maxTimesMilkedPerDay = generateMaxTimesMilkedPerDay();
        timesMilkedToday = 0;
        udderCapacity = generateUdderCapacity();
        currentUdderLevel = udderCapacity;

    }

}

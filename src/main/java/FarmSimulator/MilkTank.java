package FarmSimulator;

import java.util.UUID;

public class MilkTank
{
    private String milkTankID;
    private boolean isCowsMilk;
    private final double CAPACITY;
    private double currentLevel;


    public MilkTank()
    {
        this.milkTankID = UUID.randomUUID().toString();//Make random generated
        this.isCowsMilk = true;
        this.CAPACITY = 2000;
        this.currentLevel = 0;
    }
    public MilkTank(double capacity)
    {
        this.milkTankID = UUID.randomUUID().toString();//Make random generated
        this.isCowsMilk = true;
        this.CAPACITY = capacity;
        this.currentLevel = 0;
    }

    public double getCapacity()
    {
        return CAPACITY;
    }
    public boolean isCowsMilk()
    {
        return isCowsMilk;
    }
    public double freeSpace()
    {
        return CAPACITY - currentLevel;
    }
    public boolean addToTank(double Amount)
    {
        if(freeSpace() <= 0)
        {
            System.out.println("Tank has reached capacity");
            return false;
        }
        else if(freeSpace()>=Amount)
        {
            currentLevel += Amount;
            return true;
        }
        else if(freeSpace()< Amount)
        {
            double amountToFill = freeSpace();
            currentLevel += amountToFill;
            System.out.println("Tank has now reached capacity");
            System.out.println(Amount - amountToFill + " Litres of milk were wasted due to a full tank");
            return true;
        }
        return false;
    }
    public double getFromMilkTank(double amount)
    {
        if(amount >currentLevel)
        {
            System.out.println("Unable to extract "+amount+" Litres from tank");
            System.out.println("Extracting "+currentLevel+" Litres from Tank");
            double tempAmount = currentLevel;
            currentLevel = 0;
            return tempAmount;
        }
        else if(amount <= currentLevel)
        {
            System.out.println("Extracting "+currentLevel+" Litres from Tank");
            double tempAmount = currentLevel;
            currentLevel = 0;
            return tempAmount;
        }
        else
        {
            System.out.println("Nothing in tank");
            return 0;
        }
    }

    @Override
    public String toString()
    {
        return "MilkTank{" +
                "milkTankID='" + milkTankID + '\'' +
                ", isCowsMilk=" + isCowsMilk +
                ", CAPACITY=" + CAPACITY +
                ", currentLevel=" + currentLevel +
                '}';
    }
}

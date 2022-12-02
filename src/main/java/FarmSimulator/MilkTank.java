package FarmSimulator;

public class MilkTank
{
    private String milkTankID;
    private boolean isCowsMilk;
    private final double CAPACITY;
    private double currentLevel;


    public MilkTank()
    {
        this.milkTankID = null;//Make random generated
        this.isCowsMilk = true;
        this.CAPACITY = 2000;
        this.currentLevel = 0;
    }
    public MilkTank(double capacity)
    {
        this.milkTankID = null;//Make random generated
        this.isCowsMilk = true;
        this.CAPACITY = capacity;
        this.currentLevel = 0;
    }

    public double getCapacity()
    {
        return CAPACITY;
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
}

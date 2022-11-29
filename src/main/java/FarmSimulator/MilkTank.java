package FarmSimulator;

public class MilkTank
{
    private String milkTankID;
    private String milkType;
    private double capacity;
    private double currentLevel;

    public MilkTank(String milkTankID, String milkType, double capacity, double currentLevel)
    {
        this.milkTankID = milkTankID;
        this.milkType = milkType;
        this.capacity = capacity;
        this.currentLevel = currentLevel;
    }
}

package FarmSimulator;

public class NotMilkedAnimalCounter
{
    private int notMilkable;
    private int wrongMilkType;
    private int milkLimitExceeded;

    public NotMilkedAnimalCounter()
    {
        notMilkable =0;
        wrongMilkType =0;
        milkLimitExceeded = 0;
    }

    public int getNotMilkable()
    {
        return notMilkable;
    }

    public int getWrongMilkType()
    {
        return wrongMilkType;
    }

    public int getMilkLimitExceeded()
    {
        return milkLimitExceeded;
    }

    public void incrementNotMilkable()
    {
        notMilkable++;
    }
    public void incrementWrongMilkType()
    {
        wrongMilkType++;
    }
    public void incrementMilkLimitExceeded()
    {
        milkLimitExceeded++;
    }
}

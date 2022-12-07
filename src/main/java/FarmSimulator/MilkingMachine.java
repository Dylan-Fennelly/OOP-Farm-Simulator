package FarmSimulator;

import java.io.Serializable;
import java.util.UUID;

public class MilkingMachine implements Serializable
{
    private String idNum;
    private MilkTank milktank;

    public MilkingMachine()
    {
        this.idNum = UUID.randomUUID().toString();
    }

    public MilkTank getMilkTank()
    {
        return milktank;
    }

    public void setMilkTank(MilkTank milktank)
    {
        this.milktank = milktank;
    }
    void milk(IMilkable milkable)
    {
        if(!(milkable==null))
        {
            milktank.addToTank(milkable.milk());
        }
        else
        {
            throw new IllegalStateException("No Milk Tank Connected");
        }
    }
}

package FarmSimulator;

import java.io.Serializable;
import java.util.Objects;
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

    public boolean setMilkTank(MilkTank milktank)
    {
        if(milktank!=null)
        {
            this.milktank = milktank;
            System.out.println("MilkTank:" + milktank.getMilkTankID() + " installed");
            return true;
        }
        else
        {
            System.out.println("MilkTank:" + this.milktank.getMilkTankID() + " is already present");
            return false;
        }
    }
    public boolean removeMilkTank()
    {
        if(milktank != null)
        {
            System.out.println("MilkTank:" + this.milktank.getMilkTankID() + " Removed");
            milktank = null;
            return true;
        }
        else
        {
            System.out.println("No MilkTank present to remove");
            return false;
        }
    }
    public boolean replaceMilkTank(MilkTank milktank)
    {
        if(milktank != null)
        {
            System.out.println("MilkTank:"+ this.milktank + " has been replaced with MilkTank:"+milktank);
            this.milktank = milktank;
            return true;
        }
        else
        {
            System.out.println("No object to replace");
            return false;
        }


    }
    public void milk(IMilkable milkable)
    {
        if(milktank!=null)
        {
            milktank.addToTank(milkable.milk());
        }
        else
        {
            throw new IllegalStateException("No Milk Tank Connected");
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MilkingMachine that = (MilkingMachine) o;
        return Objects.equals(idNum, that.idNum);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(idNum);
    }
}

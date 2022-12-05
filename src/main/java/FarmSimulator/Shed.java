package FarmSimulator;

import java.util.ArrayList;
import java.util.Collection;

public class Shed
{
    private String idNum;
    private MilkingMachine milkingMachine;
    private MilkTank milktank;

    public Shed(MilkTank milktank)
    {
        this.idNum =null; //Make me random
        this.milktank = milktank;
    }

    public MilkTank getMilkTank()
    {
        return milktank;
    }
    public void installMilkingMachine(MilkingMachine milkingMachine)
    {
        this.milkingMachine = milkingMachine;
    }

    public void milkAnimal(IMilkable milkable)
    {
        if (!(milktank == null))
        {
            milkable.milk();
        }
        else
        {
            throw new IllegalStateException("No Milk Machine Connected");
        }
    }

    public void milkAnimal(Collection<IMilkable> animals)
    {
        if (!(animals == null))
        {
            for(IMilkable animal:animals)
            {
                animal.milk();
            }
        }
        else
        {
            throw new IllegalStateException("No Milk Machine Connected");
        }
    }

    @Override
    public String toString()
    {
        return "Shed{" +
                "idNum='" + idNum + '\'' +
                ", milkingMachine=" + milkingMachine +
                ", milktank=" + milktank +
                '}';
    }
}

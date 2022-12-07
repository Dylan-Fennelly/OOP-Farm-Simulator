package FarmSimulator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Shed implements Serializable
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
            milkingMachine.milk(milkable);
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
                milkingMachine.milk(animal);
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

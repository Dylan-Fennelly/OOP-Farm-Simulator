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

    }

    public void milkAnimal(Animal animal)
    {
        if (!(milktank == null))
        {
            animal.milk();
        }
        else
        {
            throw new IllegalStateException("No Milk Machine Connected");
        }
    }

    public void milkAnimal(Collection<Animal> animals)
    {
        if (!(animals == null))
        {
            for(Animal animal:animals)
            {
                animal.milk();
            }
        }
        else
        {
            throw new IllegalStateException("No Milk Machine Connected");
        }
    }
    public String toString()
    {
        return "";
    }
}

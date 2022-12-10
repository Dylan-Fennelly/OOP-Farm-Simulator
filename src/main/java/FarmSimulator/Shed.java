package FarmSimulator;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

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

    public void milkAnimal(Animal animal)
    {
        if (milkingMachine != null)
        {
            milkIfMilkable(animal);
        }
        else
        {
            throw new IllegalStateException("No Milk Machine Connected");
        }
    }

    public void milkAnimal(Collection<Animal> animals)
    {
        if (milkingMachine != null)
        {
            for(Animal animal:animals)
            {
                milkIfMilkable(animal);
            }
        }
        else
        {
            throw new IllegalStateException("No Milk Machine Connected");
        }
    }

    private void milkIfMilkable(Animal animal)
    {
        if(animal instanceof IMilkable)
        {
            if(milktank.getMilkType().equals("Cow")&& animal instanceof DairyCow)
            {
                milkingMachine.milk((IMilkable) animal);
            }
            else if (milktank.getMilkType().equals("Goat")&& animal instanceof Goat)
            {
                milkingMachine.milk((IMilkable) animal);
            }
            else
            {
                System.out.println("No animals match MilkTank Type:"+milktank.getMilkType());
            }

        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shed shed = (Shed) o;
        return Objects.equals(idNum, shed.idNum);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(idNum);
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

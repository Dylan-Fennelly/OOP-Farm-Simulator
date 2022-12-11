package FarmSimulator;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

public class Shed implements Serializable
{
    private String idNum;
    private MilkingMachine milkingMachine;
    private MilkTank milktank;

    public Shed()
    {
        this.idNum = UUID.randomUUID().toString();
    }

    public MilkTank getMilkTank()
    {
        return this.milktank;
    }
    public void installMilkingMachine(MilkingMachine milkingMachine)
    {
        this.milkingMachine = milkingMachine;
        if(milktank != null)
        {
            milkingMachine.ConnectMilkTank(milktank);
            System.out.println("MilkTank found in shed...\n" +
                    "MilkTank has been connected");
        }
    }
    public void installMilkTank(MilkTank milktank)
    {
        this.milktank = milktank;
        if(milkingMachine.getMilkTank()==null)
        {
            milkingMachine.ConnectMilkTank(milktank);
            System.out.println("MilkMachine found in shed...\n" +
                    "MilkTank has been connected");
        }
    }


    public void milkAnimal(Animal animal)
    {
        if (milkingMachine != null)
        {
            NotMilkedAnimalCounter notMilkedAnimalCounter = new NotMilkedAnimalCounter();
            if(!milkIfMilkable(animal,notMilkedAnimalCounter))
            {
                if(notMilkedAnimalCounter.getNotMilkable()>0)
                {
                    System.out.println("Animal was not milked as it was not milkable");
                }
                else if(notMilkedAnimalCounter.getWrongMilkType()>0)
                {
                    System.out.println("Animal was not milked as the MilkTank does not match current animal");
                }
                else if(notMilkedAnimalCounter.getMilkLimitExceeded()>0)
                {
                    System.out.println("Animal was not milked as this animal has been milked too many times today");
                }
            }
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
            NotMilkedAnimalCounter notMilkedAnimalCounter = new NotMilkedAnimalCounter();
            for(Animal animal:animals)
            {
                milkIfMilkable(animal,notMilkedAnimalCounter);
            }
            if(notMilkedAnimalCounter.getWrongMilkType()>0&&notMilkedAnimalCounter.getNotMilkable()>0)
            {
                System.out.println(notMilkedAnimalCounter.getNotMilkable()+" Animals not milked due to not being milkable\n" +
                        notMilkedAnimalCounter.getWrongMilkType()+" Animals not milked due to wrong Type of Milk\n" +
                        notMilkedAnimalCounter.getMilkLimitExceeded()+"Animals not milked due to milk limit exceeded");
            }
            else
            {
                System.out.println("All Animals milked successfully");
            }
        }
        else
        {
            throw new IllegalStateException("No Milk Machine Connected");
        }
    }

    private boolean milkIfMilkable(Animal animal,NotMilkedAnimalCounter notMilkedAnimalCounter)
    {
        if(animal instanceof IMilkable)
        {
            if(milktank.getMilkType().equals("Cow")&& animal instanceof DairyCow)
            {
                if(((DairyCow) animal).getMaxTimesMilkedPerDay()>((DairyCow) animal).getTimesMilkedToday()&&((DairyCow) animal).getCurrentUdderLevel()!=0)
                {
                    milkingMachine.milk((IMilkable) animal);
                    return true;
                }
                else
                {
                    notMilkedAnimalCounter.incrementMilkLimitExceeded();
                    return false;
                }
            }
            else if (milktank.getMilkType().equals("Goat")&& animal instanceof Goat)
            {
                if(((Goat)animal).isMilkedToday())
                {
                    milkingMachine.milk((IMilkable) animal);
                    return true;
                }
                else
                {
                    notMilkedAnimalCounter.incrementMilkLimitExceeded();
                    return false;
                }

            }
            else if (milktank.getMilkType().equals("Unspecified"))
            {
                System.out.println("MilkTank is Unspecified\nSetting to current animals type....");
                if(animal instanceof DairyCow)
                {
                    milktank.setMilkType("Cow");
                    milkingMachine.milk((IMilkable) animal);
                    return true;

                }
                else if (animal instanceof Goat)
                {
                    milktank.setMilkType("Goat");
                    milkingMachine.milk((IMilkable) animal);
                    return true;
                }
            }
            else
            {
                notMilkedAnimalCounter.incrementWrongMilkType();
                return false;
            }
        }
        notMilkedAnimalCounter.incrementNotMilkable();
        return false;//If animal is not milkable. This used in the milk animals method
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

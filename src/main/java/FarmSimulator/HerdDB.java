package FarmSimulator;

import java.io.Serializable;
import java.util.ArrayList;

public class HerdDB implements Serializable
{
    private String farmID;
    private ArrayList<DairyCow> dairyCows;
    private ArrayList<BeefCow> beefCows;
    private ArrayList<Goat> goats;
    private ArrayList<Sheep> sheep;

    public HerdDB(String farmID)
    {
        this.farmID = farmID;
        dairyCows = new ArrayList<>();
        beefCows = new ArrayList<>();
        goats = new ArrayList<>();
        sheep = new ArrayList<>();
    }
    public boolean addAnimalToHerd(Animal animal)
    {
        if(!(checkAnimalExists(animal)))
        {
            if(animal instanceof DairyCow)
            {
                dairyCows.add((DairyCow) animal);
                return true;
            }
            else if(animal instanceof BeefCow)
            {
                beefCows.add((BeefCow) animal);
                return true;
            }
            else if (animal instanceof Goat)
            {
                goats.add((Goat) animal);
                return true;
            }
            else if (animal instanceof Sheep)
            {
                sheep.add((Sheep) animal);
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }


    private boolean checkAnimalExists(Animal newAnimal)
    {
        for(Animal animal:dairyCows)
        {
            if(animal.equals(newAnimal))
            {
                return true;
            }
        }
        for(Animal animal:beefCows)
        {
            if(animal.equals(newAnimal))
            {
                return true;
            }
        }
        for(Animal animal:sheep)
        {
            if(animal.equals(newAnimal))
            {
                return true;
            }
        }
        for(Animal animal:goats)
        {
            if(animal.equals(newAnimal))
            {
                return true;
            }
        }
        return false;
    }
    public ArrayList<Animal> groupedHerd()
    {
        ArrayList<Animal> groupedHerd= new ArrayList<>();
        groupedHerd.addAll(dairyCows);
        groupedHerd.addAll(beefCows);
        groupedHerd.addAll(goats);
        groupedHerd.addAll(sheep);
        return groupedHerd;
    }
    public boolean removeAnimalFromHerd(Animal animal)
    {
        if(!(checkAnimalExists(animal)))
        {
            if(animal instanceof DairyCow)
            {
                dairyCows.remove((DairyCow) animal);
                return true;
            }
            else if(animal instanceof BeefCow)
            {
                beefCows.remove((BeefCow) animal);
                return true;
            }
            else if (animal instanceof Goat)
            {
                goats.remove((Goat) animal);
                return true;
            }
            else if (animal instanceof Sheep)
            {
                sheep.remove((Sheep) animal);
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }



    @Override
    public String toString()
    {
        return "HerdDB{" +
                "farmID='" + farmID + '\'' +
                ", dairyCows=" + dairyCows +
                ", beefCows=" + beefCows +
                ", goats=" + goats +
                ", sheep=" + sheep +
                '}';
    }
}

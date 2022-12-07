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


    private boolean checkAnimalExists(Animal animal)
    {
        for(Animal animal1:dairyCows)
        {
            if(animal.getAnimalID() == animal1.getAnimalID())
            {
                return true;
            }
        }
        for(Animal animal1:beefCows)
        {
            if(animal.getAnimalID() == animal1.getAnimalID())
            {
                return true;
            }
        }
        for(Animal animal1:sheep)
        {
            if(animal.getAnimalID() == animal1.getAnimalID())
            {
                return true;
            }
        }
        for(Animal animal1:goats)
        {
            if(animal.getAnimalID() == animal1.getAnimalID())
            {
                return true;
            }
        }
        return false;
    }
}

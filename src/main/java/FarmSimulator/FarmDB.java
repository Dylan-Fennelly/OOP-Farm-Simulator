package FarmSimulator;

import java.io.*;

import java.util.ArrayList;

public class FarmDB implements ISavable
{
    private ArrayList<Farm> farms;

    public FarmDB()
    {
        this.farms = new ArrayList<Farm>();
        loadFromFile();
    }
    public void addFarm(Farm farm)
    {
        if(!doesFarmAlreadyExist(farm))
        {
            this.farms.add(farm);
        }
    }

    private boolean doesFarmAlreadyExist(Farm newFarm)
    {
        for(Farm farm:farms)
        {
            if (farm.equals(newFarm))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void loadFromFile()
    {

    }

    @Override
    public void saveToFile()
    {

    }
}

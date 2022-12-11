package FarmSimulator;

import java.io.*;

import java.util.ArrayList;

public class FarmDB implements ISavable
{
    private ArrayList<Farm> farms;

    public FarmDB()
    {
        this.farms = loadFromFile();
    }
    public FarmDB(Boolean newFarm)
    {
        this.farms = new ArrayList<>();
    }
    public boolean addFarm(Farm farm)
    {
        if(!doesFarmAlreadyExist(farm))
        {
            this.farms.add(farm);
            return true;
        }
        return false;
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
    public Farm findFarmByName(String name)
    {
        for(Farm farm:farms)
        {
            if(farm.getFarmOwner().equalsIgnoreCase(name))
            {
                return farm;
            }
        }
        return null;
    }

    public ArrayList<Farm> getFarms()
    {
        return farms;
    }

    @Override
    public String toString()
    {
        return "FarmDB{" +
                "farms=" + farms +
                '}';
    }

    @Override
    public ArrayList<Farm> loadFromFile()
    {
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Farms.dat"));
            ArrayList<Farm> farms = (ArrayList<Farm>)ois.readObject();
            System.out.println("Farms loaded successfully");
            ois.close();
            return farms;
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println(fnfe);
        }
        catch (IOException ioe)
        {
            System.out.println(ioe);
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void saveToFile()
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("Farms.dat");
            ObjectOutputStream  oos = new ObjectOutputStream(fos);
            oos.writeObject(farms);
            oos.flush();
            oos.close();
            System.out.println("Farms saved");
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println(fnfe);
        }
        catch (IOException ioe)
        {
            System.out.println(ioe);
        }

    }
}

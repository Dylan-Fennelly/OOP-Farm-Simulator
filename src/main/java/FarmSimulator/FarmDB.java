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
    public void addPlayer(Farm farm)
    {
        if(!doesFarmAlreadyExist(farm))
        {
            this.farms.add(farm);
        }
    }

    private boolean doesFarmAlreadyExist(Farm f)
    {
        for(Farm farm:farms)
        {
            if (farm.equals(f))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void loadFromFile()
    {
        try (BufferedReader fileReader = new BufferedReader((new FileReader("farms.txt")))) {
            String input;
            while ((input = fileReader.readLine()) != null) {

            }
        } catch (FileNotFoundException fnfe) {
            fnfe.getMessage();
        } catch (IOException ioe) {
            ioe.getMessage();
        }
    }

    @Override
    public void saveToFile()
    {

    }
}

package FarmSimulator;

import java.io.Serializable;
import java.util.ArrayList;

public class ShedDB implements Serializable
{
    private String farmID;
    private ArrayList<Shed> sheds;

    public ShedDB(String farmID)
    {
        this.farmID = farmID;
        this.sheds = new ArrayList<>();
    }

    public ArrayList<Shed> getSheds()
    {
        return sheds;
    }
    public boolean addFarm(Shed shed)
    {
        if(!doesShedAlreadyExist(shed))
        {
            this.sheds.add(shed);
            return true;
        }
        return false;
    }
    private boolean doesShedAlreadyExist(Shed newShed)
    {
        for(Shed shed:sheds)
        {
            if (shed.equals(newShed))
            {
                return true;
            }
        }
        return false;
    }
}

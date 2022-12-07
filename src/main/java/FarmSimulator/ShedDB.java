package FarmSimulator;

import java.io.Serializable;
import java.util.ArrayList;

public class ShedDB implements Serializable
{
    private String farmID;
    private ArrayList<Shed> sheds;

    public ShedDB(String farmID, ArrayList<Shed> sheds)
    {
        this.farmID = farmID;
        this.sheds = sheds;
    }
}

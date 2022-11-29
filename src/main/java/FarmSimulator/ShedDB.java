package FarmSimulator;

import java.util.ArrayList;

public class ShedDB
{
    private String farmID;
    private ArrayList<Shed> sheds;

    public ShedDB(String farmID, ArrayList<Shed> sheds)
    {
        this.farmID = farmID;
        this.sheds = sheds;
    }
}

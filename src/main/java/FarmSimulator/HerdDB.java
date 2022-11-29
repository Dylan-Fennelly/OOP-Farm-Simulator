package FarmSimulator;

import java.util.ArrayList;

public class HerdDB
{
    private String farmID;
    private ArrayList<DairyCow> dairyCows;
    private ArrayList<BeefCow> beefCows;
    private ArrayList<Goat> goats;
    private ArrayList<Sheep> sheep;

    public HerdDB(String farmID)
    {
        this.farmID = farmID;
        dairyCows = new ArrayList<DairyCow>();
        beefCows = new ArrayList<BeefCow>();
        goats = new ArrayList<Goat>();
        sheep = new ArrayList<Sheep>();
    }
}

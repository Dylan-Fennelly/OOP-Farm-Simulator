package FarmSimulator;

public class Farm
{
    private String farmID;
    private String farmOwner;
    private ShedDB sheds;
    private HerdDB herds;

    public Farm(String farmID, String farmOwner, ShedDB sheds, HerdDB herds)
    {
        this.farmID = farmID;
        this.farmOwner = farmOwner;
        this.sheds = sheds;
        this.herds = herds;
    }
}


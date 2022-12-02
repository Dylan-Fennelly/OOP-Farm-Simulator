package FarmSimulator;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Farm farm = (Farm) o;
        return Objects.equals(farmID, farm.farmID);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(farmID);
    }
}


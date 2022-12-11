package FarmSimulator;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Farm implements Serializable
{
    private String farmID;
    private String farmOwner;
    private ShedDB sheds;
    private HerdDB herds;

    public Farm(String farmOwner)
    {
        this.farmID = UUID.randomUUID().toString();
        this.farmOwner = farmOwner;
        this.sheds = new ShedDB(farmID);
        this.herds =new HerdDB(farmID);
    }

    public String getFarmID()
    {
        return farmID;
    }

    public String getFarmOwner()
    {
        return farmOwner;
    }

    public ShedDB getSheds()
    {
        return sheds;
    }

    public HerdDB getHerds()
    {
        return herds;
    }

    @Override
    public String toString()
    {
        return "Farm{" +
                "farmID='" + farmID + '\'' +
                ", farmOwner='" + farmOwner + '\'' +
                ", sheds=" + sheds +
                ", herds=" + herds +
                '}';
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


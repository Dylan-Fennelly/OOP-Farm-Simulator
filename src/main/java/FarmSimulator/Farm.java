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

    public Farm(String farmOwner, ShedDB sheds)
    {
        this.farmID = UUID.randomUUID().toString();
        this.farmOwner = farmOwner;
        this.sheds = sheds;
        this.herds =new HerdDB(farmID);
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


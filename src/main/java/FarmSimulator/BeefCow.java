package FarmSimulator;

import FarmSimulator.MenuEnums.Pedigree;

public class BeefCow extends Animal
{
    public BeefCow(String animalName, Pedigree pedigree, double weight, int age)
    {
        super(animalName, pedigree, weight, age);
    }

    public BeefCow(Pedigree pedigree, double weight, int age)
    {
        super(pedigree, weight, age);
    }


}

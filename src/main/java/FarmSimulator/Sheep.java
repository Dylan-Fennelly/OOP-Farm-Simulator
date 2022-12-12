package FarmSimulator;

import FarmSimulator.MenuEnums.Pedigree;

public class Sheep extends Animal
{

    public Sheep(String animalName, Pedigree pedigree, double weight, int age)
    {
        super(animalName, pedigree, weight, age);
    }

    public Sheep(Pedigree pedigree, double weight, int age)
    {
        super(pedigree, weight, age);
    }

    @Override
    public int getOverallValue()
    {
        int value = (int) Math.ceil(super.getWeight()* 6.83);
        if(getPedigree()==Pedigree.PURE_BRED)
        {
            value += value*0.1;
        }
        if(super.getAge() >2)
        {
            double percentage = 1- Math.pow(0.95,super.getAge()-2);
            value =(int) Math.ceil(value *percentage);
        }
        return value;
    }
}

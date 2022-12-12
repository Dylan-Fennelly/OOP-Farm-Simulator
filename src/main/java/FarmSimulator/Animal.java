package FarmSimulator;

import FarmSimulator.MenuEnums.Pedigree;
import com.github.javafaker.Faker;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

abstract class Animal implements Serializable
{
    private String animalID;
    private String animalName;
    private Pedigree pedigree;
    private double weight;
    private int age;

    public Animal(String animalName, Pedigree pedigree, double weight, int age)
    {
        this.animalID = UUID.randomUUID().toString();
        this.animalName = animalName;
        this.pedigree = pedigree;
        this.weight = weight;
        this.age = age;
    }

    public Animal(Pedigree pedigree, double weight, int age)
    {
        this.animalID = UUID.randomUUID().toString();
        this.animalName = randomFakeName();
        this.pedigree = pedigree;
        this.weight = weight;
        this.age = age;
    }

    private String randomFakeName()
    {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public String getAnimalID()
    {
        return animalID;
    }

    public String getAnimalName()
    {
        return animalName;
    }

    public Pedigree getPedigree()
    {
        return pedigree;
    }

    public double getWeight()
    {
        return weight;
    }

    public int getAge()
    {
        return age;
    }
    public int getOverallValue()
    {
        int value = (int) Math.ceil(weight* 4.76);
        if(getPedigree()==Pedigree.PURE_BRED)
        {
            value += value*0.1;
        }
        if(age >2)
        {
            double percentage = 1- Math.pow(0.95,age -2);
            value =(int) Math.ceil(value *percentage);
        }
        return value;
    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(animalID, animal.animalID);
    }

    public void setAnimalName(String animalName)
    {
        this.animalName = animalName;
    }

    public void setPedigree(Pedigree pedigree)
    {
        this.pedigree = pedigree;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(animalID);
    }

    @Override
    public String toString()
    {
        return "Animal{" +
                "animalID='" + animalID + '\'' +
                ", animalName='" + animalName + '\'' +
                ", pedigree=" + pedigree +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }
}

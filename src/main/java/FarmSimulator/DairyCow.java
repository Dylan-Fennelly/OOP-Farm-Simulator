package FarmSimulator;

public class DairyCow extends Animal
{
    private int timesMilkedPerDay;
    private int totalMilkProduction;

    public DairyCow(String animalID, String animalName, String pedigree, double weight, int age, int timesMilkedPerDay, int totalMilkProduction)
    {
        super(animalID, animalName, pedigree, weight, age);
        this.timesMilkedPerDay = timesMilkedPerDay;
        this.totalMilkProduction = totalMilkProduction;
    }
}

package FarmSimulator;

public class DairyCow extends Animal implements IMilkable
{
    private int timesMilkedPerDay;
    private int totalMilkProduction;

    public DairyCow( String animalName, String pedigree, double weight, int age, int timesMilkedPerDay, int totalMilkProduction)
    {
        super(animalName, pedigree, weight, age);
        this.timesMilkedPerDay = timesMilkedPerDay;
        this.totalMilkProduction = totalMilkProduction;
    }

    public double milk()
    {

        return 0;
    }
}

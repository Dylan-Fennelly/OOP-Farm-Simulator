package FarmSimulator;
import FarmSimulator.MenuEnums.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu
{
    private static Scanner keyboard = new Scanner(System.in);
    private static FarmDB farmManger = new FarmDB();
    private static Farm currentFarm;
    public static void main(String[] args)
    {
        MainMenu();
    }

    private static void MainMenu()
    {
        System.out.println(Colours.BLUE +"Welcome to the Farm management application"+Colours.RESET);

        MainMenuOptions selectedOption = MainMenuOptions.CONTINUE;

        while(selectedOption != MainMenuOptions.QUIT)
        {
            try
            {
                //print the menu, get user input, act on the input, exit loop on quit
                printMainMenu();
                selectedOption = MainMenuOptions.values()[Integer.parseInt(keyboard.nextLine().trim())];

                switch(selectedOption)
                {
                    case LOAD:
                        load();
                        FarmSelectionMenu();
                        break;

                    case SAVE:
                        save();
                        break;

                    case RESET:
                        reset();
                        FarmSelectionMenu();
                        break;

                    case QUIT:
                        break;

                    default:
                        System.out.println("Not a valid option. Please try again");
                }
            }
            catch(IllegalArgumentException e)
            {
                System.out.println(Colours.RED + "Selection out of range" + Colours.RESET);
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println(Colours.RED + "Selection out of range" + Colours.RESET);
            }
        }
    }

    private static void reset()
    {
        farmManger = new FarmDB(true);
    }

    private static void FarmSelectionMenu()
    {
        System.out.println(Colours.BLUE +"Now managing current farm"+Colours.RESET);

        FarmSelectionMenuOptions selectedOption = FarmSelectionMenuOptions.CONTINUE;

        while(selectedOption != FarmSelectionMenuOptions.BACK)
        {
            try
            {
                //print the menu, get user input, act on the input, exit loop on quit
                printFarmSelectionMenu();
                selectedOption = FarmSelectionMenuOptions.values()[Integer.parseInt(keyboard.nextLine().trim())];

                switch(selectedOption)
                {
                    case ADD_FARM:
                        addFarm();
                        break;

                    case DISPLAY_FARMS:
                        listAllFarmsByName();
                        break;

                    case SELECT_FARM:
                        selectFarm();
                        break;

                    case DELETE_FARM:
                        deleteFarm();
                        break;

                    case BACK:
                        save();
                        break;
                    case QUIT:
                        exitMenu();
                        System.exit(0);

                    default:
                        System.out.println("Not a valid option. Please try again");
                }
            }
            catch(IllegalArgumentException e)
            {
                System.out.println(Colours.RED + "PLease input a valid input(number)" + Colours.RESET);
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println(Colours.RED + "Selection out of range" + Colours.RESET);
            }
        }
    }

    private static void addFarm()
    {
        System.out.println("Please enter the owner of the farm");
        String newFarmOwner = keyboard.nextLine();
        if(farmManger.addFarm(new Farm(newFarmOwner)))
        {
            System.out.println("Farm successfully added");
        }
        else
        {
            System.out.println("Farm was not added, farm already exists");
        }
    }

    private static void selectFarm()
    {
        boolean loop = true;
        while(loop)
        {
            listAllFarmsByName();
            System.out.println("Please select a farm to use by selecting the farms number in the list");
            try
            {
                int userChoice = keyboard.nextInt();
                keyboard.nextLine();
                Farm selectedFarm = farmManger.getFarms().get(userChoice-1);
                currentFarm = selectedFarm;
                loop = false;
                IndividualFarmMenu();
            }
            catch (NullPointerException npe)
            {
                System.out.println("There are no farms created yet");
                break;
            }
            catch (IndexOutOfBoundsException aioobe)
            {
                System.out.println("Please input a number if the correct range");
            }
            catch (InputMismatchException ime)
            {
                System.out.println("Please enter a valid input(number)");
                keyboard.nextLine();
            }

        }

    }

    private static void listAllFarmsByName()
    {
        int count = 0;
        try
        {
            for (Farm farm : farmManger.getFarms())
            {
                System.out.println((count + 1) + ".) " + farmManger.getFarms().get(count).getFarmOwner());
                count++;
            }
        }
        catch (NullPointerException npe)
        {
            System.out.println("There are no farms currently added");
        }
    }

    private static void deleteFarm()
    {
        boolean loop = true;
        while(loop)
        {
            listAllFarmsByName();
            System.out.println("Please select a farm to delete by selecting the farms number in the list");
            try
            {
                int userChoice = keyboard.nextInt();
                keyboard.nextLine();
                Farm selectedFarm = farmManger.getFarms().get(userChoice-1);
                int farmtoRemoveIndex =-1;
                for(int i = 0;i<farmManger.getFarms().size();i++)
                {
                    if(selectedFarm.equals(selectedFarm))
                    {
                        farmtoRemoveIndex = i;
                    }
                }
                farmManger.getFarms().remove(farmtoRemoveIndex);
                loop = false;
            }
            catch (NullPointerException npe)
            {
                System.out.println("There are no farms currently added");
                break;
            }
            catch (IndexOutOfBoundsException iobe)
            {
                System.out.println("Please input a number if the correct range");
            }
            catch (InputMismatchException ime)
            {
                System.out.println("Please enter a valid input(number)");
                keyboard.nextLine();
            }

        }
    }

    private static void IndividualFarmMenu()
    {
        System.out.println(Colours.BLUE +"Now managing current farm: "+currentFarm.getFarmOwner()+Colours.RESET);

        IndividualFarmMenuOptions selectedOption = IndividualFarmMenuOptions.CONTINUE;

        while(selectedOption != IndividualFarmMenuOptions.BACK)
        {
            try
            {
                //print the menu, get user input, act on the input, exit loop on quit
                printIndividualFarmMenu();
                selectedOption = IndividualFarmMenuOptions.values()[Integer.parseInt(keyboard.nextLine().trim())];

                switch(selectedOption)
                {

                    case ADD_ANIMAL:
                        addAnimal();
                        break;

                    case EDIT_ANIMAL:
                        SelectAnimal();
                        break;

                    case ADD_SHED:
                        addShed();
                        break;

                    case EDIT_SHED:
                        SelectSheds();
                        break;

                    case PRINT_FARM_DETAILS:
                        printFarmDetails();
                        break;

                    case MILK_ALL_ANIMALS:
                        milkAllAnimals();
                        break;

                    case Empty_ALL_MILKTANKS:
                        collectAllMilkTanks();
                        break;

                    case ANIMAL_DEATH:
                        registerAnimalDeath();
                        break;

                    case PRINT_HERD_BY_CRITERIA:
                        //printHerdByCriteria();
                        break;

                    case BACK:
                        break;
                    case QUIT:
                        exitMenu();


                    default:
                        System.out.println("Not a valid option. Please try again");
                }
            }
            catch(IllegalArgumentException e)
            {
                System.out.println(Colours.RED + "Selection out of range" + Colours.RESET);
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println(Colours.RED + "Selection out of range" + Colours.RESET);
            }
        }
    }

    private static void addAnimal()
    {

        AddAnimalOptions selectedOption = AddAnimalOptions.CONTINUE;
        while(selectedOption == AddAnimalOptions.CONTINUE)
        {
            boolean userWillNameAnimal = false;
            String animalName = null;
            Pedigree pedigree = Pedigree.CROSS_BRED;
            double animalWeight = -1;
            int animalAge = -1;
            boolean loop = true;

            while(loop)
            {
                try
                {
                    System.out.println("Do you wish to give the animal a name?");
                    System.out.println("Enter:");
                    System.out.println("\t1. Yes");
                    System.out.println("\t2. No");
                    int nameChoice = keyboard.nextInt();
                    keyboard.nextLine();
                    switch (nameChoice)
                    {
                        case 1:
                            userWillNameAnimal = true;
                            loop = false;
                            break;
                        case 2:
                            loop = false;
                            break;
                        default:
                            System.out.println("Please enter a valid option");
                    }

                }
                catch (InputMismatchException ime)
                {
                    System.out.println("Please enter a valid input type(number)");
                    keyboard.nextLine();
                }
            }
            if(userWillNameAnimal)
            {
                System.out.println("Please enter the name of the animal");
                animalName = keyboard.nextLine();
            }
            loop = true;
            while(loop)
            {
                try
                {
                    System.out.println("Please enter the pedigree of the animal");
                    System.out.println("Enter:");
                    System.out.println("\t1. PureBred");
                    System.out.println("\t2. CrossBred");
                    int PedigreeChoice = keyboard.nextInt();
                    keyboard.nextLine();
                    switch (PedigreeChoice)
                    {
                        case 1:
                            pedigree =Pedigree.PURE_BRED;
                            loop = false;
                            break;
                        case 2:
                            loop = false;
                            break;
                        default:
                            System.out.println("Please enter a valid option");
                    }
                }
                catch (InputMismatchException ime)
                {
                    System.out.println("Please enter a valid input type(number)");
                    keyboard.nextLine();
                }
            }
            loop = true;
            while (loop)
            {
                try
                {
                    System.out.println("Please enter the weight of the animal");
                    animalWeight = keyboard.nextDouble();
                    loop = false;
                    keyboard.nextLine();
                }
                catch (InputMismatchException ime)
                {
                    System.out.println("PLease enter the right input type(number)");
                    keyboard.nextLine();
                }
            }
            loop = true;
            while(loop)
            {
                try
                {
                    System.out.println("Please enter the age of the animal");
                    animalAge = keyboard.nextInt();
                    loop = false;
                    keyboard.nextLine();
                }
                catch (InputMismatchException ime)
                {
                    System.out.println("Please enter the right input type(Number)");
                    keyboard.nextLine();
                }
            }
            try
            {
                selectAnimalMenuText();
                selectedOption = AddAnimalOptions.values()[Integer.parseInt(keyboard.nextLine().trim())];

                switch(selectedOption)
                {
                    case DAIRY_COW:
                        if(userWillNameAnimal)
                        {
                            Animal newCow = new DairyCow(animalName,pedigree,animalWeight,animalAge);
                            currentFarm.getHerds().addAnimalToHerd(newCow);
                        }
                        else
                        {
                            Animal newCow = new DairyCow(pedigree,animalWeight,animalAge);
                            currentFarm.getHerds().addAnimalToHerd(newCow);
                        }

                        break;

                    case BEEF_COW:
                        if(userWillNameAnimal)
                        {
                            Animal animal = new BeefCow(animalName,pedigree,animalWeight,animalAge);
                            currentFarm.getHerds().addAnimalToHerd(animal);
                        }
                        else
                        {
                            Animal animal = new BeefCow(pedigree,animalWeight,animalAge);
                            currentFarm.getHerds().addAnimalToHerd(animal);
                        }
                        break;

                    case GOAT:
                        if(userWillNameAnimal)
                        {
                            Animal animal = new Goat(animalName,pedigree,animalWeight,animalAge);
                            currentFarm.getHerds().addAnimalToHerd(animal);
                        }
                        else
                        {
                            Animal animal = new Goat(pedigree,animalWeight,animalAge);
                            currentFarm.getHerds().addAnimalToHerd(animal);
                        }
                        break;

                    case SHEEP:
                        if(userWillNameAnimal)
                        {
                            Animal animal = new Sheep(animalName,pedigree,animalWeight,animalAge);
                            currentFarm.getHerds().addAnimalToHerd(animal);
                        }
                        else
                        {
                            Animal animal = new Sheep(pedigree,animalWeight,animalAge);
                            currentFarm.getHerds().addAnimalToHerd(animal);
                        }
                        break;

                    default:
                        System.out.println("Not a valid option. Please try again");
                }
            }
            catch(IllegalArgumentException e)
            {
                System.out.println(Colours.RED + "Please enter a valid input(number)" + Colours.RESET);
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println(Colours.RED + "Selection out of range" + Colours.RESET);
            }
        }
    }

    private static void selectAnimalMenuText()
    {
        System.out.println("\nPlease select the type of animal?");
        System.out.println("Enter: ");
        System.out.println("\t 1. Dairy Cow");
        System.out.println("\t 2. Beef Cow");
        System.out.println("\t 3. Goat");
        System.out.println("\t 4. Sheep");
    }

    private static void SelectAnimal()
    {
        currentFarm.getHerds().groupedHerd();
        boolean loop = true;
        while(loop)
        {
            listAllHerdByName();
            System.out.println("Please select an animal to modify by selecting the animal's number in the list\n" +
                    "(Not the Id Number)");
            try
            {
                int userChoice = keyboard.nextInt();
                keyboard.nextLine();
                Animal selectAnimal = currentFarm.getHerds().groupedHerd().get(userChoice - 1);
                loop = false;
                editAnimal(selectAnimal);
            }
            catch (IndexOutOfBoundsException aioobe)
            {
                System.out.println("Please input a number if the correct range");
            }
            catch (InputMismatchException ime)
            {
                System.out.println("Please enter a valid input(number)");
                keyboard.nextLine();
            }
        }
    }
    private static void editAnimal(Animal animal)
    {
        boolean loop = true;
        while (loop)
        {
            System.out.println("\nWhat operation would you like to perform on the animal?");
            System.out.println("Enter:");
            System.out.println("\t1. Change name");
            System.out.println("\t2. Change weight");
            System.out.println("\t3. Change age");
            System.out.println("\t4. Change pedigree");
            System.out.println("\t5. Make no change(back)");
            int menuChoice = keyboard.nextInt();
            keyboard.nextLine();
            switch (menuChoice)
            {
                case 1:
                    System.out.println("Please enter the name of the animal");
                    String animalName = keyboard.nextLine();
                    animal.setAnimalName(animalName);
                    loop = false;
                    break;
                case 2:
                    boolean case2Loop = true;
                    double animalWeight = 0;
                    while (case2Loop)
                    {
                        try
                        {
                            System.out.println("Please enter the weight of the animal");
                            animalWeight = keyboard.nextDouble();
                            case2Loop = false;
                            keyboard.nextLine();
                        }
                        catch (InputMismatchException ime)
                        {
                            System.out.println("PLease enter the right input type(number)");
                            keyboard.nextLine();
                        }
                    }
                    animal.setWeight(animalWeight);
                    loop = false;
                    break;
                case 3:
                    boolean case3loop = true;
                    int animalAge = 0;
                    while(case3loop)
                    {
                        try
                        {
                            System.out.println("Please enter the age of the animal");
                            animalAge = keyboard.nextInt();
                            case3loop = false;
                            keyboard.nextLine();
                        }
                        catch (InputMismatchException ime)
                        {
                            System.out.println("Please enter the right input type(Number)");
                            keyboard.nextLine();
                        }
                    }
                    animal.setAge(animalAge);
                    loop = false;
                    break;
                case 4:
                    boolean case4Loop = true;
                    Pedigree pedigree = Pedigree.CROSS_BRED;
                    while(case4Loop)
                    {
                        try
                        {
                            System.out.println("Please enter the pedigree of the animal");
                            System.out.println("Enter:");
                            System.out.println("\t1. PureBred");
                            System.out.println("\t2. CrossBred");
                            int PedigreeChoice = keyboard.nextInt();
                            keyboard.nextLine();
                            switch (PedigreeChoice)
                            {
                                case 1:
                                    pedigree =Pedigree.PURE_BRED;
                                    case4Loop = false;
                                    break;
                                case 2:
                                    case4Loop = false;
                                    break;
                                default:
                                    System.out.println("Please enter a valid option");
                            }
                        }
                        catch (InputMismatchException ime)
                        {
                            System.out.println("Please enter a valid input type(number)");
                            keyboard.nextLine();
                        }
                    }
                    animal.setPedigree(pedigree);
                    loop = false;
                    break;
                case 5:
                    loop = false;
                    break;
            }
        }
    }

    private static void listAllHerdByName()
    {
        int count = 0;
        for(Animal animal:currentFarm.getHerds().groupedHerd())
        {
            System.out.println((count+1) +".) "+currentFarm.getHerds().groupedHerd().get(count));
            count++;
        }
    }

    private static void addShed()
    {
        if(currentFarm.getSheds().addShed(new Shed()))
        {
            System.out.println("A new shed has successfully been added");
        }
        else
        {
            addShed();
        }
    }

    private static void SelectSheds()
    {
        Shed currentShed;
        boolean loop = true;
        while(loop)
        {
            listAllShedsByName();
            System.out.println("Please select a shed to modify by selecting the shed's number in the list\n" +
                    "(Not the Id Number");
            try
            {
                int userChoice = keyboard.nextInt();
                keyboard.nextLine();
                Shed selectedShed = currentFarm.getSheds().getSheds().get(userChoice - 1);
                currentShed = selectedShed;
                loop = false;
                editShed(selectedShed);
            }
            catch (IndexOutOfBoundsException aioobe)
            {
                System.out.println("Please input a number if the correct range");
            }
            catch (InputMismatchException ime)
            {
                System.out.println("Please enter a valid input(number)");
                keyboard.nextLine();
            }
        }
    }

    private static void editShed(Shed selectedShed)
    {
        boolean loop = true;
        while(loop)
        {
            try
            {
                System.out.println("\nWhat operation would you like to perform on the shed?");
                System.out.println("Enter:");
                System.out.println("\t1. Install a milking machine");
                System.out.println("\t2. Install a milkTank");
                System.out.println("\t3. Replace the milkTank");
                System.out.println("\t4. Disconnect the  milkTank from machine");
                System.out.println("\t5. Connect the  milkTank to the machine");
                System.out.println("\t6. Set the Milk Type");
                System.out.println("\t7. Back to menu");
                int menuChoice = keyboard.nextInt();
                keyboard.nextLine();
                switch (menuChoice)
                {
                    case 1:
                        selectedShed.installMilkingMachine(new MilkingMachine());
                        loop = false;
                        break;
                    case 2:
                        selectedShed.installMilkTank(generateMilkTank());
                        loop = false;
                        break;
                    case 3:
                        selectedShed.replaceMilkTank(generateMilkTank());
                        loop = false;
                        break;
                    case 4:
                        selectedShed.getMilkingMachine().DetachMilkTank();
                        loop = false;
                        break;
                    case 5:
                        selectedShed.getMilkingMachine().ConnectMilkTank(selectedShed.getMilkTank());
                        loop = false;
                        break;
                    case 6:
                        selectedShed.getMilkTank().setMilkType(userSelectMilkType());
                        loop = false;
                        break;
                    case 7:
                        loop = false;
                        break;
                }
            }
            catch (InputMismatchException ime)
            {
                System.out.println("Please input a valid option");
            }
        }
    }

    private static String userSelectMilkType()
    {
        boolean loop = true;
        while(loop)
        {
            System.out.println("Please enter the type of milk you wish to use:");
            System.out.println("Enter:");
            System.out.println("1. Cow's Milk");
            System.out.println("2. Goat's Milk");
            try
            {
                int userSelection = keyboard.nextInt();
                keyboard.nextLine();
                switch (userSelection)
                {
                    case 1:
                        return "Cow";
                    case 2:
                        return "Goat";
                }
            }
            catch(InputMismatchException ime)
            {
                System.out.println("Please enter a valid input(number)");
                keyboard.nextLine();
            }
        }

        return null;
    }

    private static MilkTank generateMilkTank()
    {
        boolean loop = true;
        while(loop)
        {
            try
            {
                System.out.println("Would you a custom capacity MilkTank?");
                System.out.println("Enter:");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int userInput = keyboard.nextInt();
                keyboard.nextLine();

                switch (userInput)
                {
                    case 1:
                        boolean innerLoop = true;
                        while (innerLoop)
                        {
                            System.out.println("Please enter a custom capacity");
                            try
                            {
                                double capacity = keyboard.nextDouble();
                                keyboard.nextLine();
                                return new MilkTank(capacity);
                            }
                            catch (InputMismatchException ime)
                            {
                                System.out.println("Please enter a valid input(number)");
                                keyboard.nextLine();
                            }
                        }
                        innerLoop = false;
                        break;
                    case 2:
                        return new MilkTank();
                    default:
                        System.out.println("Please enter a valid input");
                }
            }
            catch (InputMismatchException ime)
            {
                System.out.println("Please enter a valid input(number)");
                keyboard.nextLine();
            }
        }
        return null;
    }

    private static void listAllShedsByName()
    {
        int count = 0;
        for(Shed shed:currentFarm.getSheds().getSheds())
        {
            System.out.println((count+1) +".) "+currentFarm.getSheds().getSheds().get(count).toString());
            count++;
        }
    }

    private static void printFarmDetails()
    {
        currentFarm.toString();
    }

    private static void milkAllAnimals()
    {
        for(Shed shed:currentFarm.getSheds().getSheds())
        {
            shed.milkAnimal(currentFarm.getHerds().groupedHerd());
        }
    }

    private static void collectAllMilkTanks()
    {
        int milkAmount = 0;
        boolean loop = true;
        while(loop)
        {
            try
            {
                System.out.println("Please enter the amount of milk to collect from the tanks");
                milkAmount = keyboard.nextInt();
                keyboard.nextLine();
                loop = false;
            }
            catch (InputMismatchException ime)
            {
                System.out.println("Please enter a number");
            }
        }
        for(Shed shed:currentFarm.getSheds().getSheds())
        {
            shed.getMilkTank().getFromMilkTank(milkAmount);
        }
    }

    private static void registerAnimalDeath()
    {
        currentFarm.getHerds().groupedHerd();
        boolean loop = true;
        while(loop)
        {
            listAllHerdByName();
            System.out.println("Please select an animal to that has passed by selecting the animal's number in the list\n" +
                    "(Not the Id Number)");
            try
            {
                int userChoice = keyboard.nextInt();
                keyboard.nextLine();
                Animal selectAnimal = currentFarm.getHerds().groupedHerd().get(userChoice - 1);
                loop = false;
                currentFarm.getHerds().removeAnimalFromHerd(selectAnimal);
            }
            catch (IndexOutOfBoundsException aioobe)
            {
                System.out.println("Please input a number if the correct range");
            }
            catch (InputMismatchException ime)
            {
                System.out.println("Please enter a valid input(number)");
                keyboard.nextLine();
            }
        }
    }

    private static void printHerdByCriteria()
    {
        System.out.println("This function was not implement in time");
    }

    private static void exitMenu()
    {
        ExitMenuOptions selectedOption = ExitMenuOptions.CONTINUE;

        while(selectedOption != ExitMenuOptions.EXIT_WITHOUT_SAVING)
        {
            try
            {
                //print the menu, get user input, act on the input, exit loop on quit
                printExitMenu();
                selectedOption = ExitMenuOptions.values()[Integer.parseInt(keyboard.nextLine().trim())];

                switch(selectedOption)
                {
                    case EXIT_AND_SAVE:
                        save();
                        System.exit(0);
                        break;

                    case EXIT_WITHOUT_SAVING:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Not a valid option. Please try again");
                }
            }
            catch(IllegalArgumentException e)
            {
                System.out.println(Colours.RED + "Selection out of range" + Colours.RESET);
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println(Colours.RED + "Selection out of range" + Colours.RESET);
            }
        }
    }

    private static void save()
    {
        farmManger.saveToFile();
    }
    private static void load()
    {
        farmManger.loadFromFile();
    }

    private static void printMainMenu()
    {
        System.out.println("\nEnter: ");
        System.out.println("\t 1. Load the save farms from file");
        System.out.println("\t 2. Save all current farms to file");
        System.out.println("\t 3. Start again with new farms");
        System.out.println("\t 4. Exit Program");
    }
    private static void printFarmSelectionMenu()
    {
        System.out.println("\nEnter: ");
        System.out.println("\t 1. Display all farms by name");
        System.out.println("\t 2. Add a Farm");
        System.out.println("\t 3. Select a Farm to manage");
        System.out.println("\t 4. Select a Farm to Delete");
        System.out.println("\t 5. Return to the Main menu");
        System.out.println("\t 6. Exit Program");
    }
    private static void printIndividualFarmMenu()
    {
        System.out.println("\nEnter: ");
        System.out.println("\t 1. Add an animal to the farm");
        System.out.println("\t 2. Animal Management");
        System.out.println("\t 3. Add Shed to Farm");
        System.out.println("\t 4. Shed Management");
        System.out.println("\t 5. Farm Details");
        System.out.println("\t 6. Register animal death");
        System.out.println("\t 7. Milk all animals on Farm");
        System.out.println("\t 8. Collect milk from milk tanks");
        System.out.println("\t 9. Display herd details by criteria");
        System.out.println("\t 10. Return to Farm Selection Menu");
        System.out.println("\t 11. Exit Program");
    }
    private static void printExitMenu()
    {
        System.out.println("\nWould you like to save before exiting");
        System.out.println("Enter: ");
        System.out.println("\t 1. Exit and save");
        System.out.println("\t 2. Exit without saving");
    }

}


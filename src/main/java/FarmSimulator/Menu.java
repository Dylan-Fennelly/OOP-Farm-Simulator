package FarmSimulator;
import FarmSimulator.MenuEnums.*;

import java.sql.SQLOutput;
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
                System.out.println(Colours.RED + "Selection out of range" + Colours.RESET);
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
            ListAllFarmsByName();
            System.out.println("Please select a farm to use by selecting the farms number in the list");
            try
            {
                int userChoice = keyboard.nextInt();
                keyboard.nextLine();
                Farm selectedFarm = farmManger.getFarms().get(userChoice-1);
                currentFarm = selectedFarm;
                loop = false;
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

    private static void ListAllFarmsByName()
    {
        int count = 0;
        for(Farm farm:farmManger.getFarms())
        {
            System.out.println((count+1) +".) "+farmManger.getFarms().get(count).getFarmOwner());
            count++;
        }
    }

    private static void deleteFarm()
    {
        boolean loop = true;
        while(loop)
        {
            ListAllFarmsByName();
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
            catch (IndexOutOfBoundsException aioobe)
            {
                System.out.println("Please input a number if the correct range");
            }
            catch (InputMismatchException ime)
            {
                System.out.println("Please enter a valid input(number)");
            }

        }
    }

    private static void IndividualFarmMenu()
    {
        System.out.println(Colours.BLUE +"Now managing current farm"+Colours.RESET);

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
                        editAnimal();
                        break;

                    case ADD_SHED:
                        addShed();
                        break;

                    case EDIT_SHED:
                        editSheds();
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
                        printHerdByCriteria();
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
    }

    private static void editAnimal()
    {
        
    }

    private static void addShed()
    {
        
    }

    private static void editSheds()
    {
        
    }

    private static void printFarmDetails()
    {
        
    }

    private static void milkAllAnimals()
    {
        
    }

    private static void collectAllMilkTanks()
    {
        
    }

    private static void registerAnimalDeath()
    {
        
    }

    private static void printHerdByCriteria()
    {
        
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
        System.out.println("\t 1. Add a Farm");
        System.out.println("\t 2. Select a Farm to manage");
        System.out.println("\t 3. Select a Farm to Delete");
        System.out.println("\t 4. Return to the Main menu");
        System.out.println("\t 5. Exit Program");
    }
    private static void printIndividualFarmMenu()
    {
        System.out.println("\nEnter: ");
        System.out.println("\t 1. Add an animal to the farm");
        System.out.println("\t 2. Animal Management");
        System.out.println("\t 3. Add Shed to Farm");
        System.out.println("\t 4. Shed Management");
        System.out.println("\t 5. Farm Details");
        System.out.println("\t 6. Milk all animals on Farm");
        System.out.println("\t 7. Register animal death");
        System.out.println("\t 8. Collect milk from milk tanks");
        System.out.println("\t 9. Display herd details by criteria");
        System.out.println("\t 10. Return to Farm Selection Menu");
        System.out.println("\t 10. Exit Program");
    }
    private static void printExitMenu()
    {
        System.out.println("\nWould you like to save before exiting");
        System.out.println("Enter: ");
        System.out.println("\t 1. Exit and save");
        System.out.println("\t 3. Exit without saving");
    }

}


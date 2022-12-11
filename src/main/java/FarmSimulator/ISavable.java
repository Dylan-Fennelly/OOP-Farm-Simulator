package FarmSimulator;

import java.util.ArrayList;

public interface ISavable
{
    ArrayList<Farm> loadFromFile();
    void saveToFile();
}

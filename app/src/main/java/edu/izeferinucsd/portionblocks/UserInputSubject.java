package edu.izeferinucsd.portionblocks;

/**
 * Created by zefer on 10/1/2016.
 */

public interface UserInputSubject {
    void registerObserver(UserInputObserver observer);
    void removeObserver();
    void notifyObserver();
}

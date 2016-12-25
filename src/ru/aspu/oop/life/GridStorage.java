package ru.aspu.oop.life;


/**
 * Created by aaand on 22.12.2016.
 */
public interface GridStorage {
    void storeGrid(Grid grid, String gridName);
    Grid loadGrid(String gridName);

}

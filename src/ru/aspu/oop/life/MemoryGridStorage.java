package ru.aspu.oop.life;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aaand on 22.12.2016.
 */
public class MemoryGridStorage implements GridStorage {
    private Map<String, Grid> worlds = new HashMap<>();
    public int size;

    public void storeGrid(Grid grid, String gridName) {
        worlds.put(gridName, grid);
        size++;
    }

    public Grid loadGrid(String gridName) {
        return worlds.getOrDefault(gridName, null);
    }
}

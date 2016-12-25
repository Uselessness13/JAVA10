package ru.aspu.oop.life;

/**
 * Created by Dns on 25.12.2016.
 */
public class GridFactory {
    static LoopedGrid createGrid(int height, int width){
        return new LoopedGrid(width, height);
    }
}

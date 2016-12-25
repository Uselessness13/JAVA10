package ru.aspu.oop.life;

/**
 * Created by aaand on 22.12.2016.
 */
public class LoopedGrid extends Grid {
    public LoopedGrid(int width, int height) {
        super(width, height);
    }

    @Override
    public Cell getCellAt(int x, int y) {
        if (x >= width)
            x = 0;
        if (x < 0)
            x = width-1;
        if (y >= height)
            y = 0;
        if (y < 0)
            y = height-1;
        return cells[x][y];
    }
}

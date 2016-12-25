package ru.aspu.oop.life;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class TextFileLifeGridStorage implements GridStorage {
    public String directory;

    public TextFileLifeGridStorage(String dir) {
        this.directory = dir;
    }

    @Override
    public void storeGrid(Grid grid, String gridName) {
        try {
            PrintWriter pw = new PrintWriter(directory + gridName);
            pw.println(grid.width);
            pw.println(grid.height);
            for (int i = 0; i < grid.cells.length; i++) {
                for (int j = 0; j < grid.cells[i].length; j++) {
                    if (grid.getCellAt(i, j).getColor() == Color.MAGENTA) {
                        pw.print("@");
                    } else pw.print(".");
                }
                pw.println();
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл!");
        }

    }

    @Override
    public LoopedGrid loadGrid(String gridName) {
        LoopedGrid lp = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(directory + gridName));
            int wd = Integer.parseInt(br.readLine());
            int he = Integer.parseInt(br.readLine());
            lp = new LoopedGrid(wd, he);
            for (int i = 0; i < lp.cells.length; i++) {
                char[] temp = br.readLine().toCharArray();
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j] == '@') {
                        //    System.out.print("@");
                        lp.setCellAt(j, i, new LifeCell(true));
                    } else {
                        //    System.out.print(".");
                        lp.setCellAt(j, i, new LifeCell(false));
                    }
                }
                //System.out.println();
            }
            br.close();
            return lp;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Ошибка чтения из файла!");
        }
        return lp;
    }
}

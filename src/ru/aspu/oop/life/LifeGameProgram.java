package ru.aspu.oop.life;

import javafx.scene.shape.Path;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


// программа дл€ запуска игры
public class LifeGameProgram {
    private int savesCounter = 0;

    private BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));

    public void run() {
        TextFileLifeGridStorage meme = new TextFileLifeGridStorage("C:\\Users\\Dns\\Google ƒиск\\”нивер\\¬торой курс\\JAVA\\Labs\\life-figures\\");
        String rules = "B3/S23";
        int selection;
        // создаем новую сетку размером 200х100 €чеек
        LoopedGrid grid = GridFactory.createGrid(100, 200);
        // создаем новое окно дл€ отображени€ сетки, размер €чейки - 5 пикселей
        GridView view = new GridView(grid, 5);
        LifeGame game = new LifeGame(grid, view, rules);
        try {
            do {
                view.updateView();
                selection = menu();
                if (selection == 1) {
                    game.step();
                }
                if (selection == 2) {
                    System.out.println("¬ведите количество шагов");
                    int n = Integer.parseInt(br.readLine());
                    game.multipleSteps(n);
                }
                if (selection == 3) {
                    view.setShowGridLines(true);
                }
                if (selection == 4) {
                    view.setShowGridLines(false);
                }
                if (selection == 5) {
                    System.out.println("¬ведите название сохранени€");
                    String name = br.readLine();
                    if (name.isEmpty()) {
                        name = "—охранение " + savesCounter;
                        savesCounter++;
                    }
                    meme.storeGrid(grid, name);
                }
                if (selection == 6) {
                    System.out.println("¬ведите название сохранени€");
                    String name = br.readLine();
                    view.setGrid(meme.loadGrid(name), 5);
                }
                if (selection == 9) {
                    game = new LifeGame(grid, view, rules);
                    game.populate();
                }
            } while (selection != 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);

    }

    // ћетод выводит меню и запрашивает у пользовател€ выбор операции
    public int menu() throws IOException {
        System.out.println("¬ыберите операцию:");
        System.out.println("1 - один шаг");
        System.out.println("2 - N шагов");
        System.out.println("3 - включить сетку");
        System.out.println("4 - выключить сетку");
        System.out.println("5 - сохранить игру");
        System.out.println("6 - загрузить игру");
        System.out.println("9 - начать новую игру");
        System.out.println("0 - завершить работу");
        String input = br.readLine();
        int selection = Integer.parseInt(input);
        return selection;
    }


}

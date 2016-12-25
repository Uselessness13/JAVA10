package ru.aspu.oop.life;

import javafx.scene.shape.Path;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


// ��������� ��� ������� ����
public class LifeGameProgram {
    private int savesCounter = 0;

    private BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));

    public void run() {
        TextFileLifeGridStorage meme = new TextFileLifeGridStorage("C:\\Users\\Dns\\Google ����\\������\\������ ����\\JAVA\\Labs\\life-figures\\");
        String rules = "B3/S23";
        int selection;
        // ������� ����� ����� �������� 200�100 �����
        LoopedGrid grid = GridFactory.createGrid(100, 200);
        // ������� ����� ���� ��� ����������� �����, ������ ������ - 5 ��������
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
                    System.out.println("������� ���������� �����");
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
                    System.out.println("������� �������� ����������");
                    String name = br.readLine();
                    if (name.isEmpty()) {
                        name = "���������� " + savesCounter;
                        savesCounter++;
                    }
                    meme.storeGrid(grid, name);
                }
                if (selection == 6) {
                    System.out.println("������� �������� ����������");
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

    // ����� ������� ���� � ����������� � ������������ ����� ��������
    public int menu() throws IOException {
        System.out.println("�������� ��������:");
        System.out.println("1 - ���� ���");
        System.out.println("2 - N �����");
        System.out.println("3 - �������� �����");
        System.out.println("4 - ��������� �����");
        System.out.println("5 - ��������� ����");
        System.out.println("6 - ��������� ����");
        System.out.println("9 - ������ ����� ����");
        System.out.println("0 - ��������� ������");
        String input = br.readLine();
        int selection = Integer.parseInt(input);
        return selection;
    }


}

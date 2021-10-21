package com.company;
import customlist.Node;

import customlist.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        LinkedList<Integer> obj = new LinkedList<Integer>();
        var x=1;
        while (x!=0) {
            if (x < 0)
                System.out.println("Некорректный ввод");
            var in = new Scanner(System.in);
            Scanner index = new Scanner(System.in);
            System.out.println("Введите команду:");
            System.out.println("1: Добавить в конец списка:");
            System.out.println("2: Добавить в начало списка:");
            System.out.println("3: Удалить из конца списка:");
            System.out.println("4: Удалить из начала списка:");
            System.out.println("5: Вставить:");
            System.out.println("6: Удалить определенный элемент:");
            System.out.println("7: Извлечь:");
            System.out.println("8: Напечатать:");
            System.out.println("0: Выйти:");
            while (!in.hasNextInt()) {
                System.out.println("Некорректный ввод");
                in.next();
            }
            x = in.nextInt();
            switch (x) {
                case 1: {
                    System.out.println("Введите значение:");
                    var i = index.nextInt();
                    obj.pushBack(i);
                    break;
                }
                case 2: {
                    System.out.println("Введите значение:");
                    var i = index.nextInt();
                    obj.pushFront(i);
                    break;
                }
                case 3: {
                    try {
                        obj.popBack();
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 4: {
                    try {
                        obj.popFront();
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 5: {
                    System.out.println("Введите позицию:");
                    var position = index.nextInt();
                    System.out.println("Введите значение:");
                    var value = index.nextInt();
                    try {
                        obj.insertAt(position, value);
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 6: {
                    System.out.println("Введите позицию:");
                    var position = index.nextInt();
                    try {
                        obj.eraseAt(position);
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex.getMessage());
                    }
                }
                case 7: {
                    System.out.println("Введите позицию:");
                    var position = index.nextInt();
                    try {
                        System.out.println(obj.getAt(position));
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 8: {
                    System.out.println(obj.toString());
                    break;
                }
                default: {

                }
            }

        }
    }
}
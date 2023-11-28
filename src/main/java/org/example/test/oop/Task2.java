package org.example.test.oop;

public class Task2 {
    public static void main(String[] args) {
        /*Императивное программирование
        В исходный код программы записал инструкцию (команды);
        инструкции выполняются последовательно,
        данные, полученные при выполнении инструкции, могу записывать в память.*/
        numbersCal(9);
    }
    public static void numbersCal(int number){
        int result=1;
        for (int i = 1; i <= number; i++) {
            result*=i;
            System.out.println(1+" * "+i+" = "+result);
            result=1;
        }
    }
}

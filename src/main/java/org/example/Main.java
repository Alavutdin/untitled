package org.example;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int [] array={5,8,9,10};
        sortElement(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        Integer[] a = { 5,8,9,10 };
        Arrays.sort(a, Collections.reverseOrder());
        System.out.println(Arrays.toString(a));
    }
    public static void sortElement(int []array){
        int temp;
        for (int i = 0; i <array.length-1; i++) {
            for (int j = 1; j < array.length-i; j++) {
                if (array[j-1]<array[j]){
                    temp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }

            }

        }
    }
}
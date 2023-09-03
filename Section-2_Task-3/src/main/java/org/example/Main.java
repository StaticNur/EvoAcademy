package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[20];
        Map<Integer,Integer> amountOfNum = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            array[i] = random.nextInt(15) + 1;
            if(amountOfNum.get(array[i])!=null)
                amountOfNum.put(array[i],amountOfNum.get(array[i])+1);
            else amountOfNum.put(array[i],1);
        }
        System.out.println(Arrays.toString(array));
        for (int a:amountOfNum.keySet()) {
            if(amountOfNum.get(a)>1)
                System.out.println("число '"+a+"' встречается "+amountOfNum.get(a)+" раза");
        }
    }
}
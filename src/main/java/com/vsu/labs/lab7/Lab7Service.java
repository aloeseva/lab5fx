package com.vsu.labs.lab7;

import java.util.Arrays;

public class Lab7Service {

    public static String solution(int[] mas) {
        String str = "";
        StringBuilder strBuilder = new StringBuilder(str);

        int max = 0, min = 1;
        for (int i = 0; i < mas.length; ++i)
        {
            if (mas[max] < mas[i])
                max = i;
        }
        for (int i = mas.length - 1; i > -1; --i)
        {
            if (mas[min] > mas[i])
            {
                min = i;
            }
        }
        int s = 0;
        if (max > min)
            strBuilder.append("Максимальный элемент встречается позже минимального элемента");
        else if (max < min)
        {
            for (int i = max + 1; i < min; ++i)
            {
                s = s + mas[i];
            }
        }
        strBuilder.append(s);
        return strBuilder.toString();
    }

    public static int[] parsToMassive(String str) throws NumberFormatException {
        return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}

package com.vsu.labs.lab6;

public class Lab6Service {
    public static String result(double x, int n, double e) {
        String str = "";
        StringBuilder strBuilder = new StringBuilder(str);
        double math = Math.sin(x) / x;

        int countE = 0;
        int countEDivide = 0;
        double sum = 1;
        double anTmp = 1;
        for (int i = 2; i <= n; i++) {
            anTmp = f(x, anTmp, i);
            sum += anTmp;
            if (Math.abs(anTmp) > e) {
                countE++;
            }

            if (Math.abs(anTmp) > e/10) {
                countEDivide++;
            }
        }

        strBuilder.append("Сумма n слагаемых = ").append(sum).append("\n");
        strBuilder.append("Сумма слагаемых, которые по абсолютной величине больше e = ").append(countE).append("\n");
        strBuilder.append("Сумма слагаемых, которые по абсолютной величине больше e/10 = ").append(countEDivide).append("\n");
        strBuilder.append("Значение функции с помощью методов Math = ").append(math);
        return strBuilder.toString();
    }

    private static double f(double x, double anPrev, int n) {
        double r = anPrev * ((x * x) / ((2*n - 2) * (2*n - 1)));
        return r * -1;
    }
}

package com.vsu.labs.lab5;

public class Lab5Service {
    public static String figure(int s) {
        String str = "";
        StringBuilder strBuilder = new StringBuilder(str);
        starDraw(s/2, s/2, true, strBuilder);
        starDraw(s/2, 1, false, strBuilder);
        return strBuilder.toString();
    }

    private static void starDraw(int s, int sIter, boolean inv, StringBuilder str) {
        if (inv) {
            str.append(" ".repeat(Math.max(0, s)));

            supplier(s, sIter, str);

            if (sIter != 1) {
                starDraw(s, sIter-1, true, str);
            }
        } else {
            str.append(" ".repeat(Math.max(0, s - sIter)));

            supplier(s, sIter, str);

            if (sIter < s) {
                starDraw(s, sIter + 1, false, str);
            }
        }
    }

    private static void supplier(int s, int sIter, StringBuilder str) {
        if (s == sIter) {
            str.append("*".repeat(Math.max(0, s)));
        } else if (sIter > 1) {
            str.append("*");
            if (sIter > 2) {
                str.append("#".repeat(sIter - 2));
            }
            str.append("*");
        } else {
            str.append("*");
        }
        str.append("\n");
    }

}

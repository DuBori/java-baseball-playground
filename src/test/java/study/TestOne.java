package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestOne {

    public static String calculator() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s == null || s.equals("")) {
            return null;
        }

        String[] strings = s.split(" ");

        int result = 0;

        try {
            result = Integer.parseInt(strings[0]);
        }catch (NumberFormatException e){
            return null;
        }

        for (int i = 1; i < strings.length; i+=2) {
             result = cal(strings, i, result);
        }
        return String.valueOf(result);
    }

    private static int cal(String[] strings, int i,int result) {
        if("*".equals(strings[i])){
            return result * Integer.parseInt(strings[i + 1]);
        }
        if("/".equals(strings[i])){
            return result / Integer.parseInt(strings[i + 1]);
        }
        if("+".equals(strings[i])){
            return result + Integer.parseInt(strings[i + 1]);
        }
        if("-".equals(strings[i])){
            return result - Integer.parseInt(strings[i + 1]);
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println("result = "+ calculator());
    }

}

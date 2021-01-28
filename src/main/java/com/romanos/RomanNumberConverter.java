package com.romanos;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanNumberConverter {

    public static void main(String[] args) {
        System.out.println(convertToRomanNumber(4518));
    }

    public static String convertToRomanNumber(Integer number){
        if(number <= 0) return "Invalid input";
        Map<Integer, String> romanNumbers = new HashMap<>();
        romanNumbers.put(1, "I");
        romanNumbers.put(5, "V");
        romanNumbers.put(10, "X");
        romanNumbers.put(50, "L");
        romanNumbers.put(100, "C");
        romanNumbers.put(500, "D");
        romanNumbers.put(1000, "M");

        List<Integer> divisors = new ArrayList<>(romanNumbers.keySet());
        Collections.sort(divisors, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < divisors.size(); i++){
            int division = Math.floorDiv(number, divisors.get(i));
            int rest = number % divisors.get(i);

            if(rest == number) continue;

            if(division <= 3 || divisors.get(i) == 1000){
                String s = romanNumbers.get(divisors.get(i));
                sb.append(new String(new char[division]).replace("\0", s));
            } else {
                String s_1 = romanNumbers.get(divisors.get(i - 1));
                String s = romanNumbers.get(divisors.get(i));
                sb.append(s + s_1);
            }

            number = rest;
        }

        return sb.toString();
    }
}

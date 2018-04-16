package test.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //первое условие
        List<String> l1 = Arrays.asList("orange");
        List<String> l2 = Arrays.asList("apple", "apple");
        List<String> l3 = Arrays.asList("banana", "orange", "apple");
        List<String> l4 = Arrays.asList("banana");
        List<List<String>> codeList = Arrays.asList(l1, l2, l3, l4);
        List<String> shoppingCart = Arrays.asList("orange", "apple", "apple", "banana", "orange", "apple", "banana");
        System.out.println(isWin(codeList, shoppingCart));
        //второе условие
        List<String> l1_2 = Arrays.asList("apple", "apricot");
        List<String> l2_2 = Arrays.asList("banana", "anything", "guava");
        List<String> l3_2 = Arrays.asList("papaya", "anything");
        List<List<String>> codeLis2 = Arrays.asList(l1_2, l2_2, l3_2);
        List<String> shoppingCart2 = Arrays.asList("banana", "orange", "guava", "apple", "apricot", "papaya", "kiwi");
        System.out.println(isWin(codeLis2, shoppingCart2));
    }

    private static int isWin(List<List<String>> code, List<String> cart) {
        int numberGroups = code.size();
        int result = 0;
        int countInside = 0;
        mark:
        for (String fruitCart : cart) {
            for (int i = result; i < code.size(); i++) {
                List<String> list = code.get(i);
                for (int j = countInside; j < list.size(); j++) {
                    String fruitCode = list.get(j);
                    if (fruitCart.equals(fruitCode) || fruitCode.equals("anything")) {
                        countInside++;
                        if (countInside == list.size()) {
                            result++;
                            countInside = 0;
                            continue mark;
                        }
                        continue mark;
                    } else if (!fruitCart.equals(fruitCode) && countInside > 0) {
                        result = 0;
                        countInside = 0;
                        continue mark;
                    }
                    continue mark;
                }

            }
        }
        return numberGroups == result ? 1 : 0;
    }

}
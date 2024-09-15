package stream.task1;

import java.util.*;
import java.util.stream.*;

public class NumberStatistics {
    public static void main(String[] args) {
        List<Integer> numbers = new Random().ints(100, -1000, 1000)
                .boxed()
                .collect(Collectors.toList());

        long positiveCount = numbers.stream()
                .filter(n -> n > 0)
                .count();

        long negativeCount = numbers.stream()
                .filter(n -> n < 0)
                .count();

        long twoDigitCount = numbers.stream()
                .filter(n -> Math.abs(n) >= 10 && Math.abs(n) < 100)
                .count();

        long palindromeCount = numbers.stream()
                .filter(NumberStatistics::isPalindrome)
                .count();

        System.out.println("Числа: " + numbers);
        System.out.println("Количество положительных: " + positiveCount);
        System.out.println("Количество отрицательных: " + negativeCount);
        System.out.println("Количество двухзначных: " + twoDigitCount);
        System.out.println("Количество зеркальных чисел: " + palindromeCount);
    }

    private static boolean isPalindrome(int number) {
        String str = String.valueOf(Math.abs(number));
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}

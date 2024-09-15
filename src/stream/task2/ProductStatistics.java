package stream.task2;

import java.util.*;
import java.util.stream.*;

public class ProductStatistics {
    public static void main(String[] args) {
        try {
            List<String> products = Arrays.asList(
                    "Молоко", "Хлеб", "Сыр", "Яблоко", "Молоко", "Кефир", "Творог", "Сок", "Банан", "Молоко", "Сметана"
            );

            System.out.println("Все продукты:");
            products.stream()
                    .forEach(System.out::println);

            System.out.println("\nПродукты с названием меньше пяти символов:");
            products.stream()
                    .filter(product -> product.length() < 5)
                    .forEach(System.out::println);

            Scanner scanner = new Scanner(System.in);
            System.out.print("\nВведите название продукта для поиска: ");
            String userInput = scanner.nextLine();

            long count = products.stream()
                    .filter(product -> product.equalsIgnoreCase(userInput))
                    .count();
            System.out.println("Продукт \"" + userInput + "\" встречается " + count + " раз.");

            System.out.print("\nВведите первую букву для фильтрации продуктов: ");
            char firstLetter = scanner.nextLine().charAt(0);

            List<String> filteredProducts = products.stream()
                    .filter(product -> product.startsWith(String.valueOf(firstLetter)))
                    .collect(Collectors.toList());

            if (!filteredProducts.isEmpty()) {
                System.out.println("\nПродукты, которые начинаются на букву \"" + firstLetter + "\":");
                filteredProducts.forEach(System.out::println);
            } else {
                System.out.println("Продукты, которые начинаются на букву \"" + firstLetter + "\", не найдены.");
            }

            System.out.println("\nПродукты из категории \"Молоко\":");
            products.stream()
                    .filter(product -> product.equalsIgnoreCase("Молоко"))
                    .forEach(System.out::println);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

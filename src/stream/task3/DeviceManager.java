package stream.task3;

import java.util.*;
import java.util.stream.*;

public class DeviceManager {
    public static void main(String[] args) {
        List<Device> devices = Arrays.asList(
                new Device("Смартфон", 2020, 700.0, "черный", "мобильный"),
                new Device("Ноутбук", 2019, 1200.0, "серый", "компьютер"),
                new Device("Планшет", 2021, 500.0, "белый", "мобильный"),
                new Device("Телевизор", 2018, 1500.0, "черный", "электроника"),
                new Device("Монитор", 2017, 300.0, "черный", "компьютер"),
                new Device("Часы", 2022, 250.0, "белый", "аксессуар")
        );

        System.out.println("Все устройства:");
        devices.stream().forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);

        String tempColorFilter;
        while (true) {
            System.out.print("\nВведите цвет для фильтрации: ");
            tempColorFilter = scanner.nextLine();
            if (!tempColorFilter.isEmpty()) break;
            System.out.println("Ошибка: цвет не может быть пустым. Попробуйте еще раз.");
        }
        final String colorFilter = tempColorFilter;
        System.out.println("\nУстройства заданного цвета (" + colorFilter + "):");
        devices.stream()
                .filter(device -> device.getColor().equalsIgnoreCase(colorFilter))
                .forEach(System.out::println);

        int yearFilter;
        while (true) {
            System.out.print("\nВведите год выпуска для фильтрации: ");
            if (scanner.hasNextInt()) {
                yearFilter = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибка: введите корректное числовое значение для года.");
                scanner.next();
            }
        }

        System.out.println("\nУстройства, выпущенные в " + yearFilter + " году:");
        devices.stream()
                .filter(device -> device.getYear() == yearFilter)
                .forEach(System.out::println);

        double priceFilter;
        while (true) {
            System.out.print("\nВведите минимальную цену: ");
            if (scanner.hasNextDouble()) {
                priceFilter = scanner.nextDouble();
                break;
            } else {
                System.out.println("Ошибка: введите корректное числовое значение для цены.");
                scanner.next();
            }
        }

        System.out.println("\nУстройства дороже " + priceFilter + ":");
        devices.stream()
                .filter(device -> device.getPrice() > priceFilter)
                .forEach(System.out::println);

        scanner.nextLine();
        String tempTypeFilter;
        while (true) {
            System.out.print("\nВведите тип устройства для фильтрации: ");
            tempTypeFilter = scanner.nextLine();
            if (!tempTypeFilter.isEmpty()) break;
            System.out.println("Ошибка: тип устройства не может быть пустым. Попробуйте еще раз.");
        }
        final String typeFilter = tempTypeFilter;
        System.out.println("\nУстройства типа \"" + typeFilter + "\":");
        devices.stream()
                .filter(device -> device.getType().equalsIgnoreCase(typeFilter))
                .forEach(System.out::println);

        int minYear;
        while (true) {
            System.out.print("\nВведите минимальный год выпуска: ");
            if (scanner.hasNextInt()) {
                minYear = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибка: введите корректное числовое значение для минимального года.");
                scanner.next();
            }
        }

        int tempMaxYear;
        while (true) {
            System.out.print("Введите максимальный год выпуска: ");
            if (scanner.hasNextInt()) {
                tempMaxYear = scanner.nextInt();
                if (tempMaxYear >= minYear) {
                    break;
                } else {
                    System.out.println("Ошибка: максимальный год должен быть больше или равен минимальному.");
                }
            } else {
                System.out.println("Ошибка: введите корректное числовое значение для максимального года.");
                scanner.next();
            }
        }
        final int maxYear = tempMaxYear;

        System.out.println("\nУстройства, выпущенные с " + minYear + " по " + maxYear + " год:");
        devices.stream()
                .filter(device -> device.getYear() >= minYear && device.getYear() <= maxYear)
                .forEach(System.out::println);
    }
}

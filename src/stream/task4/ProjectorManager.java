package stream.task4;

import java.util.*;
import java.util.stream.*;

public class ProjectorManager {
    public static void main(String[] args) {
        List<Projector> projectors = Arrays.asList(
                new Projector("Epson X400", 2023, 750.0, "Epson"),
                new Projector("Sony VPL-HW45ES", 2022, 1200.0, "Sony"),
                new Projector("LG PF50KA", 2024, 500.0, "LG"),
                new Projector("BenQ HT2050A", 2021, 900.0, "BenQ"),
                new Projector("Optoma HD146X", 2024, 650.0, "Optoma"),
                new Projector("Sony VPL-VW295ES", 2023, 2000.0, "Sony")
        );

        System.out.println("Все проекторы:");
        projectors.stream().forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nВведите производителя для фильтрации: ");
        String manufacturerFilter = scanner.nextLine();
        System.out.println("\nПроекторы производителя \"" + manufacturerFilter + "\":");
        projectors.stream()
                .filter(projector -> projector.getManufacturer().equalsIgnoreCase(manufacturerFilter))
                .forEach(System.out::println);

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println("\nПроекторы текущего года (" + currentYear + "):");
        projectors.stream()
                .filter(projector -> projector.getYear() == currentYear)
                .forEach(System.out::println);

        System.out.print("\nВведите минимальную цену для фильтрации: ");
        double priceFilter = scanner.nextDouble();
        System.out.println("\nПроекторы дороже " + priceFilter + ":");
        projectors.stream()
                .filter(projector -> projector.getPrice() > priceFilter)
                .forEach(System.out::println);

        System.out.println("\nПроекторы, отсортированные по цене по возрастанию:");
        projectors.stream()
                .sorted(Comparator.comparingDouble(Projector::getPrice))
                .forEach(System.out::println);

        System.out.println("\nПроекторы, отсортированные по цене по убыванию:");
        projectors.stream()
                .sorted(Comparator.comparingDouble(Projector::getPrice).reversed())
                .forEach(System.out::println);
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создаем набор ноутбуков
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Lenovo", 8, 512, "Windows 10", "Black"));
        notebooks.add(new Notebook("HP", 16, 1000, "Windows 10", "Silver"));
        notebooks.add(new Notebook("Dell", 8, 256, "Ubuntu 20.04", "Black"));
        notebooks.add(new Notebook("Asus zenbook", 32, 6144, "Windows 11", "Black"));
        notebooks.add(new Notebook("Apple MacBook Air", 16, 1024, "macOS", "Silver"));
        notebooks.add(new Notebook("Huawei", 16, 3072, "Windows 11", "Silver"));
        notebooks.add(new Notebook("Asus", 16, 512, "Windows 11", "Blue"));
        notebooks.add(new Notebook("HP", 16, 512, "Windows 10", "White"));
        notebooks.add(new Notebook("Dell XPS 13", 16, 512, "Windows 10", "Black"));

        // Запрашиваем у пользователя критерии фильтрации
    Scanner scanner = new Scanner(System.in);
    Map<String, Object> filters = new HashMap<>();
    System.out.println("Введите критерии фильтрации:");
    System.out.println("1 - ОЗУ (минимальное значение)");
    System.out.println("2 - Объем жесткого диска (минимальное значение)");
    System.out.println("3 - Операционная система (название)");
    System.out.println("4 - Цвет");
    System.out.println("Введите номер критерия (или 0 для завершения ввода):");
    int criteria = scanner.nextInt();
    while (criteria != 0) {
        switch (criteria) {
            case 1:
                System.out.println("Введите минимальное значение ОЗУ:");
                int ram = scanner.nextInt();
                filters.put("ram", ram);
                break;
            case 2:
                System.out.println("Введите минимальное значение объема жесткого диска:");
                int storage = scanner.nextInt();
                filters.put("storage", storage);
                break;
            case 3:
                System.out.println("Введите название операционной системы:");
                String os = scanner.next();
                filters.put("os", os);
                break;
            case 4:
                System.out.println("Введите цвет:");
                String color = scanner.next();
                filters.put("color", color);
                break;
            default:
                System.out.println("Неверный номер критерия. Попробуйте еще раз.");
                break;
        }
        System.out.println("Введите номер критерия (или 0 для завершения ввода):");
        criteria = scanner.nextInt();
    }

    // Фильтруем ноутбуки и выводим результаты
    Set<Notebook> filteredNotebooks = NotebookFilter.filterNotebooks(notebooks, filters);
    if (filteredNotebooks.isEmpty()) {
        System.out.println("Ноутбуки, удовлетворяющие критериям фильтрации, не найдены.");
    } else {
        System.out.println("Найдены следующие ноутбуки, удовлетворяющие критериям фильтрации:");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }
}
}
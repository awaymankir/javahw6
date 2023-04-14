import java.util.*;

public class NotebookFilter {
    public static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<String, Object> filters) {
        Set<Notebook> filteredNotebooks = new HashSet<>();

        for (Notebook notebook : notebooks) {
            if (matchesFilters(notebook, filters)) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }

    private static boolean matchesFilters(Notebook notebook, Map<String, Object> filters) {
        for (String key : filters.keySet()) {
            Object value = filters.get(key);
            switch (key) {
                case "ram":
                    if (notebook.getRam() < (int) value) {
                        return false;
                    }
                    break;
                case "storage":
                    if (notebook.getStorage() < (int) value) {
                        return false;
                    }
                    break;
                case "os":
                    if (!notebook.getOs().equals(value)) {
                        return false;
                    }
                    break;
                case "color":
                    if (!notebook.getColor().equals(value)) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }

        return true;
    }
}
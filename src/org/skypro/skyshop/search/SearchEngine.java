package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] searchables;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public void add(Searchable item) {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = item;
                return;
            }
        }
        System.out.println("Нет свободного места в поисковом движке");
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int count = 0;

        for (Searchable item : searchables) {
            if (item == null) {
                continue;
            }

            // Ищем без учета регистра, так удобнее
            if (item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[count] = item;
                count++;
                if (count == 5) {
                    break; // нашли 5 результатов, дальше не ищем
                }
            }
        }
        return results;
    }
}

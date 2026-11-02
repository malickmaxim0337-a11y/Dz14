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
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int count = 0;
        for (Searchable item : searchables) {
            if (item == null) continue;
            if (item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[count] = item;
                count++;
                if (count == 5) break;
            }
        }
        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable item : searchables) {
            if (item == null) continue;
            int occurrences = countOccurrences(item.getSearchTerm(), search);
            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                bestMatch = item;
            }
        }

        if (bestMatch == null || maxOccurrences == 0) {
            throw new BestResultNotFound(search);
        }
        return bestMatch;
    }

    private int countOccurrences(String text, String search) {
        if (text == null || search == null || search.isEmpty()) return 0;
        int count = 0;
        int index = 0;
        int foundIndex = text.toLowerCase().indexOf(search.toLowerCase(), index);
        while (foundIndex != -1) {
            count++;
            index = foundIndex + search.length();
            foundIndex = text.toLowerCase().indexOf(search.toLowerCase(), index);
        }
        return count;
    }
}

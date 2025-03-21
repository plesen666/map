package org.skypro.skyshop.product.searchengine;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Searchable;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searchable = new HashSet<>();

    public Set<Searchable> getSearchable() {
        return searchable;
    }

    public Set<Searchable> search(String query) {
        return searchable.stream()
                .filter(product -> product != null && product.sortingElement().toLowerCase().contains(query.trim().toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new NewComparator())));
    }
    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        int indexStart = 0;
        int indexStop;
        int numberRepetitions = 0;
        int maximumNumberRepetitions = 0;
        Searchable maximumMatches = null;
        for (Searchable element : searchable) {
            if ((element.getSearchTemp().toLowerCase().trim().contains(search.toLowerCase().trim()))) {
                indexStop = element.getSearchTemp().toLowerCase().trim().indexOf(search.toLowerCase().trim(), indexStart);
                while (indexStop != -1) {
                    numberRepetitions++;
                    indexStart = indexStop + search.length();
                    indexStop = element.getSearchTemp().toLowerCase().trim().indexOf(search.toLowerCase().trim(), indexStart);
                }
                if (numberRepetitions >= maximumNumberRepetitions) {
                    maximumNumberRepetitions = numberRepetitions;
                    maximumMatches = element;
                }
                indexStart = 0;
                numberRepetitions = 0;
            }
        }
        if (maximumMatches == null) {
            throw new BestResultNotFound(" ОБЪЕКТЫ ТИПА SEARCHABLE НЕ СОДЕРЖАТ СТРОКИ " + search.toUpperCase());
        }
        return maximumMatches;
    }

    public void add(Searchable[] newObject) {
        Collections.addAll(searchable, newObject);
    }

    public void clearSearchEngine() {
        searchable.clear();
    }
}
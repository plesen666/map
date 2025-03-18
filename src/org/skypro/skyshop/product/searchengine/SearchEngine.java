package org.skypro.skyshop.product.searchengine;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Searchable;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> searchable = new HashSet<>();

    public Set<Searchable> getSearchable() {
        return searchable;
    }

    public Set<Searchable> search(String searchBar) {
        Set<Searchable> searchArray = new TreeSet<>(new NewComporator());
        for (Searchable variable : searchable) {
            if (variable.sortingElement().toLowerCase().contains(searchBar.trim().toLowerCase())) {
                searchArray.add(variable);
            }
        }
        return searchArray;
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
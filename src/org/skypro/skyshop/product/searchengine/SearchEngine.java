package org.skypro.skyshop.product.searchengine;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class SearchEngine {
    private List<Searchable> searchable = new ArrayList<>();

    public List<Searchable> getSearchable() {
        return searchable;
    }

    public TreeMap<String, Searchable> search(String searchBar) {
        TreeMap<String, Searchable> searchArray = new TreeMap<>();
        for (Searchable variable : searchable) {
            if (variable.getSearchTemp().toLowerCase().contains(searchBar.trim().toLowerCase())) {
                searchArray.put(variable.getSearchTemp(), variable);
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
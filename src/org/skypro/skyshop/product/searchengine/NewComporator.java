package org.skypro.skyshop.product.searchengine;

import org.skypro.skyshop.product.Searchable;

import java.util.Comparator;

public class NewComporator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        if (Integer.compare(o2.sortingElement().length(), o1.sortingElement().length()) != 0) {
            return Integer.compare(o2.sortingElement().length(), o1.sortingElement().length());
        } else {
            return o1.sortingElement().compareToIgnoreCase(o2.sortingElement());
        }
    }
}
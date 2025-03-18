package org.skypro.skyshop.product;

public interface Searchable {
    String getSearchTemp();

    String getContentType();
    String sortingElement();
    default String getStringRepresentation() {
        return String.format("%5s%30s%10s%30s", "Имя ", getSearchTemp(), " — тип - ", getContentType());
    }
}
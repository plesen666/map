package org.skypro.skyshop.product;

public interface Searchable {
    String getSearchTemp();

    String getContentType();

    default String getStringRepresentation() {
        return String.format("%5s%22s%10s%20s", "Имя ", getSearchTemp(), " — тип - ", getContentType());
    }
}
package org.skypro.skyshop.product.article;

import org.skypro.skyshop.product.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private String titleAtribute;
    private String textAtribute;

    public Article(String titleAtribute, String textAtribute) {
        this.titleAtribute = titleAtribute.trim();
        this.textAtribute = textAtribute;
    }

    public String sortingElement() {
        return titleAtribute;
    }

    @Override
    public String toString() {
        return (String.format("%27s\n%35s", titleAtribute, textAtribute));
    }


    @Override
    public String getSearchTemp() {
        return (String.format("%27s\n%35s", titleAtribute, textAtribute));
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Article article = (Article) object;
        return Objects.equals(titleAtribute, article.titleAtribute);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titleAtribute);
    }
}
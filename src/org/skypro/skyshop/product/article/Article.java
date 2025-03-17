package org.skypro.skyshop.product.article;

public class Article implements Searchable {
    private String titleAtribute;
    private String textAtribute;

    public Article(String titleAtribute, String textAtribute) {
        this.titleAtribute = titleAtribute;
        this.textAtribute = textAtribute;
    }


    @Override
    public String toString() {
        return (String.format("%22s%32s\n%22s%32s", "название статьи", titleAtribute, "текст статьи", textAtribute));
    }


    @Override
    public String getSearchTemp() {
        return String.format("%27s\n%27s", textAtribute, textAtribute);
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }
}
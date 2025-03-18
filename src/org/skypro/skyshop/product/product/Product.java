package org.skypro.skyshop.product.product;

import org.skypro.skyshop.product.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private String nameProduct;

    public Product(String nameProduct) throws IllegalArgumentException {
        if (nameProduct.isBlank()) {
            throw new IllegalArgumentException("Ошибка - не введено название продукта в продуктовом массиве магазина");
        }
        this.nameProduct = nameProduct.trim();
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public abstract int getPrice();

    public boolean isSpecial() {
        return false;
    }

    public String getSearchTemp() {
        return nameProduct;
    }

    public String getContentType() {
        return "PRODUCT";
    }

    public String sortingElement() {
        return nameProduct;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Product product = (Product) object;
        return Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameProduct);
    }
}
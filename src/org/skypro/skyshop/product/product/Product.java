package org.skypro.skyshop.product.product;

public abstract class Product implements Searchable {
    private  String nameProduct;

    public Product(String nameProduct) throws IllegalArgumentException {
        if ((nameProduct == null) || (nameProduct.isBlank())) {
            throw new IllegalArgumentException("ОШИБКА - НЕ ВВЕДЕНО НАЗВАНИЕ ПРОДУКТА В ПРОДУКТОВОМ МАССИВЕ МАГАЗИНА");
        }
        this.nameProduct = nameProduct;
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

}
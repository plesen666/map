package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, ArrayList<Product>> products = new HashMap<>();

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ProductBasket that = (ProductBasket) object;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(products);
    }

    public void addProduct(Product titleProduct) {
        if (!products.containsKey(titleProduct.getNameProduct())) {
            products.put(titleProduct.getNameProduct(), new ArrayList<>());
        }
        products.get(titleProduct.getNameProduct()).add(titleProduct);
    }

    public int calculateCostBasket() {
        int summa = 0;
        if (products.isEmpty()) {
            System.out.println("Корзина пуста!!!");
            return 0;
        } else {
            for (ArrayList<Product> contact : products.values()) {
                for (Product variable : contact) {
                    summa += variable.getPrice();
                }
            }
        }
        return summa;
    }

    public void printContentBasket() {
        int counterIsSpecial = 0;
        if (products.isEmpty()) {
            System.out.println("Корзина пуста!!!");
        } else {
            System.out.printf("\n%20s%23s%10s%28s", "Продукт", "Цена", "Скидка", "Итоговая цена\n");
            for (ArrayList<Product> contact : products.values()) {
                for (Product variable : contact) {
                    if (variable.isSpecial()) {
                        counterIsSpecial++;
                    }
                    System.out.println(variable);
                }
            }
            System.out.printf("%20s%20d%5s\n%20s%5d%15s", "Итого: ", calculateCostBasket(), " руб", "Специальных товаров: ", counterIsSpecial, "  наименования(е)");
        }
    }

    public List<Product> deleteProduct(String line) {
        List<Product> delete = new ArrayList<>();
        if (products.isEmpty()) {
            System.out.println("В корзине нет продуктов");
        } else {
            for (String content : products.keySet()) {
                if (content.toLowerCase().contains(line.toLowerCase().trim())) {
                    delete.add(products.get(content).get(0));
                    products.get(content).remove(0);
                }
            }
        }
        return delete;
    }

    public boolean checkProductAvailability(String product) {
        if (product == null || product.isBlank()) {
            System.out.println("Не введено название поиска товара в корзине");
            return false;
        }
        if (products.isEmpty()) {
            System.out.println("Корзина пуста!!!");
        } else {
            for (String content : products.keySet()) {
                if ((content.trim().equalsIgnoreCase(product.trim()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clearingBasket() {
        products.clear();
        System.out.println("Корзина очищена!!!");
    }
}
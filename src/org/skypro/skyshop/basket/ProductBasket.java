package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private Map<String, ArrayList<Product>> products = new HashMap<>();

    public void addProduct(Product titleProduct) {
        products.computeIfAbsent(titleProduct.getNameProduct(), k -> new ArrayList<>());
        products.get(titleProduct.getNameProduct()).add(titleProduct);
    }

    public int calculateCostBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста!!!");
            return 0;
        }
        return products.values().stream().flatMap(Collection::stream).mapToInt(Product::getPrice).sum();
    }

    public void printContentBasket() {
        int count=0;
        if (calculateCostBasket() != 0) {
            System.out.printf("\n%20s%23s%10s%28s", "Продукт", "Цена", "Скидка", "Итоговая цена\n");
            products.values().stream().flatMap(Collection::stream).forEach(System.out::println);
            count = (int) products.values().stream().flatMap(Collection::stream).filter(Product::isSpecial).count();
        }
        System.out.printf("%20s%20d%5s\n%20s%5d", "Итого: ", calculateCostBasket(), " руб", "Специальных товаров: ",count);

    }

    public List<Product> deleteProduct(String query) {
        List<Product> deletedProducts = new ArrayList<>();

        if (calculateCostBasket() != 0) {
            // Приводим query к нижнему регистру и убираем пробелы
            String normalizedQuery = query.toLowerCase().trim();

            // Проходим по всем продуктам и ищем совпадения
            for (List<Product> productList : products.values()) {
                // Ищем продукты, соответствующие запросу
                List<Product> matchingProducts = productList.stream()
                        .filter(product -> product.getNameProduct().toLowerCase().equals(normalizedQuery))
                        .collect(Collectors.toList());

                // Если нашли совпадения, удаляем их и добавляем в список удаленных
                if (!matchingProducts.isEmpty()) {
                    productList.removeAll(matchingProducts);
                    deletedProducts.addAll(matchingProducts);
                }
            }
        }

        return deletedProducts;
    }
    public boolean checkProductAvailability(String query) {
        if (query.isBlank()) {
            System.out.println("Не введено название поиска товара в корзине");
            return false;
        }
        if (calculateCostBasket() == 0) {
            return false;
        } else {
            return products.keySet().stream().anyMatch(product -> product.trim().equalsIgnoreCase(query.trim()));
        }
    }

    public void clearingBasket() {
        products.clear();
        System.out.println("Корзина очищена!!!");
    }

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
}
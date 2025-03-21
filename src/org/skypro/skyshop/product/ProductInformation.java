package org.skypro.skyshop.product;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.article.Article;
import org.skypro.skyshop.product.product.DiscountedProduct;
import org.skypro.skyshop.product.product.FixPriceProduct;
import org.skypro.skyshop.product.product.Product;
import org.skypro.skyshop.product.product.SimpleProduct;
import org.skypro.skyshop.product.searchengine.SearchEngine;

public class ProductInformation {

    public Product[] products = {
            new SimpleProduct("Конфеты", 800),
            new SimpleProduct("Макароны", 80),
            new SimpleProduct("Пельмени", 350),
            new SimpleProduct("Масло", 120),
            new SimpleProduct("Сосиски", 150),
            new SimpleProduct("Кетчуп", 120),
            new SimpleProduct("Майонез", 77),
            new SimpleProduct("Молоко", 80),
            new SimpleProduct("Кефир", 80),
            new SimpleProduct("Сметана", 210),
            new SimpleProduct("Яйца", 100),
            new DiscountedProduct("Мыло", 23, 10),
            new DiscountedProduct("Шампунь ", 888, 10),
            new DiscountedProduct("Стиральный порошок", 780, 15),
            new DiscountedProduct("Пена для бритья", 455, 15),
            new FixPriceProduct("Хлеб ржаной"),
            new FixPriceProduct("Хлеб Бородинский"),
            new FixPriceProduct("Туалетная бумага"),
            new FixPriceProduct("Батон нарезной 1 кат."),
            new FixPriceProduct("Батон нарезной 2 кат."),
            new FixPriceProduct("Батон нарезной 3 кат."),

    };
    public Article[] articles = {
            new Article("Шампунь", "Шампунь Ромашка"),
            new Article("Конфеты", "Конфеты Cладкоежка"),
            new Article("Макароны", "Макароны Макфа"),
            new Article("Пельмени", "Пельмени Рузские"),
            new Article("Масло", "Масло Вологодское"),
            new Article("Сосиски", "Сосиски Микояновские"),
            new Article("Кетчуп", "Кетчуп острый"),
            new Article("Кетчуп", "Кетчуп острый"),
            new Article("Кетчуп", "Кетчуп острый"),
            new Article("Кетчуп", "Кетчуп острый"),
            new Article("Майонез", "Майонез Провансаль"),
            new Article("Молоко", "Молоко Рузское"),
            new Article("Кефир", "Рузский"),
            new Article("Сметана", "Сметана домашняя"),
            new Article("Яйца", "Яйца куриные первой категории"),
            new Article("Мыло", "Мыло Palmolive"),
            new Article("Хлеб ржаной", "Хлебобулочное изделие"),
            new Article("Хлеб Бородинский", "Хлебобулочное изделие"),
            new Article("Батон нарезной 4 кат", "Батон нарезной 4 кат"),
            new Article("Батон нарезной 4 кат", "Батон нарезной 4 кат"),
            new Article("Стиральный порошок", "Стиральный порошок Tide"),
            new Article("Пена для бритья", "Пена для бритья Tide")
    };

    public ProductBasket basket = new ProductBasket();
    public SearchEngine searchEngeni = new SearchEngine();

    public void printProductsInStore() {
        System.out.printf("\n%30s%25s%10s%25s", "Продукт", "Цена", "Скидка", "Итоговая цена");
        System.out.println();
        for (Product variant : products) {
            System.out.println(variant);
        }
    }

    public void searchProductAddBasket(String product) {
        boolean availabilityProduct = false;
        if (!product.isBlank()) {
            for (Product value : products) {
                if (product.trim().equalsIgnoreCase(value.getNameProduct().trim())) {
                    availabilityProduct = true;
                    basket.addProduct(value);
                }
            }

            if (!availabilityProduct) {
                System.out.println("В магазине такого товара нет");
            }
        } else {
            System.out.println("Hе введено название продукта для добавления в корзину ");
        }
    }

    public void searchProductBasket(String product) {
        if (basket.checkProductAvailability(product)) {
            System.out.println("Товар есть в корзине");
        } else {
            System.out.println("Товара нет в корзине");
        }
    }
}
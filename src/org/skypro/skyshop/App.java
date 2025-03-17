

package org.skypro.skyshop;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.product.product.Product;
import org.skypro.skyshop.product.searchengine.SearchEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {

    static void printTitle(String title) {
        int lineLength = 100;
        int headerLength = title.length();
        int numberOfCharacters = (lineLength - headerLength) / 2;
        String completion = "-";
        System.out.println("\n" + completion.repeat(numberOfCharacters) + title + completion.repeat(numberOfCharacters));
    }

    static void completeTask1(ProductInformation productInformation) {
        String product1 = "Хлеб ржаной";
        String product2 = "Хлеб нарезной";
        String product3 = "Стиральный порошок";
        printTitle("ДОМАШНЕЕ ЗАДАНИЕ");
        printTitle("Демонстрация классов");
        printTitle("Создали некоторый массив продуктов имеющихся в магазине вывели его на экран");
        productInformation.printProductsInStore();
        initialFillingOfBasket(productInformation);
        printTitle("3. Печать содержимого корзины с несколькими товарами");
        productInformation.basket.printContentBasket();
        printTitle("4. Получение стоимости корзины с несколькими товарами");
        System.out.println("Стоимость корзины с отложенными товарами равна: " + productInformation.basket.calculateCostBasket() + " рублей");
        printTitle("5. Поиск товара, который есть в корзине (" + product1 + ")");
        productInformation.searchProductBasket(product1);
        printTitle("6. Поиск товара, которого нет в корзине (" + product2 + ")");
        productInformation.searchProductBasket(product2);
        printTitle("7. Очистка корзины");
        productInformation.basket.clearingBasket();
        printTitle("8. Печать содержимого пустой корзины");
        productInformation.basket.printContentBasket();
        printTitle("9. Получение стоимости пустой корзины");
        System.out.println("Стоимость пустой корзины равна: " + productInformation.basket.calculateCostBasket() + " рублей");
        printTitle("10. Поиск товара по имени в пустой корзине");
        productInformation.searchProductBasket(product3);
    }
    static void completeTask2(ProductInformation productInformation, SearchEngine searchEngeni) {
        printTitle("ДОМАШНЕЕ ЗАДАНИЕ Полиморфизм. Интерфейсы");
        System.out.println("1. Создали один объект типа SearchEngine c пустым списком ");
        System.out.println("Итого: мы имеем список размерностью изначально равной " + searchEngeni.getSearchable().size());
        System.out.println("2. Привели тип объекта products к типу Searhable  и занесли элементы в объект searchEngeni  ");
        searchEngeni.add(productInformation.products);
        System.out.println("3. Занесли объекты article в объект searchEngeni  ");
        searchEngeni.add(productInformation.articles);
        printTitle("4. Проводим проверку заполнения объекта searchEngeni");
        for (Searchable x : searchEngeni.getSearchable()) {
            System.out.println(x);
        }
        String searchOption1 = "хлеб";
        String searchOption2 = "майонез";
        String searchOption3 = "ма";
        printTitle("5. Продемонстрировали функциональность поиска при вводе строки - " + searchOption1 + " ");
        demonstrateTheMethod(searchEngeni, searchOption1);
        printTitle("6. Продемонстрировали функциональность поиска при вводе строки - " + searchOption2 + " ");
        demonstrateTheMethod(searchEngeni, searchOption2);
        System.out.println("7. Продемонстрировали функциональность поиска при вводе строки - " + searchOption3 + ", на предмет полного заполнения массива поиска \n");
        demonstrateTheMethod(searchEngeni, searchOption3);
    }

    static void completeTask3(ProductInformation productInformation, SearchEngine searchEngeni) {
        String searchOption4 = "майонез";
        String searchOption5 = "apple";
        printTitle("ДОМАШНЕЕ ЗАДАНИЕ Исключение в JAVA");
        System.out.println("1. В классы Product и его наследники ввели проверку корректности ввода данных в объекты.");
        System.out.println("2. Провели демонстрацию корректности ввода данных без ошибки для удобства проверки данных при вводе ошибки в программу.");
        productInformation.printProductsInStore();
        System.out.println("3. 4. Реализовали метод getSearchTerm(String search) в классе Searchable и создали исключение BestResultNotFound. ");
        printTitle("5.1 Продемонстрируем метод getSearchTerm(String search) когда строка имеет значение - " + searchOption4);
        System.out.println();
        demonstrateTheMethod2(searchEngeni, searchOption4);
        printTitle("5.2 Продемонстрируем метод getSearchTerm(String search) когда строка имеет значение - " + searchOption5);
        System.out.println();
        demonstrateTheMethod2(searchEngeni, searchOption5);

    }

    static void completeTask4(ProductInformation productInformation, SearchEngine searchEngeni) {
        printTitle("ДОМАШНЕЕ ЗАДАНИЕ Java Collections Framework: List");
        System.out.println("1.1 Поменяли внутреннюю структуру класса ProductBasket заменили массив на список типа  LinkedList");
        System.out.println("1.2 Убедились что теперь мы можем в корзину добавлять условно бесконечное количество продуктов");
        ArrayList<String> productBasket = new ArrayList<>();
        productBasket.add("Хлеб ржаной");
        productBasket.add("Кетчуп");
        productBasket.add("Стиральный порошок");
        productBasket.add("Туалетная бумага");
        productBasket.add("Пена для бритья");
        productBasket.add("Молоко");
        printTitle("1. Добавление продукта в корзину");
        for (int element = 0; element < productBasket.size(); element++) {
            System.out.println("Добавили " + (element + 1) + " продукт: " + productBasket.get(element));
            productInformation.searchProductAddBasket(productBasket.get(element));
        }
        System.out.println("2. Добавили метод public deleteProduct(String line), который по переданному имени продукта удаляет все" +
                " продукты с таким именем из корзины");
        printTitle("2.1 Продемонстрируем работу метода. Для этого распечатаем содержимое корзины.");
        productInformation.basket.printContentBasket();
        System.out.println();
        String productDelete = "молоко";
        System.out.println("\n 2.1 Удалим из корзины один продукт \" " + productDelete + "\" и выведем в консоль удаленные продукты с корзины.");
        printDeleteProductBasket(productInformation, productDelete);
        printTitle("2.2. Распечатаем содержимое корзины и убедимся в отсутствии в ней продукта \"" + productDelete + "\"");
        productInformation.basket.printContentBasket();
        productDelete = "пенt для бритья";
        System.out.println("\n 2.3 Удалим из корзины продукт введенный с ошибкой \" "
                + productDelete + "\" и выведем в консоль удаленные продукты с корзины.\n");
        printDeleteProductBasket(productInformation, productDelete);
        printTitle("2.4. Вывели содержимое корзины на экран.");
        productInformation.basket.printContentBasket();
        searchEngeni.clearSearchEngine();
        System.out.println("\n3. Продемонстрируем использование измененного метода search " +
                "для чего повторим вывод домашнего задания \"Полиморфизм. Интерфейсы.\" на печать");
        System.out.println("Для повторного корректного выполнения домашнего задания \"Полиморфизм. Интерфейсы.\" " +
                "произвел предварительно очистку списка объекта searchEngine дополнительным методом clearSearchEngine()  ");
        searchEngeni.clearSearchEngine();
        completeTask2(productInformation, searchEngeni);
        System.out.println("\nУбедились что программа отрабатывает согласно условия задания.");


    }

    static void demonstrateTheMethod(SearchEngine object, String line) {
        for (Map.Entry<String, Searchable> variant : object.search(line).entrySet()) {
            System.out.println(variant.getValue().getStringRepresentation());
        }
    }

    static void demonstrateTheMethod2(SearchEngine object, String line) {
        try {
            System.out.println(object.getSearchTerm(line).getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }

    static void printDeleteProductBasket(ProductInformation object, String line) {
        int index = 0;
        for (Product element : object.basket.deleteProduct(line)) {
            index++;
            System.out.println(element);
        }
        if (index == 0) {
            System.out.println("Список пуст, проверьте правильность ввода строки удаления");
        }
    }

    static void initialFillingOfBasket(ProductInformation object) {
        List<String> productN = new ArrayList<>();
        productN.add("Хлеб ржаной");
        productN.add("конфеты");
        productN.add("Стиральный порошок");
        productN.add("Туалетная бумага");
        productN.add("Пена для бритья");
        productN.add("Молоко");
        productN.add("Стиральный порошок");
        productN.add("конфеты");
        productN.add("Пена для бритья");
        productN.add("конфеты");
        productN.add("Пена для бритья");
        for (int variable = 0; variable < productN.size(); variable++) {
            System.out.println("Добавили " + (variable + 1) + " продукт: " + productN.get(variable));
            object.searchProductAddBasket(productN.get(variable));
        }
    }

    public static void main(String[] args) {
        try {
            ProductInformation productInformation = new ProductInformation();
            SearchEngine searchEngeni = new SearchEngine();
            completeTask1(productInformation);
            completeTask2(productInformation, searchEngeni);
            completeTask3(productInformation, searchEngeni);
            completeTask4(productInformation, searchEngeni);


            printTitle("Java Collections Framework: Map");
            printTitle("1. Изменение используемой структуры данных в классе ProductBacket");
            System.out.println();
            System.out.println(" 1.1 Произвели изменения в классе ProductBasket заменили тип переменной products на\n" +
                    "тип: Map<String, ArrayList<Product>> ");
            System.out.println("Для контроля корректности работы класса ProductBasket выведем на консоль" +
                    " условия работы домашнего задания \"Введение в ООП. Инкапсуляция\" ");
            completeTask1(productInformation);
            System.out.println();
            System.out.println("1.2 Продемонстрировали работу класса за исключением удаления продукта с корзины. Произведем данную проверку.\n");
            System.out.println("Для чего, вновь заполним корзину продуктами.\n");
            initialFillingOfBasket(productInformation);
            System.out.println("1.3 Выведем на консоль содержимое корзины до удаления товара\n");
            productInformation.basket.printContentBasket();
            String productDelete = "конфеты";
            System.out.println("\n 1.5 Удалим из корзины один продукт \" " + productDelete + "\" и выведем в консоль удаленные продукты с корзины.");
            printDeleteProductBasket(productInformation, productDelete);
            printTitle("1.6 Распечатаем содержимое корзины и убедимся в отсутствии в ней продукта \"" + productDelete + "\"");
            productInformation.basket.printContentBasket();
            printTitle("2. Модификация возвращаемого значения в методе поиска");
            System.out.println("Продемонстрируем работу метода search");
            String searchOption1 = "хлеб";
            String searchOption2 ="майонез";
            String searchOption3 ="а";
            printTitle("2.1 Продемонстрировали функциональность поиска при вводе строки - " + searchOption1 + " ");
            demonstrateTheMethod(searchEngeni, searchOption1);
            printTitle("2.2 Продемонстрировали функциональность поиска при вводе строки - " + searchOption2 + " ");
            demonstrateTheMethod(searchEngeni, searchOption2);
            System.out.println("2.3 Продемонстрировали функциональность поиска при вводе строки - " + searchOption3 +
                    ", на предмет сортировки выводимой информации по ключу Мар поиска \n");
            demonstrateTheMethod(searchEngeni, searchOption3);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage() + "  проведите корректировку вводимых данных");
        }
    }
}
//Для уменьшения количества продуктов в корзине замените в методе initialFillingOfBasket() число повторений в цикле
// for (int variable = 0; variable < productN.size(); variable++); productN.size() - на необходимое число продуктов в корзине
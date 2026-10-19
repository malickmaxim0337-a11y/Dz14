package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // Создаем товары
        SimpleProduct apple = new SimpleProduct("Яблоко", 50);
        DiscountedProduct bread = new DiscountedProduct("Хлеб", 40, 20);
        FixPriceProduct milk = new FixPriceProduct("Молоко");

        // Создаем статьи
        Article article1 = new Article("Польза яблок", "В яблоках много витаминов...");
        Article article2 = new Article("Как выбрать хлеб", "Хлеб должен быть свежим...");

        // Создаем поисковый движок на 10 элементов
        SearchEngine searchEngine = new SearchEngine(10);

        // Добавляем всё в движок
        searchEngine.add(apple);
        searchEngine.add(bread);
        searchEngine.add(milk);
        searchEngine.add(article1);
        searchEngine.add(article2);

        // Тестируем поиск
        System.out.println("--- Поиск по слову 'яблоко' ---");
        Searchable[] result1 = searchEngine.search("яблоко");
        System.out.println(Arrays.toString(result1));

        System.out.println("\n--- Поиск по слову 'хлеб' ---");
        Searchable[] result2 = searchEngine.search("хлеб");
        System.out.println(Arrays.toString(result2));

        System.out.println("\n--- Поиск по слову 'витамин' ---");
        Searchable[] result3 = searchEngine.search("витамин");
        System.out.println(Arrays.toString(result3));

        // Не забываем про корзину (можно оставить старую демонстрацию)
        ProductBasket basket = new ProductBasket();
        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.printBasket();
    }
}

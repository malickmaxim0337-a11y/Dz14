package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {

        // 1. Проверка исключений (IllegalArgumentException)
        System.out.println("=== Проверка исключений ===");
        try {
            new SimpleProduct("", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            new SimpleProduct(null, 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            new SimpleProduct("Телефон", -50); // Отрицательная цена
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            new DiscountedProduct("Ноутбук", 1000, 150); // Скидка больше 100
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== Поиск лучшего совпадения ===");

        // 2. Создаем движок и добавляем объекты
        SearchEngine engine = new SearchEngine(10);

        engine.add(new SimpleProduct("Яблоко", 50));
        engine.add(new DiscountedProduct("Хлеб", 40, 20));
        engine.add(new FixPriceProduct("Молоко"));
        // Создаем статьи, где слово "яблоко" встречается несколько раз
        engine.add(new Article("Польза яблок", "В яблоках много витаминов. Яблоко - это фрукт."));
        engine.add(new Article("Как выбрать хлеб", "Хлеб должен быть свежим. Покупайте хлеб каждый день."));

        // 3. Сценарий: объект существует
        try {
            Searchable best = engine.findBestMatch("яблоко");
            System.out.println("Лучший результат для 'яблоко':");
            System.out.println(best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        // 4. Сценарий: объект не найден (исключение)
        try {
            Searchable best = engine.findBestMatch("банан");
            System.out.println("Лучший результат для 'банан':");
            System.out.println(best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Поймали исключение: " + e.getMessage());
        }
    }
}

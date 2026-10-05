package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product apple = new Product("Яблоко", 50);
        Product bread = new Product("Хлеб", 40);
        Product milk = new Product("Молоко", 80);
        Product cheese = new Product("Сыр", 200);
        Product meat = new Product("Мясо", 350);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(meat);

        basket.addProduct(new Product("Рыба", 300));

        System.out.println("\n--- Содержимое корзины ---\n");
        basket.printBasket();

        System.out.println("\n--- Общая стоимость ---\n");
        System.out.println(basket.getTotalPrice());

        System.out.println("\n--- Поиск 'Хлеб' ---\n");
        System.out.println(basket.containsProductByName("Хлеб"));

        System.out.println("\n--- Поиск 'Шоколад' ---\n");
        System.out.println(basket.containsProductByName("Шоколад"));

        System.out.println("\n--- Очистка корзины ---\n");
        basket.clearBasket();

        System.out.println("\n--- Содержимое после очистки ---\n");
        basket.printBasket();

        System.out.println("\n--- Стоимость пустой корзины ---\n");
        System.out.println(basket.getTotalPrice());

        System.out.println("\n--- Поиск в пустой корзине ---\n");
        System.out.println(basket.containsProductByName("Хлеб"));
    }
}

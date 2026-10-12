package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        SimpleProduct apple = new SimpleProduct("Яблоко", 50);
        DiscountedProduct bread = new DiscountedProduct("Хлеб", 40, 20);
        FixPriceProduct milk = new FixPriceProduct("Молоко");
        SimpleProduct cheese = new SimpleProduct("Сыр", 200);
        DiscountedProduct meat = new DiscountedProduct("Мясо", 400, 25);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(meat);

        basket.addProduct(new SimpleProduct("Рыба", 300));

        System.out.println("--- Содержимое корзины ---");
        basket.printBasket();

        System.out.println("--- Общая стоимость ---");
        System.out.println(basket.getTotalPrice());

        System.out.println("--- Поиск 'Хлеб' ---");
        System.out.println(basket.containsProductByName("Хлеб"));

        System.out.println("--- Поиск 'Шоколад' ---");
        System.out.println(basket.containsProductByName("Шоколад"));

        System.out.println("--- Очистка корзины ---");
        basket.clearBasket();

        System.out.println("--- Содержимое после очистки ---");
        basket.printBasket();

        System.out.println("--- Стоимость пустой корзины ---");
        System.out.println(basket.getTotalPrice());

        System.out.println("--- Поиск в пустой корзине ---");
        System.out.println(basket.containsProductByName("Хлеб"));
    }
}

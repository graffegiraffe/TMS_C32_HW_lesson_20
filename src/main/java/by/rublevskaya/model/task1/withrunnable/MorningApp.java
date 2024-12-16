package main.java.by.rublevskaya.model.task1.withrunnable;

public class MorningApp {
    public static void main(String[] args) {
        Thread threadNews = new Thread(new Task("Чтение новостей"), "NewsReader");
        Thread threadBreakfast = new Thread(new Task("Завтрак"), "BreakfastMaker");
        Thread threadCoffee = new Thread(new Task("Приготовление кофе"), "CoffeeMaker");

        threadNews.setPriority(Thread.MIN_PRIORITY);
        threadBreakfast.setPriority(Thread.NORM_PRIORITY);
        threadCoffee.setPriority(Thread.MAX_PRIORITY);

        threadNews.start();
        threadBreakfast.start();
        threadCoffee.start();
    }
}
package main.java.by.rublevskaya.model.task1.withthread;

public class MorningApp {
    public static void main(String[] args) {
        main.java.by.rublevskaya.model.task1.withthread.Task taskNews = new main.java.by.rublevskaya.model.task1.withthread.Task("Reading the news");
        main.java.by.rublevskaya.model.task1.withthread.Task taskBreakfast = new main.java.by.rublevskaya.model.task1.withthread.Task("Breakfast");
        main.java.by.rublevskaya.model.task1.withthread.Task taskCoffee = new Task("Making coffee");

        taskNews.setPriority(Thread.MIN_PRIORITY);
        taskBreakfast.setPriority(Thread.NORM_PRIORITY);
        taskCoffee.setPriority(Thread.MAX_PRIORITY);

        taskNews.start();
        taskBreakfast.start();
        taskCoffee.start();
    }
}

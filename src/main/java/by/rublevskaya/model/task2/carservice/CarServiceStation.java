package main.java.by.rublevskaya.model.task2.carservice;

import java.util.LinkedList;
import java.util.Queue;

public class CarServiceStation {
    final Queue<String> cars = new LinkedList<>();
    private final int maxCars;
    private boolean running = true; // Флаг

    public CarServiceStation(int maxCars) {
        this.maxCars = maxCars;
    }

    public synchronized void addCar(String car) throws InterruptedException {
        while (cars.size() >= maxCars && running) {
            System.out.println("The service station is full! Wait......");
            wait();
        }
        if (!running) return;
        cars.add(car);
        System.out.println("Car \"" + car + "\" added to service");
        notifyAll(); // Уведомляем другие потоки
    }


    public synchronized String takeCar() throws InterruptedException {
        while (cars.isEmpty() && running) {
            System.out.println("There are no cars at the service station. Wait.....");
            wait();
        }
        if (!running && cars.isEmpty()) return null;
        String car = cars.poll();
        System.out.println("Car \"" + car + "\" picked up from service station");
        notifyAll(); // Уведомляем другие потоки
        return car;
    }


    public synchronized void stopService() {
        running = false;
        notifyAll(); // все потоки знают уже что ожидание
    }

    public synchronized boolean isRunning() {
        return running;
    }
}
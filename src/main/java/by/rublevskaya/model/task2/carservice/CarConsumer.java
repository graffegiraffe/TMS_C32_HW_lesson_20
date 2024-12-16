package main.java.by.rublevskaya.model.task2.carservice;

public class CarConsumer extends Thread {
    private final CarServiceStation serviceStation;

    public CarConsumer(CarServiceStation serviceStation) {
        this.serviceStation = serviceStation;
    }

    @Override
    public void run() {
        try {
            while (serviceStation.isRunning() || !serviceStation.isRunning() && !serviceStation.cars.isEmpty()) { // Пока работает или машины остаются
                String car = serviceStation.takeCar(); // Забираем машину из СТО
                if (car != null) {
                    Thread.sleep(2000);
                }
            }
            System.out.println("CarConsumer finished work.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("CarConsumer was interrupted.");
        }
    }
}
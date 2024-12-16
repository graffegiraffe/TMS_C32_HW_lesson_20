package main.java.by.rublevskaya.model.task2.carservice;

public class CarProducer extends Thread {
    private final CarServiceStation serviceStation;

    public CarProducer(CarServiceStation serviceStation) {
        this.serviceStation = serviceStation;
    }

    @Override
    public void run() {
        int carCounter = 1;
        try {
            while (serviceStation.isRunning()) {
                String car = "Car-" + carCounter++;
                serviceStation.addCar(car);
                Thread.sleep(1000);
            }
            System.out.println("CarProducer finished work.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("CarProducer was interrupted.");
        }
    }
}
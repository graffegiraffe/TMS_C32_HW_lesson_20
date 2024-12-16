package main.java.by.rublevskaya.model.task2;

import main.java.by.rublevskaya.model.task2.carservice.CarConsumer;
import main.java.by.rublevskaya.model.task2.carservice.CarProducer;
import main.java.by.rublevskaya.model.task2.carservice.CarServiceStation;

public class MainApp {
    public static void main(String[] args) {
        CarServiceStation serviceStation = new CarServiceStation(ServiceConstants.MAX_CARS);
        CarProducer producer = new CarProducer(serviceStation);
        CarConsumer consumer = new CarConsumer(serviceStation);

        producer.start();
        consumer.start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Stopping the service station...");
        serviceStation.stopService();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Service station stopped. Program finished.");
    }
}

package main.java.by.rublevskaya.model.task1.withrunnable;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    private final String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started the task: " + taskName);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " completed the task: " + taskName);
    }
}
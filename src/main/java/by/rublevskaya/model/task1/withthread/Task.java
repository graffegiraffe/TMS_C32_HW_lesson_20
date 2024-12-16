package main.java.by.rublevskaya.model.task1.withthread;

import java.util.concurrent.TimeUnit;

public class Task extends Thread{
    private final String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
        this.setName(taskName);
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

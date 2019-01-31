package ru.id61890868;

public class Checker implements Runnable{

    private Holder holder;
    private int sleepTime;

    Checker(Holder holder, int sleepTime) {
        this.holder = holder;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        while(holder.getTrigger()){
            Sleep();
            System.out.println("min value: " + holder.getMin());
            System.out.println("other values: " + holder.dataToString());
        }
    }

    public void stop(){
        holder.setTrigger(false);
    }

    private void Sleep(){
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
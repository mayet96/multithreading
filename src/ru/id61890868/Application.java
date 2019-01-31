package ru.id61890868;

public class Application {

    public static void main(String[] args) {
	    Reader r = new Reader();
	    Checker c = new Checker(r.getHolder(), 5000);
	    Thread read = new Thread(r);
	    Thread check = new Thread(c);
        read.start();
        check.start();
    }


}

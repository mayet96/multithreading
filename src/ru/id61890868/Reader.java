package ru.id61890868;

import ru.id61890868.helper.InputHelper;

public class Reader extends Holder implements Runnable{

    Reader(){
        super();
    }

    @Override
    public void run() {

        String input;
        while(getTrigger()){
            input = InputHelper.inputSting();
            if(input.equals("stop")){
                stop();
            }else{
                try {
                    add(input);
                } catch (Exception e) {
                    System.out.println("not valid arg");
                }
            }
        }
    }

    private void stop(){
        setTrigger(false);
    }

}

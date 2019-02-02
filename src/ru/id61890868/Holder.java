package ru.id61890868;

import java.util.NoSuchElementException;
import java.util.TreeSet;

class Holder {
    private final TreeSet<Integer> data;
    private boolean trigger;

    Holder(){
        data = new TreeSet<>((o1, o2) -> o1 - o2);
        trigger = true;
    }

    /**
     *
     * @param o элемент добавляемый в память
     */
    void add(Integer o) throws Exception{
        ///TODO: input validator
        data.add(o);
    }

    /**
     * возвращает первый элемент из листа и удаляет его
     * @return элемент хранимых данных
     */
    Integer getMin(){
        synchronized (data){
            try{
                int o = data.first();
                data.remove(o);
                return o;
            }catch(NoSuchElementException e){
                return null;
            }
        }
    }

    Holder getHolder(){
        return this;
    }

    boolean getTrigger() {
        return trigger;
    }

    void setTrigger(boolean trigger) {
        this.trigger = trigger;
    }

    String dataToString(){
        return data.toString();
    }
}

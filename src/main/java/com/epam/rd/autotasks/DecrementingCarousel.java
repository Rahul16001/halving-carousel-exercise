package com.epam.rd.autotasks;
import java.util.ArrayDeque;

public class DecrementingCarousel{

    static boolean isRunning;
    static ArrayDeque<Integer> carousalQue;
    final int capacity;
    boolean doHalf;
    public DecrementingCarousel(int cap) {


        carousalQue = new ArrayDeque<>();
        capacity = cap;
        doHalf = false;
    }
    public DecrementingCarousel(int cap,boolean doHalf) {
        isRunning = false;
        carousalQue = new ArrayDeque<>();
        capacity = cap;
        this.doHalf = doHalf;
    }


    public boolean addElement(int element){
        if(isRunning || carousalQue.size() == capacity || element <= 0) return false;
        return carousalQue.offer(element);
    }

    public CarouselRun run() {
        if(!isRunning && !doHalf)
        {
            isRunning = true;
            return new CarouselRun(capacity);
        }
        else if(!isRunning)
        {
            isRunning = true;
            return new CarouselRun(capacity, true);
        }
        else return null;
    }
}

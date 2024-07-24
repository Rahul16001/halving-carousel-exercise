package com.epam.rd.autotasks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecrementingCarousel{

    static boolean isRunning;
    static ArrayDeque<Integer> que;
    final int capacity;
    boolean doHalf;
    public DecrementingCarousel(int cap) {
        isRunning = false;
        que = new ArrayDeque<>();
        capacity = cap;
        doHalf = false;
    }
    public DecrementingCarousel(int cap,boolean doHalf) {
        isRunning = false;
        que = new ArrayDeque<>();
        capacity = cap;
        this.doHalf = true;
    }


    public boolean addElement(int element){
        if(isRunning || que.size() == capacity || element <= 0) return false;
        if(que.offer(element)) return true;
        return false;
    }

    public CarouselRun run() {
        if(!isRunning && !doHalf)
        {
            isRunning = true;
            return new CarouselRun(capacity);
        }
        else if(!isRunning && doHalf)
        {
            isRunning = true;
            return new CarouselRun(capacity,doHalf);
        }
        else return null;
    }
}

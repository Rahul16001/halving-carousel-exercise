package com.epam.rd.autotasks;

import static com.epam.rd.autotasks.DecrementingCarousel.isRunning;
import static com.epam.rd.autotasks.DecrementingCarousel.carousalQue;

public class CarouselRun{
    int capacity;
    boolean doHalf;
    CarouselRun(int capacity)
    {
        this.capacity = capacity;
        doHalf = false;
    }
    CarouselRun(int capacity,boolean doHalf)
    {
        this.capacity = capacity;
        this.doHalf = doHalf;
    }

    public int next() {
        int currentElement = -1 ;
        if(carousalQue.isEmpty())
        {
            return currentElement;
        }
        else {
            currentElement = carousalQue.poll();
            if(!(currentElement-1 <= 0) && !doHalf) carousalQue.offer(currentElement-1);
            else if (!(currentElement-1 <= 0))
            {
                int half = currentElement/2;
                carousalQue.offer(half);
            }
            if(carousalQue.isEmpty())
            {
                isRunning = false;
                if(doHalf) doHalf = false;
            }
        }
        return  currentElement;
    }

    public boolean isFinished() {
        return carousalQue.isEmpty();
    }
}

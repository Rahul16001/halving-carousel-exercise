package com.epam.rd.autotasks;

import static com.epam.rd.autotasks.DecrementingCarousel.isRunning;
import static com.epam.rd.autotasks.DecrementingCarousel.que;

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
        if(que.isEmpty())
        {
            return currentElement;
        }
        else {
            currentElement = que.poll();
            if(!(currentElement-1 <= 0) && !doHalf) que.offer(currentElement-1);
            else if (!(currentElement-1 <= 0) && doHalf)
            {
                int half = currentElement/2;
                que.offer(half);
            }
            if(que.isEmpty())
            {
                isRunning = false;
                if(doHalf) doHalf = false;
            }
        }
        return  currentElement;
    }

    public boolean isFinished() {
        return que.isEmpty();
    }
}

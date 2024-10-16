package com.sumit.ds.leetcode.may2023;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://stackoverflow.com/questions/56500343/maximum-number-of-meetings-that-we-can-conduct
 * https://courses.cs.duke.edu//spring19/compsci330/lecture7scribe.pdf
 */
class Events implements Comparable<Events>{
    int start;
    int endTime;
    public Events(int start,int duration){
        this.start = start;
        this.endTime = start+duration;
    }

    public int compareTo(Events other){
        return Integer.compare(this.endTime,other.endTime);
    }
}
public class JPMCQuestion1 {
    public static int getMaximumMeetings(List<Integer> start, List<Integer> timeTaken) {
        List<Events> eventsList = new ArrayList<>();
        for(int i=0;i<start.size();i++){
            eventsList.add(new Events(start.get(i),timeTaken.get(i)));
        }
        Collections.sort(eventsList);

        int count=1;
        int preEndTime = eventsList.get(0).endTime;
        for(int i=1;i<eventsList.size();i++){
            if(eventsList.get(i).start >=preEndTime){
                count++;
            }
        }
        return count;
    }

    @Test public void testing(){
        Integer [] start = {1,3,5};
        Integer [] duration = {2,2,2};
        System.out.println(getMaximumMeetings(Arrays.asList(start),Arrays.asList(duration)));
    }
}

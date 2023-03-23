package com.JatinCodes.learnspringaop.aopexample.data;

import com.JatinCodes.learnspringaop.aopexample.annotations.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    @TrackTime
    public int[] retrieveData() {

        // just added to see some time
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return new int[] {11, 22, 33, 44, 55};
    }
}

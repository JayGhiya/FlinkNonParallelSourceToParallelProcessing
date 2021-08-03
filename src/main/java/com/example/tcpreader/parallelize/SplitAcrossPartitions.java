package com.example.tcpreader.parallelize;

import org.apache.flink.api.java.functions.KeySelector;

public class SplitAcrossPartitions implements KeySelector<String,String> {

    private int[] list = new int[]{1,2,3,4,5};
    int i =0;
    @Override
    public String getKey(String s) throws Exception {

        i++;
        if(i>4)
            i=0;
        return String.valueOf(list[i]);
    }
}

package com.example.tcpreader.transform;

import org.apache.flink.api.common.functions.MapFunction;

public class TcpTransform implements MapFunction<String,String> {
//Utilize the function to convert String to hl7 and modify the operator accordingly
    @Override
    public String map(String s) throws Exception {
        System.out.println("Message is:"+s);
        return s;
    }
}

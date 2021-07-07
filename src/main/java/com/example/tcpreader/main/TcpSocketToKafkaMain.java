package com.example.tcpreader.main;

import com.example.tcpreader.parallelize.SplitAcrossPartitions;
import com.example.tcpreader.transform.TcpTransform;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class TcpSocketToKafkaMain {


    public static void main(String args[]) throws Exception {

        StreamExecutionEnvironment streamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        streamExecutionEnvironment.setParallelism(4);
        streamExecutionEnvironment.setMaxParallelism(4);
        DataStream<String> dataStream = streamExecutionEnvironment.socketTextStream("127.0.0.1",13370,"/r");
        System.out.println("parallelism for datastream from source is:"+dataStream.getParallelism());
        KeyedStream<String,String> keyedStream = dataStream.keyBy(new SplitAcrossPartitions());
        System.out.println("parallelism for keyedStream is:"+keyedStream.getParallelism());
        keyedStream.map(new TcpTransform());
        streamExecutionEnvironment.execute();

    }
}

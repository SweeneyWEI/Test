package org.Test;

import org.apache.storm.Config;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

import java.io.IOException;

/**
 * Created by weixin on 17-9-27.
 */
public class storm {
    public static void main(String[] args) throws InterruptedException{
        TopologyBuilder builder=new TopologyBuilder();
        builder.setSpout("word-reader",new WordReader(),2);
        builder.setBolt
                ("word-normalizer",new WordNormalizer(),2).shuffleGrouping("word-reader").
                setNumTasks(4).setDebug(false);
        builder.setBolt("word-counter",new WordCounter(),2).fieldsGrouping("word-normalizer",
                new Fields("word"));

        Config conf=new Config();
        conf.put("wordsFile","/home/weixin/file.txt");
        conf.setDebug(false);

        conf.put(Config.TOPOLOGY_MAX_SPOUT_PENDING,1);
        conf.setNumWorkers(2);

//        try {
//
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }


    }
}

//package com.ali.edu.stackoverflow.event;
//
//import com.ali.edu.stackoverflow.entity.Event;
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
///**
// * Description:
// * Date: 2020-09-23
// * Time: 10:04
// * @author rocky
// */
//@Service
//public class EventProducer {
//
//    @Autowired
//    private KafkaTemplate kafkaTemplate;
//
//    public void produce(Event event){
//        kafkaTemplate.send(event.getTopic(), JSONObject.toJSON(event).toString());
//    }
//}

//package com.ali.edu.stackoverflow.event;
//
//
//import com.ali.edu.stackoverflow.entity.Event;
//import com.ali.edu.stackoverflow.utils.StackOverFlowConstant;
//import com.alibaba.fastjson.JSONObject;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static com.ali.edu.stackoverflow.utils.StackOverFlowConstant.TOPIC_LIKE;
//
///**
// * Description:
// * Date: 2020-09-23
// * Time: 10:04
// * @author rocky
// */
//@Service
//public class EventConsumer implements StackOverFlowConstant {
//
//    private static final Logger logger = LoggerFactory.getLogger(EventConsumer.class);
//
//    @Autowired
//    private KafkaTemplate kafkaTemplate;
//
//    @KafkaListener(topics={TOPIC_COMMENT,TOPIC_LIKE,TOPIC_FOLLOW})
//    public void comsume(ConsumerRecord record) {
//        if (record == null || record.value() == null) {
//            logger.error("消息内容为空");
//            return;
//        }
//        Event event = JSONObject.parseObject(record.value().toString(), Event.class);
//        if (event == null){
//            logger.error("消息格式错误！");
//            return;
//        }
//
//
//        Map<String,Object> content = new HashMap<String,Object>(6);
//        content.put("topic",event.getTopic());
//        content.put("fromUser",event.getUserId());
//        content.put("entityType",event.getEntityType());
//        content.put("entityId",event.getEntityId());
//
//        for (Map.Entry<String,Object> entry:  event.getData().entrySet()) {
//            content.put(entry.getKey(),entry.getValue());
//        }
//        logger.info(content.toString());
//
//    }
//}

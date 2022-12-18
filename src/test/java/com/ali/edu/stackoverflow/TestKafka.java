//package com.ali.edu.stackoverflow;
//
//import com.ali.edu.stackoverflow.entity.Event;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import static com.ali.edu.stackoverflow.utils.StackOverFlowConstant.TOPIC_COMMENT;
//
///**
// * @author rocky
// * @Description:
// * @Date: 2020-09-23
// * @Time: 10:23
// */
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = StackOverFlowMain.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootApplication
//public class TestKafka {
//
//    @Autowired
//    private EventProducer eventProducer;
//
//    @Test
//    public void testKafka(){
//        while (true){
//            Event event = new Event();
//            event.setTopic(TOPIC_COMMENT);
//            event.setEntityId(1);
//            event.setEntityUserId(2);
//            event.setEntityType(1);
//            eventProducer.produce(event);
//        }
//    }
//}

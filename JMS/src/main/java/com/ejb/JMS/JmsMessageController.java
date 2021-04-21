package com.ejb.JMS;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.jms.JMSConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.Queue;

@Named
@RequestScoped
public class JmsMessageController {

    @Inject
    private JmsMessageModel jmsMessageModel;

    @Resource(mappedName = "jms/notifierQueue")
    private Queue myQueue;

    @Inject
//    @JMSConnectionFactory("jms/__defaultConnectionFactory")
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    public String sendMsg() {
        sendJMSMessageToMyQueue(jmsMessageModel.getMsgText());
//        System.out.println("the message: "+jmsMessageModel.getMsgText());
        return "confirmation";
    }

    private void sendJMSMessageToMyQueue(String messageData) {
        context.createProducer().send(myQueue, messageData);
    }

}

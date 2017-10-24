package org.frame.common;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMqRecevier {
	public static void main(String[] args) {
		ConnectionFactory connectionFactory;
		
		Connection connection = null;
		
		Session session;
		
		Destination destination;
		
		MessageConsumer consumer;
		
		connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://117.135.139.113:61616");
		
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			destination = session.createQueue("FirstQueue");
			
			consumer = session.createConsumer(destination);
			
			while(true){
				TextMessage message = (TextMessage) consumer.receive(10000);
				if(null!=message){
					System.out.println("收到的消息:"+message.getText());
				}else{
					break;
				}
			}
			
		} catch (JMSException e) {
			e.printStackTrace();
		}finally{
				try {
					if(null!=connection){
						connection.close();
					}
				} catch (JMSException e) {
					e.printStackTrace();
				}
		}
		
		
	}
}

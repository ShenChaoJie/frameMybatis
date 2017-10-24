package org.frame.common;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMqSender {
	
	public static void main(String[] args) {
		
		ConnectionFactory connectionFactory = null;//连接工厂，JMS 用它创建连接
		
		Connection connection = null;//JMS 客户端到JMS Provider 的连接
		
		Session session = null;// 一个发送或接收消息的线程
		
		Destination destination = null;//消息的目的地;消息发送给谁.
		
		MessageProducer producer = null;//消息发送者
		
		connectionFactory = new ActiveMQConnectionFactory("admin","admin","tcp://117.135.139.113:61616");
		
		try {
			connection = connectionFactory.createConnection();// 构造从工厂得到连接对象
			
			connection.start();//启动
			
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);// 获取操作连接
			
			destination = session.createQueue("FirstQueue");//获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
			
			producer = session.createProducer(destination);//得到消息生成者【发送者】
			
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);//设置不持久化，实际根据项目决定
			
			sendMessage(session,producer);
			
			session.commit();
			
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
	
	public static void sendMessage(Session session,MessageProducer producer) throws JMSException{
		for(int i=0;i<8;i++){
			TextMessage message = session.createTextMessage("cjshen-activeMq-producer--"+i);
			producer.send(message);
			System.out.println("发送消息：cjshen-activeMq-producer--"+i);
		}
		
	}
	
}

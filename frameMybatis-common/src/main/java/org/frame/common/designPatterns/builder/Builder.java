package org.frame.common.designPatterns.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式
 * 将很多功能集成到一个类里
 * @author cjshen
 *
 */
public class Builder {
	
	public List<Sender> list = new ArrayList<Sender>();
	
	public void produceMailSender(int count){
		for(int i=0;i<count;i++){
			list.add(new MailSender());
		}
	}
	
	public void produceSmsSender(int count){
		for(int i=0;i<count;i++){
			list.add(new SmsSender());
		}
		
	}
	

}

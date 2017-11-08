package org.frame.common.designPatterns.mediator;


/**
 * 中介者模式
 * 只需关心和Mediator类的关系，具体类类之间的关系及调度交给Mediator就行
 * @author cjshen
 *
 */
public class MyMediator implements Mediator {
	
	private User user1;
	
	private User user2;

	@Override
	public void createMediator() {
		user1 = new User1();
		user2 = new User2();
	}

	@Override
	public void workAll() {
		user1.work();
		user2.work();

	}

	public User getUser1() {
		return user1;
	}

	public User getUser2() {
		return user2;
	}
	

}

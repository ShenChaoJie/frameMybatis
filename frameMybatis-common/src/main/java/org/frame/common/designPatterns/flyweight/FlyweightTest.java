package org.frame.common.designPatterns.flyweight;

import java.sql.Connection;
import java.sql.SQLException;

public class FlyweightTest {

	public static void main(String[] args) throws SQLException {
		
		ConnectionPool pool = new ConnectionPool(20);
		Connection conn = pool.getConnection();
		System.out.println(conn);
		conn.close();
		
	}
}

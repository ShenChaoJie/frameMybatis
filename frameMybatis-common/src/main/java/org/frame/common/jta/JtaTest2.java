package org.frame.common.jta;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.transaction.UserTransaction;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JtaTest2 {
	
	// Atomikos连接池对象
	private static AtomikosDataSourceBean oracleDs =  new AtomikosDataSourceBean();
	// Atomikos连接池设置参数
	static{
		oracleDs.setUniqueResourceName("OracleXADataSource");
		oracleDs.setXaDataSourceClassName("oracle.jdbc.xa.client.OracleXADataSource");
		Properties p = new Properties();
		p.setProperty("user", "ytexp");
		p.setProperty("password", "LsIAJ693");
		p.setProperty("URL", "jdbc:oracle:thin:@10.129.220.16:1521/uatmdm");
		oracleDs.setXaProperties(p);
		oracleDs.setPoolSize(5);
	}

	private static AtomikosDataSourceBean mysqlDs = new AtomikosDataSourceBean();
	
	static{
		mysqlDs.setUniqueResourceName("MysqlXADataSource");
		mysqlDs.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
		Properties p = new Properties();
		p.setProperty("user", "ytuat");
		p.setProperty("password", "ytuat");
		p.setProperty("URL", "jdbc:mysql://10.129.220.15:3316/express");
		mysqlDs.setXaProperties(p);
		mysqlDs.setPoolSize(5);
	}

	// C3P0连接池对象
	private static ComboPooledDataSource mysqlDataSource = new ComboPooledDataSource();
	//C3P0连接池设置参数
	static{
		try {
			mysqlDataSource.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		mysqlDataSource.setJdbcUrl("jdbc:mysql://10.129.220.15:3316/express");
		mysqlDataSource.setUser("ytuat");
		mysqlDataSource.setPassword("ytuat");
		mysqlDataSource.setInitialPoolSize(5);
	}
	

	private static ComboPooledDataSource oracleDataSource = new ComboPooledDataSource();
	
	static{
		try {
			oracleDataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		oracleDataSource.setJdbcUrl("jdbc:oracle:thin:@10.129.220.16:1521/uatmdm");
		oracleDataSource.setUser("ytexp");
		oracleDataSource.setPassword("LsIAJ693");
		oracleDataSource.setInitialPoolSize(5);
	}


	// druid连接池对象
	private static DruidDataSource druidOracleDataSource = null;

	static {
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("driverClassName", "oracle.jdbc.driver.OracleDriver");
		properties.put("jdbcUrl","jdbc:oracle:thin:@10.129.220.16:1521/uatmdm");
		properties.put("username", "ytexp");
		properties.put("password", "LsIAJ693");
		properties.put("initialSize", "5");
		try {
			druidOracleDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static DruidDataSource druidMysqlDataSource = null;
	
	static{
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("driverClassName", "oracle.jdbc.driver.OracleDriver");
		properties.put("jdbcUrl","jdbc:oracle:thin:@10.129.220.16:1521/uatmdm");
		properties.put("username", "ytexp");
		properties.put("password", "LsIAJ693");
		properties.put("initialSize", "5");
		try {
			druidOracleDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void test() throws SQLException {
		for (int i = 0; i < 10; i++) {
			long beginTime = System.currentTimeMillis();
			UserTransaction utx = new UserTransactionImp();
			boolean rollback = false;
			Connection conn1 = null;
			Connection conn2 = null;
			try {
				utx.begin();

				conn1 = oracleDs.getConnection();
				PreparedStatement prepareStatement = conn1.prepareStatement("update T_EXP_LOADOMETER_WEIGHING set IO_STATUS=7 WHERE ID='a13eae48-887a-43b5-9751-ca459fcb3e36'");
				prepareStatement.executeUpdate();
				// System.out.println("conn1执行");

				conn2 = mysqlDs.getConnection();
				PreparedStatement prepareStatement2 = conn2.prepareStatement("update t_exp_loadometer_weighing_unsuccess_terminal set IO_STATUS=1 WHERE orderid='10032'");
				prepareStatement2.executeUpdate();
				// System.out.println("conn2执行");
			} catch (Exception e) {
				rollback = true;
				e.printStackTrace();
			} finally {
				try {
					if (!rollback) {
						utx.commit();
					} else {
						utx.rollback();
					}
					if (conn1 != null) {
						conn1.close();
					}
					if (conn2 != null) {
						conn2.close();
					}
					long costTime = System.currentTimeMillis() - beginTime;
					System.out.println("执行时间:" + costTime);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

	}

	public void test2() throws Exception {
		for (int i = 0; i < 10; i++) {
			long beginTime = System.currentTimeMillis();
			boolean rollback = false;
			Connection conn1 = null;
			Connection conn2 = null;
			try {
				conn1 = oracleDataSource.getConnection();
				PreparedStatement prepareStatement1 = conn1.prepareStatement("update T_EXP_LOADOMETER_WEIGHING set IO_STATUS=0 WHERE ID='a13eae48-887a-43b5-9751-ca459fcb3e36'");
				prepareStatement1.executeUpdate();

				conn2 = mysqlDataSource.getConnection();
				PreparedStatement prepareStatement2 = conn2.prepareStatement("update t_exp_loadometer_weighing_unsuccess_terminal set IO_STATUS=2 WHERE orderid='10032'");
				prepareStatement2.executeUpdate();

			} catch (Exception e) {
				rollback = true;
				e.printStackTrace();
			} finally {
				if (conn1 != null) {
					conn1.close();
				}
				if (conn2 != null) {
					conn2.close();
				}
				long costTime = System.currentTimeMillis() - beginTime;
				System.out.println("执行时间:" + costTime);
			}
		}

	}

	public void test3() throws SQLException {
		for (int i = 0; i < 10; i++) {
			long beginTime = System.currentTimeMillis();
			Connection conn1 = null;
			Connection conn2 = null;
			try {
				conn1 = druidOracleDataSource.getConnection();
				PreparedStatement prepareStatement1 = conn1.prepareStatement("update T_EXP_LOADOMETER_WEIGHING set IO_STATUS=3 WHERE ID='a13eae48-887a-43b5-9751-ca459fcb3e36'");
				prepareStatement1.executeUpdate();

				conn2 = druidMysqlDataSource.getConnection();
				PreparedStatement prepareStatement2 = conn2.prepareStatement("update t_exp_loadometer_weighing_unsuccess_terminal set IO_STATUS=3 WHERE orderid='10032'");
				prepareStatement2.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (conn1 != null) {
					conn1.close();
				}
				if (conn2 != null) {
					conn2.close();
				}
				long costTime = System.currentTimeMillis() - beginTime;
				System.out.println("执行时间:" + costTime);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		JtaTest2 jtaTest2 = new JtaTest2();
		System.out.println("--------JTA Atomikos连接池  事务测试开始--------");
		jtaTest2.test();
		System.out.println("--------JTA Atomikos连接池  事务测试结束--------");
		System.out.println("--------C3P0连接池 不带事务 测试开始--------");
		jtaTest2.test2();
		System.out.println("--------C3P0连接池 不带事务 测试结束--------");
		//jtaTest2.test3();
	}

}

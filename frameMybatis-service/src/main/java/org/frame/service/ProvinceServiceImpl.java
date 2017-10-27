package org.frame.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.frame.common.page.PageBar;
import org.frame.persistence.TProvinceMapper;
import org.frame.persistence.model.TProvince;
import org.frame.service.api.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.atomikos.jdbc.nonxa.AtomikosNonXADataSourceBean;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class ProvinceServiceImpl implements ProvinceService {

	@Autowired
	private TProvinceMapper provinceMapper;
	
	/*
	 * (non-Javadoc)
	 * @see org.frame.service.api.ProvinceService#findAll()
	 */
	public List<TProvince> findAll() {
		PageBounds pageBounds = new PageBounds();
		return provinceMapper.findAll(pageBounds);
	}

	/*
	 * (non-Javadoc)
	 * @see org.frame.service.api.ProvinceService#findByName(java.lang.String)
	 */
	public TProvince findByName(String name) {
		return provinceMapper.findByName(name);
	}

	/*
	 * (non-Javadoc)
	 * @see org.frame.service.api.ProvinceService#queryProvince(java.util.Map)
	 */
	public PageBar queryProvince(Map<String, String> para) throws Exception {
		PageBar pb = new PageBar(para);
		PageBounds pageBounds = new PageBounds();
		pb.setTotalNum(provinceMapper.findAll(pageBounds).size());
		
		pageBounds = new PageBounds((int)pb.getCurrentPageNum(),(int)pb.getEveryPageNum());
		
		pb.setResultList(provinceMapper.findAll(pageBounds));
		
		//com.atomikos.icatch.standalone.UserTransactionServiceFactory
		
		//UserTransactionServiceFactory factory = 
		
		UserTransactionManager atomikosTransactionManager = new UserTransactionManager();
		
		UserTransaction atomikosUserTransaction = new UserTransactionImp();
		
		JtaTransactionManager  transactionManager = new JtaTransactionManager(atomikosUserTransaction, atomikosTransactionManager);
		
		atomikosUserTransaction.setTransactionTimeout(60);
		transactionManager.getUserTransaction().begin();
		
		
		
		
		transactionManager.getUserTransaction().commit();
		
		atomikosTransactionManager.init();
		atomikosTransactionManager.setForceShutdown(true);
		atomikosTransactionManager.setTransactionTimeout(300);
		atomikosTransactionManager.begin();
		
		
		
		//com.atomikos.jdbc.AtomikosDataSourceBean
		
		AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
		Connection conn = atomikosDataSourceBean.getConnection();
		conn.setAutoCommit(false);
		
		conn.commit();
		//AtomikosNonXADataSourceBean
		
		
		atomikosTransactionManager.commit();
		
		
		//JtaTransactionManager jta = new JtaTransactionManager();
		//jta.setTransactionManager(transactionManager);
		
		return pb;
	}

	

}

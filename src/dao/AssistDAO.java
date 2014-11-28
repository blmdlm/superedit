package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 * 辅助dao
 *@Project superedit 
 *@ClassName AssistDAO
 *@Description TODO
 *@Author gejing gjblmdlm@sina.com
 *@Date 2014年11月28日 下午10:47:13
 */
public class AssistDAO extends HibernateDaoSupport{
	@Autowired
	private SessionFactory sessionFactory;
	
	public List query(String sql){
		sessionFactory.getCurrentSession().createSQLQuery(sql);
		return null;
	}
}

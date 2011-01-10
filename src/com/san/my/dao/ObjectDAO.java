
package com.san.my.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.Type;
import org.springframework.dao.DataAccessException;


public interface ObjectDAO
{

    
    public Object findOneByNamedQuery(String queryName, Object[] binds) throws DataAccessException;

    public Object findOneByNamedQuery(String queryName, Object bind) throws DataAccessException;

    
    public Object findOneByNamedQueryAndNamedParam(String queryName, String paramName, Object value)
        throws DataAccessException;

   
    public Object findOneByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] values)
        throws DataAccessException;

   
    public int countNamedQuery(String queryName, Object[] binds);

   
    public int countNamedQuery(String queryName, Object bind);

   
    public int countQuery(String sql, Object bind);

   
    public int countQuery(String sql, Object[] binds);

    
    public List findByNamedQuery(final String queryName, final Object[] binds) throws DataAccessException;

    
    public List findByNamedQuery(String queryName, Object bind) throws DataAccessException;

    
    public List findByNamedQuery(String queryName) throws DataAccessException;

    
    public List findByNamedQueryAndNamedParam(String queryName, String paramName, Object value)
        throws DataAccessException;

    
    public List findByNamedQueryAndNamedParam(final String queryName, final String[] paramNames, final Object[] values)
        throws DataAccessException;

   
    public List findByNamedQueryAndValueBean(final String queryName, final Object valueBean)
        throws DataAccessException;

    public void flush();

    
    public Serializable save(Object o) throws DataAccessException;

    
    public Serializable save(String persistentObjectName, Object o) throws DataAccessException;

    
    public Object merge(Object o) throws DataAccessException;

    
    public Object get(Class c, Serializable id) throws DataAccessException;

   
    public void delete(Object o) throws DataAccessException;

   
    public void saveOrUpdate(Object o) throws DataAccessException;

    public void saveOrUpdate(String persistentObjectName, Object o) throws DataAccessException;

   
    public void update(Object dataObject) throws DataAccessException;

    
    public void refresh(Object dataObject) throws DataAccessException;

    
    public void refreshAndLock(Object dataObject) throws DataAccessException;

    
    public void evict(Object dataObject) throws DataAccessException;
    
    
    public Object findOne(String sql) throws DataAccessException;

   
    public Object findOne(String sql, Object bind) throws DataAccessException;

    
    public Object findOne(String sql, Object[] bind) throws DataAccessException;

   
    public Object load(Class refClass, Serializable key) throws DataAccessException;

   
    public List findAll(Class clazz) throws DataAccessException;

   
    public List find(String queryString) throws DataAccessException;

    
    public List find(String queryString, Object bind) throws DataAccessException;

   
    public List find(String queryString, Object[] bind) throws DataAccessException;

   
    public List findAndLock(String sql, Object[] binds);

    
    public List findByNamedParam(String queryString, String[] paramNames, Object[] values) throws DataAccessException;

   
    public Object lockAndLoad(Class refClass, Serializable key);

    
    public Object queryByExample(Object example);

   
    public void clear();

    public List findAndLockByNamedQuery(String queryName, Object bind);

    public long count(final String queryString, final boolean isHQL);

    public long count(final String queryString, final Object value, final boolean isHQL);

    public long count(final String queryString, final Object[] values, final boolean isHQL);

    
    public List findByNamedQueryAsTransformer(String queryName, Object[] binds, ResultTransformer transformer);

    
    public <T> List<T> findBySqlQuery(String query, Map<String, Type> scalars, List<Object> binds, Class<T> aliasClass);

    
    public Session getHibSession();

    public Integer executeUpdateByNamedQuery(final String queryName, final Object[] binds);
    
    
 	public void updateAll(Collection<? extends Object> objectCollection) ;
 	
 	
 	public void saveAll(Collection<? extends Object> objectCollection);
 	 
 	public void deleteAll(Collection<? extends Object> objectCollection);
}

package com.tom.ssm.spring5.chapter0808.common.dao.impl;

import com.tom.ssm.spring5.chapter0808.common.dao.BaseDao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2018, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class BaseDaoJpa<T> implements BaseDao<T>
{
	@PersistenceContext
	protected EntityManager entityManager;

	// ����ID����ʵ��
	public T get(Class<T> entityClazz , Serializable id)
	{
		return (T)entityManager.find(entityClazz , id);
	}
	// ����ʵ��
	public Serializable save(T entity)
	{
		entityManager.persist(entity);
		try
		{
			return (Serializable) entity.getClass()
				.getMethod("getId").invoke(entity);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(entity + "�����ṩgetId����������");
		}
	}
	// ����ʵ��
	public void update(T entity)
	{
		entityManager.merge(entity);
	}
	// ɾ��ʵ��
	public void delete(T entity)
	{
		entityManager.remove(entity);
	}
	// ����IDɾ��ʵ��
	public void delete(Class<T> entityClazz , Serializable id)
	{
		entityManager.createQuery("delete " + entityClazz.getSimpleName()
				+ " en where en.id = ?0")
			.setParameter(0 , id)
			.executeUpdate();
	}
	// ��ȡ����ʵ��
	public List<T> findAll(Class<T> entityClazz)
	{
		return find("select en from "
			+ entityClazz.getSimpleName() + " en");
	}
	// ��ȡʵ������
	public long findCount(Class<T> entityClazz)
	{
		List<?> l = find("select count(*) from "
			+ entityClazz.getSimpleName());
		// ���ز�ѯ�õ���ʵ������
		if (l != null && l.size() == 1 )
		{
			return (Long)l.get(0);
		}
		return 0;
	}

	// ����JPQL����ѯʵ��
	@SuppressWarnings("unchecked")
	protected List<T> find(String jpql)
	{
		return (List<T>)entityManager.createQuery(jpql)
			.getResultList();
	}
	// ���ݴ�ռλ������JPQL����ѯʵ��
	@SuppressWarnings("unchecked")
	protected List<T> find(String jpql , Object... params)
	{
		// ������ѯ
		Query query = entityManager.createQuery(jpql);
		// Ϊ����ռλ����JPQL������ò���
		for(int i = 0 , len = params.length ; i < len ; i++)
		{
			query.setParameter(i , params[i]);
		}
		return (List<T>)query.getResultList();
	}
	/**
	 * ʹ��JPQL�����з�ҳ��ѯ����
	 * @param jpql ��Ҫ��ѯ��JPQL���
	 * @param pageNo ��ѯ��pageNoҳ�ļ�¼
	 * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String jpql,
		 int pageNo, int pageSize)
	{
		// ������ѯ
		return entityManager.createQuery(jpql)
			// ִ�з�ҳ
			.setFirstResult((pageNo - 1) * pageSize)
			.setMaxResults(pageSize)
			.getResultList();
	}
	/**
	 * ʹ��JPQL�����з�ҳ��ѯ����
	 * @param jpql ��Ҫ��ѯ��JPQL���
	 * @param params ���jpql��ռλ��������params���ڴ���ռλ������
	 * @param pageNo ��ѯ��pageNoҳ�ļ�¼
	 * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String jpql , int pageNo, int pageSize
		, Object... params)
	{
		// ������ѯ
		Query query = entityManager.createQuery(jpql);
		// Ϊ����ռλ����JPQL������ò���
		for(int i = 0 , len = params.length ; i < len ; i++)
		{
			query.setParameter(i , params[i]);
		}
		// ִ�з�ҳ�������ز�ѯ���
		return query.setFirstResult((pageNo - 1) * pageSize)
			.setMaxResults(pageSize)
			.getResultList();
	}
}

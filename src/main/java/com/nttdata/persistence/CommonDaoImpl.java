package com.nttdata.persistence;

import java.util.List;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Session;

public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	private Class<T> entityClass;

	private Session session;

	@SuppressWarnings("unchecked")
	public CommonDaoImpl(final Session session) {
		setEntityClass((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public void insert(final T newEntityT) {

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		session.save(newEntityT);

		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		final List<T> entityListResult = session.createQuery("FROM " + this.entityClass.getName()).list();

		return entityListResult;
	}

	@Override
	public T searchById(final Long entityTIdToSearch) {
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		final T entityResult = session.get(this.entityClass, entityTIdToSearch);
		return entityResult;
	}

	@Override
	public void delete(final T removeEntityT) {
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		session.delete(removeEntityT);

		session.getTransaction().commit();

	}

	@Override
	public void update(final T updateEntityT) {
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		session.saveOrUpdate(updateEntityT);

		session.getTransaction().commit();
	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass
	 *            the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
}
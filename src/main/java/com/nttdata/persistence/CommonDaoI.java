package com.nttdata.persistence;

import java.util.List;

public interface CommonDaoI<T> {

	public void insert(final T newEntityt);

	public List<T> searchAll();

	public T searchById(final Long entityTIdToSearch);

	public void delete(final T removeEntityT);

	public void update(final T updateEntityT);

}
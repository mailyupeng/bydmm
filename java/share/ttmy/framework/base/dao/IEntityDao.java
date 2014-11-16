package ttmy.framework.base.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import ttmy.framework.base.model.BaseEntity;

public interface IEntityDao<E extends BaseEntity> {
	List<E> findBy(final DetachedCriteria detachedCriteria);
	List<E> findAll();
	E findById(Long id);
}

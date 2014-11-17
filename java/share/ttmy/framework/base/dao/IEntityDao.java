package ttmy.framework.base.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import ttmy.framework.base.model.BaseEntity;
import ttmy.framework.core.IPage;

public interface IEntityDao<E extends BaseEntity> {
	List<E> findBy(DetachedCriteria detachedCriteria);

	E findUniqueBy(DetachedCriteria detachedCriteria);

	List<E> findAll();

	E findById(Long id);

	IPage<E> findPageBy(DetachedCriteria detachedCriteria, final int pageSize, final int pageIndex);
}

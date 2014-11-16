package ttmy.module.frameworkimpl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import ttmy.framework.base.model.BaseEntity;
import ttmy.framework.core.model.IModule;

@Entity
@Table(name = "ts_module")
public class Module extends BaseEntity implements IModule {

	private static final long serialVersionUID = 4942022632038121899L;

	@Column(name = "parent_id")
	private Long parentId;
	@Column(name = "name")
	private String name;
	@Column(name = "url")
	private String url;
	@Column(name = "type")
	private int type;
	@Column(name = "sort")
	private int sort;

	@Id
	@Column(name = "id")
	public Long getId() {
		return super.getId();
	}

	@Override
	public Long getParentId() {
		return parentId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public int getType() {
		return type;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}

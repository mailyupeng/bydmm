package ttmy.module.frameworkimpl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import ttmy.framework.base.model.BaseEntity;
import ttmy.framework.core.model.IRole;

@Entity
@Table(name = "ts_role")
public class Role extends BaseEntity implements IRole {
	private static final long serialVersionUID = 7107249348076879284L;

	@Column(name = "name")
	private String name;

	@Id
	@Column(name = "id")
	public Long getId() {
		return super.getId();
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

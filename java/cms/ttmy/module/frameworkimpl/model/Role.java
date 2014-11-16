package ttmy.module.frameworkimpl.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import ttmy.framework.base.model.BaseEntity;
import ttmy.framework.core.model.IModule;
import ttmy.framework.core.model.IRole;

@Entity
@Table(name = "ts_role")
public class Role extends BaseEntity implements IRole {
	private static final long serialVersionUID = 7107249348076879284L;

	@Column(name = "name")
	private String name;
	private List<IModule> authModules = new ArrayList<>();

	@Id
	@Column(name = "id")
	@Override
	public Long getId() {
		return super.getId();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<IModule> getAuthModules() {
		return authModules;
	}

	public void setName(String name) {
		this.name = name;
	}

}

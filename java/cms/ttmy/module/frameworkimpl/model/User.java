package ttmy.module.frameworkimpl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import ttmy.framework.base.model.BaseEntity;
import ttmy.framework.core.model.IUser;

@Entity
@Table(name = "ts_user")
public class User extends BaseEntity implements IUser {

	private static final long serialVersionUID = -2547329871445157634L;

	@Column(name = "name")
	private String name;
	@Column(name = "status")
	private int status;
	@Column(name = "password")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public int getStatus() {
		return 0;
	}

	@Id
	@Column(name = "id")
	public Long getId() {
		return super.getId();
	}

}

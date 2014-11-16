package ttmy.module.frameworkimpl.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import ttmy.framework.base.model.BaseEntity;

@Entity
@Table(name = "ts_user_role")
@Embeddable
public class UserRole extends BaseEntity {

	private static final long serialVersionUID = -4409383246170211928L;

	@Id
	@Column(name = "role_id")
	private Long roleId;
	@Id
	@Column(name = "user_id")
	private Long userId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}

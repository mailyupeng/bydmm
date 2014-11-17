package ttmy.module.frameworkimpl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ts_user_role")
@Embeddable
public class UserRole implements Serializable {
	private static final long serialVersionUID = 7146397888621025001L;
	@Id
	@Column(name = "role_id")
	private Long roleId;
	@Id
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "is_default")
	private Long isDefault;

	public Long getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Long isDefault) {
		this.isDefault = isDefault;
	}

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

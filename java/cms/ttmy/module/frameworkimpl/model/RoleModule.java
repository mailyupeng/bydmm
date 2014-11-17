package ttmy.module.frameworkimpl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ts_role_module")
@Embeddable
public class RoleModule implements Serializable {
	private static final long serialVersionUID = -338592040909972245L;
	@Id
	@Column(name = "role_id")
	private Long roleId;
	@Id
	@Column(name = "module_id")
	private Long moduleId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

}

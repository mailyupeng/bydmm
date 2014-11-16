package ttmy.framework.base.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -5851260017695156422L;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

package ttmy.module.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ttttt")
public class Abc {

	@Id
	@Column(name = "a")
	private String aa;

	@Column(name = "b")
	private String bb;

	@Override
	public String toString() {
		return "Abc [aa=" + aa + ", bb=" + bb + "]";
	}

}

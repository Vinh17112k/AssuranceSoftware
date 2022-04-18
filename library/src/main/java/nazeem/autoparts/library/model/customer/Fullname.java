package nazeem.autoparts.library.model.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="fullname")
public class Fullname {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fullname_id")
	private Long id;
	private String firstName;
	private String lastname;
	public Fullname(String firstName, String lastname) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
	}
	
}

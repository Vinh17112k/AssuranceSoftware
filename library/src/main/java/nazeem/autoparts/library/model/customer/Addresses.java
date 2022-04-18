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
@Table(name="address")
public class Addresses {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Long address_id;
	private String number;
	private String street;
	private String district;
	private String city;
	public Addresses(String number, String street, String district, String city) {
		super();
		this.number = number;
		this.street = street;
		this.district = district;
		this.city = city;
	}
	public Addresses(String number, String district, String city) {
		super();
		this.number = number;
		this.district = district;
		this.city = city;
	}
	
}

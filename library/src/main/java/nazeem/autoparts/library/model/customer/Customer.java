package nazeem.autoparts.library.model.customer;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import nazeem.autoparts.library.model.Country;
import nazeem.autoparts.library.model.Order;
import nazeem.autoparts.library.model.ShoppingCart;
import nazeem.autoparts.library.model.user.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;
	@Column(name = "phone")
	private String phone;
	@Column(name = "company")
    private String company;
	@NotNull(message = "Enter state!")
    @Column(name = "state")
    private String state;

    @NotNull(message = "Enter postal code!")
    @Column(name = "postal_code")
    private String postalCode;
    @NotNull(message = "Select Country!")
    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;
    //---------------- end address -------------//

    @OneToOne
    @JoinColumn(name = "fullname_id")
	private Fullname fullname;
    @OneToOne
    @JoinColumn(name = "address_id")
	private Addresses address;

    @Column(name = "is_deleted")
    private Boolean isDeleted;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "customer_roles",
            joinColumns = @JoinColumn(
                    name = "customer_id", referencedColumnName = "customer_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "role_id"))
    private Collection <Role> roles;

    @OneToOne(mappedBy = "customer")
    private ShoppingCart shoppingCart;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
	private String password;

    @Override
    public int hashCode() {
        return 42;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + fullname.getFirstName() + '\'' +
                ", lastName='" + fullname.getLastname() + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                ", address1='" + address.getNumber() + '\'' +
                ", address2='" + address.getDistrict() + '\'' +
                ", city='" + address.getCity() + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country=" + country +
                ", isDeleted=" + isDeleted +
                ", roles=" + roles +
                //", shoppingCart=" + shoppingCart +
                //", orders=" + orders +
                '}';
    }
//	private String sex;
//	private Date DOB;
}

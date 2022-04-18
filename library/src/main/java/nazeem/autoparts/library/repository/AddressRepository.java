package nazeem.autoparts.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nazeem.autoparts.library.model.customer.Addresses;

public interface AddressRepository extends JpaRepository<Addresses, Long>{

}

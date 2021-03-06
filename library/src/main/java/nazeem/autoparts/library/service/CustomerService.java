package nazeem.autoparts.library.service;

import nazeem.autoparts.library.model.customer.Customer;

/*
    Created By: noman azeem
    Contact: syed.noman.azeem@gmail.com
*/

import nazeem.autoparts.library.web.dto.CustomerRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomerService extends UserDetailsService{
    Customer save(CustomerRegistrationDto registrationDto);//For insert
    Customer save(Customer customer);//For update
    Customer findByUsername(String username);
    
}

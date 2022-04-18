package nazeem.autoparts.library.repository;

/*
    Created By: noman azeem
    Contact: syed.noman.azeem@gmail.com
*/

import org.springframework.data.jpa.repository.JpaRepository;

import nazeem.autoparts.library.model.customer.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByName(String name);
}
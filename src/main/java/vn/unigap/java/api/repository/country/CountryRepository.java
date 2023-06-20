package vn.unigap.java.api.repository.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.java.api.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
}

package com.bank.accounts.repository;

import com.bank.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByMobileNumber(String mobileNumber); // Here MobileNumber should match the defined field in Customer entity,
    // it's not case sensitive but should match the field name
    // say, want to query by multiple fields, then just pass them as arguments, and make function call as findBy<field1>And<field2>And<field3>...

}

package com.example.loans.repository;

import com.example.loans.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Long> {

    /*
    * @param mobileNumber - Mobile Number of the Customer
    * @return - Loans Object
    * */
    Optional<Loans> findByMobileNumber(String mobileNumber);
}

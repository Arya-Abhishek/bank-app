package com.example.loans.service;

import com.example.loans.dto.LoansDto;

public interface ILoansService {

    /*
    * @param mobileNumber - Mobile Number of the Customer
    * */
    void createLoan(String mobileNumber);


    /*
    * @param mobileNumber - Mobile Number of the Customer
    * @return - LoansDto Object
    * */
    LoansDto fetchLoan(String mobileNumber);

    /*
    * @param loansDto - LoansDto Object
    * @return - boolean
    * */
    boolean updateLoan(LoansDto loansDto);

    /*
    * @param mobileNumber - Mobile Number of the Customer
    * @return - boolean
    * */
    boolean deleteLoan(String mobileNumber);
}

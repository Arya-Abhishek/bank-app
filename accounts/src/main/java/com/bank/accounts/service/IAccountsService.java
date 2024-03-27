package com.bank.accounts.service;

import com.bank.accounts.dto.CustomerDto;

public interface IAccountsService {

    /*
    *
    * @param customerDto - CustomerDto Object
    * */
    void createAccount(CustomerDto customerDto);

    /*
    *
    * @param mobileNumber - Input mobile number
    * @return CustomerDto - CustomerDto Object
    * */
    CustomerDto fetchAccount(String mobileNumber);

    /*
    *
    * @param customerDto - CustomerDto Object
    * @return boolean indicating if the update of Account details is successful or not
    * */
    boolean updateAccount(CustomerDto customerDto);
}

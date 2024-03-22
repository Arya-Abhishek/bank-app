package com.bank.accounts.service;

import com.bank.accounts.dto.CustomerDto;

public interface IAccountsService {

    /*
    *
    * @param customerDto - CustomerDto Object
    * */
    void createAccount(CustomerDto customerDto);
}

package com.bank.accounts.controller;

import com.bank.accounts.constants.AccountsConstants;
import com.bank.accounts.dto.CustomerDto;
import com.bank.accounts.dto.ResponseDto;
import com.bank.accounts.service.IAccountsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
class AccountsController {

    private IAccountsService iAccountsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {

        iAccountsService.createAccount(customerDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber) {
        CustomerDto customerDto = iAccountsService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = iAccountsService.updateAccount(customerDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_UPDATE));
        }
    }
}

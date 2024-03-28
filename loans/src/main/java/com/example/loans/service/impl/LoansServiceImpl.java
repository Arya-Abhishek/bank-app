package com.example.loans.service.impl;

import com.example.loans.constants.LoansConstants;
import com.example.loans.entity.Loans;
import com.example.loans.exception.LoanAlreadyExistsException;
import com.example.loans.repository.LoansRepository;
import com.example.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansService {

    private LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loans> optionalLoans = loansRepository.findByMobileNumber(mobileNumber);
        if (optionalLoans.isPresent()) {
             throw new LoanAlreadyExistsException("Loan already exists for the given mobile number " + mobileNumber);
        }
        loansRepository.save(createNewLoan(mobileNumber));
    }

    /*
    * @param mobileNumber - Mobile Number of the Customer
    * @return - New Loans Object
    * */
    private Loans createNewLoan(String mobileNumber) {
        Loans newLoan = new Loans();
        long randomLoanNumber = (long) (Math.random() * 100000 + 333333);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoansConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }
}

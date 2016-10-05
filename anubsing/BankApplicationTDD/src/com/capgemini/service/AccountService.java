package com.capgemini.service;

import com.capgemini.exceptions.AccountAlreadyExist;
import com.capgemini.exceptions.AccountNotExist;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.InvalidAmmountException;
import com.capgemini.model.Account;

public interface AccountService {
	
	Account createAccount(int accountNumber,int amount)throws AccountAlreadyExist, InsufficientInitialBalanceException , InvalidAccountNumberException,InvalidAmmountException;
	
	int showBalance(int accountNumber) throws InvalidAccountNumberException,AccountNotExist ;
	
	String deposite(int accountNumber, int amount) throws AccountNotExist, InvalidAccountNumberException,InvalidAmmountException;
	
	String widraw(int accountNumber, int amount) throws InvalidAccountNumberException,InvalidAmmountException;

	public String fundTransfer(int accountNumberone, int accountNumberTwo, int ammount) throws InvalidAccountNumberException,InvalidAmmountException;
}

package com.capgemini.service;

import com.capgemini.exceptions.AccountAlreadyExist;
import com.capgemini.exceptions.AccountNotExist;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.InvalidAmmountException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository=accountRepository;
	}
	@Override
	public Account createAccount(int accountNumber, int amount) throws AccountAlreadyExist, InsufficientInitialBalanceException,InvalidAccountNumberException,InvalidAmmountException {
		if(amount<500)
		{
			throw new InsufficientInitialBalanceException();
		}
		
		Account account = new Account();
		
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		
		if(accountRepository.save(account))
		{
			
			return account;
		}
		else
		{
			throw new AccountAlreadyExist();
		}
		
		
	}

	@Override
	public int showBalance(int accountNumber) throws InvalidAccountNumberException,AccountNotExist {
		
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		
		if(accountRepository.save(account))
		{
			throw new AccountNotExist();
		}
		return 0;
	}
	@Override	
public String deposite(int accountNumber, int amount) throws AccountNotExist, InvalidAccountNumberException,InvalidAmmountException
{
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		
		
		if(accountRepository.save(account))
		{
			throw new AccountNotExist();
		}
	return null;
	
}
	@Override
public String widraw(int accountNumber, int amount) throws InvalidAccountNumberException,InvalidAmmountException
{
	return null;
	
}
	@Override
public String fundTransfer(int accountNumberone, int accountNumberTwo, int ammount) throws InvalidAccountNumberException,InvalidAmmountException
{
	return null;
}

}

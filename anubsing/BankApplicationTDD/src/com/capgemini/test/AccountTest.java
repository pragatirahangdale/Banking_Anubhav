package com.capgemini.test;

import static org.junit.Assert.*;

import org.objenesis.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.exceptions.AccountAlreadyExist;
import com.capgemini.exceptions.AccountNotExist;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.InvalidAmmountException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;

public class AccountTest {

	AccountService accountService;
	
	@Mock
	AccountRepository accountRepository;
	
	
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		accountService = new AccountServiceImpl(accountRepository);
	}

	/*
	 * test cases for create account
	 * 1. when the amount is less than 500 system should throw exception
	 * 2. when the valid info is passed account should be created successfully
	 */
	
	//Create Account Method
	
	@Test(expected = com.capgemini.exceptions.InsufficientInitialBalanceException.class)
	public void whenTheAmountIsLessThan500SystemShouldThrowException() throws AccountAlreadyExist, InsufficientInitialBalanceException,InvalidAmmountException,InvalidAccountNumberException
	{
		accountService.createAccount(102,600);
	}

	@Test(expected = com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void whenAccountNumberIsInvalid() throws AccountAlreadyExist, InsufficientInitialBalanceException,InvalidAmmountException,InvalidAccountNumberException
	{
		accountService.createAccount(102,600);
	}
	@Test(expected = com.capgemini.exceptions.InvalidAmmountException.class)
	public void whenAmountIsInvalid() throws AccountAlreadyExist, InsufficientInitialBalanceException,InvalidAmmountException,InvalidAccountNumberException
	{
		accountService.createAccount(102,600);
	}
	@Test
	public void sucessfullyCreated() throws InsufficientInitialBalanceException,InvalidAmmountException,InvalidAccountNumberException
	{
		Account myAccount = accountService.createAccount(102,600);
		assertEquals(myAccount.getAccountNumber() ,)
	}
	
	@Test(expected = com.capgemini.exceptions.AccountAlreadyExist.class)
	public void whenAccountAlreadyExist() throws AccountAlreadyExist, InsufficientInitialBalanceException,InvalidAmmountException,InvalidAccountNumberException,AccountAlreadyExist
	{
		accountService.createAccount(102,600);
		
	}
	
	//Show Balance Method
	
	@Test(expected = com.capgemini.exceptions.AccountNotExist.class)
	public void whenAccountNotExist() throws InvalidAccountNumberException,AccountNotExist
	{
		accountService.showBalance(1234);
	}
	
	@Test(expected = com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void whenAccountNumberIsInvalidForShowBalanceMethod() throws InvalidAccountNumberException,AccountNotExist
	{
		accountService.showBalance(1234);
	}
	
	//Deposite
	
	@Test(expected = com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void whenAccountNumberIsInvalidForDeposite() throws InvalidAccountNumberException,InvalidAmmountException,AccountNotExist
	{
		accountService.deposite(1234, 100);
	}
	
	@Test(expected = com.capgemini.exceptions.InvalidAmmountException.class)
	public void whenAmountIsInvalidForDeposite() throws InvalidAccountNumberException,InvalidAmmountException,AccountNotExist
	{
		accountService.deposite(1234, 100);
	}
	
	@Test(expected = com.capgemini.exceptions.InvalidAmmountException.class)
	public void whenAccountNotExistForDeposite() throws InvalidAccountNumberException,InvalidAmmountException,AccountNotExist
	{
		accountService.deposite(1234, 100);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package com.epam.engx.cleancode.functions.task1;

import com.epam.engx.cleancode.functions.task1.thirdpartyjar.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.epam.engx.cleancode.functions.task1.thirdpartyjar.CheckStatus.OK;

public class RegisterAccountAction {


    private PasswordChecker passwordChecker;
    private AccountManager accountManager;
    private void validateAccountName(Account account)
    {
    	if (account.getName().length() <= 5){
            throw new WrongAccountNameException();
        }
    }
    private void validatePassword(Account account)
    {
    	String password = account.getPassword();
        if (password.length() <= 8) {
            throw new TooShortPasswordException();
        }
        if (passwordChecker.validate(password) != OK) {
            throw new WrongPasswordException();
        }
    }
    private void validateAccount(Account account)
    {
    	 validateAccountName(account);
    	 validatePassword(account);
         

    }
    private void setAccountCreatedDate(Account account)
    {
        account.setCreatedDate(new Date());
    }
    private void setAddress(Account account)
    {
    	List<Address> addresses = new ArrayList<Address>();
        addresses.add(account.getHomeAddress());
        addresses.add(account.getWorkAddress());
        addresses.add(account.getAdditionalAddress());
        account.setAddresses(addresses);
	
    }
    public void register(Account account) {
        validateAccount(account);
        setAccountCreatedDate(account);
        setAddress(account);
        accountManager.createNewAccount(account);
    }


    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void setPasswordChecker(PasswordChecker passwordChecker) {

        this.passwordChecker = passwordChecker;
    }

}

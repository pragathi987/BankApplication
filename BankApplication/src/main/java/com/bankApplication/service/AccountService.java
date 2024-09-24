package com.bankApplication.service;

import java.util.List;

import com.bankApplication.DTO.AccountDTO;

public interface AccountService {
	
	AccountDTO createAccount(AccountDTO accountDto);
	
	AccountDTO getAccountbyId(Long account_Id);
	
	AccountDTO depositAmount(Long account_Id, double amount);
	
	AccountDTO withdrawAmount(Long account_Id,double amount);
	
	List<AccountDTO> getAllAccounts();
	
	void deleteAccount(Long account_Id);

}

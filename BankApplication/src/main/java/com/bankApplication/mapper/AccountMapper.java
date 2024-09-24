package com.bankApplication.mapper;

import com.bankApplication.DTO.AccountDTO;
import com.bankApplication.entity.Account;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDTO accountDto) {
		Account account = new Account();
		
		if (accountDto.getAccount_Id() != null) {
			account.setAccount_Id(accountDto.getAccount_Id().longValue());

	    }
		account.setAccountHolderName(accountDto.getAccountHolderName());
		account.setBalance(accountDto.getBalance());
	    
	    return account;
		
		
		
	}
	
	public static AccountDTO mapToAccountDTO(Account account) {
		AccountDTO accountDto = new AccountDTO(account.getAccount_Id(), account.getAccountHolderName(), account.getBalance());
		return accountDto;
		
	}
	
	
}




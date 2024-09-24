package com.bankApplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDTO {
	
	public AccountDTO(AccountDTO accountbyId) {
		// TODO Auto-generated constructor stub
	}
	private Long account_Id;
	private String accountHolderName;
	private double balance;

}


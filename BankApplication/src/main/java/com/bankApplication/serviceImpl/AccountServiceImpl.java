package com.bankApplication.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankApplication.DTO.AccountDTO;
import com.bankApplication.entity.Account;
import com.bankApplication.mapper.AccountMapper;
import com.bankApplication.repository.AccountRepository;
import com.bankApplication.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService{
	
	
	private AccountRepository accountRepo;
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepo) {
		super();
		this.accountRepo = accountRepo;
	}

	@Override
	public AccountDTO createAccount(AccountDTO accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepo.save(account);
		
		return AccountMapper.mapToAccountDTO(savedAccount);
	}

	@Override
	public AccountDTO getAccountbyId(Long account_Id) {
		Account account = accountRepo.findById(account_Id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		return AccountMapper.mapToAccountDTO(account);
	}

	@Override
	public AccountDTO depositAmount(Long account_Id, double amount) {
		Account account = accountRepo.findById(account_Id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account savedAccount = accountRepo.save(account);
		return AccountMapper.mapToAccountDTO(savedAccount);
	}

	@Override
	public AccountDTO withdrawAmount(Long account_Id, double amount) {
		Account account = accountRepo.findById(account_Id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount = accountRepo.save(account);
		return AccountMapper.mapToAccountDTO(savedAccount);
	}

	@Override
	public List<AccountDTO> getAllAccounts() {
		List<Account> accounts = accountRepo.findAll();
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDTO(account)).collect(Collectors.toList());
		
		
	
	}

	@Override
	public void deleteAccount(Long account_Id) {
		Account account = accountRepo.findById(account_Id).orElseThrow(() -> new RuntimeException("account does not exisit"));
		accountRepo.deleteById(account_Id);
		
	}

}

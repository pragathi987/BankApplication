package com.bankApplication.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankApplication.DTO.AccountDTO;
import com.bankApplication.service.AccountService;

@RestController
@RequestMapping("/api/banking")
public class AccountController {
	
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	
	//Add account REST API
	@PostMapping("/create")
	public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
	}
	
	//Find by Id REST API
	@GetMapping("/{account_Id}/find")
	public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long account_Id){
		AccountDTO accountDto = accountService.getAccountbyId(account_Id);
		return ResponseEntity.ok(accountDto);
	}
	
	//Deposit Amount REST API
	@PutMapping("/{account_Id}/deposit")
	public ResponseEntity<AccountDTO> depositAmount(@PathVariable Long account_Id,@RequestBody Map<String, Double> request){
		Double amount = request.get("amount");		
		AccountDTO accountDto = accountService.depositAmount(account_Id, amount);
		return ResponseEntity.ok(accountDto);
		
	}
	
	//Withdraw Amount REST API
	@PutMapping("/{account_Id}/withdraw")
	public ResponseEntity<AccountDTO> withdrawAmount(@PathVariable Long account_Id,@RequestBody Map<String, Double> request){
		Double amount = request.get("amount");
		AccountDTO accountDto = accountService.withdrawAmount(account_Id, amount);
		return ResponseEntity.ok(accountDto);
		
	}
	
	//Get all accounts
	@GetMapping("getAll")
	public ResponseEntity<List<AccountDTO>> getAll(){
		List<AccountDTO> accounts = accountService.getAllAccounts();
		return ResponseEntity.ok(accounts);
	}
	
	//Delete records	
	@DeleteMapping("/{account_Id}/delete")
	public ResponseEntity<String> deleteAccount(@PathVariable Long account_Id){
		accountService.deleteAccount(account_Id);
		return ResponseEntity.ok("account Deleted");
	}
	
}

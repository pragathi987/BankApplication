package com.bankApplication.DTO;

public record FundTransferDTO(Long fromAccountId, Long toAccountId, Double amount) {

}

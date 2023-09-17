package ma.sid.ebankservices.service;

import ma.sid.ebankservices.dto.BankAccountResponseDTO;
import ma.sid.ebankservices.dto.BankAccountRequestDTO;

public interface AccountService {
     BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

     BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}

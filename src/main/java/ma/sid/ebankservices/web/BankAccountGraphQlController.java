package ma.sid.ebankservices.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.sid.ebankservices.dto.BankAccountRequestDTO;
import ma.sid.ebankservices.dto.BankAccountResponseDTO;
import ma.sid.ebankservices.entities.BankAccount;
import ma.sid.ebankservices.entities.Customer;
import ma.sid.ebankservices.repositories.BankAccountRepository;
import ma.sid.ebankservices.repositories.CustomerRepository;
import ma.sid.ebankservices.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQlController {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException(String.format("Account %s not found",id)));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id,bankAccount);
    }

    @MutationMapping
    public void deleteAccount(@Argument String id){
         bankAccountRepository.deleteById(id);
         //return true;
    }

    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }
}








































// c'est mieux comme d'utilisé record pad comme ça(java 14 > :
//
//@Data @NoArgsConstructor @AllArgsConstructor
//class BankAccountDTO {
//    private String type;
//    private Double balance;
//    private String currency;
//}

//record BankAccountDTO(Double balance,String type,String currency){
//
//}

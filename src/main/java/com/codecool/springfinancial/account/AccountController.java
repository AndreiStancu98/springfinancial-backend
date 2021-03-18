package com.codecool.springfinancial.account;

import com.codecool.springfinancial.payload.request.AccountRequest;
import com.codecool.springfinancial.payload.response.MessageResponse;
import com.codecool.springfinancial.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/test")
@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account/customerPid={customerPid}")
    public List<Account> getAccountsByCustomerPid(@PathVariable("customerPid")String customerPid) {
        return accountService.getAccountsByCustomerPid(customerPid);
    }

    @PostMapping("/account/new-account")
    public ResponseEntity<?> createAccount(@Valid @RequestBody AccountRequest accountRequest) {
        if (accountRepository.existsByAccountNumber(accountRequest.getAccountNumber())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error : Account already exists !"));
        }

        if (!userRepository.existsByUsername(accountRequest.getCustomerPid())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error : No customer found !"));
        }

        Account account = new Account(accountRequest.getCustomerPid(), accountRequest.getType(), accountRequest.getCurrency(), accountRequest.getAmount(), accountRequest.getAccountNumber(), accountRequest.getInterest());
        accountRepository.save(account);

        return ResponseEntity.ok(new MessageResponse("Account created successfully"));
    }

    @DeleteMapping("/account/delete/id={id}")
    public void deleteAccount(@PathVariable("id") Long id){
        accountService.deleteAccount(id);
    }

}

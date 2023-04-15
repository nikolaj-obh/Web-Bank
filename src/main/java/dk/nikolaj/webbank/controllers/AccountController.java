package dk.nikolaj.webbank.controllers;

import dk.nikolaj.webbank.model.Account;
import dk.nikolaj.webbank.service.interfaces.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("")
    public List<Account> list() {
        return accountService.listAllAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable Long id) {
        try {
            Account account = accountService.getAccount(id);
            return new ResponseEntity<Account>(account, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Account account) {
        accountService.saveAccount(account);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Account account, @PathVariable Long id) {
        try {
            Account existAccount = accountService.getAccount(id);
            account.setID(id);
            accountService.saveAccount(account);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        accountService.deleteAccount(id);
    }
}

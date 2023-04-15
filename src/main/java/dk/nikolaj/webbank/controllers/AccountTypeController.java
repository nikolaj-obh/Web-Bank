package dk.nikolaj.webbank.controllers;

import dk.nikolaj.webbank.model.AccountType;
import dk.nikolaj.webbank.service.interfaces.AccountTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/account-type")
public class AccountTypeController {

    AccountTypeService accountTypeService;

    public AccountTypeController(AccountTypeService accountTypeService) {
        this.accountTypeService = accountTypeService;
    }

    @GetMapping("")
    public List<AccountType> list() {
        return accountTypeService.listAllAccountTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountType> get(@PathVariable Long id) {
        try {
            AccountType accountType = accountTypeService.getAccountType(id);
            return new ResponseEntity<AccountType>(accountType, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<AccountType>(HttpStatus.NOT_FOUND);
        }
    }
    // TODO implement missing CRUD operations
    //@PostMapping("/")
    //public void add(@RequestBody AccountType accountType) {
    //    accountTypeService.saveAccountType(accountType);
    //}
//
    //@PutMapping("/{id}")
    //public ResponseEntity<?> update(@RequestBody AccountType accountType, @PathVariable Long id) {
    //    try {
    //        AccountType existAccountType = accountTypeService.getAccountType(id);
    //        accountType.setAccountType();
    //        accountTypeService.saveAccountType(accountType);
    //        return new ResponseEntity<>(HttpStatus.OK);
    //    } catch (NoSuchElementException e) {
    //        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //    }
    //}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        accountTypeService.deleteAccountType(id);
    }
}

package dk.nikolaj.webbank.service;

import dk.nikolaj.webbank.model.AccountType;
import dk.nikolaj.webbank.repositories.AccountTypeRepository;
import dk.nikolaj.webbank.service.interfaces.AccountTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class AccountTypeServiceImpl implements AccountTypeService {

    private final AccountTypeRepository accountTypeRepository;

    public AccountTypeServiceImpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    public List<AccountType> listAllAccountTypes() {
        return accountTypeRepository.findAll();
    }

    public AccountType getAccountType(Long id) {
        return accountTypeRepository.findById(id).get();
    }

    public void saveAccountType(AccountType accountType) {
        accountTypeRepository.save(accountType);
    }

    public void deleteAccountType(Long id) {
        accountTypeRepository.deleteById(id);
    }
}

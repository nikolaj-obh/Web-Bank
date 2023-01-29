package dk.nikolaj.webbank.service.interfaces;

import dk.nikolaj.webbank.model.AccountType;

import java.util.List;

public interface AccountTypeService {

    List<AccountType> listAllAccountTypes();

    AccountType getAccountType(Long id);

    void saveAccountType(AccountType accountType);

    void deleteAccountType(Long id);
}

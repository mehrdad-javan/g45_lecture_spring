package se.lexicon.dao.impl;

import org.springframework.stereotype.Component;
import se.lexicon.dao.AccountDao;
import se.lexicon.dao.sequencer.AccountIdGenerator;
import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class AccountDaoImpl implements AccountDao {

  private List<Account> storage = new ArrayList<>();


  @Override
  public Account create(Account account) {
    // step1: validate the method parameters
    // step2: generate account number and set it to account id
    // step3: add account to storage
    // step4: return the result

    if (account == null) throw new IllegalArgumentException("account was null");
    Long accountId = AccountIdGenerator.generateAccountNumber();
    account.setId(accountId);
    storage.add(account);
    return account;
  }

  @Override
  public Optional<Account> findById(Long id) {
    if (id == null) throw new IllegalArgumentException("account id was null");
    return storage.stream() // stream source
            .filter(account -> account.getId().equals(id)) // used intermediate operation to create a small stream
            .findFirst(); // terminal operation used to make a result
  }

  @Override
  public Collection<Account> findAll() {
    return new ArrayList<>(storage);
  }

  @Override
  public void remove(Long accountId) throws DataNotFoundException {
    Optional<Account> optionalAccount = findById(accountId);
    if (!optionalAccount.isPresent()) throw new DataNotFoundException("data not found exception");
    else storage.remove(optionalAccount.get());
  }


  @Override
  public void updateBalance(Account account) throws DataNotFoundException {
    if (account == null) throw new IllegalArgumentException("account data was null");
    Optional<Account> optionalAccount = findById(account.getId());
    if (!optionalAccount.isPresent()) throw new DataNotFoundException("data not found exception");
    else storage.forEach(element -> {
     if(element.getId().equals(account.getId())){
       element.setBalance(account.getBalance());
     }
    });
  }


}

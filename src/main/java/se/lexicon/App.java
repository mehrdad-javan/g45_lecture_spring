package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.dao.AccountDao;
import se.lexicon.dao.CustomerDao;
import se.lexicon.model.Account;
import se.lexicon.model.Customer;
import se.lexicon.service.CustomerService;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) {
    //AccountDao accountDao = new AccountDaoImpl();

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    CustomerService customerService = context.getBean(CustomerService.class);

    System.out.println(customerService.registerCustomer(new Customer("Test","Test",new Account(100))));





  }
}

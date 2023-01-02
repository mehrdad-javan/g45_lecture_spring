package se.lexicon.model;

import se.lexicon.exception.InsufficientFoundsException;

import java.util.Objects;

public class Account {

  private Long id;
  private double balance;


  public Account(double balance) {
    this.balance = balance;
  }

  public Account(Long id, double balance) {
    this.id = id;
    this.balance = balance;
  }


  public void withdraw(double amount) throws InsufficientFoundsException {
    if (amount <= 0) throw new IllegalArgumentException("amount is not valid!");
    if(amount > balance) throw new InsufficientFoundsException(amount, "Balance is insufficient");
    this.balance -= amount;
  }

  public void deposit(double amount) {
    if (amount <= 0) throw new IllegalArgumentException("amount is not valid!");
    this.balance += amount;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Account account = (Account) o;
    return Double.compare(account.balance, balance) == 0 && Objects.equals(id, account.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, balance);
  }

  @Override
  public String toString() {
    return "Account{" +
            "id=" + id +
            ", balance=" + balance +
            '}';
  }
}

package se.lexicon.exception;

public class InsufficientFoundsException extends Exception {

  private final double amount;

  public InsufficientFoundsException(double amount ,String message) {
    super(message);
    this.amount = amount;
  }

  public double getAmount() {
    return amount;
  }

}

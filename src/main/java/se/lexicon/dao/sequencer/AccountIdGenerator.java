package se.lexicon.dao.sequencer;

public class AccountIdGenerator {

  private static long sequencer = 0;

  private static final int MAX = 999999;
  private static final int MIN = 100000;

  private static long nextId(){
    return ++sequencer;
  }

  private static long getRandomNumber(){
    return (long) ((Math.random() * (MAX - MIN)) + MIN);
  }

  public static long generateAccountNumber(){
    String result =  nextId() + "" + getRandomNumber();
    return Long.parseLong(result);
  }



}

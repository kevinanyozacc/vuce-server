package com.senasa.tupaserver.shared.sql;

public class CounterSql {
  private int counter;

  CounterSql(int counter) {
    this.counter = counter;
  }

  public int getCounter() {
    return counter;
  }

  public void setCounter(int counter) {
    this.counter = counter;
  }
}

package ru.sber.beautifulcode.domain;

public class IllegalTextStringException extends RuntimeException {
  IllegalTextStringException(String message) {
    super(message);
  }
}

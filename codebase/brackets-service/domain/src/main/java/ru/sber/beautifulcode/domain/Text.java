package ru.sber.beautifulcode.domain;

public class Text {
  private final String value;

  private Text(String value) {
    this.value = value;
  }

  /**
   * @throws IllegalTextStringException if value is null or empty
   */
  public static Text fromString(String string) {
    if (string == null) {
      throw new IllegalTextStringException("Value can not be null.");
    }
    if (string.isBlank()) {
      throw new IllegalTextStringException("Value can not be blank.");
    }
    return new Text(string);
  }

  String value() {
    return this.value;
  }
}

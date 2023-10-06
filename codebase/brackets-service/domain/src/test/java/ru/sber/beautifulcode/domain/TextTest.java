package ru.sber.beautifulcode.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TextTest {
  @Test
  @DisplayName("Text creation from valid string")
  void fromValidString() {
    Assertions.assertDoesNotThrow(() -> Text.fromString("Some text."));
  }

  @Test
  @DisplayName("Text creation failed from invalid string")
  void fromInvalidString() {
    Assertions.assertThrows(IllegalTextStringException.class, () -> Text.fromString("  "));
    Assertions.assertThrows(IllegalTextStringException.class, () -> Text.fromString(null));
  }
}
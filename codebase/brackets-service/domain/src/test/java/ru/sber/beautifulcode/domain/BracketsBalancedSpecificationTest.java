package ru.sber.beautifulcode.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.sber.beautifulcode.shared.domain.specification.Specification;

class BracketsBalancedSpecificationTest {
  private static final BracketsBalancedSpecification BRACKETS_BALANCED_SPECIFICATION = new BracketsBalancedSpecification();

  @Test
  @DisplayName("Specification is satisfied by text with balanced brackets")
  void satisfiedByTextWithBalancedBrackets() {
    Text textWithBalancedBrackets = Text.fromString("""
      Вчера я отправился в поход в лес (это мое любимое место для отдыха) вместе с друзьями.
      Мы выбрали маршрут, который проходил через горные потоки и поля (для разнообразия).
      """);
    Assertions.assertTrue(BRACKETS_BALANCED_SPECIFICATION.isSatisfiedBy(textWithBalancedBrackets));
  }

  @Test
  @DisplayName("Specification is satisfied by text without brackets at all")
  void satisfiedByTextWithoutBracketsAtAll() {
    Text textWithoutBalancedBrackets = Text.fromString("""
      Вчера я отправился в поход в лес вместе с друзьями.
      Мы выбрали маршрут, который проходил через горные потоки и поля.
      """);
    Assertions.assertTrue(BRACKETS_BALANCED_SPECIFICATION.isSatisfiedBy(textWithoutBalancedBrackets));
  }

  @Test
  @DisplayName("Specification is not satisfied by text with unbalanced brackets")
  void notSatisfiedByTextWithUnbalancedBrackets() {
    Text textWithoutBalancedBrackets = Text.fromString("""
      Вчера я отправился в поход в лес (это мое любимое место для отдыха) вместе с друзьями.
      Мы выбрали маршрут, который проходил через горные потоки и поля (для разнообразия.
      """);
    Assertions.assertTrue(BRACKETS_BALANCED_SPECIFICATION.not().isSatisfiedBy(textWithoutBalancedBrackets));
  }

  @Test
  @DisplayName("Specification is not satisfied by text with balanced brackets and empty text between any pair of them")
  void notSatisfiedByTextWithBalancedBracketsAndEmptyTextBetweenAnyPairOfThem() {
    Text textWithoutBalancedBrackets = Text.fromString("""
      Вчера я отправился в поход в лес (это мое любимое место для отдыха) вместе с друзьями.
      Мы выбрали маршрут, который проходил через горные потоки и поля ( ).
      """);
    Assertions.assertTrue(BRACKETS_BALANCED_SPECIFICATION.not().isSatisfiedBy(textWithoutBalancedBrackets));
  }
}
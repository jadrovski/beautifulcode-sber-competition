package ru.sber.beautifulcode.domain;

import ru.sber.beautifulcode.shared.domain.specification.AbstractSpecification;

public class BracketsBalancedSpecification extends AbstractSpecification<Text> {
  @Override
  public boolean isSatisfiedBy(Text text) {
    boolean balanced = true;
    boolean hasLetterAfterOpenBracket = false;
    for (char currentChar : text.value().toCharArray()) {
      if (currentChar == '(') {
        if (!balanced) {
          // Данная спецификация не предусматривает вложенные скобки
          break;
        }
        balanced = false;
        hasLetterAfterOpenBracket = false;
      } else if (currentChar == ')') {
        if (balanced) {
          balanced = false;
          break;
        } else {
          if (!hasLetterAfterOpenBracket) {
            break;
          }
          balanced = true;
        }
      } else if (!balanced && Character.isLetter(currentChar)) {
        hasLetterAfterOpenBracket = true;
      }
    }
    return balanced;
  }
}

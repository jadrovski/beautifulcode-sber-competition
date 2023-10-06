package ru.sber.beautifulcode.application;

import ru.sber.beautifulcode.domain.BracketsBalancedSpecification;
import ru.sber.beautifulcode.domain.IllegalTextStringException;
import ru.sber.beautifulcode.domain.Text;
import ru.sber.beautifulcode.shared.application.Logger;

public class CheckBracketsUseCase {
  private final static BracketsBalancedSpecification BRACKETS_BALANCED_SPECIFICATION
    = new BracketsBalancedSpecification();

  private final Logger logger;

  public CheckBracketsUseCase(Logger logger) {
    this.logger = logger;
  }

  public void execute(Input input, Presenter presenter) {
    try {
      Text text = Text.fromString(input.text());
      if (BRACKETS_BALANCED_SPECIFICATION.isSatisfiedBy(text)) {
        presenter.presentCorrect();
      } else {
        presenter.presentIncorrect();
      }
    } catch (IllegalTextStringException e) {
      presenter.presentErrorIllegalString();
    } catch (Exception e) {
      this.logger.error(e);
      presenter.presentFailed();
    }
  }

  public static class Input {
    private final String text;

    public Input(String text) {
      this.text = text;
    }

    public String text() {
      return text;
    }
  }

  public interface Presenter {
    void presentCorrect();
    void presentIncorrect();
    void presentErrorIllegalString();
    void presentFailed();
  }
}

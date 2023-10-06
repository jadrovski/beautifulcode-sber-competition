package ru.sber.beautifulcode.infrastructure.api;

import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import ru.sber.beautifulcode.application.CheckBracketsUseCase;

import java.io.IOException;
import java.util.Map;

public class JsonBracketsCorrectnessPresenter implements CheckBracketsUseCase.Presenter {
  private static final String IS_CORRECT_JSON_OBJECT_KEY = "isCorrect";

  private final HttpServletResponse httpServletResponse;

  public JsonBracketsCorrectnessPresenter(HttpServletResponse httpServletResponse) {
    this.httpServletResponse = httpServletResponse;
  }

  @Override
  public void presentCorrect() {
    writeJsonResponse((new JSONObject(Map.of(IS_CORRECT_JSON_OBJECT_KEY, true))).toString());
  }

  @Override
  public void presentIncorrect() {
    writeJsonResponse((new JSONObject(Map.of(IS_CORRECT_JSON_OBJECT_KEY, false))).toString());
  }

  @Override
  public void presentErrorIllegalString() {
    this.httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
  }

  @Override
  public void presentFailed() {
    this.httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
  }

  private void writeJsonResponse(String response) {
    try {
      this.httpServletResponse.setStatus(HttpServletResponse.SC_OK);
      this.httpServletResponse.setContentType("application/json");
      this.httpServletResponse.getWriter().write(response);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

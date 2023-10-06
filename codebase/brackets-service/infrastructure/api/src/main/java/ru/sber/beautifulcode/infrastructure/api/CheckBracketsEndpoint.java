package ru.sber.beautifulcode.infrastructure.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import ru.sber.beautifulcode.application.CheckBracketsUseCase;
import ru.sber.beautifulcode.shared.infrastructure.api.Endpoint;
import ru.sber.beautifulcode.shared.infrastructure.api.HttpRequest;

import java.util.Optional;

public class CheckBracketsEndpoint implements Endpoint {
  private final CheckBracketsUseCase useCase;

  public CheckBracketsEndpoint(CheckBracketsUseCase useCase) {
    this.useCase = useCase;
  }

  @Override
  public boolean match(HttpServletRequest httpServletRequest) {
    return httpServletRequest.getMethod().equals("POST") && httpServletRequest.getPathInfo().equals("/api/checkBrackets");
  }

  @Override
  public void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
    JsonBracketsCorrectnessPresenter presenter = new JsonBracketsCorrectnessPresenter(httpServletResponse);
    String requestBody = HttpRequest.extractBody(httpServletRequest);
    Optional<String> text = readText(requestBody);
    if (text.isEmpty()) {
      httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }

    this.useCase.execute(
      new CheckBracketsUseCase.Input(text.get()),
      presenter
    );
  }

  private Optional<String> readText(String body) {
    String text;
    try {
      JSONObject object = new JSONObject(body);
      text = object.has("text") ? object.getString("text") : null;
    } catch (JSONException e) {
      text = null;
    }
    return Optional.ofNullable(text);
  }
}

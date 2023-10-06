package ru.sber.beautifulcode.shared.infrastructure.api;

import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class HttpRequest {
  private HttpRequest() {
  }

  public static String extractBody(HttpServletRequest httpServletRequest) {
    try {
      return new BufferedReader(new InputStreamReader(httpServletRequest.getInputStream()))
        .lines().parallel().collect(Collectors.joining("\n"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

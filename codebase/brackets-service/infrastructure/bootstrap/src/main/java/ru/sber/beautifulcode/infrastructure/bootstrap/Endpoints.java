package ru.sber.beautifulcode.infrastructure.bootstrap;

import ru.sber.beautifulcode.application.CheckBracketsUseCase;
import ru.sber.beautifulcode.infrastructure.api.CheckBracketsEndpoint;
import ru.sber.beautifulcode.shared.infrastructure.api.Endpoint;

import java.util.Collection;
import java.util.List;

public class Endpoints {
  private Endpoints() {
  }

  public static Collection<Endpoint> all() {
    return List.of(
      new CheckBracketsEndpoint(new CheckBracketsUseCase(Throwable::printStackTrace))
    );
  }
}

package ru.sber.beautifulcode.shared.infrastructure.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Endpoint {
    boolean match(HttpServletRequest httpServletRequest);
    void execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);
}

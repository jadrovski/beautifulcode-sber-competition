package ru.sber.beautifulcode.shared.infrastructure.api;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Collection;

@WebServlet
public class ApiServlet extends GenericServlet {
    private final Collection<Endpoint> endpoints;

    public ApiServlet(Collection<Endpoint> endpoints) {
        this.endpoints = endpoints;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (httpRequest == null || httpResponse == null) {
            throw new ServletException("non-HTTP request or response");
        }

        Endpoint endpointFound = null;
        for (Endpoint endpoint : this.endpoints) {
            if (endpoint.match(httpRequest)) {
                endpointFound = endpoint;
                break;
            }
        }

        if (endpointFound != null) {
            endpointFound.execute(httpRequest, httpResponse);
        } else {
            httpResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}

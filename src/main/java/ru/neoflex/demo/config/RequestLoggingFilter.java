package ru.neoflex.demo.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class RequestLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request, 10240);
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response); // для логирования ответа (сделал для себя)

        try {
            filterChain.doFilter(wrappedRequest, wrappedResponse);
        } finally {

            String requestBody = new String(wrappedRequest.getContentAsByteArray(), StandardCharsets.UTF_8);

            String responseBody = new String(wrappedResponse.getContentAsByteArray(), StandardCharsets.UTF_8);

            log.info("Request  {} {} {}", request.getMethod(), request.getRequestURI(), requestBody);
            log.info("Response {} {}", response.getStatus(), responseBody);

            wrappedResponse.copyBodyToResponse();
        }
    }
}

package com.example.spring_blog.exception;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {

        String errorMessage;
        if (exception instanceof BadCredentialsException) {
            System.out.println(request.getParameter("email"));
            System.out.println(request.getParameter("password"));
            errorMessage = "id,pw wrong.";
        } else if (exception instanceof InternalAuthenticationServiceException) {
            errorMessage = "server error.";
        } else if (exception instanceof UsernameNotFoundException) {
            errorMessage = "can't find id.";
        } else if (exception instanceof AuthenticationCredentialsNotFoundException) {
            errorMessage = "auth fail.";
        } else {
            errorMessage = "no idea.";
        }
        exception.printStackTrace();
        setDefaultFailureUrl("/login?error=true&exception=" + errorMessage);
        super.onAuthenticationFailure(request, response, exception);

    }
}

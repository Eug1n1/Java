package com.example.lab_9;

import java.io.*;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "HelloServlet", value = "/")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        request.setAttribute("time", new Date().toString());
        request.setAttribute("protocol", request.getProtocol());
        request.setAttribute("name", request.getServerName());
        request.setAttribute("method", request.getMethod());

        StringBuilder headers = new StringBuilder();
        Enumeration headersEnum = request.getHeaderNames();

        while (headersEnum.hasMoreElements()) {

            String parameterName = (String) headersEnum.nextElement();
            String parameterValue = request.getHeader(parameterName);
            headers.append(parameterName).append(": ").append(parameterValue).append("<br>");
        }

        request.setAttribute("headers", headers);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
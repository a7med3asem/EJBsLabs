package com.ejb.JMS;

import java.io.*;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "messaging", value = "/messaging-servlet")
public class MessagingServlet extends HttpServlet {

    @Inject
    private JmsMessageController jmsMessageController;
    @Inject
    private JmsMessageModel jmsMessageModel;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<head>\n" +
                "    <!-- Required meta tags -->\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "\n" +
                "    <!-- Bootstrap CSS -->\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6\" crossorigin=\"anonymous\">\n" +
                "\n" +
                "    <title>Hello, world!</title>\n" +
                "  </head>");

        out.println("<body><form action=\"messaging-servlet\" method=\"Post\">\n" +
                "  <div class=\"mb-3\">\n" +
                "    <label for=\"message\" class=\"form-label\">Enter your message</label>\n" +
                "    <input type=\"text\" class=\"form-control\" id=\"message\" name=\"message\">\n" +
                "  <button type=\"submit\" class=\"btn btn-primary\">Send</button>\n" +
                "</form></body>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        jmsMessageModel.setMsgText(request.getParameter("message"));
        String status = jmsMessageController.sendMsg();
        out.println("<h1>" + status + "</h1>");
    }

    public void destroy() {
    }
}
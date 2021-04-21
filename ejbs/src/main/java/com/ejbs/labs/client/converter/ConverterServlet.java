package com.ejbs.labs.client.converter;

import com.ejbs.labs.server.beans.converter.ConverterBean;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet(name = "ConverterServlet", urlPatterns = {"/ConverterServlet"})
public class ConverterServlet extends HttpServlet {

    @EJB
    private ConverterBean converter;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
// Output the results
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<title>Servlet ConverterServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet ConverterServlet at " + request.getContextPath() + "</h1>");
        try {
            String amount = request.getParameter("amount");
            if (amount != null && amount.length() > 0) {
                // convert the amount to a BigDecimal from the request parameter
                BigDecimal d = new BigDecimal(amount);
                // call the ConverterBean.dollarToYen() method to get the amount
                // in Yen
                BigDecimal yenAmount = converter.dollarToYen(d);

                // call the ConverterBean.yenToEuro() method to get the amount
                // in Euros
                BigDecimal euroAmount = converter.yenToEuro(yenAmount);

                out.println("<p class='alert alert-success'>" + amount + " dollars are " +
                        yenAmount.toPlainString() + " yen.</p>");
                out.println("<p class='alert alert-success'>" + yenAmount.toPlainString() + " yen are " +
                        euroAmount.toPlainString() + " Euro.</p>");
            } else {
                out.println("<p>Enter a dollar amount to convert:</p>");
                out.println("<form method=\"get\">");
                out.println("<p>$ <input title=\"Amount\" type=\"text\" name=\"amount\"size=\"25\"></p>");
                out.println("<br/>");
                out.println("<input type=\"submit\" value=\"Submit\">"
                        + "<input type=\"reset\" value=\"Reset\">");
                out.println("</form>");
            }

        } finally {
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


}

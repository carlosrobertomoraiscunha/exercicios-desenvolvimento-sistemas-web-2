package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos
 */
public class GenerateTableFutureValue extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String investmentAmount = request.getParameter("investmentAmount");
        String interestRate = request.getParameter("interestRate");
        String numberMonths = request.getParameter("numberMonths");
        String contributions = request.getParameter("contributions");
        RequestDispatcher rd;

        // GenerateTableFutureValue?investmentAmount=300&interestRate=-0.1&numberMonths=12&contributions=300
        if (isValid(investmentAmount)
                && isValid(interestRate)
                && isValid(numberMonths)
                && isValid(contributions)) {
            if (Double.parseDouble(interestRate) < 0 || Double.parseDouble(interestRate) > 1) {
                request.setAttribute("error", "O valor dos juros deve ser um número entre 0 e 1.");

                rd = request.getRequestDispatcher("index.jsp");
            } else {
                rd = request.getRequestDispatcher("tableFutureValue.jsp");
            }
        } else {
            request.setAttribute("error", "Os valores informados devem ser números positivos.");

            rd = request.getRequestDispatcher("index.jsp");
        }

        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private boolean isValid(String number) {
        try {
            if (Double.parseDouble(number) < 0.0) {
                return false;
            }
        } catch (NumberFormatException | NullPointerException ex) {
            return false;
        }

        return true;

    }
}

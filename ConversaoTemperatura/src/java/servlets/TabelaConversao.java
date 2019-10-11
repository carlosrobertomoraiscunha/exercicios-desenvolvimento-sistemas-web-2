package servlets;

import basics.Temperatura;
import basics.TipoTemperatura;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos
 */
public class TabelaConversao extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Cria um array para armazenar todos os valores de temperatura
        List<Temperatura> tempList = new ArrayList<>();

        // Cria um objeto temperatura para cada valor que ira para a tabela, e
        // armazena ele no array de temperatura
        for (int i = -40; i <= 100; i += 10) {
            tempList.add(new Temperatura(i, TipoTemperatura.CELSIUS));
        }

        // Cria um atributo para o array de temperaturas no request
        request.setAttribute("tempList", tempList);

        // Redireciona para o index
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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

}

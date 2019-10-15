package servlets;

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
public class GenerateTable extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Armazena os valores de inicio e fim da tabuada, passados pelo request
        String start = request.getParameter("start");
        String end = request.getParameter("end");

        // Verifica se esses valores foram realmente passados
        if (start != null && end != null) {
            // Verifica se essas strings são compostas unicamente de valores
            // numericos
            if (onlyNumber(start) && onlyNumber(end)) {
                // Transforma essas sequencias de caracteres em valores inteiros
                int startNumber = Integer.valueOf(start);
                int endNumber = Integer.valueOf(end);

                // Cria uma lista para armazenar os dados da tabela
                List<List<Integer>> result = new ArrayList<>();
                List<Integer> aux = new ArrayList<>();

                // Percorre e multiplica os numeros entre os valores informados,
                // e armazena-os dentro de um ArrayList
                for (int i = startNumber; i <= endNumber; i++) {
                    for (int j = startNumber; j <= endNumber; j++) {
                        aux.add(i * j);
                    }
                    result.add(new ArrayList<>(aux));
                    aux.clear();
                }

                // Coloca os valores do inicio e fim da tabela, e os resultados
                // das multiplicacoes em atributos no request
                request.setAttribute("start", startNumber);
                request.setAttribute("end", endNumber);
                request.setAttribute("multiplicationTable", result);
            } else {
                // Coloca um valor dentro do atributo integerNumbers, informando
                // que os valores passados nao sao numeros inteiros
                request.setAttribute("integerNumbers", true);
            }
        }

        // Redireciona para o index.jsp
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

    /**
     * Verifica se a string passada e composta apenas de numeros, ou nao
     * 
     * @param text uma string qualquer
     * @return true se for apenas numeros
     *         false caso nao
     */
    private boolean onlyNumber(String text) {
        for (char c : text.toCharArray()) {
            if (!Character.isDigit(c)) {
                if (!Character.toString(c).equals("-")) {
                    return false;
                }
            }
        }

        return true;
    }

}

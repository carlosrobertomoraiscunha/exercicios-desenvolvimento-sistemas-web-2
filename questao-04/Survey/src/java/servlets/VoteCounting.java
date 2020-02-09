package servlets;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos
 */
public class VoteCounting extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // Armazena o valor da disciplina votada
        String votedDiscipline = request.getParameter("votedDiscipline");
        // Pega uma referencia do ServletContext
        ServletContext sc = getServletContext();
        // Pega os nomes da disciplinas do ServletContext
        String[] disciplines = sc.getInitParameter("disciplines").split(",");

        // Verifica se o valor da discplina votada e valido
        if (votedDiscipline != null && isDiscipline(votedDiscipline, disciplines)) {
            // Guarda o valor do total de votos
            int totalVotes = (int) sc.getAttribute("totalVotes");
            // Guarda um Map com as disciplinas a quantidade de votos que cada
            // uma possui
            Map<String, Integer> votes = (Map<String, Integer>) sc.getAttribute("votes");

            // Itera no Map com as disciplinas e seus votos
            for (Map.Entry<String, Integer> entry : votes.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();

                // Verifica se a disciplinas votada esta dentro do Map
                if (key.equals(votedDiscipline)) {
                    // Incrementa a quantidade de votos daquela disciplina em 1
                    votes.replace(key, value + 1);
                }
            }

            // Define os atributos no ServletContext apos todas alteracoes
            sc.setAttribute("votes", votes);
            sc.setAttribute("totalVotes", totalVotes + 1);

            // Redireciona para o result.jsp
            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);
        } else {
            // Redireciona para o index.jsp
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }

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
     * Verifica se uma disciplinas esta dentro de uma lista de disciplinas
     * validas
     *
     * @param discipline uma disciplina qualquer
     * @param disciplines um array de disciplinas validas
     * @return true se a disciplina for valida false caso nao
     */
    private boolean isDiscipline(String discipline, String[] disciplines) {
        for (String d : disciplines) {
            if (d.equals(discipline)) {
                return true;
            }
        }

        return false;
    }

}

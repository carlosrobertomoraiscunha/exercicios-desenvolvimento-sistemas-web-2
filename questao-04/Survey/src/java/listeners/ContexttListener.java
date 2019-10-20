package listeners;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Carlos
 */
public class ContexttListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Pega um referencia do ServletContext
        ServletContext sc = sce.getServletContext();
        // Guarda um Array com o nome das disciplinas
        String[] disciplines = sc.getInitParameter("disciplines").split(",");
        // Cria um Map para armazenar o nome das disciplinas e quantos votos
        // cada uma possui
        Map<String, Integer> votes = new HashMap<>();
        
        // Itera no Array de disciplinas
        for (String discipline : disciplines) {
            // Coloca as disciplinas no Map como key, e a quantidade de votos
            // como value
            votes.put(discipline, 0);
        }
        
        // Cria um atributo para o Map de votos e um para o total de votos
        sc.setAttribute("votes", votes);
        sc.setAttribute("totalVotes", 0);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}

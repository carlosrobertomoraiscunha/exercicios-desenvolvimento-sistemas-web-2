package servlets;

import java.io.IOException;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos
 */
public class NumerologyCalculator extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // Pega o nome passado pelo usuario
        String name = request.getParameter("name");
        // Cria um Map para armazenar a tabela pitagorica
        Map<Character, Integer> pythagoreanTable;

        // Verifica se o nome do usuario e valido
        if (name != null && onlyCharacters(name)) {
            pythagoreanTable = new HashMap<>();

            // Remove os acentos do nome
            String nameWhitoutAccents = removeAccents(name);

            // Monta a tabela pitagorica
            mountPythagoreanTable(pythagoreanTable);

            // Calcula a numerologia do nome
            int sum = calculateNumerology(nameWhitoutAccents, pythagoreanTable);

            // Verifica se o nome e um palindromo
            boolean palindrome = isPalindrome(nameWhitoutAccents.toLowerCase());

            // Coloca o nome, o resultado da numerologia, e se e um palindromo,
            // ou nao, em atributos do request
            request.setAttribute("name", name);
            request.setAttribute("numerology", sum);
            request.setAttribute("isPalindrome", palindrome);
        } else {
            request.setAttribute("invalidDigit", true);
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
     * Verifica se os conteudo da string e composto apenas de caracteres
     *
     * @param text um texto qualquer
     * @return true se o texto conter apenas caracteres false caso contrario
     */
    private boolean onlyCharacters(String text) {
        for (char c : removeAccents(text.replace(" ", "")).toLowerCase().toCharArray()) {
            if ((int) c >= 97 && (int) c <= 172) {
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * Monta uma tabela pitagorica dentro de um map
     *
     * @param pythagoreanTable um Map<Charater, Integer>
     */
    private void mountPythagoreanTable(Map<Character, Integer> pythagoreanTable) {
        int count = 1;

        for (int i = 97; i <= 122; i++) {
            pythagoreanTable.put((char) i, count);
            if (count >= 9) {
                count = 1;
            } else {
                count++;
            }
        }
    }

    /**
     * Calcula a numerologia de um nome, utilizando uma tabela pitagorica
     *
     * @param name nome a ser calculado a numerologia
     * @param pythagoreanTable tabela pitagorica
     * @return a numerologia do nome
     */
    private int calculateNumerology(String name, Map<Character, Integer> pythagoreanTable) {
        int sum = 0;

        for (char c : name.replace(" ", "").toLowerCase().toCharArray()) {
            System.out.println(c);
            sum += pythagoreanTable.get(c);
        }

        if (sum == 11 || sum == 22 || sum == 33 || String.valueOf(sum).length() == 1) {
            return sum;
        } else {
            return _calculateNumerology(sum);
        }
    }

    /**
     * Remove os acentos de um texto, substituindo por seus equivalentes, sem
     * acento
     *
     * @param str um texto qualquer
     * @return o texto sem acentos
     */
    private String removeAccents(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    /**
     * Verifica se a numerologia do numero possui apenas um digita, caso nao
     * soma todos os digitos, ate resultar em uma numerologia de digito unico
     *
     * @param num uma numerologia a ser testada e calculada
     * @return uma numerologia de digito unico
     */
    private int _calculateNumerology(int num) {
        int lenght = String.valueOf(num).length();
        int sum = 0;

        String[] numbers = String.valueOf(num).split("");

        for (String number : numbers) {
            sum += Integer.valueOf(number);
        }

        if (lenght > 1) {
            return _calculateNumerology(sum);
        }

        return sum;
    }

    /**
     * Verifica se uma palavra e um palindromo
     *
     * @param text um texto qualquer
     * @return true se for um palindrome false caso nao seja
     */
    private boolean isPalindrome(String text) {
        String reverse = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            reverse += text.charAt(i);
        }

        return text.replace(" ", "").equals(reverse.replace(" ", ""));
    }
}

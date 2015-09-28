package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
@WebServlet("/exercicio517")
public class ServletExercicio517 extends HttpServlet {

    private int contador = 0;

    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        contador++;

        // busca o writer
        PrintWriter out = response.getWriter();

        // imprime o nome do contato que foi adicionado
        out.println("<html>");
        out.println("<body>");
        out.println("Contador " + contador);
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Iniciando a servlet");
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet");
    }
}

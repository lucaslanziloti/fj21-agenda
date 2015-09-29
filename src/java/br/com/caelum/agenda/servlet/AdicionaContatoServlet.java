package br.com.caelum.agenda.servlet;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lucas
 */
@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

    private static final long serialVersionUID = -7161718484315386878L;

    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        // busca o writer
        PrintWriter out = response.getWriter();

        // buscando os parâmetros no request
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String dataEmTexto = request.getParameter("dataNascimento");
        Calendar dataNascimento = null;

        // fazendo a conversão da data
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (ParseException ex) {
            out.println("Erro de conversão da data");
            return; //para a execução do método
        }

        // monta um objeto contato
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);
        contato.setDataNascimento(dataNascimento);

        // salva o contato
        Connection connection = (Connection) request.getAttribute("conexao");
        ContatoDao dao = new ContatoDao(connection);
        dao.adiciona(contato);
        
        RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
        rd.forward(request, response);
//        // imprime o nome do contato que foi adicionado
//        out.println("<html>");
//        out.println("<body>");
//        out.println("Contato " + contato.getNome() + " adicionado com sucesso");
//        out.println("</body>");
//        out.println("</html>");
    }
}

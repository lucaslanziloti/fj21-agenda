package br.com.caelum.mvc.logica;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lucas
 */
public class RemoveContatoLogic implements Logica {

    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {
        long id = Long.parseLong(req.getParameter("id"));
        Connection connection = (Connection) req.getAttribute("conexao");

        Contato contato = new Contato();
        contato.setId(id);
        ContatoDao dao = new ContatoDao(connection);

        dao.exclui(contato);

        System.out.println("Excluindo contato... ");

        return "lista-contatos.jsp";
    }
}

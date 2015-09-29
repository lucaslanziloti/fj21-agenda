package br.com.caelum.mvc.logica;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lucas
 */
public class ListaContatosLogic implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Connection connection = (Connection) req.getAttribute("conexao");
        List<Contato> contatos = new ContatoDao(connection).getLista();
        req.setAttribute("contatos", contatos);
        return "lista-contatos.jsp";
    }
}

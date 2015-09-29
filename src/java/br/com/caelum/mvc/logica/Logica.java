package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
public interface Logica {

    String executa(HttpServletRequest req, HttpServletResponse res) throws Exception;
}

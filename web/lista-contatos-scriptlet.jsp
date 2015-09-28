<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="br.com.caelum.jdbc.modelo.Contato"%>
<%@page import="br.com.caelum.jdbc.dao.ContatoDao"%>
<html>
    <body>
        <table>
            <%
                ContatoDao dao = new ContatoDao();
                List<Contato> contatos = dao.getLista();
                for (Contato contato : contatos) {
            %>
            <tr>
                <td><%=contato.getNome()%></td>
                <td><%=contato.getEmail()%></td>
                <td><%=contato.getEndereco()%></td>
                <td><%=new SimpleDateFormat("dd/MM/yyyy").format((contato.getDataNascimento().getTime())%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
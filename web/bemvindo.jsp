<%-- 
    Document   : bemvindo
    Created on : Sep 28, 2015, 10:50:08 AM
    Author     : lucas
--%>

<%-- coment�rio em JSP aqui: nossa primeira p�gina JSP --%>
<html>

    <body>
        <%
            String mensagem = "Bem vindo ao sistema de agenda do FJ-21!";
        %>

        <% out.println(mensagem); %>

        <br />

        <%
            String desenvolvido = "Desenvolvido por (SEU NOME AQUI)";
        %>

        <%= desenvolvido%>

        <br />

        <%
            System.out.println("Tudo foi executado!");
        %>
    </body>
</html>
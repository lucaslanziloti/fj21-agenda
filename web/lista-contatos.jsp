<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="cabecalho.jsp" />

        <table>
            <tr>
                <th>Nome</th>
                <th>e-mail</th> 
                <th>Endereço</th>
                <th>Data Nascimento</th>
            </tr>
            <!-- percorre contatos montando as linhas da tabela -->
            <c:forEach var="contato" items="${contatos}" varStatus="i">
                <tr>
                    <td>${contato.nome}</td> 
                    <td>
                        <c:if test="${not empty contato.email}">
                            <a href="mailto:${contato.email}">${contato.email}</a>
                        </c:if>
                    </td>
                    <td>${contato.endereco}</td>
                    <td>
                        <fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>
                    </td>
                    <td>
                        <a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <c:import url="rodape.jsp" />
    </body>
</html>

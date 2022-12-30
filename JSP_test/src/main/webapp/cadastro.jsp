<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<JavaBeans> consultas = (ArrayList<JavaBeans>) request.getAttribute("consultasAgendadas");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Cadastro de pacientes</title>
<link rel="icon" href="imgs/usericon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<center><h1>GERENCIAR AGENDAMENTOS</h1></center>
	<center><a class="botao1" href="novaConsulta">Novo agendamento</a>
	<%if(consultas.size() > 0){ %>
	<a class="botao4" href="buscaAgendamento.html">Buscar agendamento</a></center>
	<table id="tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Número da carteira</th>
				<th>Plano de saúde</th>
				<th>Especialidade</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for(int i = 0; i < consultas.size(); i++){ %>
			<tr>
				<td><%=consultas.get(i).getidPaciente() %></td>
				<td><%=consultas.get(i).getnomePaciente() %></td>
				<td><%=consultas.get(i).getnmCarteira() %></td>
				<td><%=consultas.get(i).getPlanSaude() %></td>
				<td><%=consultas.get(i).getespeci() %></td>
				<td><a href="select?idPaciente=<%=consultas.get(i).getidPaciente() %>" class="botao1">Editar</a>
				<a href="javascript: confirmacao(<%=consultas.get(i).getidPaciente() %>)" class="botao2">Remover</a></td>
			</tr>
			<%} %>
		</tbody>
	</table>
	<br>
	<center><a href="relatorio" class="botao3">Gerar PDF</a></center>
	<%} %>
	<script src="scripts/confirmacao.js"></script>
</body>
</html>
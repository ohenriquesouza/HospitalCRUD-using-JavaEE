<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar dados consulta</title>
<link rel="stylesheet" href="style.css">
<style>
fieldset {
	border-radius: 10px;
	border: 1px solid #66bbff;
}

.input_name {
	width: 320px;
	padding: 5px;
	margin-bottom: 8px;
	border: 1px solid #66bbff;
	border-radius: 7px;
}

.input_nmCarteira {
	width: 320px;
	padding: 5px;
	margin-bottom: 8px;
	border: 1px solid #66bbff;
	border-radius: 7px;
}

.input_plano {
	padding: 5px;
	margin-bottom: 8px;
	border: 1px solid #66bbff;
	border-radius: 7px;
}

.input_espec {
	padding: 5px;
	margin-bottom: 8px;
	border: 1px solid #66bbff;
	border-radius: 7px;
}
.input_id {
	padding: 5px;
	margin-bottom: 8px;
	border: 1px solid #66bbff;
	border-radius: 7px;
}
</style>
</head>
<body>
	<div class="box">
		<h1>VISUALIZAR DADOS</h1>
		<form name="formConsulta" action="edit">
			<fieldset>
			<p>Sr(a). <%out.print(request.getAttribute("nome")); %>, aqui estão seus dados cadastrados.<br>⚠️ Os dados do usuário não podem ser alterados nesta página.</p>
				<div class="input_box">
					<label for="nome">ID</label> <input type="text"
						value="<%out.print(request.getAttribute("idPaciente")); %>" name="iduser" id="iduser" class="input_id" readonly></input>
				</div>
				<br>
				<div class="input_box">
					<label for="nome">Nome Completo:</label> <input type="text"
						 value="<%out.print(request.getAttribute("nome")); %>" name="nome" id="nome" class="input_name" readonly></input>
				</div>
				<br>
				<div class="input_box">
					<label for="NmCarteira">Número da carteira:</label> <input
						type="number" value="<%out.print(request.getAttribute("NmCarteira")); %>" name="NmCarteira" id="NmCarteira"
						class="input_nmCarteira" readonly></input>
				</div>
				<br>
				<div class="input_box">
					<label for="">Plano de saúde:</label> <input type="text"
						 value="<%out.print(request.getAttribute("plan")); %>" name="plan" id="plan" class="input_plano" readonly>
					</input>
				</div>
				<br>
				<div class="input_box">
					<label for="">Especialidade escolhida:</label> <input type="text" name="especs"
						 value="<%out.print(request.getAttribute("especs")); %>" id="especs" class="input_espec" readonly>
					</input>
				</div>
				<br>
				<center>
					<input class="botao1" type="submit" onclick="validar(event)"></input>
				</center>
			</fieldset>
		</form>
	</div>
	<script src="scripts/validacao.js"></script>
</body>
</html>
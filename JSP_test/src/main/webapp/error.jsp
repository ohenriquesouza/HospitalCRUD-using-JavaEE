<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans" %>
<%@ page import="model.Espec" %>
<%@ page import="model.Plano" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<JavaBeans> consultas = (ArrayList<JavaBeans>) request.getAttribute("consultasAgendadas");
	ArrayList<Espec> especialidades = (ArrayList<Espec>) request.getAttribute("especsCadastradas");
	ArrayList<Plano> planos = (ArrayList<Plano>) request.getAttribute("planosCadastradas");
%>
<!DOCTYPE html>
<html lang = "pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Nova Consulta</title>
        <link rel="stylesheet" href="style.css">
        <style>
            fieldset{
                border-radius: 10px;
                border: 1px solid #66bbff;
            }
            .input_name{
            	width: 320px;
            	padding: 5px;
            	margin-bottom: 8px;
            	border: 1px solid #66bbff;
            	border-radius: 7px;
            }
            .input_nmCarteira{
            	width: 320px;
            	padding: 5px;
            	margin-bottom: 8px;
            	border: 1px solid #66bbff;
            	border-radius: 7px;
            }
             .input_plano{
            	padding: 5px;
            	margin-bottom: 8px;
            	border: 1px solid #66bbff;
            	border-radius: 7px;
            }
             .input_espec{
            	padding: 5px;
            	margin-bottom: 8px;
            	border: 1px solid #66bbff;
            	border-radius: 7px;
            }

        </style>
    </head>
    <body>
        <div class="box">
        	<h1>INFORME SEUS DADOS</h1>
            <form name="formConsulta" action="search">
                <fieldset>
               <p style="color:red">⚠️ Não foram encontrados registros deste paciente.</p>
                    <div class="input_box">
                        <label for="nome">Nome Completo:</label>
                        <input type="text" name="nome" id="nome" class="input_name"></input>
                    </div>
                    <br>
	                <div class="input_box">
                        <label for="NmCarteira">Número da carteira:</label>
                        <input type="number" name="NmCarteira" id="NmCarteira" class="input_nmCarteira"></input>
                    </div>
                    <br>
                    <center><input class="botao1" type="submit" onclick="validar(event)"></input></center>
                </fieldset>
            </form>
        </div>
        <script src="scripts/validacao.js"></script>
    </body>
</html>
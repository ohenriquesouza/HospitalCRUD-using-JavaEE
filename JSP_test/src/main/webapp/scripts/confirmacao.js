function confirmacao(idPaciente){
	let retorno = confirm("Tem certeza que deseja excluir este agendamento permanentemente?")
	if(retorno == true){
		window.location.href="delete?idPaciente=" + idPaciente
	}
}
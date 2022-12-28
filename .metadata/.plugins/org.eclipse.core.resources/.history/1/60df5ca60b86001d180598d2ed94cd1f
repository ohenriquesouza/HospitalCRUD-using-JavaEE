function validar(e){
	//alert('teste')
	let nome = formConsulta.nome.value
	let carteira = formConsulta.NmCarteira.value
	if(nome == ""){
		alert('Preencha o campo "Nome"')
		formConsulta.nome.focus()
		e.preventDefault()
	}else if(carteira == ""){
		alert('Preencha o campo "Número da Carteira"')
		formConsulta.NmCarteira.focus()
		e.preventDefault()
	}else{
		document.forms["formConsulta"].submit()
	}
}
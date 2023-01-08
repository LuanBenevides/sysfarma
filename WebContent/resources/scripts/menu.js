function mostrarTabelaMedicamentos(){
	let novoMedicamentoForm = document.getElementById('frmForm');
	let tabelaMedicamentos = document.getElementById('medTabel');
	
	if(tabelaMedicamentos.classList.contains('table_notShow')){
		
		tabelaMedicamentos.classList.remove('table_notShow');
		tabelaMedicamentos.classList.add('table_Show');
		
		novoMedicamentoForm.classList.remove('form_inShow');
		novoMedicamentoForm.classList.add('form_inNotShow');
		
	}else if(tabelaMedicamentos.classList.contains('table_Show')){
		tabelaMedicamentos.classList.remove('table_show');
		tabelaMedicamentos.classList.add('table_notShow');
		
		novoMedicamentoForm.classList.add('form_inShow')
	}
}
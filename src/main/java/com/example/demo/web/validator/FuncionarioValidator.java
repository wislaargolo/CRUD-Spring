package com.example.demo.web.validator;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.domain.Funcionario;

public class FuncionarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return Funcionario.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Funcionario funcionario = (Funcionario) object;
		
		LocalDate entrada = funcionario.getDataEntrada();
		
		if(funcionario.getDataSaida() != null) {
			if(funcionario.getDataSaida().isBefore(funcionario.getDataEntrada())) {
				errors.rejectValue("dataSaida", "PosteriorDataEntrada.funcionario.dataSaida");
			}
		}
		
	}

}

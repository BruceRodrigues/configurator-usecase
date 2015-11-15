package br.ufsc.usecase.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InformacoesPessoaisForm {

	private String firstName;

	private String lastName;

	private String cpf;

	private Sexo sexo;

}

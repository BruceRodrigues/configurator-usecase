package br.ufsc.usecase.user;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private InformacoesPessoaisForm informacoesPessoais;

	private String cep;

	private String uf;

	private String municipio;

	private String logradouro;

}

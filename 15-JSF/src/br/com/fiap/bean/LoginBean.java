package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {
	private String nome;
	private String senha;
	private String mensagem;
	
	
	public void validarLogin() {
		if(nome.equals("FIAP") && senha.equals("FIAP2019")) {
			System.out.println("Logado");
			mensagem = "Logado com sucesso!!";
		}else {
			System.out.println("Usuario e/ou senha inv�lidos");
			mensagem = "Usuarios e/ou sneha inv�lidos";
		}
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}

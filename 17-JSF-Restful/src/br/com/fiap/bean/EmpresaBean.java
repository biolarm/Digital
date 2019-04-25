package br.com.fiap.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.exception.ResponseException;
import br.com.fiap.repository.EmpresaRepository;
import br.com.fiap.to.Empresa;

@ViewScoped
@ManagedBean

public class EmpresaBean implements Serializable{
	Empresa empresa;
	EmpresaRepository bo;
	
	@PostConstruct
	public void iniciar() {
		empresa = new Empresa();
		bo = new EmpresaRepository();
	}
	
	private void exibirMensagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}
	
	public void excluir(int codigo) {
		try {
			bo.remover(codigo);
			exibirMensagem("Removido com suceso!");
		} catch (ResponseException e) {
			e.printStackTrace();
			exibirMensagem("Errooouu");
		}
	}
	
	public List<Empresa> listar() throws ResponseException{
		return bo.listar();		
	}
	
	public void cadastrar() {
		try {
			if(empresa.getCodigo() == 0) {
				
			bo.cadastrar(empresa);
			exibirMensagem("Cadastrado com sucesso!!");
			}else {
				bo.atualizar(empresa);
				exibirMensagem("Atualizado com sucesso!!");
			}
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			exibirMensagem("Errou no cadastro");
		}
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}

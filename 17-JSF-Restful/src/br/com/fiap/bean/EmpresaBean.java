package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.exception.ResponseException;
import br.com.fiap.repository.EmpresaRepository;
import br.com.fiap.to.Empresa;

@ManagedBean
public class EmpresaBean {
	Empresa empresa;
	EmpresaRepository bo;
	
	@PostConstruct
	public void iniciar() {
		empresa = new Empresa();
		bo = new EmpresaRepository();
	}
	
	public List<Empresa> listar() throws ResponseException{
		return bo.listar();		
	}
	
	public void cadastrar() {
		FacesMessage msg;
		try {
			bo.cadastrar(empresa);
			msg = new FacesMessage("Cadastrado");
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = new FacesMessage("ERRO");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}

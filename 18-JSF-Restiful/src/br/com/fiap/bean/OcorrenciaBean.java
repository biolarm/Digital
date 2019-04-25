package br.com.fiap.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.fiap.dao.OcorrenciaDAO;
import br.com.fiap.dao.impl.OcorrenciaDAOImpl;
import br.com.fiap.entity.Ocorrencia;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@ManagedBean
@ViewScoped
public class OcorrenciaBean implements Serializable {
	private Ocorrencia ocorrencia;

	private OcorrenciaDAO dao;
	private EntityManager em;
	
	@PostConstruct
	public void iniciar() {
		ocorrencia = new Ocorrencia();
		ocorrencia.setData(Calendar.getInstance());
		dao = new OcorrenciaDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	private void exibirMensagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}
	
	public String cadastrar() {
		try {
			dao.cadastrar(ocorrencia);
			dao.commit();
			exibirMensagem("cadastrado!!");
			return "OcorrenciaLista?faces-redirect=true";
		} catch (Exception e) {
			// TODO: handle exception
			exibirMensagem("erroouu vacilão");
			return "Ocorrencia";
		}
	}
	
	public List<Ocorrencia> listar() {
		return dao.listar();
	}
	
	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}
	
	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	
	
	
	

}

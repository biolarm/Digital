package br.com.fiap.exception;

import br.com.fiap.repository.EmpresaRepository;
import br.com.fiap.to.Empresa;

public class ResponseException extends Exception {

	public ResponseException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public ResponseException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ResponseException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ResponseException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	


	
	
}

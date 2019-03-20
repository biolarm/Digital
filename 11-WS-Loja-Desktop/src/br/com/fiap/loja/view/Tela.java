package br.com.fiap.loja.view;

import org.apache.axis2.AxisFault;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.loja.bo.EstoqueBOStub;

public class Tela {

	protected Shell shell;
	private Table table;
	private Text txtCod;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(512, 469);
		shell.setText("SWT Application");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(36, 107, 375, 239);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblCodigo = new TableColumn(table, SWT.NONE);
		tblCodigo.setWidth(100);
		tblCodigo.setText("Codigo");
		
		TableColumn tblDescricao = new TableColumn(table, SWT.NONE);
		tblDescricao.setWidth(100);
		tblDescricao.setText("Descri\u00E7\u00E3o");
		
		TableColumn tblPreco = new TableColumn(table, SWT.NONE);
		tblPreco.setWidth(100);
		tblPreco.setText("Pre\u00E7o");
		
		TableColumn tblQtd = new TableColumn(table, SWT.NONE);
		tblQtd.setWidth(100);
		tblQtd.setText("Qtd");
		
		Label lblCodProduto = new Label(shell, SWT.NONE);
		lblCodProduto.setBounds(36, 42, 105, 15);
		lblCodProduto.setText("Codigo Produto");
		
		txtCod = new Text(shell, SWT.BORDER);
		txtCod.setBounds(151, 36, 76, 21);
		
		Button btnPesquisa = new Button(shell, SWT.NONE);
		btnPesquisa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				int cod = Integer.parseInt(txtCod.getText());
				
				try {
					EstoqueBOStub stub = new EstoqueBOStub();
					
					
					
					
				} catch (AxisFault e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
				
				
				
			}
		});
		btnPesquisa.setBounds(247, 37, 75, 25);
		btnPesquisa.setText("Pesquisar");

	}
}

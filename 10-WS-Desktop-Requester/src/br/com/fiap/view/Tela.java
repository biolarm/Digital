package br.com.fiap.view;

import org.apache.axis2.AxisFault;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class Tela {

	protected Shell shell;
	private Text txtNumero1;
	private Text txtNumero2;
	private Text txtResultado;
	private Text txtResultado2;
	private Text txtCep1;
	private Text text;
	private Text txtCep2;
	private Text text_2;
	private Text txtData1;
	private Text txtData;
	private Text txtPrazo;
	private Text txtPrazo1;

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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(46, 37, 55, 15);
		lblNewLabel.setText("Numero 1");
		
		txtNumero1 = new Text(shell, SWT.BORDER);
		txtNumero1.setBounds(124, 31, 76, 21);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(46, 69, 55, 15);
		lblNewLabel_1.setText("Numero 2");
		
		txtNumero2 = new Text(shell, SWT.BORDER);
		txtNumero2.setBounds(124, 63, 76, 21);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//executado no click do botao 
				
				//capturar os dois valores 
				int n1 = Integer.parseInt(txtNumero1.getText());
				int n2 = Integer.parseInt(txtNumero2.getText());				
				//somar
				int soma = n1 + n2;
				//exibir resposta
				txtResultado2.setText(Integer.toString(soma));
				
				
			}
		});
		btnNewButton.setBounds(124, 104, 76, 21);
		btnNewButton.setText("Somar");
		
		txtResultado = new Text(shell, SWT.BORDER);
		txtResultado.setText("Resultado");
		txtResultado.setEditable(false);
		txtResultado.setBounds(42, 150, 76, 21);
		
		txtResultado2 = new Text(shell, SWT.BORDER);
		txtResultado2.setEditable(false);
		txtResultado2.setBounds(134, 150, 76, 21);
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(230, 31, 2, 186);
		
		txtCep1 = new Text(shell, SWT.BORDER);
		txtCep1.setText("CEP Origem");
		txtCep1.setEditable(false);
		txtCep1.setBounds(238, 31, 76, 21);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(320, 31, 76, 21);
		
		txtCep2 = new Text(shell, SWT.BORDER);
		txtCep2.setText("CEP Destino");
		txtCep2.setEditable(false);
		txtCep2.setBounds(238, 69, 76, 21);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(320, 69, 76, 21);
		
		Button btnCalcular = new Button(shell, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String cep1 = text.getText();
				String cep2 = text_2.getText();
				
				try {
					//chamando o objeto que obtem o web service
					CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
					
					//parametro que serão enviados para web service 
					CalcPrazo valores = new CalcPrazo();
					valores.setNCdServico("40010");
					valores.setSCepOrigem(cep1);
					valores.setSCepDestino(cep2);
					
					//chamando o web service e recuperando a resposta
					CalcPrazoResponse resp = stub.calcPrazo(valores);
					
					txtPrazo1.setText(resp.getCalcPrazoResult().getServicos().getCServico()[0].getPrazoEntrega());
					txtData1.setText(resp.getCalcPrazoResult().getServicos().getCServico()[0].getDataMaxEntrega());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnCalcular.setBounds(320, 102, 75, 25);
		btnCalcular.setText("Calcular");
		
		txtData1 = new Text(shell, SWT.BORDER);
		txtData1.setBounds(322, 186, 76, 21);
		
		txtData = new Text(shell, SWT.BORDER);
		txtData.setText("Data Maxima");
		txtData.setEditable(false);
		txtData.setBounds(240, 186, 76, 21);
		
		txtPrazo = new Text(shell, SWT.BORDER);
		txtPrazo.setText("Prazo ");
		txtPrazo.setEditable(false);
		txtPrazo.setBounds(240, 148, 76, 21);
		
		txtPrazo1 = new Text(shell, SWT.BORDER);
		txtPrazo1.setBounds(322, 148, 76, 21);

	}
}

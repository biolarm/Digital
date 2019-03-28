package br.com.fiap.view;

import java.util.List;
import java.util.Scanner;

import br.com.fiap.exception.ResponseException;
import br.com.fiap.repository.EmpresaRepository;
import br.com.fiap.to.Empresa;

public class View {

	private static EmpresaRepository rep = new EmpresaRepository();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("5 - Deletar");
		System.out.println("4 - Atualizar");
		System.out.println("3 - Cadastrar");
		System.out.println("2 - Buscar");
		System.out.println("1  - Listar ");
		System.out.println("0 - Sair");

		int opcao = sc.nextInt();

		switch (opcao) {
		case 1:
			listar();
			break;

		case 2:
			buscar(sc);
			break;

		case 3:
			cadastrar(sc);
			break;

		case 4:
			atualizar(sc);
			break;
			
		case 5:
			remover(sc);
			break;

		default:
			System.out.println("Opção invalida");
			break;
		}

	}

	private static void remover(Scanner sc) {
		
		System.out.println("Digite o codigo: ");
		int codigo = sc.nextInt();
		
		
		try {			
			 rep.remover(codigo);
			 System.out.println("removido com sucesso!!");
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		
	}

	private static void buscar(Scanner sc) {
		System.out.println("Digite o codigo: ");
		int codigo = sc.nextInt();

		try {

			Empresa empresa = rep.pesquisa(codigo);
			System.out.println(empresa.getNome());
			System.out.println("Faturamento " + empresa.getFaturamento());
			System.out.println("Multinacional 	" + empresa.isMultinacional());

		} catch (ResponseException e) {
			e.printStackTrace();
		}
	}

	private static void cadastrar(Scanner sc) {
		Empresa empresa = new Empresa();

		System.out.println("Digite o nome: ");
		empresa.setNome(sc.next() + sc.nextLine());

		System.out.println("Faturamento: ");
		empresa.setFaturamento(sc.nextDouble());

		System.out.println("Multinacional: ");
		empresa.setMultinacional(sc.hasNext());

		try {
			rep.cadastrar(empresa);
			System.out.println("Atualizado com sucesso!");

		} catch (ResponseException e) {
			e.printStackTrace();

		}
	}

	private static void atualizar(Scanner sc) {
		Empresa empresa = new Empresa();

		System.out.println("Digite o codigo: ");
		empresa.setCodigo(sc.nextInt());

		System.out.println("Digite o nome: ");
		empresa.setNome(sc.next() + sc.nextLine());

		System.out.println("Faturamento: ");
		empresa.setFaturamento(sc.nextDouble());

		System.out.println("Multinacional: ");
		empresa.setMultinacional(sc.hasNext());
	}

	public static void listar() {

		EmpresaRepository rep = new EmpresaRepository();

		try {
			List<Empresa> lista = rep.listar();

			for (Empresa empresa : lista) {

				System.out.println(empresa.getNome());
				System.out.println("Faturamento" + empresa.getFaturamento());
				System.out.println("Multinacional" + empresa.isMultinacional());
				System.out.println("***************************");

			}

		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

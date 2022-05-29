package br.com.alura.gerenciador.acao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Ação mostrando dados da empresa");
		
		
		String idEmpresa = request.getParameter("id");
		Integer id = Integer.valueOf(idEmpresa);
		System.out.println("Mostrando empresa Id: " + id);
		
		Banco banco = new Banco();
		
		Empresa empresaMostrada = banco.buscaEmpresaPorId(id);
		System.out.println(empresaMostrada.getNome());
		
		request.setAttribute("empresa", empresaMostrada);
		
		return "forward:formEditaEmpresa.jsp";
	}
}

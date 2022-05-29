package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// @WebFilter(urlPatterns = "/entrada")
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("MonitoramentoFilter");
		long inicio = System.currentTimeMillis();
		String acao = request.getParameter("acao");
//		Executa a ação
		chain.doFilter(request, response);

		long fim = System.currentTimeMillis();
		System.out.println("Tempo de execução da ação " + acao + " => " + (fim - inicio));
	}

}

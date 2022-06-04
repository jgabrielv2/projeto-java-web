package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

/**
 * Servlet Filter implementation class EntradaFilter
 */
//@WebFilter(filterName = "entrada", urlPatterns = { "/entrada" })
public class EntradaFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(FilterConfig config) throws ServletException {
		super.init(config);
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		System.out.println("EntradaFilter");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("acao");

		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;

		String nome;
		try {
			Class<?> classe = Class.forName(nomeDaClasse); // Carrega a classe com o nome fornecido
			Acao acao = (Acao) classe.getDeclaredConstructor().newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| InvocationTargetException | NoSuchMethodException | IOException e) {
			throw new ServletException(e);
		}

		String[] endereco = nome.split(":");
		if (endereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + endereco[1]);
			rd.forward(request, response);
		} else if (endereco[0].equals("redirect")) {
			response.sendRedirect("entrada?acao="+endereco[1]);
		}

		
		
	//	chain.doFilter(request, response);
	}



}

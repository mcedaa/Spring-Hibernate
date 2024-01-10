package com.example.demo;

import jakarta.servlet.Filter;

import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
@Scope("prototype") //her kullanıcı için ayrı bir filter oluşmasını sağlar
public class LoginFilter extends HttpFilter implements Filter {
       
    public static User user = null;
    public LoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		//işlem bittiğinde çalışacak metod
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req= (HttpServletRequest) request;
		HttpServletResponse res= (HttpServletResponse) response;

		//System.out.println(req.getRequestURI());
		//fonksiyonlarınfilter a takılmaması için sıra sıra hangisinde takılmasını nistemiyordak ekleriz
		if(req.getRequestURI().contains("login")) {
			chain.doFilter(request, response);
			return;
		}
		//üye olmadan register a geçebilmek için
		if(req.getRequestURI().contains("register")) {
			chain.doFilter(request, response);
			return;
		}
		if(req.getRequestURI().contains("addUser")) {
			chain.doFilter(request, response);
			return;
		}
		if(req.getRequestURI().contains("logout")) {
			chain.doFilter(request, response);
			return;
		}
		if(req.getRequestURI().contains("reg")) {
			chain.doFilter(request, response);
			return;
		}
		if(req.getRequestURI().contains("controlUser")) {
			chain.doFilter(request, response);
			return;
		}
		if(req.getRequestURI().contains("rest")) {
			chain.doFilter(request, response);
			return;
		}
		User user = (User) req.getSession().getAttribute("user");
		//gelen user ı yukarıda oluşturduğumuz user a atıyoruz
		this.user=user;
		if(user != null) {

			chain.doFilter(request, response);
			return;
		}else {
			res.sendRedirect(NotAlmaController.url+"/login");
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		//başlangıçta çalışacak metod
	}

}

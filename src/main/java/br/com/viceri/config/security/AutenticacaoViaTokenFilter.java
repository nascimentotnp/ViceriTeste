package br.com.viceri.config.security;

import br.com.viceri.repository.UsuarioRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

	private UsuarioRepository repository;
	private AutenticacaoService service;
	private TokenService tokenService;

	public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioRepository repository, AutenticacaoService service) {
		this.tokenService = tokenService;
		this.repository = repository;
		this.service = service;
	}


	//filter para intercepitar uma requisicao e antes de processar a req para frente, estamos add um usu autenticado caso o token esteja valido
	@Override
	protected void doFilterInternal(
			HttpServletRequest request,
			HttpServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {

		String authorization = request.getHeader("Authorization");
		if(authorization != null && authorization.startsWith("Bearer")){
			String token = authorization.split(" ")[1];
			boolean isValid = tokenService.validateToken(token);
			if(isValid){
				String email = tokenService.getUsernameFromToken(token);
				UserDetails usuario = service.loadUserByUsername(email);
				UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(
						usuario,null,usuario.getAuthorities());
				user.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(user);
			}
		}
		filterChain.doFilter(request,response);
	}

}
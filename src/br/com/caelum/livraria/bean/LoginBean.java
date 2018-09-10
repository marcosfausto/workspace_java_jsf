package br.com.caelum.livraria.bean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.caelum.livraria.dao.UsuarioDao;
import br.com.caelum.livraria.modelo.Usuario;
import br.com.caelum.livraria.util.RedirectView;


@ManagedBean
@ViewScoped
public class LoginBean {

	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario() {
		return usuario;
	}

	public RedirectView efetuaLogin(){
		
	    System.out.println("Fazendo login do usu�rio "
	            + this.usuario.getEmail());

	    boolean existe = new UsuarioDao().existe(this.usuario);

        FacesContext context = FacesContext.getCurrentInstance();

	    if (existe) {
            context.getExternalContext().getSessionMap()
            .put("usuarioLogado", this.usuario);
		    return new RedirectView("livro");
	    }

	    return null;
	    
	}
	
	
	
}


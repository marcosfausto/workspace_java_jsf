package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.util.RedirectView;

@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor = new Autor();
	
	private Integer autorId;	

	public Integer getAutorId() {
		return autorId;
	}
	
	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public void carregarAutorPelaId() {
		this.autor = new DAO<Autor>(Autor.class).buscaPorId(autorId);
	}


	
//	public void carregarAutorPelaId() {
//    Integer id = this.autor.getId();
//    this.autor = new DAO<Autor>(Autor.class).buscaPorId(id);
//    if (this.autor == null) {
//            this.autor = new Autor();
//    }
//}

	public Autor getAutor() {
		return autor;
	}

	public RedirectView gravar() {
	    System.out.println("Gravando autor " + this.autor.getNome());
	    
	    if (this.autor.getId() == null) {
	    new DAO<Autor>(Autor.class).adiciona(this.autor);
	    } else {
	    new DAO<Autor>(Autor.class).atualiza(this.autor);
	    }

	    this.autor = new Autor();

	    return new RedirectView("livro");
	}
	
	public List<Autor> getAutores() {
		return new DAO<Autor>(Autor.class).listaTodos();
	}
	
	public List<Livro> getLivros() {
		return new DAO<Livro>(Livro.class).listaTodos();
	}
	
	public void carregar(Autor autor) {
	    System.out.println("Carregando autor " + autor.getNome());
	    this.autor = autor;
	}
	
	
	private LivroBean livroBean = new LivroBean();

	
	public void remover(Autor autor) {
		if(livroBean.getAutores().contains(autor) == true) {
            FacesContext.getCurrentInstance().addMessage("autor",
                    new FacesMessage("Nao pode remover autor que contem um livro!"));
		}
		else {
		System.out.println("Removendo autor: "+autor);	
		System.out.println("autores: "+getAutores());
		new DAO<Autor>(Autor.class).remove(autor);
		}
		

	}
	
	
	
}


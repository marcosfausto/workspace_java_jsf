package br.com.caelum.livraria.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.com.caelum.livraria.dao.DAO;

@Entity
public class Autor {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
/*    @ManyToMany(mappedBy="autor")
	private List<Livro> livros = new ArrayList<Livro>();
		
    
	public List<Livro> getLivros() {
		return livros;
	}*/
	

	public List<Livro> getLivros() {
		return new DAO<Livro>(Livro.class).listaTodos();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	@Override
	public boolean equals(Object ref) {
		
        Autor outro = (Autor) ref;

        if (this.nome != outro.nome ) {
        	System.out.println("this nome "+this.nome);
        	System.out.println("outro nome "+outro.nome);

        	return false;
        }
        
        System.out.println("RETORNEIIII TRUUEEEEE");
		
		return true;
	}
	

}

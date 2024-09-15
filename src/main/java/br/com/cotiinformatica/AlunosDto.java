package br.com.cotiinformatica;

public class AlunosDto {
	
	private Integer id;
	private String nome;

	public AlunosDto() {
		// TODO Auto-generated constructor stub
	}

	public AlunosDto(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

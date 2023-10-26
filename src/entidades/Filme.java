package entidades;

public class Filme {
    private String nome;
    private Genero genero;
    private int duracao;
    private double nota;

    public Filme(String nome, Genero genero, int duracao, double nota) {
        this.nome = nome;
        this.genero = genero;
        this.duracao = duracao;
        this.nota = nota;
    }

    public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getDuracao() {
		return duracao;
	}


	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}


	public double getNota() {
		return nota;
	}


	public void setNota(double nota) {
		this.nota = nota;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNome() {
        return nome;
    }

    public String toFileString() {
        return nome + "\n" + genero.getNome() + "\n" + duracao + "\n" + nota + "\n";
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nGênero: " + genero.getNome() + "\nDuração: " + duracao + " minutos\nNota: " + nota + "/10";
    }
}

package entidades;


public class Serie extends Video {
    private int duracao;

    public Serie(String nome, double nota, Genero genero, int duracao) {
        super(nome, nota, genero.getNome());
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toFileString() {
        return getNome() + "\n" + getGenero() + "\n" + duracao + "\n" + getNota() + "\n";
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nGênero: " + getGenero() + "\nDuração: " + duracao + " minutos\nNota: " + getNota() + "/10";
    }
}

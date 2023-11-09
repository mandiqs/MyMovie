package entidades;

public abstract class Video {
    private String nome;
    private double nota;
    private String genero;

    public Video(String nome, double nota, String genero) {
        this.nome = nome;
        this.nota = nota;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public abstract String toFileString();

    @Override
    public String toString() {
        return "Video{" +
                "nome='" + nome + '\'' +
                ", nota=" + nota +
                ", genero='" + genero + '\'' +
                '}';
    }
}

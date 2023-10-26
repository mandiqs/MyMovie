package telas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import aplicacao.Programa;

public class TelaInicialFrame extends JFrame {
    private Programa app;

    public TelaInicialFrame(String title, Programa app) {
        super(title);
        this.app = app;

        // Configurar os componentes da interface gráfica
        JButton cadastrarFilmesButton = new JButton("Cadastrar Filmes");
        JButton cadastrarGenerosButton = new JButton("Cadastrar Gêneros");

        // Layout
        setLayout(new FlowLayout());
        add(cadastrarFilmesButton);
        add(cadastrarGenerosButton);

        cadastrarFilmesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastroFilmes();
            }
        });

        cadastrarGenerosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastroGeneros();
            }
        });

        setSize(300, 100);
        Programa.centerFrame(this); // Centraliza a janela
    }

    private void abrirTelaCadastroFilmes() {
        JFrame frame = new CadastroDeFilmesFrame("Cadastro de Filmes", app);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Programa.centerFrame(frame); // Centraliza a janela
        frame.setVisible(true);
        this.setVisible(false);
    }

    private void abrirTelaCadastroGeneros() {
        JFrame frame = new CadastroDeGenerosFrame("Cadastro de Gêneros", app);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Programa.centerFrame(frame); // Centraliza a janela
        frame.setVisible(true);
        this.setVisible(false);
    }
}
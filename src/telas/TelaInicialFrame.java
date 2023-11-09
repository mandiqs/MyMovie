package telas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import aplicacao.Programa;

public class TelaInicialFrame extends JFrame {
    private Programa app;
    private ImageIcon filmesIcon;
    private JLabel myLabelFilmes;
    private ImageIcon seriesIcon;
    private JLabel myLabelSeries;
    private JLabel myLabelMain;
    private ImageIcon mainIcon;
    private JLabel myLabelGeneros;
    private ImageIcon generosIcon;

    public TelaInicialFrame(String title, Programa app) {
        super(title);
        this.app = app;

        // Configurar os componentes da interface gráfica
        JButton cadastrarFilmesButton = new JButton("Cadastrar Filmes");
        JButton cadastrarGenerosButton = new JButton("Cadastrar Gêneros");
        JButton cadastrarSeriesButton = new JButton("Cadastrar Séries"); // Novo botão para cadastrar séries

        // Layout
        filmesIcon = new ImageIcon(this.getClass().getResource("/recursos/imagem-filmes.jpg"));
        myLabelFilmes = new JLabel(filmesIcon);
        myLabelFilmes.setSize(650, 650);

        seriesIcon = new ImageIcon(this.getClass().getResource("/recursos/imagem-series.jpg"));
        myLabelSeries = new JLabel(seriesIcon);
        myLabelSeries.setSize(650, 650);

        mainIcon = new ImageIcon(this.getClass().getResource("/recursos/main.jpg"));
        myLabelMain = new JLabel(mainIcon);
        myLabelMain.setSize(384, 384);

        generosIcon = new ImageIcon(this.getClass().getResource("/recursos/generos.jpg"));
        myLabelGeneros = new JLabel(generosIcon);
        myLabelGeneros.setSize(650, 450);

        setLayout(new FlowLayout());
        add(cadastrarFilmesButton);
        add(cadastrarSeriesButton);// Adicionar o botão para cadastrar séries
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

        cadastrarSeriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastroSeries(); // Ação para abrir a tela de cadastro de séries
            }
        });

        setSize(660, 710);
        add(myLabelMain);
        Programa.centerFrame(this); // Centraliza a janela
    }

    private void abrirTelaCadastroFilmes() {
        JFrame frame = new CadastroDeFilmesFrame("Cadastro de Filmes", app);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(myLabelFilmes);
        Programa.centerFrame(frame); // Centraliza a janela
        frame.setVisible(true);
        this.setVisible(false);
    }

    private void abrirTelaCadastroGeneros() {
        JFrame frame = new CadastroDeGenerosFrame("Cadastro de Gêneros", app);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(myLabelGeneros);
        Programa.centerFrame(frame); // Centraliza a janela
        frame.setVisible(true);
        this.setVisible(false);
    }

    private void abrirTelaCadastroSeries() {
        JFrame frame = new CadastroDeSeriesFrame("Cadastro de Séries", app); // Substitua "CadastroDeSeriesFrame" pelo nome correto da classe de cadastro de séries
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(myLabelSeries);
        Programa.centerFrame(frame); // Centraliza a janela
        frame.setVisible(true);
        this.setVisible(false);
    }
}

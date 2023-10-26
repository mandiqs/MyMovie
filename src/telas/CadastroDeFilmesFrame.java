package telas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import aplicacao.Programa;
import entidades.Filme;
import entidades.Genero;
import aplicacao.*;

public class CadastroDeFilmesFrame extends JFrame {
    private Programa app;
    private JTextField nomeField;
    private JComboBox<Genero> generoComboBox;
    private JTextField duracaoField;
    private JTextField notaField;
    private JTextArea filmesTextArea;

    public CadastroDeFilmesFrame(String title, Programa app) {
        super(title);
        this.app = app;

        // Configurar os componentes da interface gráfica
        nomeField = new JTextField(15);
        generoComboBox = new JComboBox<>(app.getGeneros().toArray(new Genero[0]));
        duracaoField = new JTextField(3);
        notaField = new JTextField(3);

        JButton cadastrarFilmeButton = new JButton("Cadastrar Filme");
        JButton voltarButton = new JButton("Voltar");

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarParaTelaInicial();
            }
        });

        cadastrarFilmeButton.addActionListener(new CadastrarFilmeListener());

        filmesTextArea = new JTextArea(10, 40);
        filmesTextArea.setEditable(false);

        JScrollPane filmesScrollPane = new JScrollPane(filmesTextArea);

        // Layout
        setLayout(new FlowLayout());
        add(new JLabel("Nome do filme:"));
        add(nomeField);
        add(new JLabel("Gênero do filme:"));
        add(generoComboBox);
        add(new JLabel("Duração (minutos):"));
        add(duracaoField);
        add(new JLabel("Nota (1-10):"));
        add(notaField);
        add(cadastrarFilmeButton);
        add(voltarButton);
        add(filmesScrollPane);

        carregarFilmes();
        setSize(700, 400);
        Programa.centerFrame(this); // Centraliza a janela
    }

    private void carregarFilmes() {
        List<Filme> filmes = app.getFilmes();
        filmesTextArea.setText("");

        for (Filme filme : filmes) {
            filmesTextArea.append(filme + "\n\n");
        }
    }

    private class CadastrarFilmeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nome = nomeField.getText();
            Genero genero = (Genero) generoComboBox.getSelectedItem();
            String duracaoText = duracaoField.getText();
            String notaText = notaField.getText();

            if (nome.isEmpty() || genero == null || duracaoText.isEmpty() || notaText.isEmpty()) {
                JOptionPane.showMessageDialog(CadastroDeFilmesFrame.this, "Por favor, preencha todos os campos.");
                return;
            }

            try {
                int duracao = Integer.parseInt(duracaoText);
                double nota = Double.parseDouble(notaText);

                Filme filme = new Filme(nome, genero, duracao, nota);
                app.adicionarFilme(filme);
                nomeField.setText("");
                duracaoField.setText("");
                notaField.setText("");
                carregarFilmes();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(CadastroDeFilmesFrame.this, "Duração e nota devem ser números válidos.");
            }
        }
    }

    private void voltarParaTelaInicial() {
        JFrame frame = new TelaInicialFrame("Cadastro de Filmes", app);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Programa.centerFrame(frame); // Centraliza a janela
        frame.setVisible(true);
        this.setVisible(false);
    }
}
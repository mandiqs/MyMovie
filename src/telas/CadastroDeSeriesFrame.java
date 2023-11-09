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
import entidades.Serie;
import aplicacao.*;

public class CadastroDeSeriesFrame extends JFrame {
    private Programa app;
    private JTextField nomeField;
    private JComboBox<Genero> generoComboBox;
    private JTextField duracaoField;
    private JTextField notaField;
    private JTextArea seriesTextArea;

    public CadastroDeSeriesFrame(String title, Programa app) {
        super(title);
        this.app = app;

        // Configurar os componentes da interface gráfica
        nomeField = new JTextField(15);
        generoComboBox = new JComboBox<>(app.getGeneros().toArray(new Genero[0]));
        duracaoField = new JTextField(3);
        notaField = new JTextField(3);

        JButton cadastrarSerieButton = new JButton("Cadastrar Serie");
        JButton voltarButton = new JButton("Voltar");

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarParaTelaInicial();
            }
        });

        cadastrarSerieButton.addActionListener(new CadastrarSerieListener());

        seriesTextArea = new JTextArea(10, 40);
        seriesTextArea.setEditable(false);

        JScrollPane seriesScrollPane = new JScrollPane(seriesTextArea);

        // Layout
        setLayout(new FlowLayout());
        add(new JLabel("Nome da série:"));
        add(nomeField);
        add(new JLabel("Gênero da série:"));
        add(generoComboBox);
        add(new JLabel("Duração (minutos):"));
        add(duracaoField);
        add(new JLabel("Nota (1-10):"));
        add(notaField);
        add(cadastrarSerieButton);
        add(voltarButton);
        add(seriesScrollPane);

        carregarSeries();
        setSize(755, 680);
        Programa.centerFrame(this); // Centraliza a janela
    }

    private void carregarSeries() {
        List<Serie> series = app.getSeries();
        seriesTextArea.setText("");

        for (Serie serie : series) {
            seriesTextArea.append(serie + "\n\n");
        }
    }

    private class CadastrarSerieListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nome = nomeField.getText();
            Genero genero = (Genero) generoComboBox.getSelectedItem();
            String duracaoText = duracaoField.getText();
            String notaText = notaField.getText();

            if (nome.isEmpty() || genero == null || duracaoText.isEmpty() || notaText.isEmpty()) {
                JOptionPane.showMessageDialog(CadastroDeSeriesFrame.this, "Por favor, preencha todos os campos.");
                return;
            }

            try {
                int duracao = Integer.parseInt(duracaoText);
                double nota = Double.parseDouble(notaText);

                Serie serie = new Serie(nome, nota, genero, duracao);
                app.adicionarSerie(serie);
                nomeField.setText("");
                duracaoField.setText("");
                notaField.setText("");
                carregarSeries();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(CadastroDeSeriesFrame.this, "Duração e nota devem ser números válidos.");
            }
        }
    }

    private void voltarParaTelaInicial() {
        JFrame frame = new TelaInicialFrame("Cadastro de Séries", app);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Programa.centerFrame(frame); // Centraliza a janela
        frame.setVisible(true);
        this.setVisible(false);
    }
}
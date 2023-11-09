package telas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import aplicacao.*;
import entidades.Genero;

public class CadastroDeGenerosFrame extends JFrame {
        private Programa app;
        private JTextField generoField;
        private DefaultListModel<Genero> generoListModel;
        private JList<Genero> generoList;

    public CadastroDeGenerosFrame(String title, Programa app) {
        super(title);
        this.app = app;

        generoListModel = new DefaultListModel<>();
        generoList = new JList<>(generoListModel);

        // Configurar os componentes da interface gráfica
        generoField = new JTextField(20);

        JButton cadastrarGeneroButton = new JButton("Cadastrar Gênero");
        JButton voltarButton = new JButton("Voltar");

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarParaTelaInicial();
            }
        });

        cadastrarGeneroButton.addActionListener(new CadastrarGeneroListener());

        // Layout
        setLayout(new FlowLayout());
        add(new JLabel("Nome do Gênero:"));
        add(generoField);
        add(cadastrarGeneroButton);
        add(new JScrollPane(generoList));
        add(voltarButton);

        carregarGeneros();
        setSize(610, 680);
        Programa.centerFrame(this); // Centraliza a janela
    }

    private void carregarGeneros() {
        generoListModel.clear();
        List<Genero> generos = app.getGeneros();

        for (Genero genero : generos) {
            generoListModel.addElement(genero);
        }
    }

    private class CadastrarGeneroListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nomeGenero = generoField.getText().trim();

            if (!nomeGenero.isEmpty()) {
                Genero genero = new Genero(nomeGenero);
                app.adicionarGenero(genero);
                generoField.setText("");
                carregarGeneros();
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



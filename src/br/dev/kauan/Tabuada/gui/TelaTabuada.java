package br.dev.kauan.Tabuada.gui;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import br.dev.kauan.Tabuada.model.Tabuada;

public class TelaTabuada {
	//
	// ATRIBUTOS
	//

	// Comunicação com o usário e Inputs
	private JLabel labelMultiplicando;
	private JLabel labelMinMultiplicador;
	private JLabel labelMaxMultiplicador;
	private JTextField textMultiplicando;
	private JTextField textMinMultiplicador;
	private JTextField textMaxMultiplicador;

	// Botões para executar os métodos
	private JButton buttonCalcular;
	private JButton buttonLimpar;

	// Exibição e navegação dos resultados
	private JList listTabuada;
	private JScrollPane scrollTabuada;
	private String tituloDaTela;

	//
	// MÉTODOS
	//

	public void criarTela(String tituloDaTela) {
		// recebebendo os atributos
		this.tituloDaTela = tituloDaTela;

		// Instanciando e configurando o JFrame
		JFrame tela = new JFrame();
		tela.setTitle(this.tituloDaTela);
		tela.setSize(265, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);

		// Criando referencias para os Bounds

		// Criando text labels para a janela
		tela.setLayout(null);
		labelMultiplicando = new JLabel();
		labelMultiplicando.setText("Multiplicando:");
		labelMultiplicando.setBounds(5, 20, 150, 30);

		labelMinMultiplicador = new JLabel();
		labelMinMultiplicador.setText("Multiplicador Mínimo:");
		labelMinMultiplicador.setBounds(5, 60, 150, 30);

		labelMaxMultiplicador = new JLabel();
		labelMaxMultiplicador.setText("Multiplicador Máximo:");
		labelMaxMultiplicador.setBounds(5, 100, 150, 30);

		// Criando text fields para a janela
		textMultiplicando = new JTextField();
		textMultiplicando.setBounds(195, 20, 50, 30);

		textMinMultiplicador = new JTextField();
		textMinMultiplicador.setBounds(195, 60, 50, 30);

		textMaxMultiplicador = new JTextField();
		textMaxMultiplicador.setBounds(195, 100, 50, 30);

		// Criando botões para a janela
		buttonCalcular = new JButton("Calcular");
		buttonCalcular.setBounds(5, 150, 100, 30);

		buttonLimpar = new JButton("Limpar");
		buttonLimpar.setBounds((195 - 50), 150, 100, 30);

		// Obtendo referência do Container, o painel de conteudo da janela
		Container container = tela.getContentPane();

		// Criar o JList que vai receber a tabuada
		listTabuada = new JList();

		// Criar o Scrollpane que vai receber o JList
		scrollTabuada = new JScrollPane(listTabuada);
		scrollTabuada.setBounds(20, 200, 210, 340);
		

		// Adicionando elementos na janela
		container.add(labelMultiplicando);
		container.add(labelMinMultiplicador);
		container.add(labelMaxMultiplicador);

		container.add(textMultiplicando);
		container.add(textMinMultiplicador);
		container.add(textMaxMultiplicador);

		container.add(buttonCalcular);
		container.add(buttonLimpar);

		container.add(scrollTabuada);

		// Adicionando escutantes de ação aos botões
		buttonCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Coletando os valores nos campos
				String multiplicando = textMultiplicando.getText();
				String minMultiplicador = textMinMultiplicador.getText();
				String maxMultiplicador =  textMaxMultiplicador.getText();
				
				//Convertendo os valores para double
				double multiplicandoDouble = Double.parseDouble(multiplicando);
				double minMultiplicadorDouble = Double.parseDouble(minMultiplicador);
				double maxMultiplicadorDouble = Double.parseDouble(maxMultiplicador);
				
				//Fonecendo os valores para a tabuada
				Tabuada tabuada = new Tabuada(multiplicandoDouble, minMultiplicadorDouble, maxMultiplicadorDouble);
				
				//Trazer a tabuada e colocar na tela
				String[] tabuadaVisual = tabuada.mostrarTabuada();
				listTabuada.setListData(tabuadaVisual);
				
			}
		});

		// tornando a tela visível
		tela.setVisible(true);
	}

	private void exibirTabuada() {

	}

	private void limparTabuada() {

	}

}

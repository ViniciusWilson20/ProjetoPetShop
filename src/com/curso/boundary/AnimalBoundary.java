package com.curso.boundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.curso.controller.AnimalControl;
import com.curso.entity.Animal;
import com.curso.entity.TableModel;

public class AnimalBoundary extends JFrame implements ActionListener {

	private JPanel painel;
	private JTable tabela;
	private JLabel lblId;
	private JLabel lblNome;
	private JLabel lblNascimento;
	private JLabel lblPeso;

	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtNascimento;
	private JTextField txtPeso;

	private JButton btnAdicionar;
	private JButton btnPesquisar;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private AnimalControl controlAnimal = new AnimalControl();

	public AnimalBoundary() {

		setTitle("Controle de Animais");
		setSize(800, 580);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		painel = new JPanel();
		painel.setLayout(null);
		painel.setOpaque(true);

		lblId = new JLabel("ID:");
		lblId.setSize(100, 30);
		lblId.setLocation(50, 40);
		painel.add(lblId);

		lblNome = new JLabel("Nome: ");
		lblNome.setSize(100, 30);
		lblNome.setLocation(50, 80);
		painel.add(lblNome);

		lblNascimento = new JLabel("Nascimento: ");
		lblNascimento.setSize(100, 30);
		lblNascimento.setLocation(50, 120);
		painel.add(lblNascimento);

		lblPeso = new JLabel("Peso:");
		lblPeso.setSize(100, 30);
		lblPeso.setLocation(50, 160);
		painel.add(lblPeso);

		txtID = new JTextField();
		txtID.setSize(250, 30);
		txtID.setLocation(150, 40);
		painel.add(txtID);

		txtNome = new JTextField();
		txtNome.setSize(250, 30);
		txtNome.setLocation(150, 80);
		painel.add(txtNome);

		txtNascimento = new JTextField();
		txtNascimento.setSize(250, 30);
		txtNascimento.setLocation(150, 120);
		painel.add(txtNascimento);

		txtPeso = new JTextField();
		txtPeso.setSize(250, 30);
		txtPeso.setLocation(150, 160);
		painel.add(txtPeso);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setSize(200, 25);
		btnAdicionar.setLocation(199, 200);
		painel.add(btnAdicionar);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setSize(200, 25);
		btnPesquisar.setLocation(401, 200);
		painel.add(btnPesquisar);

		TableModel model = new TableModel();

		tabela = new JTable();
		tabela.setModel(model);
		tabela.setSize(500, 280);
		tabela.setLocation(100, 240);
		painel.add(tabela);

		getContentPane().add(painel);
		setVisible(true);

		btnAdicionar.addActionListener(this);
		btnPesquisar.addActionListener(this);

	}

	public Animal boundaryToAnimal() {

		Animal a = new Animal();
		a.setNome(txtNome.getText());
		Date data;
		try {
			a.setId(Integer.valueOf(txtID.getText()));
			data = sdf.parse(txtNascimento.getText());
			a.setNascimento(data);
			a.setPeso(Float.parseFloat(txtPeso.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return a;
	}

	public void animalToBoundary(Animal a) {

		txtID.setText(String.valueOf(a.getId()));
		txtNome.setText(a.getNome());
		String strData = sdf.format(a.getNascimento());
		txtNascimento.setText(strData);
		txtPeso.setText(String.format("%.2f", a.getPeso()));
	}

	public static void main(String[] args) {

		AnimalBoundary a = new AnimalBoundary();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) {

			Animal a = boundaryToAnimal();
			controlAnimal.adicionar(a);
		}
		if (e.getSource() == btnPesquisar) {

			controlAnimal.pesquisarPorNome(txtNome.getText());
		}

	}

}

package prueba;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Method;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Vista extends JFrame implements ActionListener{
	
	private Container panelPricipal;
	private JPanel inferior;
	private JTextArea codigo;
	private JButton analizar;
	private JButton xml;
	private JComboBox metodo;
	private JScrollPane scroll;
	private JFileChooser explorador;
	

	public Vista() {
		// TODO Auto-generated constructor stub
		super("JPet");
		String normas= "Solo utilizar desde linux/unix."
				+ "\nSeleccionar el archivo .class y luego pulsar analizar"
				+ "\nQuitar el package";
		panelPricipal = this.getContentPane();
		panelPricipal.setLayout(new BorderLayout());
		this.codigo = new JTextArea();
		float tam =22;
		this.codigo.setFont(this.codigo.getFont().deriveFont(tam));
		this.codigo.setText(normas);
		this.scroll = new JScrollPane(this.codigo);
		this.panelPricipal.add(this.scroll, BorderLayout.CENTER);
		this.inferior = new JPanel();
		this.inferior.setLayout(new FlowLayout());
		this.analizar = new JButton("Seleccionar");
		this.analizar.addActionListener(this);
		this.explorador = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	            "Compiled java (class) files", "class");
	    explorador.setFileFilter(filter);
		this.xml = new JButton("Analizar");
		this.xml.setEnabled(false);
		xml.addActionListener(this);
		File f = new File("/home/jaime/Documentos/4AÑO/TFG/otra.class");
		Class aClass = f.getClass();
		Method[] methods = aClass.getMethods();
		metodo = new JComboBox(methods);
		this.metodo.setEnabled(false);
		//this.metodo.setModel(methods);
		this.inferior.add(this.analizar);
		this.inferior.add(this.xml);
		this.inferior.add(this.metodo);
		this.panelPricipal.add(inferior, BorderLayout.SOUTH);
		Dimension dim = new Dimension();
		dim = super.getToolkit().getScreenSize();
		int altura = dim.height;
		int ancho = dim.width;
		this.setSize((ancho/3)*2, (altura/3)*2);
		this.setMinimumSize(new Dimension((ancho/2), (altura/2)));
		this.setLocation((ancho/6), (altura/8));
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.analizar){
			int returnVal = explorador.showOpenDialog(getParent());
	        if(returnVal == JFileChooser.APPROVE_OPTION) {
	        	this.codigo.setText("Has abierto este archivo: " +
	        		   explorador.getSelectedFile().getPath()
	        		   + "\nNombre del archivo: " + explorador.getSelectedFile().getName());
	        		   this.xml.setEnabled(true);
	        }else
	        	this.xml.setEnabled(false);
		}
		else if(e.getSource()==this.xml){
			Tfg tfg = new Tfg();
			this.codigo.setText(tfg.Jpet(this.explorador.getSelectedFile()));
		}
	}
}

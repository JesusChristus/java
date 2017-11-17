package ersteGUI;

import java.awt.*;
import java.awt.event.*;

public class ersteGui extends Frame implements WindowListener, ActionListener
{	
	private Button button;
	private Button button2;
	private Label label;
	private TextField textfeld;
	
	public static void main(String[]args)
	{
		ersteGui GUI= new ersteGui(); //Instanziieren
	}
	public ersteGui()
	{
		initialize();
	}

	private void initialize()
	{
		this.setTitle("1.Gui");
		//größe, Sichtbarkeit und WindowListener hinzufügen
		this.setSize(300, 100);
		this.setVisible(true);
		this.addWindowListener(this);
		//erzeugen eines opjekts
		button = new Button("Hell yeah");	
		button2 = new Button("2");
		label = new Label("nope");
		textfeld = new TextField("Hallo ich bin das erste Textfeld!");
		// Gestaltungsopjekte zu Layoutmanager des Frames hinzufügen
		add(BorderLayout.WEST, button);
		add(BorderLayout.EAST, button2);
		add(BorderLayout.CENTER, label);
		add(BorderLayout.SOUTH,textfeld);
		button.addActionListener(this);
		button2.addActionListener(this);
		this.pack();
	}


	//abstracte Methoden des Intrfaces WindowListener
	public void windowOpened(WindowEvent e)
	{}
	public void windowClosed(WindowEvent e)
	{}
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	public void windowActivated(WindowEvent e)
	{}
	public void windowDeactivated(WindowEvent e)
	{}
	public void windowDeiconified(WindowEvent e)
	{}
	public void windowIconified(WindowEvent e)
	{}
		//actionListender abstracte Methoden
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == button)
		{
			this.setVisible(false);
		}
		
		if(e.getSource() == button2)
		{
			this.setSize(5000, 5000)
		}
	}
	
}


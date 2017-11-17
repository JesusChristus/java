package ersteGUI;

import java.awt.*;
import java.awt.event.*;

public class Ostfriesenrechner extends Frame implements WindowListener, ActionListener, MouseListener
{
	private Button plus;
	private Button minus;
	private Label startwert;
	private TextField textfeld;
	private Label fehler;
	private int i = 20;
	
	public static void main(String[]args)
	{
		Ostfriesenrechner gui = new Ostfriesenrechner();
	}
	
	public Ostfriesenrechner()
	{
		initialize();
	}
	
	private void initialize()
	{
		this.setTitle("OstfriesenRechner");
		this.setVisible(true);
		this.setSize(1000,500);
		this.addWindowListener(this);
		
		plus = new Button("Plus");
		minus = new Button("Minus");
		fehler = new Label("");
		startwert = new Label("Startwert: " + i) ;
		textfeld = new TextField("wer das liest hat ein unnützes textfeld gelesen");
		
		add(BorderLayout.CENTER, startwert);
		add(BorderLayout.SOUTH, textfeld);
		add(BorderLayout.NORTH, fehler);
		add(BorderLayout.EAST, minus);
		add(BorderLayout.WEST, plus);
		
		minus.addActionListener(this);
		plus.addActionListener(this);
		textfeld.addActionListener(this);
		
		this.pack();
	}
	
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
	
	public void MouseEntered(MouseEvent e)
	{
		if(e.getSource() == plus)
		{
			plus.setBackground(Color.green);
		}
		
		if(e.getSource() == minus)
		{
			minus.setBackground(Color.red);
		}
	}
	
	public void MouseExited(MouseEvent e)
	{
		if(e.getSource() == plus)
		{
			plus.setBackground(Color.gray);
		}
		
		if(e.getSource() == minus)
		{
			minus.setBackground(Color.gray);
		}

	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == plus)
		{
			i++;
			zeigeAn();
		}
		
		if(e.getSource() == minus)
		{
			i--;
			zeigeAn();
		}
		
		if (e.getSource() == textfeld)
		{
			try
			{
				i=Integer.valueOf(textfeld.getText()).intValue();
				zeigeAn();
			}
			catch(NumberFormatException a)
			{
				fehler.setText("you shall not pass you fool");
				this.pack();
			}
		}
	}
	private void zeigeAn()
	{
		fehler.setText("");
		startwert.setText("Startwert: " + i);
		this.pack();
	}
}
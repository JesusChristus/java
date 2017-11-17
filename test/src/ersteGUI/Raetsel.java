package ersteGUI;

import java.awt.*;
import java.awt.event.*;

public class Raetsel extends Frame implements WindowListener, ActionListener
{
	private Label winOrLose;
	private Label fehler;
	private Label angabe;
	private Button raten;
	private TextField textfeld;
	private int i;
	private int rand = Math.random() * 10 + 1;
	
	public static void main(String[]args)
	{
		Raetsel gui = new Raetsel();
	}
	
	public Raetsel()
	{
		initialize();
	}
	
	private void initialize()
	{
		this.setTitle("OstfriesenRechner");
		this.setVisible(true);
		this.setSize(1000,500);
		this.addWindowListener(this);

		winOrLose = new Label("");
		fehler = new Label("");
		angabe = new Label("Raten sie eine Zahl von 0 - 10");
		raten = new Button("raten");
		textfeld = new Textfield("");
		
		add(BorderLayout.CENTER, textfeld);
		add(BorderLayout.EAST, raten);
		add(BorderLayout.NORTH, angabe);
		add(BorderLayout.SOUTH, winOrLose);
		add(BorderLayout.SOUTH, fehler);
		
		textfeld.addActionListener(this);
		raten.addActionListener(this);
		
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
		this.pack();
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == textfeld)
		{
			try
			{
				i=Integer.valueOf(textfeld.getText()).intValue();
			}
			catch(NumberFormatException a)
			{
				fehler.setText("you shall not pass you fool");
				this.pack();
			}
		}

		if(e.getSource() == raten)
		{
			if(i == rand)
			{
				winOrLose.setText("GEWONNEN, die zahl war " + rand);
				rand = Math.random() * 10 + 1;
				this.pack();
			}
			else
			{
				winOrLose.setText("Verloren, die zahl war " + rand);
				rand = Math.random() * 10 + 1;
				this.pack();
 		}
	}
}
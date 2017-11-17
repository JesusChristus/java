package ersteGUI;

import java.awt.*;
import java.awt.event.*;


public class Verbrauchsrechner extends Frame
{
	private Label kilometer;
	private Label labelVerbrauch;
	private Label literProKm;
	private Label ergebnis;
	private Label fehler;
	private TextField km;
	private TextField verbrauch;
	private Button delete;
	private List values;
	private double i = 0;
	private double j = 0;
	
	public static void main(String[]args)
	{
		Verbrauchsrechner gui = new Verbrauchsrechner();
	}
	
	public Verbrauchsrechner()
	{
		initialize();
	}
	
	private void initialize()
	{
		this.setTitle("Verbrauchsrechner");
		this.setVisible(true);
		this.setSize(700, 700);
		
		kilometer = new Label("Kilometer");
		labelVerbrauch = new Label("Verbrauch:");
		literProKm = new Label("Liter/km -->");
		ergebnis = new Label("");
		fehler = new Label("");
		km = new TextField("");
		verbrauch = new TextField("");
		delete = new Button ("weg");
		values = new List();
			
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		
		add(kilometer,gbc); //hier wird erst das Label hinzugefügt!
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		
		add(km,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		
		add(labelVerbrauch,gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		
		add(verbrauch,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		
		add(literProKm,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		
		add(ergebnis,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 4;
		gbc.gridheight = 1;

		add(values,gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		
		add(fehler,gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 1;	
		gbc.gridheight = 1;
		
		add(delete,gbc);
		
		delete.addActionListener(e -> loescheListe() );
		km.addActionListener(e -> exeptionKm());
		verbrauch.addActionListener(e -> exeptionVerbrauch());
		
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
		this.pack();
	}

	private void exeptionVerbrauch()
	{
		try
		{
			Double.valueOf(verbrauch.getText()).doubleValue();
			berechneDurchschnittsverbrauch();
		}
		catch(NumberFormatException e)
		{
			fehler.setText("Zahleneingabe benötigt");
		}
	}
	
	private void exeptionKm()
	{
		try
		{
			Double.valueOf(km.getText()).doubleValue();
			verbrauch.requestFocus();
		}
		catch(NumberFormatException e)
		{
			fehler.setText("Zahleneingabe benötigt");
		}		
		
	}

	private void loescheListe()
	{
		values.removeAll();
		km.setText(" ");
		verbrauch.setText(" ");
		ergebnis.setText(" ");
		fehler.setText(" ");
	}
	
	private void berechneDurchschnittsverbrauch()
	{
		i = Double.valueOf(km.getText()).doubleValue();
		j = Double.valueOf(verbrauch.getText()).doubleValue();
		
		ergebnis.setText("" + (j / i)*100);
		
		anzeigenListe();
	}
	
	private void anzeigenListe()
	{
		values.add(" km   Verbrauch");
		
		while(i > 0)
		{
			values.add(i + "   " + j );
			j = j - Double.valueOf(ergebnis.getText()).doubleValue();		
			i = i - 100;			
		}
	}
}
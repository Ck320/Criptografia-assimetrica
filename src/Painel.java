import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;

/**
 * Classe responsável pela interface gráfica
 * 
 * 
 * @author Mauricio Sugimoto Polloni
 *
 */

public class Painel extends JFrame
{
	JButton b1 = new JButton("Criptografar");
	JButton b2 = new JButton("Descriptografar");
	JTextArea t1 = new JTextArea(5,30);
	JTextArea t2 = new JTextArea(5,30);
	
	Painel()
	{
		super("Criptografia");
		Container content = getContentPane();
		SpringLayout sL = new SpringLayout();
		setLayout(sL);
		
		content.setBackground(Color.DARK_GRAY);
		b1.setBackground(Color.green);
		b2.setBackground(Color.green);
		t2.setBackground(Color.black);
		t1.setBackground(Color.black);
		t1.setForeground(Color.green);
		t2.setForeground(Color.green);
		
		add(b1);
		add(b2);
		add(t1);
		add(t2);				
		
		sL.putConstraint(SpringLayout.WEST,b1,35,SpringLayout.WEST,content);
		sL.putConstraint(SpringLayout.NORTH,b1,50,SpringLayout.NORTH,content);
		
		sL.putConstraint(SpringLayout.WEST,b2,25,SpringLayout.WEST,content);
		sL.putConstraint(SpringLayout.NORTH,b2,175,SpringLayout.NORTH,content);
		
		sL.putConstraint(SpringLayout.EAST,t1,25,SpringLayout.EAST,content);
		sL.putConstraint(SpringLayout.NORTH,t1,25,SpringLayout.NORTH,content);
		
		sL.putConstraint(SpringLayout.EAST,t2,25,SpringLayout.EAST,content);
		sL.putConstraint(SpringLayout.NORTH,t2,150,SpringLayout.NORTH,content);	
		
		
		
		
				
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{	
				
				Maquina m = new Maquina();				
				String x = t1.getText();
				t2.setText(m.Criptografar(x));
				t1.setText("");
				m = new Maquina();
				
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{	
				Maquina m1 = new Maquina();			
				String y = t2.getText();
				t1.setText(m1.DesCriptografar(y));
				t2.setText("");	
				m1 = new Maquina();				
			}
		});
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);		
	}
	

	
	
	public static void main(String[] args)
	{
		Painel p = new Painel();
		p.setSize(500,300);
		
	}
}

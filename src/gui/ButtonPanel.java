package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ButtonPanel {

	// Constants.
	// ------------------------------------------------
	private static final int HEIGHT = 40;
	
	// Fields.
	// ------------------------------------------------
	private Controller controller;
	
	// Constructors.
	// ------------------------------------------------
	protected ButtonPanel(Controller controller){
		
		this.controller = controller;
		
		JPanel topPanel = makeTopPanel();
		JPanel botPanel = makeBotPanel();
		
		JLabel label = new JLabel("Num Pts: ");
		JTextField textField = new JTextField("");
		JButton btnMake = new JButton("Make World");
		JButton bntStep = new JButton("Step");
		
		btnMake.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
				
			}
		});
		
	}
	
	// Set up methods.
	// ------------------------------------------------
	private JPanel makeTopPanel(){
		JLabel label = new JLabel("Num Pts: ");
		JTextField textField = new JTextField("");
		JButton btnMake = new JButton("Make World");
		btnMake.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//controller.sendEvent("Make");
			}
		});
		return null;
	}
	
	private JPanel makeBotPanel(){
		return null;
	}
	
}

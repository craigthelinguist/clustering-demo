package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ButtonPanel extends JPanel {

	// Constants.
	// ------------------------------------------------
	private static final int HEIGHT = 40;
	
	// Fields.
	// ------------------------------------------------
	private Controller controller;
	private Gui gui;
	private JTextField fieldNumPoints;
	private JTextField fieldNumClusters;
	
	// Constructors.
	// ------------------------------------------------
	protected ButtonPanel(Gui gui, Controller controller){
		
		// fields
		this.controller = controller;
		this.gui = gui;
		
		// components
		JPanel topPanel = makeTopPanel();
		JPanel botPanel = makeBotPanel();
		
		// make layout
		GroupLayout gl = new GroupLayout(this);
		this.setLayout(gl);
		GroupLayout.SequentialGroup horizontal = gl.createSequentialGroup();
		GroupLayout.SequentialGroup vertical = gl.createSequentialGroup();
		gl.setHorizontalGroup(horizontal);
		gl.setVerticalGroup(vertical);
		
		// horizontal
		horizontal.addGroup(
			gl.createParallelGroup()
				.addComponent(topPanel)
				.addComponent(botPanel)
			);
		
		// vertical
		vertical.addComponent(topPanel);
		vertical.addComponent(botPanel);
		
		// finish
		this.setVisible(true);
		
	}
	
	// Set up methods.
	// ------------------------------------------------
	private JPanel makeTopPanel(){
		
		// make components
		JLabel label = new JLabel("Num Pts: ");
		fieldNumPoints = new JTextField("30");
		fieldNumPoints.setPreferredSize(new Dimension(10, HEIGHT));
		//fieldNumPoints.setMaximumSize(new Dimension(10, HEIGHT));
		JButton btnMake = new JButton("Make World");
		
		// lisetners
		btnMake.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.sendEvent(Signal.MAKE_WORLD);
			}
		});
		
		// make panel
		JPanel panel = new JPanel();
		Dimension dimension = new Dimension((int)gui.getCanvasDimensions().getWidth(), 40);
		panel.setPreferredSize(dimension);
		
		// make layout
		GroupLayout gl = new GroupLayout(panel);
		panel.setLayout(gl);
		GroupLayout.SequentialGroup horizontal = gl.createSequentialGroup();
		GroupLayout.SequentialGroup vertical = gl.createSequentialGroup();
		gl.setHorizontalGroup(horizontal);
		gl.setVerticalGroup(vertical);
		
		// horizontal layout
		horizontal.addGroup(
			gl.createParallelGroup()
				.addComponent(label)
				.addComponent(fieldNumPoints)
				.addComponent(btnMake)
		);
		
		// vertical layout
		vertical.addComponent(label);
		vertical.addComponent(fieldNumPoints);
		vertical.addComponent(btnMake);
		
		return panel;
	}
	
	private JPanel makeBotPanel(){
		
		// make components
		JLabel label = new JLabel("Num Clusters: ");
		fieldNumClusters = new JTextField("5");
		fieldNumClusters.setPreferredSize(new Dimension(10, HEIGHT));
		JButton btnStart = new JButton("Start");
		JButton btnStep = new JButton("Step");
		
		// listeners
		btnStart.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.sendEvent(Signal.INITIALISE);
			}
		});
		btnStep.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.sendEvent(Signal.STEP);
			}
		});
		
		// make panel
		JPanel panel = new JPanel();
		Dimension dimension = new Dimension((int)gui.getCanvasDimensions().getWidth(), 40);
		panel.setPreferredSize(dimension);
		
		// make layout
		GroupLayout gl = new GroupLayout(panel);
		panel.setLayout(gl);
		GroupLayout.SequentialGroup horizontal = gl.createSequentialGroup();
		GroupLayout.SequentialGroup vertical = gl.createSequentialGroup();
		gl.setHorizontalGroup(horizontal);
		gl.setVerticalGroup(vertical);
		
		// horizontal layout
		horizontal.addGroup(
			gl.createParallelGroup()
				.addComponent(label)
				.addComponent(fieldNumClusters)
				.addComponent(btnStart)
				.addComponent(btnStep)
		);
		
		// vertical layout
		vertical.addComponent(label);
		vertical.addComponent(fieldNumClusters);
		vertical.addComponent(btnStart);
		vertical.addComponent(btnStep);
		
		return panel;
	}
	
	// Instance methods.
	// ------------------------------------------------
	
	protected int getNumberOfPoints() {
		return Integer.parseInt(fieldNumPoints.getText());
	}
	
	protected int getNumberOfClusters(){
		return Integer.parseInt(fieldNumClusters.getText());
	}
	
}

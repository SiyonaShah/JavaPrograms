// Siyona Shah
// 9-3-26
// SneezePanels.java
/*  IDEA of this program:  PanelHolder, which is added to the frame, holds two panels,
LeftPanel and RightPanel, which are added to PanelHolder in a GridLayout. The 
LeftHolder has a BorderLayout and has two panels-a direction panel, with a FlowLayout 
that has a the button, and a textField panel that contains the textField.  When
the button is pressed, Achoo and a yellow oval are drawn on the Right Panel.  
When the user types in "Bless you" in the textField, the RightPanel is erased
and variables are reset.
*/
/// Testing:  Only clicking on the button will draw on the right panel.  Only typing 
/// in "Bless you" will clear it.
/// Try clicking anywhere other that the button.  This should will not change anything.  
/// Typing anything other than "Bless you" will not reset the panels.

import java.awt.event.ActionListener;	
import java.awt.event.ActionEvent;

import javax.swing.JFrame;	
import javax.swing.JPanel;

import java.awt.Color;		
import java.awt.Graphics;
import java.awt.Font;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

 // I added this so it works
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;


public class SneezePanels
{	
	public static void main( String[] args )
	{
		SneezePanels sp = new SneezePanels();
		sp.run();
	}
	
	public SneezePanels()
	{	
	}

	public void run()
	{
		JFrame sneezeFrame = new JFrame ("Sneeze and Bless you.");
		
		sneezeFrame.setSize( 600, 400);				
		sneezeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		sneezeFrame.setLocation(400,50);
		sneezeFrame.setResizable(true);
		PanelHolder pHolder = new PanelHolder(); 
		sneezeFrame.add( pHolder );		

		sneezeFrame.setVisible(true);	
	}

// This panel holds two panels-one on the left and one on the right, aptly named
class PanelHolder extends JPanel
{
	private RightPanel rp;	// these are field variables so the nested classes have access to them
	private boolean nosePressed;	// otherwise, we have to use getter-setter methods
	private Font font;
	
	public PanelHolder()
	{
		setLayout( new GridLayout(1, 2) );
		nosePressed = false;
		font = new Font("Serif", Font.BOLD, 20);

		LeftPanel lp = new LeftPanel();
		add( lp );
		rp = new RightPanel();
		add( rp );
	}

	// This panel will have a BorderLayout
	//  It will have the directions panel in the center, and the 
	// textField panel in the south. 
	class LeftPanel extends JPanel
	{	
		public LeftPanel()
		{	
			setLayout(new BorderLayout());
					
			DirectionPanel dirP = new DirectionPanel ();
			TFPanel tfp = new TFPanel();
			
			add ( dirP, BorderLayout.CENTER );
			add ( tfp, BorderLayout.SOUTH );
		}
	
	}
	
	// DirectionPanel will print the directions and contain the 
	// nose button. It has a FlowLayout. It will use a 
	// ButtonHandler for actionPerformed.
 	class DirectionPanel extends JPanel
	{
		public DirectionPanel()
		{
			setBackground(Color.BLUE);			
			setLayout(new FlowLayout(FlowLayout.CENTER, 20, 130));
			JButton noseButton = new JButton("Nose");
			noseButton.addActionListener(new Button1Handler());
			add(noseButton);
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.setFont(font);
			g.drawString("Directions: Press button", 40, 70);
			g.drawString("to tickle the nose", 40, 100);
		}
	}

	// The TFPanel will have a FlowLayout and contain a text field
	// that will be on the left. It uses a handler class for 
	// actionPerformed
 	class TFPanel extends JPanel
 	{
		private JTextField tf;
		public TFPanel()
		{
			setLayout(new FlowLayout(FlowLayout.LEFT));
			setBackground(Color.GREEN);
			tf = new JTextField("Type: Bless you.", 18);
			tf.addActionListener(new TextFieldHandler());
			add(tf);
		}
	}
 	
	// The RightPanel is used to draw "Achoo" and a yellow oval when the
	// button is pressed and cleared when "Bless you" is typed in
	// the textField
 	class RightPanel extends JPanel
 	{
		public RightPanel()
		{
			setBackground(Color.PINK); // pink color
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			if (nosePressed)
			{
				g.setFont(font);
				g.setColor(Color.BLACK);
				g.drawString("Achoo!", 115, 80);

				g.setColor(Color.YELLOW);
				g.fillOval(100, 120, 100, 120);
			}
		}
	}

	// When the button is pressed, the method actionPerformed is 
	// used to call paintComponent in RightPanel
 	class Button1Handler implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			nosePressed = true;
			rp.repaint();
		}
	}	// end class Button1Handler	

	// When the user types in "Bless you" in the textField, the 
	// boolean is reset	and RightPanel's paintComponent is called
	class TextFieldHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			JTextField tf = (JTextField) e.getSource();
			if (tf.getText().equals("Bless you."))
			{
				nosePressed = false;
				tf.setText("Type: Bless you.");
				rp.repaint();
			}
		}
	}
}	// end class TextFieldHandler
}

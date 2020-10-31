import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

	JTextField firstNum;
	JTextField secondNum;
	JTextField finalAns;

	JButton addButton;
	JButton subButton;
	JButton multButton;
	JButton divButton;

	JLabel firstLabel;
	JLabel secondLabel;
	JLabel finalLabel;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Calculator");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
		//initialize the main Jpanel
	  mainPanel = new JPanel();
	  //disable any layout helpers 
	  mainPanel.setLayout(null);

		// create the side labels
	  firstLabel = new JLabel("First Number");
	  secondLabel = new JLabel("Second Number");
	  finalLabel = new JLabel("Result");

		firstLabel.setBounds(150,100,150,25);
	  secondLabel.setBounds(150,200,150,25);
	  finalLabel.setBounds(150,300,150,25);

		//initialize the textfields
		firstNum = new JTextField();
		secondNum = new JTextField();
		finalAns = new JTextField();

		//initialize the buttons 
		addButton = new JButton("Add");
		subButton = new JButton("Sub");
		multButton = new JButton("Mult");
		divButton = new JButton("Div");
		
		//set the location and size of the textfields
		firstNum.setBounds(400,100,150,25);
		secondNum.setBounds(400,200,150,25);
		finalAns.setBounds(400,300,150,25);

		//set the size and location of the buttons
		addButton.setBounds(100,425,100,35);
		//Add an action listener to this 
		addButton.addActionListener(this);
		//set the action commands to the button
		addButton.setActionCommand("add");

		subButton.setBounds(250,425,100,35);
		//Add an action listener to this 
		subButton.addActionListener(this);
		//set the action commands to the button
		subButton.setActionCommand("sub");

		multButton.setBounds(400,425,100,35);
	  //Add an action listener to this 
		multButton.addActionListener(this);
		//set the action commands to the button
		multButton.setActionCommand("mult");

		divButton.setBounds(550,425,100,35);
		//Add an action listener to this 
		divButton.addActionListener(this);
		//set the action commands to the button
		divButton.setActionCommand("div");

		//make it os that you cant type in the final ans text boxes
		finalAns.setEnabled(false);

		//add it to the panel 
		mainPanel.add(firstNum);
		mainPanel.add(secondNum);
		mainPanel.add(finalAns);

		//add it to the panel
		mainPanel.add(addButton);
		mainPanel.add(subButton);
		mainPanel.add(multButton);
		mainPanel.add(divButton);

		//add it to the panel
		mainPanel.add(firstLabel);
		mainPanel.add(secondLabel);
		mainPanel.add(finalLabel);
		//add the panel to the window
		frame.add(mainPanel);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
		//get all of the text in the text boxes
		String firstText = firstNum.getText();
		String secondText = secondNum.getText();

		//change the string into an Integer
		int num1 = Integer.parseInt(firstText);
		int num2 = Integer.parseInt(secondText);
		//make an integer which stores the final answer 
		int ans;
		//depending on which button is pressed it accordingly mutliply, divides, subtracts or adds then outputs the message to the user 
		if(command.equals("add")){
			ans = num1 + num2;
			finalAns.setText(""+ans);
		}else if(command.equals("sub")){
			ans = num1 - num2;
			finalAns.setText(""+ans);
		}else if(command.equals("mult")){
			ans = num1 * num2;
			finalAns.setText(""+ans);
		}else if(command.equals("div")){
			ans = num1 / num2;
			finalAns.setText(""+ans);
		}
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}

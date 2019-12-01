
//this program asks the user to toss the dice.
//2 arrays are created and a number at random is selected, 
//one array keeps track of which number appeared on the dice
//every time the dice was tossed
//and the second array keeps track of how many times each number from
// 1-6 showed up

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.Random;

public class Proj6_1 extends Applet implements ActionListener
{

	Label instruct;
	Button randNum;
	Image dice1, dice2, dice3, dice4, dice5, dice6;
	
	//dataArr[] keeps the data of each toss
	//counterArr[] counts how many times each number was shown
	int element, dataArr[], counterArr[];
	Random rand; //random number that will be generated
	int value;
	
	final int arraySize = 20;
	final int diceSize = 6;
	
	public void init()
	{
		setLayout(null);
		dataArr = new int[arraySize];
		counterArr = new int[diceSize];
		element = 0;
		dice1 = getImage(getDocumentBase(), "");
		dice2 = getImage(getDocumentBase(), "");
		dice3 = getImage(getDocumentBase(), "");
		dice4 = getImage(getDocumentBase(), "");
		dice5 = getImage(getDocumentBase(), "");
		dice6 = getImage(getDocumentBase(), "");
		
		instruct = new Label("Click the button and toss the dice 20 times:");
		instruct.setBounds(30, 30, 300, 20);
		add(instruct);
		
		rand = new Random();
		
		randNum = new Button("Toss Dice");
		randNum.setBounds(400, 30, 150, 20);
		add(randNum);
		randNum.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(element == arraySize)
			showStatus("You are only tossing the Dice 20 times.");
		
		//a random value is picked from 1-6
		value = rand.nextInt(6);
		value += 1;
		
		//array stores the value that was randomly picked
		dataArr[element] = value;
		
		//a counter is attached to this array
		if(value ==1)
			++counterArr[value-1];
		
		if(value ==2)
			++counterArr[value-1];
		
		if(value ==3)
			++counterArr[value-1];
		
		if(value ==4)
			++counterArr[value-1];
		
		if(value ==5)
			++counterArr[value-1];
		
		if(value ==6)
			++counterArr[value-1];
		
		element++;
		repaint();
		
	}
	
	
	//the results are displayed showing how many times each number from 1-6
	//appeared when the dice was tossed 20 times
	public void paint(Graphics g)
	{
		int xpos = 20, ypos = 80;
		
		for(int accumulator=1; accumulator <= counterArr.length; accumulator++)
		{
			g.drawString(accumulator + " appeared on the dice " + counterArr[accumulator-1] + " times.", xpos, ypos);
			ypos+=30;
		}
	}
	
}

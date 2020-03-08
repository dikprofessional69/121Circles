package driver;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import circles.Circle;
import circles.Effects;



public class Run implements ActionListener,MouseMotionListener{
	JFrame jFrame;
	int index=0;
	Circle circle[]=new Circle[300];
	Graphics graphics;
	JButton Demo,resetvisual,visual,reset,showCircles,addPattern,pattern1,pattern2,pattern3,pattern4,pattern5;
	JTextField pattern1level,pattern2level,pattern3level,pattern4level,pattern5level;
	JTextField pattern1Color,pattern2Color,pattern3Color,pattern4Color,pattern5Color;
	JTextField pattern1Sleep,pattern2Sleep,pattern3Sleep,pattern4Sleep,pattern5Sleep;
	JTextField loopsField;
	Font myFont = new Font ("Arial", 1, 17);
	int number_of_patterns=0;
	String patternString[]=new String[1000];
	
	int mouseTemp=0;
	int patternIndex=0;
	int colorIndex=0; 
	Color color[]=new Color[1000];
	int levels[]=new int[1000];
	Effects effects;
	
	public static void main(String args[]){
		new Run();
		
		
		
	} 
			
	public Run(){
		jFrame=new JFrame("Circles121");
		jFrame.setSize(1000,700);
		jFrame.getContentPane().setBackground(Color.BLACK);
		showCircles=new JButton("Start");
		pattern1=new JButton("Pattern 1");
		pattern2=new JButton("Pattern 2");
		pattern3=new JButton("Pattern 3");
		pattern4=new JButton("Pattern 4");
		pattern5=new JButton("Pattern 5");
		addPattern=new JButton("AddPattern");
		resetvisual=new JButton("ResetVisual");
		reset=new JButton("Reset");
		visual=new JButton("Visual Loop");
		Demo=new JButton("Demo");
		
		pattern1level=new JTextField();
		pattern2level=new JTextField();
		pattern3level=new JTextField();
		pattern4level=new JTextField();
		pattern5level=new JTextField();
		
		pattern1Color=new JTextField();
		pattern2Color=new JTextField();
		pattern3Color=new JTextField();
		pattern4Color=new JTextField();
		pattern5Color=new JTextField();
		
		pattern1Sleep=new JTextField();
		pattern2Sleep=new JTextField();
		pattern3Sleep=new JTextField();
		pattern4Sleep=new JTextField();
		pattern5Sleep=new JTextField();
		
		loopsField=new JTextField();
		
		
		pattern1.setBounds(500,50,120,50);
		pattern2.setBounds(500,100,120,50);
		pattern3.setBounds(500,150,120,50);
		pattern4.setBounds(500,200,120,50);
		pattern5.setBounds(500,250,120,50);
		showCircles.setBounds(175,430,120, 50);
		addPattern.setBounds(500,430,120, 50);
		reset.setBounds(650,430,120,50);
		visual.setBounds(800,430,120,50);
		resetvisual.setBounds(800,500,120,50);
		Demo.setBounds(650,500,120,50);
		pattern1level.setBounds(650,57,60,35);
		pattern2level.setBounds(650,107,60,35);
		pattern3level.setBounds(650,157,60,35);
		pattern4level.setBounds(650,207,60,35);
		pattern5level.setBounds(650,257,60,35);
		
		pattern1Color.setBounds(725,57,60,35);
		pattern2Color.setBounds(725,107,60,35);
		pattern3Color.setBounds(725,157,60,35);
		pattern4Color.setBounds(725,207,60,35);
		pattern5Color.setBounds(725,257,60,35);
		

//		pattern1Sleep.setBounds(800,57,60,35);
//		pattern2Sleep.setBounds(800,107,60,35);
		pattern3Sleep.setBounds(800,57,60,35);
		loopsField.setBounds(875,57,60,35);
//		pattern5Sleep.setBounds(800,257,60,35);
//		
		
		
		jFrame.setVisible(true);
		
		jFrame.setLayout(null);
		jFrame.setResizable(false);
	    
		
		jFrame.add(showCircles);
		jFrame.add(pattern1);
		jFrame.add(pattern2);
		jFrame.add(pattern3);
		jFrame.add(pattern4);
		jFrame.add(pattern5);
		jFrame.add(addPattern);
		jFrame.add(reset);
		jFrame.add(visual);
		jFrame.add(resetvisual);
//		jFrame.add(Demo);
		
		jFrame.add(pattern1level);
		jFrame.add(pattern2level);
		jFrame.add(pattern3level);
		jFrame.add(pattern4level);
		jFrame.add(pattern5level);
		
//		jFrame.add(pattern1Sleep);
//		jFrame.add(pattern2Sleep);
		jFrame.add(pattern3Sleep);
		jFrame.add(loopsField);
//		jFrame.add(pattern5Sleep);

		
		jFrame.add(pattern1Color);
		jFrame.add(pattern2Color);
		jFrame.add(pattern3Color);
		jFrame.add(pattern4Color);
		jFrame.add(pattern5Color);
		
		pattern1.addActionListener(this);
		pattern2.addActionListener(this);
		pattern3.addActionListener(this);
		pattern4.addActionListener(this);
		pattern5.addActionListener(this);
		
		jFrame.addMouseMotionListener(this);
		visual.addActionListener(this);
		showCircles.addActionListener(this);
		addPattern.addActionListener(this);
		reset.addActionListener(this);
		resetvisual.addActionListener(this);
//		Demo.addActionListener(this);
		
		graphics=jFrame.getGraphics();
		
		
		
	
	}
	public Color checkColor(String col) {
		if(col!="RGB") {
//			System.out.println("CAlled string");
			if(col.equals("R")){
				return Color.RED;				
			}
			if(col.equals("G")) {
				return Color.GREEN;	
			}
			if(col.equals("B")) {
				return Color.BLUE;								
			}
		}
		return	Color.WHITE;
	}
	
	 void circleReset() {
		for(int i=1;i<=11;i++) {
			for(int j=1;j<=11;j++) {
				try {
					circle[index++]=new Circle(index,jFrame.getGraphics(),i*40,j*40);
				}
				catch(Exception exception){
					System.out.println(exception.getMessage());
				}
					
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		String colorString[]=new String[5];
//		int level[]=new int[5];
		
	
		if(e.getSource()==showCircles) {
			
			pattern1level.setText("0");
			pattern2level.setText("0");
			pattern3level.setText("0");
			pattern4level.setText("0");
			pattern5level.setText("0");
			
			pattern3Sleep.setText("1000");
			
			pattern1Color.setText("RGB");
			pattern2Color.setText("RGB");
			pattern3Color.setText("RGB");
			pattern4Color.setText("RGB");
			pattern5Color.setText("RGB");
			loopsField.setText("2");
		//here paste
			circleReset();
			effects=new Effects(circle,graphics);
			
		}
		
		if(e.getSource()==pattern1){
			String tempString=pattern1Color.getText();
			int tempLevel=Integer.parseInt(pattern1level.getText());
			levels[patternIndex]=tempLevel;
			color[patternIndex]=checkColor(tempString);
			
			effects.getEffect("pattern1", color[patternIndex], levels[patternIndex]);
			
			number_of_patterns++;
			patternString[patternIndex++]="pattern1";
			
			
		}
		if(e.getSource()==pattern2){
			String tempString=pattern2Color.getText();
			color[patternIndex]=checkColor(tempString);
			
			int tempLevel=Integer.parseInt(pattern2level.getText());
			levels[patternIndex]=tempLevel;
			
			effects.getEffect("pattern2",   color[patternIndex], levels[patternIndex]);
			
			number_of_patterns++;
			patternString[patternIndex++]="pattern2";
		}
		if(e.getSource()==pattern3){
			String tempString=pattern3Color.getText();
			color[patternIndex]=checkColor(tempString);
			
			int tempLevel=Integer.parseInt(pattern3level.getText());
			levels[patternIndex]=tempLevel;
			
			effects.getEffect("pattern3", color[patternIndex], levels[patternIndex]);
			
			number_of_patterns++;
			patternString[patternIndex++]="pattern3";
		}
		if(e.getSource()==pattern4){
			String tempString=pattern4Color.getText();
			color[patternIndex]=checkColor(tempString);
			
			int tempLevel=Integer.parseInt(pattern4level.getText());
			levels[patternIndex]=tempLevel;
			
			effects.getEffect("pattern4", color[patternIndex], levels[patternIndex]);
			
			number_of_patterns++;
			patternString[patternIndex++]="pattern4";
		}
		if(e.getSource()==pattern5){
			String tempString=pattern5Color.getText();
			color[patternIndex]=checkColor(tempString);
			
			int tempLevel=Integer.parseInt(pattern5level.getText());
			levels[patternIndex]=tempLevel;
			
			effects.getEffect("pattern5", color[patternIndex], levels[patternIndex]);
			
			number_of_patterns++;
			patternString[patternIndex++]="pattern5";
		}
		
		if(e.getSource()==reset){
			number_of_patterns=0;
			patternIndex=0;
			circleReset();
		}
		if(e.getSource()==addPattern){
			
			
			
//			
//			level[0]=Integer.parseInt(pattern1level.getText());
//			level[1]=Integer.parseInt(pattern2level.getText());
//			level[2]=Integer.parseInt(pattern3level.getText());
//			level[3]=Integer.parseInt(pattern4level.getText());
//			level[4]=Integer.parseInt(pattern5level.getText());
//			
			int tempSleep=Integer.parseInt(pattern3Sleep.getText());
			
				
					
				
			

			effects.storePattern(patternString,number_of_patterns,color,levels,tempSleep);
//			System.out.println(effects.patternOrderString);
//			effects.dev();
			number_of_patterns=0;
			patternIndex=0;
		}
		
		if(e.getSource()==visual) {
			int temploops=Integer.parseInt(loopsField.getText());
			effects.looptimes=temploops;
			effects.visualLoop();
			
		}
		
		if(e.getSource()==resetvisual) {
			effects.posIndex=0;
			effects.skipIndex=0;
		}
		
//		if(e.getSource()==Demo) {
//			effects.dev();
//		}
		
		
		
		graphics.setFont(myFont);
		graphics.setColor(Color.WHITE);
		graphics.drawString("LEVEL",661,70);
		graphics.drawString("COLOR",735,70);
		graphics.drawString("DelaySec",805,70);
		graphics.drawString("LoopTimes",880,70);
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		try {
			
			int x=e.getX();
			int y=e.getY();
			for(int i=0;i<=120;i++) {
				int subx=0;
				subx=x-circle[i].x;
				int suby=0;
				suby=y-circle[i].y;
				if(subx<0) {
					subx=subx*(-1);
				}
				if(suby<0) {
					suby=suby*(-1);
				}
				if(subx<=20 && suby<=20) {
					circle[i].turnOn(Color.WHITE);
				}
			}

		}catch (Exception exception) {
		
		}
				}
		
	}
	
	

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snack.master;

import com.sun.java.swing.plaf.windows.WindowsBorders;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Amoula
 */
public class Window extends JFrame {
    	private static final long serialVersionUID = -2542001418764869760L;
	public static ArrayList<ArrayList<DataOfSquare>> Grid;
	public static int width = 20;
	public static int height = 20;
	public Window(){
//		          JComboBox cs = new JComboBox ();
//                          cs.setSize(20, 6);
//                          cs.addItem("High");
//                          cs.addItem("Medium");
//                          cs.addItem("Low");
//                          
//                          this.add(cs);
		// Creates the arraylist that'll contain the threads
		Grid = new ArrayList<ArrayList<DataOfSquare>>();
		ArrayList<DataOfSquare> data;
		
		// Creates Threads and its data and adds it to the arrayList
		for(int i=0;i<width;i++){
			data= new ArrayList<DataOfSquare>();
			for(int j=0;j<height;j++){
				DataOfSquare c = new DataOfSquare(1);
				data.add(c);
			}
			Grid.add(data);
		}
		
		// Setting up the layout of the panel
		getContentPane().setLayout(new GridLayout(20,20,0,0));
		
		// Start & pauses all threads, then adds every square of each thread to the panel
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				getContentPane().add(Grid.get(i).get(j).square);
			}
		}
		
		// initial position of the snake
		Tuple position = new Tuple(10,10);
		// passing this value to the controller
//                
// if (cs.getSelectedIndex() == 0)
//     ThreadsController.speed = 50;
// else if (cs.getSelectedIndex() == 1)
//     ThreadsController.speed = 75 ;
// else 
//     ThreadsController.speed = 100 ;
                int l =0 ;
    String x = JOptionPane.showInputDialog("Please Enter 1 for Low  Speed OR 2 for Medium OR 3 for High ", null);
    int r = Integer.parseInt(x);
    if (r == 1)
        l = 50;
    else if (r == 2)
        l = 75 ;
    else 
        l = 100 ;
                
		ThreadsController c   = new ThreadsController(position , l);
		//Let's start the game now..
		c.start();

		// Links the window to the keyboardlistenner.
		this.addKeyListener((KeyListener) new KeyboardListener());

		//To do : handle multiplayers .. The above works, test it and see what happens
		
		//Tuple position2 = new Tuple(13,13);
		//ControlleurThreads c2 = new ControlleurThreads(position2);
		//c2.start();
		
	}
    
}

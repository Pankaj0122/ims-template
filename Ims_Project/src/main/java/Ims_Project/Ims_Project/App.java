package Ims_Project.Ims_Project;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import org.math.plot.*;
import javax.swing.JFrame;
import javax.swing.text.Position;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import org.math.plot.*;
import java.lang.Math; 


public class App {
	private static List<String> y_values;

	public static void main(String[] args) {
	List<Double> prerandx= new ArrayList<Double>();
	prerandx.add(0.0);
	prerandx.add(0.0);
	prerandx.add(0.0);
	List<Double> prerandy= new ArrayList<Double>();
	prerandy.add(0.0);
	prerandy.add(0.0);
	prerandy.add(0.0);
	String fileName = "wifigdansk.csv";//getting data from csv file 
	File file = new File(fileName);
	List<String> x_values = new ArrayList<String>();//original dataset of x values 
	List<String> y_values = new ArrayList<String>();//original dataset of x values 
	
	List<String> randomx = new ArrayList<String>();//First three random values of x-- array 
	List<String> randomy = new ArrayList<String>();//First three random values of y-- array
	
	List<Double> dist_values0 = new ArrayList<Double>();//distance value zero array has eucledian distance between centroid and each values in the data set 
	List<Double> dist_values1 = new ArrayList<Double>();//distance value one array has eucledian distance between centroid and each values in the data set 
	List<Double> dist_values2 = new ArrayList<Double>();//distance value two array has eucledian distance between centroid and each values in the data set
	
	List<String> clusterx0 = new ArrayList<String>();//cluster x zero array divided the values according to the minimum distances out of all three distance array 
	List<String> clusterx1 = new ArrayList<String>();//cluster x one array divided the values according to the minimum distances out of all three distance array
	List<String> clusterx2 = new ArrayList<String>();//cluster x two array divided the values according to the minimum distances out of all three distance array
	List<String> clustery0 = new ArrayList<String>();//cluster y zero array divided the values according to the minimum distances out of all three distance array
	List<String> clustery1 = new ArrayList<String>();//cluster y one array divided the values according to the minimum distances out of all three distance array
	List<String> clustery2 = new ArrayList<String>();//cluster y two array divided the values according to the minimum distances out of all three distance array
	
	int p=0;
	
	try {
			List<String> lines;
			Scanner inputStream = new Scanner(file); 	//Here scanner is used to scan data from the data set	
			lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            for (String line : lines) {
                String[] array = line.split(";"); //splitting lines and putting into the array 
                String[] linetext = array[0].split(",");//splitting each column and putting into the array 
                x_values.add(linetext[2]);//
                y_values.add(linetext[3]);
                             
            }
            
            
			inputStream.close();
	}	catch(Exception e) {
			e.printStackTrace();
	}
	
	x_values.remove(0);//this code is just removing the first element of the x list  
	y_values.remove(0);//this code is just removing the first element of the y lis
	System.out.println(x_values.toString());//printing the x values
	System.out.println(y_values.toString());//printing the y values
	String rx="";
	String ry="";

	// this loop is used once in a whole process to choose the first three random values of X and the Y values are selected from the same position of random value of X 
	for (int p1 = 0; p1 < 3; p1++) {
	
		Random randomizer = new Random();
		rx= x_values.get(randomizer.nextInt(x_values.size()));
		ry= y_values.get(x_values.indexOf(rx));
		randomx.add(rx);
		randomy.add(ry);	
		System.out.println("random value of x"+p1+" >>"+randomx);
		System.out.println("random value of y"+p1+" on the basis of x"+p1+" position >>"+randomy);
		
	
		
	} 
	//this loop is the number of iteration for finding clusters and it will break by itself when it will reach where the code stop finding new position of centroids.  
	while(true) {
		
		
		
	for(int k=0;k < 3;k++) 
	{		
	for (int i=0;i < x_values.size();i++) 
	{
	/*Here x1,y1 is taken as random value and converted to double. we are using k as an increment, to point the each element of 
	 of the random value list */
	double x1 = Double.parseDouble(randomx.get(k));
	double y1 = Double.parseDouble(randomy.get(k));	
	/*Here x2,y2 is taken as actual value from the given data and converted to double. we are using i as an increment, to point the each 
	 * element of the given data list */	
	String valuex2 = x_values.get(i);
	double x2 = Double.parseDouble(valuex2);	
	String valuey2 = y_values.get(i);
	double y2 = Double.parseDouble(valuey2);
	/*Eucladian distance formula is used to calculate distance for one random value t each element of the given data */
	double distance = Math.hypot(x1-x2, y1-y2);
	//populating list with eucledian distance between one random element with each element of the given data
	//this will be three time recurssive process to fill three distance matrix and making three centroids.
	if(k==0) {		
		dist_values0.add(distance);//list 1 of distances 
	}
	else if (k==1) {
		dist_values1.add(distance);//list 2 of distances
	}
	else if (k==2) {
		dist_values2.add(distance);//list 3 of distances
	}}
	}
	
	
	
	System.out.println("list 1 of eucladiean distances >> "+dist_values0);
	System.out.println("list 2 of eucladiean distances >> "+dist_values1);
	System.out.println("list 3 of eucladiean distances >> "+dist_values2);
	
	
	//this loop is making the clusters on the behalf of distances i.e. it will compare distance in all three list of distances and the according to minmum value of distance it will throw the va
	//value in respective cluster.
	for (int j=0;j < dist_values0.size();j++) 
	{
		double col0=dist_values0.get(j);
		double col1=dist_values1.get(j);
		double col2=dist_values2.get(j);		
		if(col0 < col1 && col0 < col2) {
			String x0 = x_values.get(j);
			clusterx0.add(x0);
			String y0 = y_values.get(j);
			clustery0.add(y0);
		}
		else if (col1 < col0 && col1 < col2) {
			String x1 = x_values.get(j);
			clusterx1.add(x1);
			String y1 = y_values.get(j);
			clustery1.add(y1);
		}
		else if (col2 < col0 && col2 < col1) {
			String x2 = x_values.get(j);
			clusterx2.add(x2);
			String y2 = y_values.get(j);
			clustery2.add(y2);
		}	
		
	}
	
	
		
	Double b0=0.0, b1=0.0, b2=0.0, by0=0.0, by1=0.0, by2=0.0;		
	int c0= 0, c1= 0, c2= 0, cy0= 0, cy1= 0, cy2= 0;
		// converting the cluster string values into double values as well as taking the toatl sum into the b variable
	for (int q0 = 0; q0 < clusterx0.size(); q0++) {
		Double a0=Double.parseDouble(clusterx0.get(q0));
		c0= clusterx0.size();		
		b0 =(b0 + a0);
		Double ay0=Double.parseDouble(clustery0.get(q0));
		cy0= clustery0.size();		
		by0 =(by0 + ay0);
		
	}
	for (int q1 = 0; q1 < clusterx1.size(); q1++) {
		Double a1=Double.parseDouble(clusterx1.get(q1));
		c1= clusterx1.size();		
		b1 =(b1 + a1);
		Double ay1=Double.parseDouble(clustery1.get(q1));
		cy1= clustery1.size();		
		by1 =(by1 + ay1);
	}
	for (int q2 = 0; q2 < clusterx2.size(); q2++) {
		Double a2=Double.parseDouble(clusterx2.get(q2));
		c2= clusterx2.size();		
		b2 =(b2 + a2);	
		Double ay2=Double.parseDouble(clustery2.get(q2));
		cy2= clustery2.size();		
		by2 =(by2 + ay2);
	}
	
	// dividing the (total sum of the element in the cluster)/(total number of elements in a cluster) 
	 b0 = b0/c0;
	 b1 = b1/c1;
	 b2 = b2/c2;
	 by0 = by0/cy0;
	 by1 = by1/cy1;
	 by2 = by2/cy2;
	 //taking difference of previous previous mean value to the new mean value 
	 double distance1 = Math.hypot(b0-prerandx.get(0), by0-prerandy.get(0));
	 double distance2 = Math.hypot(b1-prerandx.get(1), by1-prerandy.get(1));
	 double distance3 = Math.hypot(b2-prerandx.get(2), by2-prerandy.get(2));

	 //clear the list 
	 prerandx.clear();
	 prerandy.clear();
	 //add new values 
	 prerandx.add(b0);
	 prerandx.add(b1);
	 prerandx.add(b2);
	 prerandy.add(by0);
	 prerandy.add(by1);
	 prerandy.add(by2);
	//clear the list
	 randomx.clear();
	 randomy.clear();
	 //add new values 
	 randomx.add(Double.toString(b0));
	 randomx.add(Double.toString(b1));
	 randomx.add(Double.toString(b2));
	 randomy.add(Double.toString(by0));
	 randomy.add(Double.toString(by1));
	 randomy.add(Double.toString(by2));
	 
	 
	 //print the distance: when this valueswill become zero the iteration willl stop 
	 System.out.println(distance1);
	 System.out.println(distance2);
	 System.out.println(distance3);
	 if (distance1==0) {
		 if (distance2==0) {
			 if (distance3==0) {
				 System.out.println("loop break");
				 break;
				
			}}}
	 
	 
	 
	 //clear the previous values from the cluster 
	 clusterx0.clear();
	 clusterx1.clear();
	 clusterx2.clear();
	 clustery0.clear();
	 clustery1.clear();
	 clustery2.clear();
	 dist_values0.clear();
	 dist_values1.clear();
	 dist_values2.clear();
	
	
	
	}
 		 //here code is written to plot three cluster on the graph 
	 double[] px1 = new double[clusterx0.size()];
	 double[] px2 = new double[clusterx1.size()];
	 double[] px3 = new double[clusterx2.size()];
	 double[] py1 = new double[clustery0.size()];
	 double[] py2 = new double[clustery1.size()];
	 double[] py3 = new double[clustery2.size()];
	//clusters values are converter to double and populating the px's and py's array  
	 for (int q0 = 0; q0 < clusterx0.size(); q0++) {		 
		 double a0=Double.parseDouble(clusterx0.get(q0));
		 px1[q0]=a0;
		 double ay0=Double.parseDouble(clustery0.get(q0));
		 py1[q0]=ay0;
	 }
	 
	 for (int q1 = 0; q1 < clusterx1.size(); q1++) {
		 double a1=Double.parseDouble(clusterx1.get(q1));
		 px2[q1]=a1;
		 double ay1=Double.parseDouble(clustery1.get(q1));
		 py2[q1]=ay1;
	 }
	 
	 for (int q2 = 0; q2 < clusterx2.size(); q2++) {
		 double a2=Double.parseDouble(clusterx2.get(q2));
		 px3[q2]=a2;
		 double ay2=Double.parseDouble(clustery2.get(q2));
		 py3[q2]=ay2;
	 }
	 // create your PlotPanel (you can use it as a JPanel)
	 	  Plot2DPanel plot = new Plot2DPanel();
		    
		  // add a line plot to the PlotPanel
		  // three cluster plot
		  plot.addScatterPlot("my plot",px1 , py1);
		  plot.addScatterPlot("my plot",px2 , py2);
		  plot.addScatterPlot("my plot",px3 , py3);
		 
		  // put the PlotPanel in a JFrame, as a JPanel
		  JFrame frame = new JFrame("a plot panel");
		  frame.setContentPane(plot);
		  frame.setVisible(true);
	 	
	}}	

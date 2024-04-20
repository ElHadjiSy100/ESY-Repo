package ESY_Assignment5_Complete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class TwoDimRaggedArrayUtility {
	
	public TwoDimRaggedArrayUtility() {
		
	}
	
	public static double[][] readFile(File file) throws FileNotFoundException{
		Scanner fileReader = new Scanner(file);
		int max = 10; 
		
		String [][] arr = new String[max][max];
		
		int intitalIndex = 0;
		while(fileReader.hasNextLine()) {
			String str = fileReader.nextLine();
			String[] array = str.split(" ");
			for(int j = 0; j < array.length; j++) {
				arr[intitalIndex][j] = array[j];
			}
			intitalIndex++;
		}
		
		int rowCount = 0; 
		for(int i = 0; i < arr.length; i++) {
			if(arr[i][0] != null) {
				rowCount++;
			}
		}
		
		int colCount;
		double[][] doubleArray = new double[rowCount][];
		for(int i = 0; i < rowCount; i++) {
			colCount = 0;
			for(int j = 0; j < max; j++) {
				if(arr[i][j] != null) {
					colCount++;
				} else {
					break;
				}
			}
			doubleArray[i] = new double[colCount];
			for(int k = 0; k < doubleArray[i].length; k++) {
				doubleArray[i][k] = Double.parseDouble(arr[i][k]);
			}
		}
		fileReader.close();
		return doubleArray;
		
	}
	
	  public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		PrintWriter printOut = new PrintWriter(outputFile);
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; i++) {
				printOut.print(data[i][j] + " ");
			}
			printOut.print("\n");
		}
		printOut.close();
	}
	  
	  public static double getTotal(double[][] data) {
		  double total = 0.0; 
		  for(int i = 0; i < data.length; i++) {
			  for(int j = 0; j < data[i].length; j++) {
				  total += data[i][j];
			  }
		  }
		  return total;
	  }
	  
	  public static double getAverage(double[][] data) {
		  int count = 0;
		  double total = 0.0; 
		  for(int i = 0; i < data.length; i++) {
			  for(int j = 0; i < data[i].length; i++) {
				  total +=  data[i][j];
				  count++;
			  }
		  }
		  return(total/count);
	  }
	  
	  public static double getRowTotal(double[][] data, int row) {
		  double rowTotal = 0.0;	
		  for(int col = 0; col < data[row].length; col++) {
			  rowTotal += data[row][col];
		  }
		  return rowTotal; 
	  }
	  
	  public static double getColumnTotal(double[][] data, int col) {
		  double colTotal = 0.0; 
		  for(int row = 0; row < data.length; row++) {
			  if(col < data[row].length ) {
				  colTotal += data[row][col];
			  }
		  }
		  return colTotal;
	  }
	  
	  public static double getHighestInRow(double[][] data, int row) {
		  double highest = -1; 
		  for(int col = 0; col < data[row].length; col++) {
			  if(data[row][col] > highest) {
				  highest = data[row][col];
			  }
		  }
		  return highest;
	  }
	  
	  public static int getHighestInRowIndex(double[][] data, int row) {
		  int index = 0;
		  double highest = -1; 
		  for(int col = 0; col < data[row].length; col++) {
			  if(data[row][col] > highest) {
				  highest = data[row][col];
				  index = col;
			  }
		  }
		  return index;
	  }
	  
	  public static double getLowestInRow(double[][] data, int row) {
		  double lowest = Integer.MAX_VALUE; 
		  for(int col = 0; col < data[row].length; col++) {
			  if(data[row][col] < lowest) {
				  lowest = data[row][col];
			  }
		  }
		  return lowest;
	  }
	  
	  public static int getLowestInRowIndex(double[][] data, int row) {
		  int index = 0;
		  double lowest = Integer.MAX_VALUE; 
		  for(int col = 0; col < data[row].length; col++) {
			  if(data[row][col] < lowest) {
				  lowest = data[row][col];
				  index = col;
			  }
		  }
		  return index;
	  }
	  
	  public static double getHighestInColumn(double[][] data, int col) {
		  double highest = -1; 
		  for(int row = 0; row < data.length; row++) {
			  if(col < data[row].length && data[row][col] > highest) {
				  highest = data[row][col];
			  }
		  }
		  return highest;
	  }
	  
	  public static int getHighestInColumnIndex(double[][] data, int col) {
		  int index = 0;
		  double highest = -1; 
		  for(int row = 0; row < data.length; row++) {
			  if(col < data[row].length && data[row][col] > highest) {
				  highest = data[row][col];
				  index = row;
			  }
		  }
		  return index;
	  }
	  
	  public static double getLowestInColumn(double[][] data, int col) {
		  double lowest = Integer.MAX_VALUE; 
		  for(int row = 0; row < data.length; row++) {
			  if(col < data[row].length && data[row][col] < lowest) {
				  lowest = data[row][col];
			  }
		  }
		  return lowest;
	  }
	  
	  public static int getLowestInColumnIndex(double[][] data, int col) {
		  int index = 0;
		  double lowest = Integer.MAX_VALUE; 
		  for(int row = 0; row < data.length; row++) {
			  if(col < data[row].length && data[row][col] < lowest) {
				  lowest = data[row][col];
				  index = row;
			  }
		  }
		  return index;
	  }
	  
	  public static double getHighestInArray(double [][] data) {
		  double highest = -1;
		  for(int i = 0; i < data.length; i++) {
			  for(int j = 0; j < data[i].length; j++) {
				  if(highest < data[i][j]) {
					  highest = data[i][j];
				  }
			  }
		  }
		  return highest;
	  }
	  
	  public static double getLowestInArray(double [][] data) {
		  double lowest = Integer.MAX_VALUE;
		  for(int i = 0; i < data.length; i++) {
			  for(int j = 0; j < data[i].length; j++) {
				  if(lowest > data[i][j]) {
					  lowest = data[i][j];
				  }
			  }
		  }
		  return lowest;
	  }
}

package complexmatrix;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComplexMatrix {

	private Complex[][] matrix;

	public ComplexMatrix(int m, int n) {
		this.matrix = new Complex[m][n];
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++) this.matrix[i][j] = new Complex();
	}

	public ComplexMatrix(Complex[][] input) {
		this.matrix = input;
	}

	public Complex[][] getMatrix() {
		return this.matrix;
	}

	public int getRows() {
		return this.matrix.length;
	}

	public int getCols() {
		return this.matrix[0].length;
	}

	public ComplexMatrix add(ComplexMatrix cm) throws MatrixDimensionException {
		if(this.getRows() != cm.getRows() || this.getCols() != cm.getCols())
			throw new MatrixDimensionException(
					"Dimension Mismatch: m x n matrix can only be added with m x n matrix");
		Complex[][] newMatrix = new Complex[this.getRows()][this.getCols()];
		for(int i=0; i<this.getRows(); i++) {
			for(int j=0; j<this.getCols(); j++) {
				newMatrix[i][j] = this.getMatrix()[i][j].add(cm.getMatrix()[i][j]);
			}
		}
		return new ComplexMatrix(newMatrix);
	}

	public ComplexMatrix multiply(ComplexMatrix cm) throws MatrixDimensionException {
		if(this.getCols() != cm.getRows())
			throw new MatrixDimensionException(
					"Dimension Mismatch: a x m matrix can be only multipled with m x b matrix");
		ComplexMatrix newMatrix = new ComplexMatrix(this.getRows(), cm.getCols());
		for(int i=0; i<this.getRows(); i++) {
			for(int j=0; j<cm.getCols(); j++) {
				for(int k=0; k<cm.getRows(); k++) {
					newMatrix.getMatrix()[i][j] = newMatrix.getMatrix()[i][j].add(
							this.getMatrix()[i][k].multiply(cm.getMatrix()[k][j]));
				}
			}
		}
		return newMatrix;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; j < this.getCols(); j++) {
				sb.append(matrix[i][j] + "\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static ComplexMatrix read(String fileName) throws IncompatibleMatrixException {
		try {
			Scanner in = new Scanner(new FileReader(fileName));
			List<String> sb = new ArrayList<>();
			int cols = 0;
			while(in.hasNext()) {
			    String complexString = in.nextLine().trim();
			    if(cols > 0 && complexString.split(" ").length != cols)
			    	throw new IncompatibleMatrixException("IncompatibleMatrixException: mismatch in size of rows");
			    cols = complexString.split(" ").length;
			    sb.add(complexString);
			}
			in.close();
			Complex[][] inputMatrix = new Complex[sb.size()][cols];
			for(int i=0; i<sb.size(); i++) {
				String[] parsedLine = sb.get(i).split(" ");
				for(int j=0; j<cols; j++) {
					String[] parsedComplexString = parsedLine[j].split("_");
					inputMatrix[i][j] = new Complex(
							Double.parseDouble(parsedComplexString[0]), Double.parseDouble(parsedComplexString[1]));
				}
			}
			return new ComplexMatrix(inputMatrix);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new ComplexMatrix(1, 1);
	}

	public void write(String fileName) {	
        PrintWriter out = null;	
        try {	
            out = new PrintWriter(new FileWriter(fileName));	
            for(Complex[] comArray : this.getMatrix()) {
            	StringBuilder outputLine = new StringBuilder("");
            	for(Complex comp : comArray) {
            		outputLine.append(comp.getReal() +"_"+comp.getImaginary() +" ");
            	}
            	out.println(outputLine);
            }  
        } catch (IndexOutOfBoundsException e) {	
            System.err.println("Caught IndexOutOfBoundsException: " + e.getMessage());	
        } catch (IOException e) {	
            System.err.println("Caught IOException: " + e.getMessage());	
        } finally {	
            if (out != null) {	
                System.out.println("Closing PrintWriter");	
                out.close();	
            } else {	
                System.out.println("PrintWriter not open");	
            }	
        }	
    }

	public static void main(String[] args) {
		// test complex numbers
		System.out.println(new Complex(2., 2.));
		System.out.println(new Complex(-2., 2.));
		System.out.println(new Complex(2., -2.));
		System.out.println(new Complex(-2., -2.));
		// verify 0 magnitude complex matrix
		ComplexMatrix cm = new ComplexMatrix(2, 2);
		System.out.println(cm.toString());
		try {
			ComplexMatrix complexmatrix1 = ComplexMatrix.read("complexmatrix1.txt");
			ComplexMatrix complexmatrix2 = ComplexMatrix.read("complexmatrix2.txt");
			ComplexMatrix complexmatrix3 = ComplexMatrix.read("complexmatrix3.txt");

			System.out.println("\nPrinting complexmatrix1: \n\n" + complexmatrix1 + "\nDone!");
			System.out.println("\nPrinting complexmatrix2: \n\n" + complexmatrix2 + "\nDone!");
			System.out.println("\nPrinting complexmatrix3: \n\n" + complexmatrix3 + "\nDone!");
			System.out.println("\nPrinting 2 * complexmatrix1 : \n\n" + complexmatrix1.add(complexmatrix1) + "\nDone!");

			ComplexMatrix complexmatrix4 = complexmatrix1.multiply(complexmatrix2);
			System.out.println(
					"\nPrinting complexmatrix1 x complexmatrix2: \n\n" + complexmatrix4 + "\nDone!");
			// Test writing to file
			complexmatrix4.write("complexmatrix4.txt");
			ComplexMatrix complexmatrix5 = ComplexMatrix.read("complexmatrix4.txt");
			System.out.println(
					"\nPrinting complexmatrix4 == complexmatrix5 : \n\n" + complexmatrix5 + "\nDone!");
		} catch (IncompatibleMatrixException e) {
			System.out.println(
					"IncompatibleMatrixException: The rows in the input file have varying columns!" + e.getMessage());
		} catch (MatrixDimensionException e) {
			// TODO Auto-generated catch block
			System.out.println("MatrixDimensionException: " + e.getMessage());
		}

		
		try {
			ComplexMatrix brokenmatrix = ComplexMatrix.read("brokenmatrix.txt");
			System.out.println(brokenmatrix);
		} catch (IncompatibleMatrixException e) {
			System.out.println("\nCannot input brokenmatrix: " + e.getMessage());
		}

		try {
			ComplexMatrix complexmatrix2 = ComplexMatrix.read("complexmatrix2.txt");
			ComplexMatrix complexmatrix3 = ComplexMatrix.read("complexmatrix3.txt");
			System.out.println(complexmatrix2.multiply(complexmatrix3));
		} catch (IncompatibleMatrixException e) {
			e.printStackTrace();
		} catch (MatrixDimensionException e) {
			System.out.println(
					"\nMatrixDimensionException: cannot mul complexmatrix2 and complexmatrix3: " + e.getMessage());
		}
	}
}

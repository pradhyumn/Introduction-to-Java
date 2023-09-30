import java.io.*;

import java.util.List;
import java.util.ArrayList;


public class ListOfNumbers {

    private List<RDFTriple<Integer, Integer, Integer>> rdfTripleList;
    private String fileName;

    public ListOfNumbers() {
        // create an ArrayList of Pairs of Integers
    	rdfTripleList = new ArrayList<>();
    }

    public ListOfNumbers(String fileName) {
    	this();
    	this.fileName = fileName;	
    }

    public List<RDFTriple<Integer, Integer, Integer>> getRdfTripleList() {
    	return this.rdfTripleList;
    }

    public void createList() {
    	for (int i=0; i<100; i++) {
    		Integer number1 = (int) (Math.random()*10000);
    		Integer number2 = (int) (Math.random()*10000);
    		Integer number3 = (int) (Math.random()*10000);
    		rdfTripleList.add(new RDFTriple<Integer, Integer, Integer>(number1, number2, number3));
    	}
    }
    
    public void readList() {
    	this.rdfTripleList = new ArrayList<RDFTriple<Integer, Integer, Integer>>();
    	try {
    		FileReader fr = new FileReader(this.fileName);
    		BufferedReader br = new BufferedReader(fr);
    		String line = br.readLine();

    		while(line != null) {
    			System.out.println(line);
    			String[] splitted = line.split(" ");
    			this.rdfTripleList.add(
    					new RDFTriple<Integer, Integer, Integer>(
								Integer.parseInt(splitted[0]), 
								Integer.parseInt(splitted[1]), 
								Integer.parseInt(splitted[2]))
    					);
    			line = br.readLine();
    		}
    		br.close();
    		fr.close();
    		//Printing the list!
    		System.out.println(rdfTripleList);
    	} catch(IndexOutOfBoundsException ex) {
    		System.out.println("Index out of bound: " + ex.getMessage());
    	} catch(FileNotFoundException fne) {
    		System.out.println("File not found!: " + fne.getMessage());
    	} catch(IOException ex) {
    		System.out.println("IOException while reading numberfile.txt!: " + ex.getMessage());
    	}
    }
    
    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            // out = new PrintWriter(new FileWriter(this.fileName));
            out = new PrintWriter(new FileWriter("outFile.txt"));
            for (int i = 0; i < rdfTripleList.size(); i++)
            	out.println(
            			rdfTripleList.get(i).getSubj() + " " +
            			rdfTripleList.get(i).getPred() + " " +
            			rdfTripleList.get(i).getObj());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
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
    
    public static void cat(String fileName) {
        RandomAccessFile input = null;
        String line = null;
        File file = new File(fileName);
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
            return;
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
        return;
    }
    
    public static void main(String[] args) {
    	ListOfNumbers listOfNumbers = new ListOfNumbers("numberfile.txt");
    	System.out.println("Reading from file numberfile.txt...\n\n");
    	listOfNumbers.readList();
    	listOfNumbers.writeList();
    	System.out.println("\nReading from outext.txt...\\n\\n");
    	ListOfNumbers.cat("outext.txt");
    }

}

package LectureCSV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class ReadCSVFile {
	
	public static void main(String[] args) {
		List<String[]> data = null;
		String fileName = "C:/Users/slassoua/Desktop/file.csv";
		//data = readFromCsvFile(",",fileName);
		data = read('$',fileName);
		
		for (String[] str : data) {
			for (String s : str) {
				System.out.println(s);
			}
			System.out.println("saut de ligne");
		}
		
		
	}
	
	public static List<String[]> readFromCsvFile(String separator, String fileName){
	    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
	        List<String[]> list = new ArrayList<>();
	        String line = "";
	        while((line = reader.readLine()) != null){
	            String[] array = line.split(separator);
	            list.add(array);
	        }
	        return list;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }  
	}
	
	
	public static List<String[]> read(char separator, String fileName) {
		List<String[]> data = null;
		try(CSVReader reader = new CSVReader(new FileReader(fileName), separator)){
			//CSVReader reader = new CSVReader(new FileReader(fileName)) // , par defaut
	        data = reader.readAll();
	        // Do something with the data
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}

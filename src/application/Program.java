package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> election = new HashMap<>();
		
		System.out.print("Enter file full path: ");
		String path = sc.next();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while (line != null) {
				String[] v = line.split(";");
				if (election.containsKey(v[0])) {
					election.put(v[0], election.get(v[0]) + Integer.parseInt(v[1]));	
				} else {
					election.put(v[0], Integer.parseInt(v[1]));
				}
				line = br.readLine();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		for (String key : election.keySet()) {
			System.out.println(key + ": " + election.get(key));
		}
		
		sc.close();

	}

}

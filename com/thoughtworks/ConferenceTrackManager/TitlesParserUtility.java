package com.thoughtworks.ConferenceTrackManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Utility class that
 * parses the list of titles provided to it
 * and prepares a map to be returned to scheduler
 * @author akanchan
 */
public class TitlesParserUtility {
	public LinkedHashMap<String,String> titlesAndDurationMap = new LinkedHashMap<String,String>();
	
	/**
	 * Method to populate the Linked<HashMap>
	 * Key-TitleName(eg:Lua for the Masses 30min)
	 * Value-Duration(eg:30)
	 * @param fileLoc
	 * @return LinkedHashMap<String,String>
	 * @throws IOException
	 */
	public LinkedHashMap<String,String> populateTitleDurationMap(String fileLoc){
		File titleFile = new File(fileLoc);
		try{
			Scanner s = new Scanner(titleFile);
			int lineNum=1;
			while (s.hasNextLine()) {
			 String line = s.nextLine();
			 String[] lineTokens = line.split("\\s");
			 if("lightning".equals(lineTokens[lineTokens.length-1])){
				 //for lightning sessions
				 titlesAndDurationMap.put(line, "5");
			 } else{
				 //for rest of the sessions
				 titlesAndDurationMap.put(line, lineTokens[lineTokens.length-1].substring(0,2));
			 }	 
			 lineNum++;
			}
			s.close();
		} catch(FileNotFoundException e){
			System.out.println("We are sorry, but the file name your provides seems invalid. Please check and provide a valid file name");
		}	
	    return titlesAndDurationMap;
	 }

}
	


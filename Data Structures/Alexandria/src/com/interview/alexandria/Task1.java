package com.interview.alexandria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Task1 {

	public static final Logger log = Logger.getLogger(Task1.class.getName());
	public static final ArrayList<String> stopWordsList = new ArrayList<String>();

	static {
		initializeStopWordDict();
	}

	public static void initializeStopWordDict() {

		// initializing stop words
		// remove "of", "ceo", "country names"
		//	Source : https://www.mkyong.com/java/display-a-list-of-countries-in-java/
		for (String eachstr : Locale.getISOCountries()) {
			Locale obj = new Locale("", eachstr);
			stopWordsList.add(obj.getDisplayCountry().toLowerCase());
		}

		stopWordsList.add("of");
		stopWordsList.add("ceo");
	}

	public static String getCompany(String line) {

		ArrayList<String> splitLines = new ArrayList<String>(Arrays.asList(line.split(" ")));

		Iterator<String> listItr = splitLines.iterator();

		while (listItr.hasNext()) {

			String value = listItr.next();

			if (stopWordsList.contains(value.toLowerCase())) {
				listItr.remove();
			}
		}

		int i ;

		for (i = splitLines.size() - 1; i >= 0;) {

			String lowerCaseWord = splitLines.get(i).toLowerCase();

			String actualWord = splitLines.get(i);

			if (actualWord.equals(lowerCaseWord)) {
				i += 1;
				break;
			}

			else {
				i--;
			}
		}
		
		

		return line.substring(line.lastIndexOf(splitLines.get(i)), line.length());
	}

	public static String manipulateCompany(String line) {

		String removedApostrophe = line.replace("'s", "");

		String removedSpecialDoubleQuotes = removedApostrophe.replace("\"", "");

		return getCompany(removedSpecialDoubleQuotes);

	}

	public static void main(String[] args) {
		// print a file line by line

		BufferedReader bReader = null;
		BufferedWriter bWriter = null;

		try {

			bReader = new BufferedReader(new FileReader("./input/task1.txt"));
			bWriter = new BufferedWriter(new FileWriter("./output/task1Output.txt"));
			String line = null;
			while ((line = bReader.readLine()) != null) {

				bWriter.write(line + "\t" + manipulateCompany(line) + "\n");
			}

		} catch (FileNotFoundException e) {

			log.log(Level.INFO, "Exception occured while reading the file", e);

		} catch (IOException e) {

			log.log(Level.INFO, "Exception occured while reading a line", e);

		} finally {

			try {

				if (bReader != null) {
					bReader.close();
				}

				if (bWriter != null) {
					bWriter.close();
				}

			} catch (IOException e) {
				
				log.log(Level.INFO, "Problems with closing the file",e);
			}
		}
	}
}

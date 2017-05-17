package com.interview.alexandria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Task2 {

	public static Map<String, Integer> defaultRatings = new LinkedHashMap<>();
	public static final Logger logger = Logger.getLogger(Task2.class.getName());

	// There can be many product ratings in a given day
	// There can be many ratings for a given product
	// map based on date and product. date being the t
	public static Map<String, Map<String, Map<String, Integer>>> mapOfDateAndProduct = new LinkedHashMap<String, Map<String, Map<String, Integer>>>();
	public static Map<String, Map<String, Map<String, Integer>>> mapOfProductAndDate = new LinkedHashMap<String, Map<String, Map<String, Integer>>>();
	static {
		defaultRatings.put("1", 0);
		defaultRatings.put("2", 0);
		defaultRatings.put("3", 0);
		defaultRatings.put("4", 0);
		defaultRatings.put("5", 0);
		defaultRatings.put("cum_1", 0);
		defaultRatings.put("cum_2", 0);
		defaultRatings.put("cum_3", 0);
		defaultRatings.put("cum_4", 0);
		defaultRatings.put("cum_5", 0);
	}

	public static void dateMap(String line) {

		String[] array = line.split("\t");

		String dateAndDay = convertUTCToEST(array[0]);
		String product = array[1];
		String rating = array[2];
		String cum_rating = "cum_" + array[2];

		if (mapOfDateAndProduct.containsKey(dateAndDay)) {

			Map<String, Map<String, Integer>> productMap = mapOfDateAndProduct.get(dateAndDay);

			if (productMap.containsKey(product)) {

				Map<String, Integer> ratingMap = productMap.get(product);
				ratingMap.put(rating, ratingMap.get(rating) + 1);
				ratingMap.put(cum_rating, ratingMap.get(cum_rating) + 1);
				productMap.put(product, ratingMap);

			} else {

				Map<String, Integer> ratingMap = new LinkedHashMap<String, Integer>(defaultRatings);
				ratingMap.put(rating, ratingMap.get(rating) + 1);
				ratingMap.put(cum_rating, ratingMap.get(cum_rating) + 1);
				productMap.put(product, ratingMap);

			}

			mapOfDateAndProduct.put(dateAndDay, productMap);

		} else {

			Map<String, Map<String, Integer>> productMap = new LinkedHashMap<>();
			Map<String, Integer> ratingMap = new LinkedHashMap<>(defaultRatings);
			ratingMap.put(rating, ratingMap.get(rating) + 1);
			ratingMap.put(cum_rating, ratingMap.get(cum_rating) + 1);
			productMap.put(product, ratingMap);
			mapOfDateAndProduct.put(dateAndDay, productMap);

		}

	}

	public static void buildWeeklyMap(String line) {
		
		String[] array = line.split("\t");

		String dateAndDay = convertUTCToEST(array[0]);
		String product = array[1];
		String rating = array[2];
		String cum_rating = "cum_" + array[2];

		if (mapOfProductAndDate.containsKey(product)) {

			Map<String, Map<String, Integer>> dayWiseSales = mapOfProductAndDate.get(product);

			if (dayWiseSales.containsKey(dateAndDay)) {

				Map<String, Integer> ratingMap = dayWiseSales.get(dateAndDay);
				ratingMap.put(rating, ratingMap.get(rating) + 1);
				ratingMap.put(cum_rating, ratingMap.get(cum_rating) + 1);
				dayWiseSales.put(dateAndDay, ratingMap);

			} else {

				Map<String, Integer> ratingMap = new LinkedHashMap<String, Integer>(defaultRatings);
				ratingMap.put(rating, ratingMap.get(rating) + 1);
				ratingMap.put(cum_rating, ratingMap.get(cum_rating) + 1);
				dayWiseSales.put(dateAndDay, ratingMap);

			}

			mapOfProductAndDate.put(product, dayWiseSales);

		} else {

			Map<String, Map<String, Integer>> dayWiseSales = new LinkedHashMap<>();
			Map<String, Integer> ratingMap = new LinkedHashMap<>(defaultRatings);
			ratingMap.put(rating, ratingMap.get(rating) + 1);
			ratingMap.put(cum_rating, ratingMap.get(cum_rating) + 1);
			dayWiseSales.put(dateAndDay, ratingMap);
			mapOfProductAndDate.put(product, dayWiseSales);

		}
		
		
		

		
	}
	
	
	
	public static void printWeeklyMap(BufferedWriter bwriter) throws IOException{
		String line = "";
		String product = "";
		
		int prevWeek1Rating = 0;
		int prevWeek2Rating=0;
		int prevWeek3Rating=0;
		int prevWeek4Rating =0;
		int prevWeek5Rating=0;
		
		
		for (Entry<String, Map<String, Map<String, Integer>>> productEntry : mapOfProductAndDate.entrySet()) {

			product = productEntry.getKey();

			for (Entry<String, Map<String, Integer>> dateEntry : productEntry.getValue().entrySet()) {


				String[] dateWithDay = dateEntry.getKey().split(" ");
				String date = dateWithDay[0];
				String day = dateWithDay[1];
				if(day.equalsIgnoreCase("Friday")){
					line += date + "\t"+day+"\t"+ product + "\t";
					
					for (Entry<String, Integer> ratingEntry : dateEntry.getValue().entrySet()) {
						if (!ratingEntry.getKey().toString().matches("\\d")) {
							
							if(ratingEntry.getKey().equals("cum_1")){
								
								line +=Math.max(ratingEntry.getValue(), (ratingEntry.getValue()-prevWeek1Rating))+"\t";
								prevWeek1Rating = ratingEntry.getValue();
								
							}else if(ratingEntry.getKey().equals("cum_2")){
								
								line +=Math.max(ratingEntry.getValue(),(ratingEntry.getValue()-prevWeek2Rating))+"\t";
								prevWeek2Rating = ratingEntry.getValue();
								
							}else if(ratingEntry.getKey().equals("cum_3")){
								
								line +=Math.max(ratingEntry.getValue(), (ratingEntry.getValue()-prevWeek3Rating))+"\t";
								prevWeek3Rating = ratingEntry.getValue();
								
							}else if(ratingEntry.getKey().equals("cum_4")){
								
								line +=Math.max(ratingEntry.getValue(), (ratingEntry.getValue()-prevWeek4Rating))+"\t";
								prevWeek4Rating = ratingEntry.getValue();
							}else{
								
								line +=Math.max(ratingEntry.getValue(), (ratingEntry.getValue()-prevWeek5Rating))+"\n";
								prevWeek5Rating = ratingEntry.getValue();
							}
							
							
							//line += ratingEntry.getValue() + "\t";
						}
					}
					bwriter.write(line);;
					line = "";
				}
	
			}
			
			prevWeek1Rating=0;
			prevWeek2Rating=0;
			prevWeek3Rating=0;
			prevWeek4Rating=0;
			prevWeek5Rating=0;

		}
	}

	public static void printMap(BufferedWriter bWriter) throws IOException {
		String line = "";
		String product = "";

		for (Entry<String, Map<String, Map<String, Integer>>> dateEntry : mapOfDateAndProduct.entrySet()) {
			String[] dateWithDay = dateEntry.getKey().split(" ");
			String date = dateWithDay[0];

			for (Entry<String, Map<String, Integer>> productEntry : dateEntry.getValue().entrySet()) {

				product = productEntry.getKey();
				line += date + "\t" + product + "\t";

				for (Entry<String, Integer> ratingEntry : productEntry.getValue().entrySet()) {
					if (ratingEntry.getKey().toString().matches("\\d")) {
						line += ratingEntry.getValue() + "\t";
					}
				}
				bWriter.write(line + "\n");
				line = "";
			}

		}

	}

	public static String convertUTCToEST(String time) {
		String date = "";
		String day = "";

		try {
			// Timezone conversion from here
			// http://stackoverflow.com/questions/8559165/converting-date-from-utc-to-est-in-java
			
		
			DateFormat estFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
	        TimeZone estTime = TimeZone.getTimeZone("EST");
	        //set EST time zone
	        estFormat.setTimeZone(estTime);
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
	        //get GMT datetime
	        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
	        // convert to est timezone
	        String datetime = estFormat.format(sdf.parse(time));
			// get time stamp
	        Timestamp ts = Timestamp.valueOf(datetime);
			// get day of the week
			SimpleDateFormat dayofWeek = new SimpleDateFormat("EEEE");
			
			day = dayofWeek.format(ts);
			date = ts.toString().split(" ")[0];

		} catch (ParseException e) {

			logger.log(Level.INFO, "Exception occured while parsing the date", e);
		}

		return date + " " + day;
	}

	public static void main(String[] args) {

		BufferedReader bReader = null;
		BufferedWriter bWriter = null;
		BufferedWriter b2Writer = null;

		try {

			bReader = new BufferedReader(new FileReader("./input/task2.log"));
			bWriter = new BufferedWriter(new FileWriter("./output/task2Daily.txt"));
			b2Writer = new BufferedWriter(new FileWriter("./output/task2Weekly.txt"));
			String line = null;
			
			
			while ((line = bReader.readLine()) != null) {
				dateMap(line);
				buildWeeklyMap(line);
			}
			

			bWriter.write("Date\tItem\t# of 1\t# of 2\t# of 3\t# of 4\t# of 5\n");
			printMap(bWriter);
			b2Writer.write("Date\tItem\t# of 1\t# of 2\t# of 3\t# of 4\t# of 5\n");
			printWeeklyMap(b2Writer);

		} catch (FileNotFoundException e) {

			logger.log(Level.INFO, "Exception occured while reading the file", e);
		} catch (IOException e) {

			logger.log(Level.INFO, "Exception occured while writing the file", e);
		} finally {

			try {

				if (bReader != null) {

					bReader.close();
				}

				if (bWriter != null) {

					bWriter.close();
				}
				if(b2Writer!=null){
					b2Writer.close();
				}

			} catch (IOException e) {

				logger.log(Level.INFO, "Exception occured while closing the file connection", e);
			}
		}
	}

}

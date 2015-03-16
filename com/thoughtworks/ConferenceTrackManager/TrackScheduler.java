package com.thoughtworks.ConferenceTrackManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Class containing the business logic for scheduling titles
 * in tracks
 * @author akanchan
 */
public class TrackScheduler {
	/**
	 * This method does the processing of file provided
	 * via TitlesParserUtility and obtains a HashMap.
	 * It applies scheduling logic to populate a track with titles.
	 * If a track is exhausted, and there are entries remaining in HashMap,
	 * It initialises another track and tries scheduling remaining entries of the map
	 * within that track, This processing is carried on till we run out of titles
	 * (HashMap is exhausted)
	 * @param fileContainingTitleList
	 */
	public void scheduleTitlesWithinTracks(String fileContainingTitleList){
		LinkedHashMap<String,String> titleMap = new LinkedHashMap<String,String>();
		List<Track> trackList = new ArrayList<Track>();
		
		//Using TitlesParserUtility to parse input file and get the map we want to process for scheduling
		titleMap = new TitlesParserUtility().populateTitleDurationMap(fileContainingTitleList);
		
		if(titleMap.size()>0){
			Set<Entry<String, String>> set = titleMap.entrySet();
		    // Get an iterator
		    Iterator<Entry<String, String>> i = set.iterator();
		    int id=1;
		    //Do while loop to iterate the map and associate titles with tracks
			do{
				Calendar cal =  Calendar.getInstance();
				cal.set(Calendar.HOUR,9);
				cal.set(Calendar.MINUTE,00);
				Track track = new Track();				
				track.setTitleHashSet(new LinkedHashSet<String>());
				track.setId(id);
				while(cal.get(Calendar.HOUR)>=9 && cal.get(Calendar.HOUR)<12 && i.hasNext()){
					Map.Entry<String,String> me = i.next();			        
					track.getTitleHashSet().add(String.valueOf(cal.get(Calendar.HOUR))+":"+String.valueOf(cal.get(Calendar.MINUTE))+"AM "+me.getKey());
					cal.add(Calendar.MINUTE,Integer.valueOf((String) me.getValue()));					
				}
				cal.set(Calendar.HOUR_OF_DAY,12);
				cal.set(Calendar.MINUTE,00);
				if(cal.get(Calendar.HOUR_OF_DAY)==12){
					track.getTitleHashSet().add(String.valueOf(cal.get(Calendar.HOUR_OF_DAY))+":0"+String.valueOf(cal.get(Calendar.MINUTE))+"PM "+"Lunch");
					cal.add(Calendar.MINUTE,60);
				}
				cal.set(Calendar.HOUR_OF_DAY,13);
				cal.set(Calendar.MINUTE,00);
				while(cal.get(Calendar.HOUR_OF_DAY)>=13 && cal.get(Calendar.HOUR_OF_DAY)<17 && i.hasNext()){
					Map.Entry<String,String> me = i.next();
					track.getTitleHashSet().add(String.valueOf(cal.get(Calendar.HOUR))+":"+String.valueOf(cal.get(Calendar.MINUTE))+"PM "+me.getKey());
					cal.add(Calendar.MINUTE,Integer.valueOf((String) me.getValue()));
				}
				if(cal.get(Calendar.HOUR_OF_DAY)==17){
					track.getTitleHashSet().add(cal.get(Calendar.HOUR)+":00"+"PM "+"Networking Event");
					cal.add(Calendar.MINUTE,60);
				} 
				trackList.add(track);
				id++;
			}while(i.hasNext());				
		}
		
		for(Track t:trackList){
			System.out.println("------");
			System.out.println("Track"+ t.getId());
			System.out.println();
			Iterator<String> trackListIterator = t.getTitleHashSet().iterator();
			while(trackListIterator.hasNext()){
				System.out.println(trackListIterator.next());
			}
			System.out.println("------");
		}
	}
	
}

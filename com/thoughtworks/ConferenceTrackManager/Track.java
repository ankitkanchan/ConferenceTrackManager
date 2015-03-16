package com.thoughtworks.ConferenceTrackManager;
import java.util.LinkedHashSet;

/**
 * Class used by TrackScheduler
 * to instantiate track objects
 * and associate track number and
 * titles with them
 * @author akanchan
 *
 */
public class Track {
	private int Id;
	private LinkedHashSet<String> titleHashSet;	
	public Track(){
				
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @param titleHashSet the titleHashSet to set
	 */
	public void setTitleHashSet(LinkedHashSet<String> titleHashSet) {
		this.titleHashSet = titleHashSet;
	}

	/**
	 * @return the titleHashSet
	 */
	public LinkedHashSet<String> getTitleHashSet() {
		return titleHashSet;
	}

}

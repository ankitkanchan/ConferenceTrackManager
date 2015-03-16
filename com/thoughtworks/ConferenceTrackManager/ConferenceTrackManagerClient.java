/**
 * 
 */
package com.thoughtworks.ConferenceTrackManager;

/**
 * Client class for our conference track manager
 * Entry point for the application
 * @author akanchan
 *
 */
public class ConferenceTrackManagerClient {
	
	public void manageConferenceTrack(String inputListOfTitlesToBeTrackedViaConferenceManager){
		new TrackScheduler().scheduleTitlesWithinTracks(inputListOfTitlesToBeTrackedViaConferenceManager);
	}
	
	public static void main(String[] args){
		String defaultInputFile = "TitleInputFile";
		if(args.length!=0){
			new ConferenceTrackManagerClient().manageConferenceTrack(args[0]);
		}else{
			new ConferenceTrackManagerClient().manageConferenceTrack(defaultInputFile);
		}
	}
	
}

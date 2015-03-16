The ThoughtWorks ConferenceTrackManager has the following classes:

1.)ConferenceTrackManagerClient.java--Entry Point of the program, contains the main method and takes user provided argument as input. In the scenario, where user does not provide 
any input, it initializes TrackScheduler with default test data, which is present in TitleInputFile

2.)Track.java- Used for initializing a track object. It has two member variables, int Id(To associate a number with a specific track) and a LinkedHashSet<String> titleHashSet (An ordered set
to contain all titles that can be scheduled within the track)

3.)TrackScheduler.java - It contains the logic for scheduling titles within a given track. This class also prints the complete schedules of tracks once processing is done.

4.)TitlesParserUtility.java -  This utiltity class is used by TrackScheduler to parse input file. It has the logic to process input data and then convert it to a LinkedHashMap<String,String> 
 which contains complete Titles as Keys and respective durations as Values
 
 

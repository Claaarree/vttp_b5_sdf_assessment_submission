package vttp.batch5.sdf.task01;

import java.util.List;

import vttp.batch5.sdf.task01.models.BikeEntry;

public class Template {
    private static final String[] POSITION = {"highest", "second highest", "third highest", "fourth highest", "fifth highest"};
    private static final String[] WEATHER = {"Clear, Few clouds, Partly cloudy, Partly cloudy",
                                             "Mist + Cloudy, Mist + Broken clouds, Mist + Few clouds, Mist",
                                             "Light Snow, Light Rain + Thunderstorm + Scattered clouds, Light Rain + Scattered clouds",
                                             "Heavy Rain + Ice Pallets + Thunderstorm + Mist, Snow + Fog"};
    public static final String[] HOLIDAY = {"a holiday", "not a holiday"};
    public static final String[] DAY = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

    public static void printTemplate(List<BikeEntry> entriesList){
        for (int i = 0; i < POSITION.length; i++ ){
            BikeEntry entry = entriesList.get(i);
            System.out.printf("The %s (position) recorded number of cyclists was in %s (season), on a %s (day) in the month of %s (month).\n", 
            POSITION[i], Utilities.toSeason(entry.getSeason()), toWeekday(entry.getWeekday()), Utilities.toMonth(entry.getMonth()));

            System.out.printf("There were a total of %d (total) cyclists. The weather was %s (weather).\n", 
            entry.getCasual() + entry.getRegistered(), toWeather(entry.getWeather()));

            System.out.printf("%s (day) was %s.\n\n", toWeekday(entry.getWeekday()), toHoliday(entry.isHoliday()));

        }
    }

    public static String toWeekday(int weekday) {
		switch (weekday) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				return DAY[weekday];
			default:
				return "incorrect day";
		}
	}

    public static String toWeather(int weather){
        switch (weather) {
            case 1:
            case 2:
            case 3:
            case 4:
                
                return WEATHER[weather -1];        
            default:
                return "strange weather";
        }
    }

    public static String toHoliday(boolean holiday){
        if (holiday){
            return HOLIDAY[0];
        } else return HOLIDAY[1];
    }
    
}

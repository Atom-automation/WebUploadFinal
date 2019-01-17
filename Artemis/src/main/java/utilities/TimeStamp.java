package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeStamp {
	
	private DateTimeFormatter DateFormat;
	
	public TimeStamp() {
		DateFormat = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH:mm:ss");
	}
	
	public String getCurrentTimeStamp() {
		LocalDateTime now = LocalDateTime.now();
		return DateFormat.format(now);
	}
}

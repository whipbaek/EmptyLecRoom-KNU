package Model;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimeCalculator {
	
	LocalTime localTime; // 현재 시간
	
	LocalTime standardTime; // 비교 기준 시간 

	LocalTime startTime; // 시작 시간 
	LocalTime endTime; // 종료 시간 
			
	LocalTime nextStartTime; // 다음 시작 시간
	
	public TimeCalculator() {
		localTime = LocalTime.now();
		
		standardTime = LocalTime.of(14, 45);
		
		startTime = LocalTime.of(00, 00); // 시작 시간 
		endTime = LocalTime.of(00, 00); // 종료 시간 	
		
		nextStartTime = LocalTime.of(00, 00); // 다음 시작 시간
	}
	
	public void setStartTime(int hours, int mins) {
		startTime = LocalTime.of(hours, mins);
	}
	
	public void setEndTime(int hours, int mins) {
		endTime = LocalTime.of(hours, mins);
	}
	
	public void setTime(int startH, int startM, int endH, int endM) {
		startTime = LocalTime.of(startH, startM);
		endTime = LocalTime.of(endH, endM);
	}
	
	public void setStringTime(String start, String end) {
		String startString = start;
		String endString = end;
		
		String[] startAry = startString.split(" : ");
		int[] startInt = new int[startAry.length];
		for(int i = 0; i < startAry.length; i++) {
		    startInt[i] = Integer.parseInt(startAry[i]);
		}
		
		String[] endAry = endString.split(" : ");
		int[] endInt = new int[endAry.length];
		for(int i = 0; i < endAry.length; i++) {
		    endInt[i] = Integer.parseInt(endAry[i]);
		}
		
		setTime(startInt[0], startInt[1], endInt[0], endInt[1]);
	}
	
	public String compareTime(LocalTime now, LocalTime start, LocalTime end, LocalTime nextStart) {
		
		String returnString = "";
		if (now.isAfter(start) && now.isBefore(end)) {
			returnString =  "Classroom is now using, left time for empty is : " + now.until(end, ChronoUnit.MINUTES) + " minutes";
		} else if (now.isAfter(end) && now.isBefore(nextStart)) {
			returnString = "Classroom is now empty, left time for next class is : " + now.until(nextStart, ChronoUnit.MINUTES) + " minutes";
		} else {
			returnString =  "Error";
			System.exit(0);
		}
		return returnString;
		
	}
	
	public static void main(String[] args) {
		
		TimeCalculator tc = new TimeCalculator();
		String startTime = "13 : 00";
		String endTime = "15 : 00";
//		tc.setTime(14, 00, 16, 00);
		tc.setStringTime(startTime, endTime);
		System.out.print(tc.compareTime(tc.standardTime, tc.startTime, tc.endTime, tc.nextStartTime));
		
	}
	
}

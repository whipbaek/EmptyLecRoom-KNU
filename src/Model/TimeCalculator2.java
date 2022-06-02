package Model;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimeCalculator2 {

	LocalTime nowTime; // 현재 시간
	LocalTime startTime; // 시작 시간
	LocalTime endTime; // 종료 시간
	boolean isEmpty = true;
	long LeftTime = 99999;

	private String result="";

	public TimeCalculator2() {}

	public TimeCalculator2(String input, String start, String end){
		nowTime = StringToLocal(input);
		startTime = StringToLocal(start);
		endTime = StringToLocal(end);
	}

	public TimeCalculator2(String input){
		nowTime = StringToLocal(input);
	}

	public void setTimes(String start, String end){
		startTime = StringToLocal(start);
		endTime = StringToLocal(end);
	}

	// nowTime 을 String으로 입력받고, local변수로 초기화 해주는 생성자
	// strattime과 endtime 을 string으로 받고 local변수로 변환해주는 메소드
	// 현재 local 변수에 now, start, end, 를 가지고 포함되어 있는지 아닌지 t/f로 반환하는 메소드
	// 남

	public LocalTime StringToLocal(String time){
		String[] arr = time.split(":");
		int[] arrInt = new int[arr.length];
		for(int i = 0; i< arr.length; i++) arrInt[i] = Integer.parseInt(arr[i]);

		return LocalTime.of(arrInt[0],arrInt[1]);
	}
	
	public void compareTime() {

		//사용중일 때
		if (nowTime.isAfter(startTime) && nowTime.isBefore(endTime) || nowTime.equals(startTime)) {
			//사용중이면 연속적으로 강의가 있는지 Left Time 에 계산할 필요가 있다.
			//근본적으로 endTime 값을 수정해서 가져오는게 현실적이지 않은가?
			result =  "Classroom is now using, left time for empty is : " + nowTime.until(endTime, ChronoUnit.MINUTES) + " minutes";
			LeftTime = nowTime.until(endTime, ChronoUnit.MINUTES);
			isEmpty = false;
		}

		//사용중이지 않을때 && 사용시작 시간이 나보다 뒤일때
		else if (nowTime.isBefore(startTime)) {
			if(LeftTime > nowTime.until(startTime, ChronoUnit.MINUTES)){
				LeftTime = nowTime.until(startTime, ChronoUnit.MINUTES);
				result = "Classroom is now empty, left time for next class is : " + LeftTime + " minutes";
			}
		}
		
	}

	public static void main(String[] args) {
		LocalTime s1 = LocalTime.of(20,20);
		LocalTime n1 = LocalTime.of(18,20);

		long until = n1.until(s1, ChronoUnit.MINUTES);
		System.out.println("until = " + until);

	}


	public LocalTime getNowTime() {
		return nowTime;
	}

	public void setNowTime(LocalTime nowTime) {
		this.nowTime = nowTime;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean empty) {
		isEmpty = empty;
	}

	public long getLeftTime() {
		return LeftTime;
	}

	public void setLeftTime(long leftTime) {
		LeftTime = leftTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}

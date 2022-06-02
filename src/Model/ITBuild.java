package Model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 첫째 라인은 무조건 과목 이름
 * 월 ~ 일 이 처음 캐릭터로 들어간 문자열은 강의시간을 알림 -> 시간 parsing
 * 그게 끝나면 강의실 건물
 * 마지막 줄은 강의실 호수
 */

public class ITBuild {

    private ArrayList<ArrayList<String>> arrayLists = new ArrayList<>(); // 파일에서 데이터 읽어옴.
    private ArrayList<ClassInfo> classInfos = new ArrayList<>(); // 읽어온 데이터를 알맞게 파싱함.
    private HashMap<String, ArrayList<Time>> classByRoom = new HashMap<>();

    public ArrayList<ArrayList<String>> getArrayLists() {
        return arrayLists;
    }

    public void setArrayLists() throws FileNotFoundException {

        File file = new File("TestCrawling.txt");
        Scanner sc = new Scanner(file);
        int idx = 0;
        while (sc.hasNextLine()) {
            arrayLists.add(new ArrayList<>()); //객체 생성
            while (true) {
                if (!sc.hasNextLine()) break;
                String line = sc.nextLine();
                if (line.isEmpty()) break;
                arrayLists.get(idx).add(line);
            }
            idx++;
        }
    }

    public ArrayList<ClassInfo> getClassInfos() {
        return classInfos;
    }

    public void setCinfos() {

        for (ArrayList<String> arrayList : arrayLists) {
            int size = arrayList.size(); // 이미 강의수 만큼 만들어진 리스트의 사이즈를 받아옴
            if(!(arrayList.get(size-2).equals("IT융복합관(IT융복합공학관)"))) continue; //IT 융복합관 데이터만 가져오기 위함

            ArrayList<Time> times = new ArrayList<>(); // 각 수업마다 타임 테이블을 생성하기 위함

            //시간 파싱 index : 1 ~ size-2
            for (int k = 1; k < size - 2; ) {
                int tempIdx = k+1;
                int cnt = 1;
                if(arrayList.get(k).startsWith("08", 2)) { // 오전 8시에 시작하는 시간은 제외
                    k++;
                    continue;
                }
                while(true) {
                    if (arrayList.get(k).substring(0, 1).equals(arrayList.get(tempIdx).substring(0, 1))) { // 시간표의 가장 앞 시간과 끝 시간을 파싱하기 위한 처리
                        tempIdx++;
                        cnt++;
                    } else break;
                }
                // 최종적으로 요일이 같지 않아질때 이 쪽으로 탈출하기에 tempIdx 값을 -1 해줄 필요가 있다.
                times.add(new Time(arrayList.get(k).substring(0, 1), arrayList.get(k).substring(2, 7), arrayList.get(tempIdx-1).substring(10, 15)));
                k += cnt;
            }
            //distinguish floor
            Floors floor = null;

            switch (arrayList.get(size-1).charAt(0)){
                case 'B': floor = Floors.BASEMENT; break;
                case '2': floor = Floors.SECOND; break;
                case '3': floor = Floors.THIRD; break;
            }

            classInfos.add(new ClassInfo(arrayList.get(0), floor, arrayList.get(size - 1), times)); //classname, floor, classroom, timetable
        }
    }

    public void showAllClassInfo(){
        for (ClassInfo classInfo : classInfos) {
            System.out.println(classInfo.getClassname());
            classInfo.getTimetable2();
            System.out.println(classInfo.getClassroom());
            System.out.println(classInfo.getFloor());
            System.out.println();
        }
    }

    public HashMap<String, ArrayList<Time>> getClassByRoom() {
        return classByRoom;
    }

    public void setClassByRoom(HashMap<String, ArrayList<Time>> classByRoom) {
        this.classByRoom = classByRoom;
    }

    public void setClassByRoom(){
        /**
         * 먼저 ClassInfo 에서 순환하면서 Key 값 설정 및, ArrayList<Time> 객체를 할당한다.
         */

        //Key 값 설정 및 List 객체 생성
        for (ClassInfo classInfo : classInfos) {
            classByRoom.put(classInfo.getClassroom(),new ArrayList<>());
        }

        for (String classInfo : classByRoom.keySet()) {
            ArrayList<Time> arrayList = new ArrayList<>();
            for(ClassInfo classInfo2 : classInfos){
                if(classInfo.equals(classInfo2.getClassroom())){
                    for(Time temp : classInfo2.getTimetable()){
                        arrayList.add(temp);
                    }
                }
            }


            classByRoom.put(classInfo, arrayList);
        }
    }

    public void printClassByRoom(){
        for(String room : classByRoom.keySet()){
            System.out.println("room : " + room);
            for(Time time : classByRoom.get(room)){
                System.out.println(time);
            }
            System.out.println();
        }
    }

    /**
     * ClassInfo
     * classname
     * floor
     * classroom
     * arraylist<Time>timetable -> Time 은 요일, 날짜, 시간
     */

    /**
     * 1. 요일 비교
     * 2. 요일이 같다면 시간 비교
     * 3-1 만약 nowTime 이 시간내에 존재한다면
     *  0. bool isEmpty = false
     *  1. leftTimeInClass = (끝나는 시간 - nowTime) 한다. -> 어차피 한개의 경우밖에 존재하지 않음.
     *
     * 3-2. 만약 nowTime 이 시간내에 존재하지 않는다면 (강의실이 비어있는 경우)
     *  0. bool isEmpty = true
     *  1. 시작시간이 나보다 더 뒤인것만 체크
     *  2. 체크후에, leftTimeOutClass = min(leftTimeOutClass)
     *
     *  TimeCalculator는 현재시각, 클래스 시작시각, 클래스 끝나는시각 3개를 설정해준다.
     *  이후에 room이 비어있는지, 아닌지를 판단한다.
     *  여부에 따라 다른 String을 반환한다.
     */

    //EmptyRoomByClassRoom Ver
    public String IsEmptyRoom2(String roomNum, String nowDay, String nowTime){

        TimeCalculator2 timeCalculator2 = new TimeCalculator2(nowTime);

        ArrayList<Time> times = classByRoom.get(roomNum); //해당 호실의 타임 테이블을 가져온다.
        for (Time time : times) {
            if(nowDay.equals(time.getDay())){ //요일이 같다면
                timeCalculator2.setTimes(time.getStart(), time.getEnd());
                timeCalculator2.compareTime();
                if(!timeCalculator2.isEmpty()){ //강의실이 차 있다면
                    return timeCalculator2.getResult();
                }
            }
        }

        //위에서 반환이 되지 않았다면
        if(timeCalculator2.getLeftTime() == 99999){
            timeCalculator2.setResult("이후에 수업이 없습니다.");
        }
        return timeCalculator2.getResult();
    }

    public boolean IsEmptyRoomBool(String roomNum, String nowDay, String nowTime){
        TimeCalculator2 timeCalculator2 = new TimeCalculator2(nowTime);

        ArrayList<Time> times = classByRoom.get(roomNum); //해당 호실의 타임 테이블을 가져온다.
        for (Time time : times) {
            if(nowDay.equals(time.getDay())){ //요일이 같다면
                timeCalculator2.setTimes(time.getStart(), time.getEnd());
                timeCalculator2.compareTime();
                if(!timeCalculator2.isEmpty()){ //강의실이 차 있다면
                    return false;
                }
            }
        }

        return true;
    }
}


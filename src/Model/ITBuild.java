package Model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

    public ArrayList<ArrayList<String>> getArrayLists() {
        return arrayLists;
    }

    public void setArrayLists() throws FileNotFoundException {

        File file = new File("testdata.txt");
        Scanner sc = new Scanner(file);
        int idx = 0;
        while (sc.hasNextLine()) {
            arrayLists.add(new ArrayList<>());
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
            int size = arrayList.size();
            if(!(arrayList.get(size-2).equals("IT융복합관(IT융복합공학관)"))) continue; //IT 융복합관 데이터만 가져오기 위함

            ArrayList<Time> times = new ArrayList<>(); // 각 수업마다 타임 테이블을 생성하기 위함

            //시간 파싱 index : 1 ~ size-2
            for (int k = 1; k < size - 2; k++)
                times.add(new Time(arrayList.get(k).substring(0, 1), arrayList.get(k).substring(2, 7), arrayList.get(k).substring(10, 15)));

            //distinguish floor
            Floors floor = Floors.BASEMENT;

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
            System.out.println(classInfo.getTimetable());
            System.out.println(classInfo.getClassroom());
            System.out.println(classInfo.getFloor());
            System.out.println();
        }
    }

}


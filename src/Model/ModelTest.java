package Model;

import java.io.FileNotFoundException;

public class ModelTest {

    public static void main(String[] args) throws FileNotFoundException {
        ITBuild itBuild = new ITBuild();
        itBuild.setArrayLists(); //파일에서 데이터 읽어옴
        itBuild.setCinfos(); // 읽어온 데이터를 Cinfos에 저장함
      //  itBuild.showAllClassInfo(); // Cinfos 를 모두 출력

       // HashMap<String, String> hashMap = new HashMap<>();

        /**
         *   Class 정보를 모두 돌면서 Key: 강의실 / Value : result String
         *  전체 강의실 셋팅 및 출력
        for (ClassInfo classinfo : itBuild.getClassInfos()) {
            hashMap.put(classinfo.getClassroom(), itBuild.IsEmptyRoom(classinfo.getClassroom(),"월","12:00"));
        }

        for (String s : hashMap.keySet()) {
            System.out.println("s = " + s);
        }
        */

//        System.out.println(itBuild.IsEmptyRoom("301","월","12:00"));
//
//        for(ClassInfo classInfo : itBuild.getClassInfos()){
//            System.out.println(classInfo.getClassroom());
//            System.out.println(itBuild.IsEmptyRoom(classInfo.getClassroom(), "월","09:57"));
//            System.out.println();
//        }

        itBuild.setClassByRoom();
      itBuild.printClassByRoom();


        for (String room : itBuild.getClassByRoom().keySet()) {
            System.out.println("room : " + room);
            System.out.println(itBuild.IsEmptyRoom2(room, "월", "11:11"));
        }

//        System.out.println(itBuild.IsEmptyRoom("355","목","15:00"));


    }
}

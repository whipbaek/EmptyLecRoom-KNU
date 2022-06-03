package Test;

import Model.ITBuild;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ModelTest {

    public static void main(String[] args) throws FileNotFoundException {
        ITBuild itBuild = new ITBuild();
        itBuild.setArrayLists(); //파일에서 데이터 읽어옴
        for (ArrayList<String> arrayList : itBuild.getArrayLists()) {
            System.out.println("arrayList = " + arrayList);
        }
        itBuild.setCinfos(); // 읽어온 데이터를 Cinfos에 저장함
        itBuild.showAllClassInfo(); // Cinfos 를 모두 출력
//
        itBuild.setClassByRoom(); // 호실 마다 시간표를 정리
        itBuild.printClassByRoom(); // 호실 배정된 시간표를 출력


        // 특정시간을 매개변수로 넣고 비어있는지 차 있는지 확인한다.
        for (String room : itBuild.getClassByRoom().keySet()) {
            System.out.println("room : " + room);
            System.out.println(itBuild.IsEmptyRoom(room, "월", "11:11"));
        }


    }
}

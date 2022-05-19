package Model;

import java.io.FileNotFoundException;

public class ModelTest {

    public static void main(String[] args) throws FileNotFoundException {
        ITBuild itBuild = new ITBuild();
        itBuild.setArrayLists(); //파일에서 데이터 읽어옴
        itBuild.setCinfos(); // 읽어온 데이터를 Cinfos에 저장함
        itBuild.showAllClassInfo(); // Cinfos 를 모두 출력
    }
}

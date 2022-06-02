package Model;

import java.io.FileNotFoundException;

public class TempTimeTable {

    public static void main (String[] args) throws FileNotFoundException {
        ITBuild itBuild = new ITBuild();
        itBuild.setArrayLists();
        itBuild.setCinfos();

        TimeTable tt = new TimeTable("B101",itBuild.getClassInfos());
        tt.setVisible(true);
    }
}

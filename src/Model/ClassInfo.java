package Model;
import java.util.ArrayList;

public class ClassInfo {
    private String classname;
    private Floors floor;
    private String classroom;
    private ArrayList<Time> timetable;

    public ClassInfo(String classname,Floors  floor, String classroom, ArrayList<Time> arrayList) {
        this.classname = classname; //클래스명
        this.floor = floor; //층수
        this.classroom = classroom; //호수
        this.timetable = arrayList; // 요일, 시작시간, 종료시간
    }

    public ClassInfo() {
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Floors getFloor() {
        return floor;
    }

    public void setFloor(Floors floor) {
        this.floor = floor;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public ArrayList<Time> getTimetable() {
        return timetable;
    }

    public void setTimetable(ArrayList<Time> timetable) {
        this.timetable = timetable;
    }
}

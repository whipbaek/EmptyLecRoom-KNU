package Model;

import java.util.ArrayList;

public class forTesting {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("운영체제");
        arrayList.add("월 13:00 ~ 14:00");
        arrayList.add("월 14:00 ~ 15:00");
        arrayList.add("화 14:00 ~ 15:00");
        arrayList.add("화 15:00 ~ 16:00");
        arrayList.add("IT융복합관");
        arrayList.add("301");

        for(int i=1; i<arrayList.size()-2;){
            int tempidx = i+1;
            int cnt = 1;
            while(true){
                if(arrayList.get(i).substring(0,1).equals(arrayList.get(tempidx).substring(0,1))){
                    tempidx++;
                    cnt++;
                }
                else break;
            }

            Time time = new Time(arrayList.get(i).substring(0, 1), arrayList.get(i).substring(2, 7), arrayList.get(tempidx - 1).substring(10, 15));
            System.out.println("time = " + time);

            i = i + cnt;
        }

    }

}

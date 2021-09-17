package manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Function implements Interface{
    private ArrayList<Format> list = new ArrayList<>(); // Member list
    private Scanner in = new Scanner(System.in);

    public Format findName(String name){
        Iterator<Format> it = list.iterator();
        while(it.hasNext()){
            Format check = it.next();
            if(check.getName().equals(name)){
                return check;
            }
        }
        return null;
    }

    @Override
    public void insert(){
        String name;
        do{ // 중복값 검사 | Duplicate value check.
            System.out.print("추가할 학생의 이름을 입력 하세요 : "); // Name of the student to be added
            name = in.next();
            if(findName(name) != null) System.out.println("이미 추가된 학생입니다. 다시 입력해 주세요"); // A student who's already been added. Try again please
        }while(findName(name) != null);
        System.out.print("국어 점수 입력 : "); // a national language grades Input
        int lng = in.nextInt();
        System.out.print("수학 점수 입력 : "); // mathematics grades Input
        int mth = in.nextInt();
        System.out.print("스포츠 점수 입력 : "); // sports grades Input
        int sp = in.nextInt();

        Format insert = new Format(name,lng,mth,sp);
        list.add(insert);
    }

    @Override
    public void allView(){
        Iterator<Format> it = list.iterator();
        System.out.printf("이름   국어\t수학\t스포츠\t평균\n"); // name   a national language / mathematics / sports
        while(it.hasNext()){
            Format view = it.next();
            view.print();
        }
    }
    @Override
    public void findView(){
        System.out.print("검색할 착생의 이름 : "); // The name of the student you want to search for.
        String name = in.next();
        Format findStudent = findName(name);
        if(findName(name) == null) System.out.println("존재하지 않는 학생입니다, 다시 시도해주세요."); // A student who doesn't exist. Try again please
        else findStudent.print();
    }
    @Override
    public void delete(){
        System.out.print("삭제할 착생의 이름 : "); // Name of the student to be deleted.
        String name = in.next();
        Format findStudent = findName(name);
        if(findStudent == null) System.out.println("존재하지 않는 학생입니다, 다시 시도해주세요.");
        else list.remove(findStudent);
    }

    @Override
    public void modify(){
        System.out.print("수정할 착생의 이름 : "); // Name of the student to be modified.
        String name = in.next();
        Format findStudent = findName(name);
        if(findStudent == null) System.out.println("존재하지 않는 학생입니다, 다시 시도해주세요.");
        else {
            findStudent.print();
            System.out.print("수정할 국어 점수 입력 : "); // Enter the national language you want to modify.
            int lng = in.nextInt();
            System.out.print("수정할 수학 점수 입력 : "); // Enter the mathematics you want to modify.
            int mth = in.nextInt();
            System.out.print("수정할 스포츠 점수 입력 : "); // Enter the sports you want to modify.
            int sp = in.nextInt();
            findStudent.setLng(lng);
            findStudent.setMth(mth);
            findStudent.setSp(sp);
            findStudent.setAvg();
        }
    }

    @Override
    public void exit(){
        System.out.println("프로그램을 종료합니다."); // exit program
        System.exit(0);
    }
}

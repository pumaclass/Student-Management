package camp.model;

import java.util.ArrayList;
import java.util.List;


public class Student { //수강생
    private final String studentId;//고유번호(겹치는안되는 단위의 값)
    private String studentName;//이름
    private List<Subject> mainSubjects; //과목목록-필수과목
    private List<Subject> subSubjects; //과목목록-선택과목
    //리스트를 받기 때문에 목록을 갯수를 제한하지 않고 추가가능


    public Student(String studentId, String studentName, List<Subject> mainSubjects, List<Subject> subSubjects) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.mainSubjects = mainSubjects;
        this.subSubjects = subSubjects;
    }


    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Subject> getMainSubjects() {
        return mainSubjects;
    }

    public List<Subject> getSubSubjects() {
        return subSubjects;
    }


    // Setter
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

}

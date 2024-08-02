package camp.model;

import java.util.ArrayList;
import java.util.List;


public class Student { //수강생
    private String studentId;//고유번호(겹치는안되는 단위의 값)
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

    public Student(){}

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

    public Subject getSubjectInfo(String subject){
        int idx = 0;
        for(int i = 0 ; i < SubjectList().size() ; i++)
            if(SubjectList().get(i).getSubjectName().equals(subject))
                idx = i;
        return SubjectList().get(idx);
    }

    // Setter
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void newScore(int score, String select){
        for(int i = 0 ; i < SubjectList().size() ; i++){
            if(SubjectList().get(i).getSubjectName().equals(select)){
                SubjectList().get(i).setScore(score);
                break;
            }
        }
    }

    public List<Subject> SubjectList(){
        List<Subject> list = new ArrayList<>();
        for(Subject i : mainSubjects)
            list.add(i);
        for(Subject i : subSubjects)
            list.add(i);

        return list;
    }

    public void printList(List<Subject> list){
        for(Subject i : list)
            System.out.println(" - " + i.getSubjectName());
    }
}

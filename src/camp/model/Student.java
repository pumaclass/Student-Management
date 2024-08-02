package camp.model;

import java.util.ArrayList;
import java.util.List;


public class Student { //수강생
    private final String studentId;//고유번호(겹치는안되는 단위의 값)
    private String studentName;//이름
    private String mental;
    private final List<Subject> mainSubjects; //과목목록-필수과목
    private final List<Subject> subSubjects; //과목목록-선택과목
    //리스트를 받기 때문에 목록을 갯수를 제한하지 않고 추가가능


    public Student(String studentId, String studentName, List<Subject> mainSubjects, List<Subject> subSubjects, String mental) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.mainSubjects = mainSubjects;
        this.subSubjects = subSubjects;
        this.mental = mental;
    }

    // Setter
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setMental(String mental) {
        this.mental = mental;
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

    public String getMental() {
        return mental;
    }

    public void printAllGrades(){
        for(Subject sub : subjectList()){
            sub.printAllGrades();
        }
    }

    public void editScore(String subject, int round, int score) {
        for(Subject sub : subjectList()){
            if(sub.getSubjectName().equals(subject)) {
                sub.editScores(round, score);
                break;
            }
        }
    }


    public Subject getSubjectInfo(String subject){
        int idx = 0;
        for(int i = 0 ; i < subjectList().size() ; i++)
            if(subjectList().get(i).getSubjectName().equals(subject))
                idx = i;
        return subjectList().get(idx);
    }

    //원하는 과목 하나만 출력
    public void printScores(String subjectName) {
        for(Subject sub : subjectList()){
            if(sub.getSubjectName().equals(subjectName)) {
                sub.printScores();
                break;
            }
        }
    }

    //모든 과목 점수 출력
    public void printAllScores() {
        for(Subject sub : subjectList()){
            sub.printScores();
        }
    }

    // 점수 등록
    public void addStudentScore(String subjectName, int score) {
        for(Subject sub : subjectList()){
            if(sub.getSubjectName().equals(subjectName))
                sub.addScore(score);
        }
    }

    // 모든 과목 출력
    public void printAllSubject(){
        int cnt = 0;
        for(Subject sub : subjectList()){
            sub.printSubject(++cnt);
        }
    }


    // 수강생 과목들 하나로 정리
    public List<Subject> subjectList(){
        List<Subject> list = new ArrayList<>();
        for(Subject i : mainSubjects)
            list.add(i);
        for(Subject i : subSubjects)
            list.add(i);

        return list;
    }

    // 수강생의 수강과목 리스트 중 입력한 과목이 있는지 조회
    public boolean chkSubject(String subject){
        for(Subject sub : subjectList()){
            if(sub.getSubjectName().equals(subject))
                return true;    // 과목 있음
        }
        return false;   // 과목 없음
    }
}

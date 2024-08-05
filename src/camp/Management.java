package camp;

import camp.model.Student;
import camp.model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Management {
    // 과목 타입
    protected static final String SUBJECT_TYPE_MANDATORY = "MANDATORY";
    protected static final String SUBJECT_TYPE_CHOICE = "CHOICE";

    // index 관리 필드
    protected static int studentIndex;
    protected static final String INDEX_TYPE_STUDENT = "ST";
    protected static int subjectIndex;
    protected static final String INDEX_TYPE_SUBJECT = "SU";
    protected static int scoreIndex;
    protected static final String INDEX_TYPE_SCORE = "SC";

    // 데이터 저장소
    protected static List<Student> studentStore;
    protected static List<Subject> subjectStore;

    // 초기 데이터 생성
    public static void setInitData() {
        studentStore = new ArrayList<>();
        subjectStore = List.of(
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Java",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "객체지향",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "JPA",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MySQL",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "디자인 패턴",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring Security",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Redis",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MongoDB",
                        SUBJECT_TYPE_CHOICE
                )
        );
    }

    // index 자동 증가
    protected static String sequence(String type) {
        switch (type) {
            case INDEX_TYPE_STUDENT -> {
                studentIndex++;
                return INDEX_TYPE_STUDENT + studentIndex;
            }
            case INDEX_TYPE_SUBJECT -> {
                subjectIndex++;
                return INDEX_TYPE_SUBJECT + subjectIndex;
            }
            default -> {
                scoreIndex++;
                return INDEX_TYPE_SCORE + scoreIndex;
            }
        }
    }

    protected String getStudentId() {
        Scanner sc = new Scanner(System.in);
        for(Student student : studentStore) {
            System.out.println("학생 ID : " + student.getStudentId() + ", 학생 이름 : "+ student.getStudentName());
        }

        String studentId = "ST" + Util.filterInt();

        return studentId;
    }

}

package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.Scanner;

public class ScoreMagagement extends Management {

    public ScoreMagagement() {
    }
    // 스캐너
    private static Scanner sc = new Scanner(System.in);

    public void displayScoreView() throws InterruptedException{
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생의 과목별 회차 점수 수정");
            System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
            System.out.println("4. 과목별 통합 등급 조회");
            System.out.println("4. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");

            while(!sc.hasNextInt()){    // 입력된 데이터가 숫자가 아니라면~
                sc.next();              // 잘못 들어온 값 삭제
                Print.plzNumber();      // Print문 출력
            }
            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1 -> createScore(); // 수강생의 과목별 시험 회차 및 점수 등록
                case 2 -> updateRoundScoreBySubject(); // 수강생의 과목별 회차 점수 수정
                case 3 -> inquireRoundGradeBySubject(); // 수강생의 특정 과목 회차별 등급 조회
                case 4 -> gradeAverage();
                case 5 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    // 수강생의 과목별 시험 회차 및 점수 등록
    private void createScore() throws InterruptedException {
        if(studentStore.isEmpty()){
            System.out.println("등록 된 수강생이 없습니다. 수강생을 등록한 후 다시 이용해주세요.");
            Thread.sleep(1000); // 1초 일시정지 후 동작
            return;
        }

        System.out.println("시험 점수를 등록합니다...");
        String studentId;
        int studentIdx = 0;
        boolean flag = true;
        while(flag) { // 유효한 수강생인지 조회
            studentId = getStudentId(); // 관리할 수강생 고유 번호 입력 받기

            // studentIdx로 학생 정보 조회
            for (int i = 0; i < studentStore.size(); i++) {
                if (studentStore.get(i).getStudentId().equals(studentId)) {
                    studentIdx = i;
                    flag = false;
                    break;
                }
            }

            if(flag)
                System.err.println("유효한 수강생 번호가 아닙니다. 다시 입력해주세요");
        }

        Student student = studentStore.get(studentIdx);

        // 점수를 입력할 과목 선택
        System.out.println("점수를 등록할 과목을 선택해주세요.");
        student.printAllSubject();

        String selectSubject = getSubject(student);

        // 과목 점수 입력
        int newScore = getScore();

        // 점수 저장
        student.addStudentScore(selectSubject, newScore);

        System.out.println("StudentId : " + student.getStudentId());
        System.out.println("subjectName : " + student.getSubjectInfo(selectSubject).getSubjectName());
        System.out.print("score :");
        for(int i : student.getSubjectInfo(selectSubject).getScores().getScore())
            System.out.print(" " + i);
        System.out.print("\nGrade :");
        for(char i : student.getSubjectInfo(selectSubject).getScores().getGrade())
            System.out.print(" " + i );

        // 확인하기
        //student.printAllScores();

        System.out.println("\n점수 등록 성공!");
    }

    // 수강생의 과목별 회차 점수 수정
    private void updateRoundScoreBySubject() {
        // 기능 구현 (수정할 과목 및 회차, 점수)
        System.out.println("시험 점수를 수정합니다...");
        String studentId = getStudentId(); // 관리할 수강생 고유 번호

        // studentIdx로 학생 정보 조회
        int studentIdx = 0;
        for(int i = 0 ; i < studentStore.size() ; i++){
            if(studentStore.get(i).getStudentId().equals(studentId)){
                studentIdx = i;
            }
        }
        Student student = studentStore.get(studentIdx);

        System.out.println("수정할 과목의 이름을 입력해주세요.");
        student.printAllSubject();
        String subject = getSubject(student);

        System.out.println("수정할 회차를 입력해주세요");
        student.printAllScores();
        int round = sc.nextInt();
        sc.nextLine();

        System.out.println("수정할 점수를 입력하세요.");
        int newScore = getScore();

        student.editScore(subject, round-1, newScore);
        student.printAllScores();
        // 기능 구현
        System.out.println("\n점수 수정 성공!");
    }

    // 수강생의 특정 과목 회차별 등급 조회
    private void inquireRoundGradeBySubject() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        int studentIdx = 0;
        for (int i = 0; i < studentStore.size(); i++) {
            if (studentStore.get(i).getStudentId().equals(studentId)) {
                studentIdx = i;
            }

            // 기능 구현 (조회할 특정 과목)
            System.out.println("회차별 등급을 조회합니다...");
            // 기능 구현
            Student student = studentStore.get(studentIdx);
            student.printAllGrades();
            System.out.println("\n등급 조회 성공!");
        }
    }


    private int getScore(){
        int score;

        while(true){
            System.out.print("점수를 입력해주세요.");

            while(!sc.hasNextInt()){    // 입력된 데이터가 숫자가 아니라면~
                sc.next();              // 잘못 들어온 값 삭제
                Print.plzNumber();      // Print문 출력
            }

            score = sc.nextInt();
            sc.nextLine();

            if(score >= 0 && score <= 100)
                return score;
            else
                System.out.println("잘못 입력하셨습니다. 0 ~ 100 사이로 입력해주세요.");
        }
    }

    // 등급 편균 구하기
    private void gradeAverage() {
        System.out.println("원하는 과목의 번호를 입력해주세요.");
        System.out.println("1. Java, 2. 객체지향, 3. Spring, 4. JPA, 5. MySQL, 6. 디자인 패턴, 7.Spring Security, 8. Redis, 9. MongoDB");
        int num = sc.nextInt();
        double avg = 0;
        String subject="";
        char grade = 0;
        switch(num){
            case 1 -> subject = "Java";
            case 2 -> subject = "객체지향";
            case 3 -> subject = "Spring";
            case 4 -> subject = "JPA";
            case 5 -> subject = "MySQL";
            case 6 -> subject = "디자인 패턴";
            case 7 -> subject = "Spring Security";
            case 8 -> subject = "Redis";
            case 9 -> subject = "MongoDB";
        }

        for (Student student : studentStore) {
            avg += student.averageScore(subject);
        }
        if(num <= 5) {
            grade = Score.scoreToGrade((int)avg, SUBJECT_TYPE_MANDATORY);
        } else {
            grade = Score.scoreToGrade((int)avg, SUBJECT_TYPE_CHOICE);
        }

        System.out.println("과목 이름 : " + subject + ", 평균 등급:" + grade);

    }

    private String getSubject(Student std){
        int idx;
        String subjectName;

        while(true) {
            idx = sc.nextInt();
            sc.nextLine();

            if (idx >= 1 && idx <= std.subjectList().size()) {
                subjectName = std.subjectList().get(idx - 1).getSubjectName();
                break;
            }

            Print.plzSubject();
        }
        return subjectName;
    }


}

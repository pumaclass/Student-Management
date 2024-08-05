package camp;

import camp.model.Student;
import camp.model.Subject;

import java.util.Scanner;

public class ScoreMagagement extends Management {

    public ScoreMagagement() {
    }
    // 스캐너
    private static Scanner sc = new Scanner(System.in);

    public void displayScoreView() throws InterruptedException{
        if(studentStore.isEmpty()){ // 등록 된 수강생이 없을 경우 이용할 수 없음
            System.out.println("등록 된 수강생이 없습니다. 수강생을 등록한 후 다시 이용해주세요.");
            Thread.sleep(1000); // 1초 일시정지 후 동작
            return;
        }

        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생의 과목별 회차 점수 수정");
            System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
            System.out.println("4. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");

            int input = Util.filterInt();

            switch (input) {
                case 1 -> createScore(); // 수강생의 과목별 시험 회차 및 점수 등록
                case 2 -> updateRoundScoreBySubject(); // 수강생의 과목별 회차 점수 수정
                case 3 -> inquireRoundGradeBySubject(); // 수강생의 특정 과목 회차별 등급 조회
                case 4 -> flag = false; // 메인 화면 이동
                default -> {
                    System.err.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    // 수강생의 과목별 시험 회차 및 점수 등록
    private void createScore(){
        System.out.println("시험 점수를 등록합니다...");

        // 수강생 확인
        Student student = studentStore.get(verifyStudentId());

        // 점수를 입력할 과목 선택
        System.out.println("점수를 등록할 과목을 선택해주세요.");
        student.printAllSubject(); // 수강과목 리스트 출력
        String selectSubject = getSubject(student).getSubjectName();

        // 과목 점수 입력
        int newScore = getScore();

        // 점수 저장
        student.addStudentScore(selectSubject, newScore);

        System.out.println("StudentId : " + student.getStudentId());
        System.out.println("subjectName : " + student.getSubjectInfo(selectSubject).getSubjectName());
        System.out.print("score :");
        for(int i : student.getSubjectInfo(selectSubject).getScores().getScore())
            System.out.print(" " + i);
        System.out.print("\ngrade :");
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
        Subject subject;

        // 수강생 확인
        Student student = studentStore.get(verifyStudentId());

        System.out.println("수정할 과목의 이름을 입력해주세요.");
        student.printAllSubject(); // 수강과목 리스트 출력

        while(true){
            subject = getSubject(student);
            // 등록된 점수가 없는 과목을 선택했을 경우 재선택
            if(subject.getScores().getScore().isEmpty()){
                System.out.println("등록된 점수가 없습니다. 다른 과목을 입력해주세요.");
                continue;
            }
            break;
        }

        System.out.println("수정할 회차를 입력해주세요");
        student.printSelectScore(subject);
        int round = getRound(student, subject.getSubjectName());

        System.out.println("수정할 점수를 입력하세요.");
        int newScore = getScore();

        student.editScore(subject.getSubjectName(), round-1, newScore);
        student.printAllScores();
        // 기능 구현
        System.out.println("\n점수 수정 성공!");
    }

    // 수강생의 특정 과목 회차별 등급 조회
    private void inquireRoundGradeBySubject() {
        System.out.print("\n관리할 수강생 ID의 숫자를 입력하시오...");

        for (int i = 0; i < studentStore.size(); i++) {
            // 기능 구현 (조회할 특정 과목)
            Student student = studentStore.get(verifyStudentId());
            System.out.println("회차별 등급을 조회합니다...");
            student.printAllGrades();
            System.out.println("\n등급 조회 성공!");
        }
    }

    private int getRound(Student student, String subject){
        int round;

        while(true){
            round = Util.filterInt();

            if(round > 0 && round <= student.getSubjectInfo(subject).getScores().getScore().size())
                break;

            System.out.println("잘못 입력하셨습니다. 수정할 회차를 다시 입력해주세요.");
        }

        return round;
    }

    private int getScore(){
        int score;

        while(true){
            System.out.print("점수를 입력해주세요 : ");
            score = Util.filterInt();

            if(score >= 0 && score <= 100)  return score;
            else                            System.out.println("잘못 입력하셨습니다. 0 ~ 100 사이로 입력해주세요.");
        }
    }

    // 등급 편균 구하기
    private static void gradeAverage() {

    }

    private Subject getSubject(Student std){
        int idx;
        Subject subject;

        while(true) {
            idx = sc.nextInt();
            sc.nextLine();

            if (idx >= 1 && idx <= std.subjectList().size()) {
                subject = std.subjectList().get(idx - 1);
                break;
            }
            Util.plzSubject();
        }
        return subject;
    }
}

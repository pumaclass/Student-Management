package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Notification
 * Java, 객체지향이 아직 익숙하지 않은 분들은 위한 소스코드 틀입니다.
 * main 메서드를 실행하면 프로그램이 실행됩니다.
 * model 의 클래스들과 아래 (// 기능 구현...) 주석 부분을 완성해주세요!
 * 프로젝트 구조를 변경하거나 기능을 추가해도 괜찮습니다!
 * 구현에 도움을 주기위한 Base 프로젝트입니다. 자유롭게 이용해주세요!
 */


public class CampManagementApplication {
    // 데이터 저장소
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> scoreStore;

    // 과목 타입
    private static String SUBJECT_TYPE_MANDATORY = "MANDATORY";
    private static String SUBJECT_TYPE_CHOICE = "CHOICE";

    // index 관리 필드
    private static int studentIndex;
    private static final String INDEX_TYPE_STUDENT = "ST";
    private static int subjectIndex;
    private static final String INDEX_TYPE_SUBJECT = "SU";
    private static int scoreIndex;
    private static final String INDEX_TYPE_SCORE = "SC";

    // 스캐너
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        setInitData();


        try {
            displayMainView();
        } catch (Exception e) {
            System.out.println("\n오류 발생!\n프로그램을 종료합니다.");
        }
    }

    // 초기 데이터 생성
    private static void setInitData() {
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
        scoreStore = new ArrayList<>();
    }

    // index 자동 증가
    private static String sequence(String type) {
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

    private static void displayMainView() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            System.out.println("\n==================================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중...");
            System.out.println("1. 수강생 관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> displayStudentView(); // 수강생 관리
                case 2 -> displayScoreView(); // 점수 관리
                case 3 -> flag = false; // 프로그램 종료
                default -> {
                    System.out.println("잘못된 입력입니다.\n되돌아갑니다!");
                    Thread.sleep(2000);
                }
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    private static void displayStudentView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("수강생 관리 실행 중...");
            System.out.println("1. 수강생 등록");
            System.out.println("2. 수강생 목록 조회");
            System.out.println("3. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createStudent(); // 수강생 등록
                case 2 -> inquireStudent(); // 수강생 목록 조회
                case 3 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    // 수강생 등록
    private static void createStudent() {
        List<Subject> mainSubjects = new ArrayList<Subject>();
        List<Subject> subSubjects = new ArrayList<Subject>();

        System.out.println("\n수강생을 등록합니다...");
        System.out.print("수강생 이름 입력: ");
        String studentName = sc.next();
        // 기능 구현 (필수 과목, 선택 과목)
        sc.nextLine();
        while(true) {
            System.out.println("원하는 필수 과목 수를 입력하세요.");
            int ms = sc.nextInt();
            sc.nextLine();
            List<String> msNotSame = new ArrayList<>();
            if (ms < 3 || ms >= 5) {
                System.out.println("필수과목은 최소 3과목 이상 5과목 이하로 선택해야 합니다. 다시 입력해 주세요");
            } else {
                for (int i = 0; i < ms; i++) {
                    while (true) {
                        System.out.println("필수과목 ['Java', '객체지향', 'Spring', 'JPA', 'MySQL']중에서 듣고싶은 과목을 선택하세요.");
                        String subject = sc.nextLine();
                        if(msNotSame.contains(subject)) {
                            System.out.println("이미 수강한 과목입니다. 다시 입력해주세요.");
                            continue;
                        }
                        if (subject.equals("Java")) {
                            mainSubjects.add(subjectStore.get(0));
                            msNotSame.add("Java");
                            break;
                        } else if (subject.equals("객체지향")) {
                            mainSubjects.add(subjectStore.get(1));
                            msNotSame.add("객체지향");
                            break;
                        } else if (subject.equals("Spring")) {
                            mainSubjects.add(subjectStore.get(2));
                            msNotSame.add("Spring");
                            break;
                        } else if (subject.equals("JPA")) {
                            mainSubjects.add(subjectStore.get(3));
                            msNotSame.add("JPA");
                            break;
                        } else if (subject.equals("MySQL")) {
                            mainSubjects.add(subjectStore.get(4));
                            msNotSame.add("MySQL");
                            break;
                        } else {
                            System.out.println("과목 명을 다시 입력해 주세요.");
                        }
                    }
                }
                break;
            }
        }
        while(true) {
            System.out.println("원하는 선택 과목 수를 입력하세요.");
            int ss = sc.nextInt();
            sc.nextLine();
            List<String> ssNotSame = new ArrayList<>();
            if (ss < 2 || ss >= 4) {
                System.out.println("선택 과목은 최소 2과목 이상 4과목 이하로 선택해야 합니다. 다시 입력해 주세요");
            } else {
                for (int i = 0; i < ss; i++) {
                    while(true) {
                        System.out.println("필수과목 ['디자인 패턴', 'Spring Security', 'Redis', 'MongoDB']중에서 듣고싶은 과목을 선택하세요.");
                        String subject = sc.nextLine();
                        if(ssNotSame.contains(subject)) {
                            System.out.println("이미 수강한 과목입니다. 다시 입력해주세요.");
                            continue;
                        }
                        if (subject.equals("디자인 패턴")) {
                            subSubjects.add(subjectStore.get(5));
                            ssNotSame.add("디자인 패턴");
                            break;
                        } else if (subject.equals("Spring Security")) {
                            subSubjects.add(subjectStore.get(6));
                            ssNotSame.add("Spring Security");
                            break;
                        } else if (subject.equals("Redis")) {
                            subSubjects.add(subjectStore.get(7));
                            ssNotSame.add("Redis");
                            break;
                        } else if (subject.equals("MongoDB")) {
                            subSubjects.add(subjectStore.get(8));
                            ssNotSame.add("MongoDB");
                            break;
                        } else {
                            System.out.println("과목 명을 잘못 입력하셨습니다. 과목 명을 다시 입력해 주세요.");
                        }
                    }
                }
                break;
            }
        }
        for (Subject mainSubject : mainSubjects) {
            System.out.println(mainSubject.getSubjectId() + " " + mainSubject.getSubjectName() + " " + mainSubject.getSubjectType());
        }
        for (Subject subSubject : subSubjects) {
            System.out.println(subSubject.getSubjectId() + " " + subSubject.getSubjectName() + " " + subSubject.getSubjectType());
        }
        Student student = new Student(sequence(INDEX_TYPE_STUDENT), studentName, mainSubjects, subSubjects); // 수강생 인스턴스 생성 예시 코드
        // 기능 구현
        System.out.println(student.getStudentName() + " " + student.getStudentId());
        studentStore.add(student);
        System.out.println("수강생 등록 성공!\n");
    }

    // 수강생 목록 조회
    private static void inquireStudent() {
        System.out.println("\n수강생 목록을 조회합니다...");
        // 기능 구현
        // 1. 수강생 목록을 조회를 하려면
        // 2. 이 목록을 가지고 있는 이름을 찾아보면 studentStore이란걸 알 수 있음
        // 3. 조회라는 행동을 했을 때 return 할 필요 없이 눈에 바로 보여지니까 print 해야됨
        // 4. 수강생이 한명이 아니라 여러명이라 계속 프린트로 뽑아줘야 하고 list 에 있는 size 메소드사용하니
        // 수강생이 몇명인지 알 수 있으니 향상된 for문을 사용할 수 있음(while이 틀린건 아니지만 귀찮음)
        // 향상된for문:배열을 넘기면 배열안에있는 모든 원소를 탐색(조건없이 안에있는 수강생전부 보여줄거니까)
        // 6. 조회필수정보: 고유번호와 이름 -> private이라 직접적으로 접근 불가능 그래서 getter 사용
        // getter 메소드가 무엇인지 정리하면서 해보기 (고유번호/이름 을 반환하는 메소드이름)

        System.out.println("\n수강생 목록 조회 성공!");
    }

    private static void displayScoreView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생의 과목별 회차 점수 수정");
            System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
            System.out.println("4. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createScore(); // 수강생의 과목별 시험 회차 및 점수 등록
                case 2 -> updateRoundScoreBySubject(); // 수강생의 과목별 회차 점수 수정
                case 3 -> inquireRoundGradeBySubject(); // 수강생의 특정 과목 회차별 등급 조회
                case 4 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    private static String getStudentId() {
        System.out.print("\n관리할 수강생의 번호를 입력하시오...");
        return sc.next();
    }

    // 수강생의 과목별 시험 회차 및 점수 등록
    private static void createScore() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        System.out.println("시험 점수를 등록합니다...");
        // 기능 구현
        System.out.println("\n점수 등록 성공!");
    }

    // 수강생의 과목별 회차 점수 수정
    private static void updateRoundScoreBySubject() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현 (수정할 과목 및 회차, 점수)
        System.out.println("시험 점수를 수정합니다...");
        // 기능 구현
        System.out.println("\n점수 수정 성공!");
    }

    // 수강생의 특정 과목 회차별 등급 조회
    private static void inquireRoundGradeBySubject() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현 (조회할 특정 과목)
        System.out.println("회차별 등급을 조회합니다...");
        // 기능 구현
        System.out.println("\n등급 조회 성공!");
    }

}

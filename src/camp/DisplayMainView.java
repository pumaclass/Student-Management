package camp;

import java.util.Scanner;

public class DisplayMainView {

    public void displayMainView() throws InterruptedException {
        ScoreMagagement scoreMagagement = new ScoreMagagement();
        StudentManagement studentManagement = new StudentManagement();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("\n==================================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중...");
            System.out.println("1. 수강생 관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            System.out.print("관리 항목을 선택하세요...");

            while(!sc.hasNextInt()){    // 입력된 데이터가 숫자가 아니라면~
                sc.next();              // 잘못 들어온 값 삭제
                Print.plzNumber();      // Print문 출력
            }
            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1 -> studentManagement.displayStudentView(); // 수강생 관리
                case 2 -> scoreMagagement.displayScoreView(); // 점수 관리
                case 3 -> flag = false; // 프로그램 종료
                default -> {
                    System.out.println("잘못된 입력입니다.\n되돌아갑니다!");
                    Thread.sleep(2000);
                }
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }
}

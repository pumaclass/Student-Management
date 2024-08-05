package camp;

import java.util.Scanner;

public class Util {
    public static void plzNumber(){
        System.err.println("잘못 입력하셨습니다. 숫자만 입력해주세요.");
    }

    public static void plzSubject(){
        System.err.println("잘못 입력하셨습니다. 유효한 과목을 입력해주세요.");
    }

    public static int filterInt(){
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        while(!sc.hasNextInt()){
            sc.next();
            plzNumber();
        }

        answer = sc.nextInt();
        sc.nextLine();

        return answer;
    }
}

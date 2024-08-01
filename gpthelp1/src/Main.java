import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();

        // 사용자 추가
        System.out.print("아이디를 입력하세요: ");
        String userId = scanner.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.nextLine();
        userManager.addUser(userId, password);

        // 사용자 출력
        System.out.println("저장된 사용자 정보:");
        userManager.printUsers();

        // 사용자 수정
        System.out.print("수정할 사용자의 아이디를 입력하세요: ");
        String targetUserId = scanner.nextLine();
        System.out.print("새 아이디를 입력하세요: ");
        userId = scanner.nextLine();
        System.out.print("새 비밀번호를 입력하세요: ");
        password = scanner.nextLine();
        userManager.updateUser(targetUserId, userId, password);

        // 수정된 사용자 출력
        System.out.println("수정된 사용자 정보:");
        userManager.printUsers();

        // 사용자 삭제
        System.out.print("삭제할 사용자의 아이디를 입력하세요: ");
        targetUserId = scanner.nextLine();
        userManager.deleteUser(targetUserId);

        // 삭제 후 사용자 출력
        System.out.println("삭제 후 남은 사용자 정보:");
        userManager.printUsers();
    }
}
import java.util.Scanner;

public class UserManager {
    private static final int MAX_USERS = 100; // 최대 사용자 수
    private String[] userIds = new String[MAX_USERS];
    private String[] passwords = new String[MAX_USERS];
    private int userCount = 0;

    // 아이디와 비밀번호 저장
    public void addUser(String userId, String password) {
        if (userCount < MAX_USERS) {
            userIds[userCount] = userId;
            passwords[userCount] = password;
            userCount++;
        } else {
            System.out.println("더 이상 사용자를 추가할 수 없습니다.");
        }
    }

    // 아이디와 비밀번호 수정
    public void updateUser(String targetUserId, String newUserId, String newPassword) {
        int index = findUserIndex(targetUserId);
        if (index != -1) {
            userIds[index] = newUserId;
            passwords[index] = newPassword;
        } else {
            System.out.println("사용자를 찾을 수 없습니다.");
        }
    }

    // 아이디로 사용자 삭제
    public void deleteUser(String targetUserId) {
        int index = findUserIndex(targetUserId);
        if (index != -1) {
            for (int i = index; i < userCount - 1; i++) {
                userIds[i] = userIds[i + 1];
                passwords[i] = passwords[i + 1];
            }
            userIds[userCount - 1] = null;
            passwords[userCount - 1] = null;
            userCount--;
        } else {
            System.out.println("사용자를 찾을 수 없습니다.");
        }
    }

    // 사용자 인덱스를 찾는 메서드
    private int findUserIndex(String userId) {
        for (int i = 0; i < userCount; i++) {
            if (userIds[i].equals(userId)) {
                return i;
            }
        }
        return -1;
    }

    // 모든 사용자 정보 출력
    public void printUsers() {
        for (int i = 0; i < userCount; i++) {
            System.out.println("아이디: " + userIds[i] + ", 비밀번호: " + passwords[i]);
        }
    }

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

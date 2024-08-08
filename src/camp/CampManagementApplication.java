package camp;

public class CampManagementApplication {

    public static void main(String[] args) {
        Management.setInitData();
        try {
            Init.initStudent("조수현", new int[]{1, 2, 3}, new int[]{1, 2}, 1, new int[][]{{100, 20, 30}, {100, 20}, {30, 50}},new int[][]{{10, 50}, {90, 100}});
            Init.initStudent("이봉원", new int[]{1, 3, 4}, new int[]{1, 4}, 3, new int[][]{{100, 20, 30}, {100, 20}, {30, 50}},new int[][]{{10, 50}, {90, 100}});
            DisplayMainView.displayMainView();
        } catch (Exception e) {
            System.out.println("\n오류 발생!\n프로그램을 종료합니다.");
            System.out.println("오류 발생 이유: " + e.getMessage());
        }
    }
}


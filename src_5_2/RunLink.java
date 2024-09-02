import java.util.Scanner;

public class RunLink {
    static public void run(){
        StackLink obj_link = new StackLink();

        Scanner input = new Scanner(System.in);
        String[] checker = new String[3];
        do {
            checker = input.nextLine().split(" ");
            if (checker.length > 0 && !checker[0].isEmpty()) {
                switch (Integer.parseInt(checker[0])) {
                    case 1: // push
                        try {
                            obj_link.push(checker[1]);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2: // pop
                        try {
                            System.out.println(obj_link.pop());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3: // peek
                        try {
                            System.out.println(obj_link.peek());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4: // size
                        System.out.println(obj_link.size());
                        break;
                    case 5: // show
                        obj_link.show();
                        break;
                    case 6: // isEmpty
                        if (obj_link.isEmpty()) {
                            System.out.println("is empty");
                        } else {
                            System.out.println("not empty");
                        }
                        break;
                }
            }
        } while (!checker[0].equals("-99"));
        input.close();
    }
}

import java.util.Scanner;

public class RunArray {
    static public void run(){
        Scanner input = new Scanner(System.in);
        int size_arr = input.nextInt();
        StackArray obj_arr = new StackArray(size_arr);

        String[] checker = new String[3];
        do {
            checker = input.nextLine().split(" ");
            if (checker.length > 0 && !checker[0].isEmpty()) {
                switch (Integer.parseInt(checker[0])) {
                    case 1: // push
                        try {
                            obj_arr.push(Integer.parseInt(checker[1]));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2: // pop
                        try {
                            System.out.println(obj_arr.pop());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3: // peek
                        try {
                            System.out.println(obj_arr.peek());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4: // size
                        System.out.println(obj_arr.size());
                        break;
                    case 5: // show
                        obj_arr.show();
                        break;
                    case 6: // isEmpty
                        if (obj_arr.isEmpty()) {
                            System.out.println("is empty");
                        } else {
                            System.out.println("not empty");
                        }
                        break;
                    case 7: // isEmpty
                        if (obj_arr.isFull()) {
                            System.out.println("is full");
                        } else {
                            System.out.println("not full");
                        }
                        break;
                }
            }
        } while (!checker[0].equals("-99"));
        input.close();
    }
}

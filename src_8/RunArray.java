import java.util.Scanner;
public class RunArray {
    public void running(){
        Scanner input = new Scanner(System.in);
        int size_arr = input.nextInt();
        ArrayList obj_arr = new ArrayList(size_arr);

        String[] checker = new String[3];
        do {
            checker = input.nextLine().split(" ");
            if (checker.length > 0 && !checker[0].isEmpty()) {
                switch (Integer.parseInt(checker[0])) {
                    case 1: // add
                        try {
                            obj_arr.add(checker[1]);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2: // add
                        try {
                            obj_arr.add(Integer.parseInt(checker[1]), checker[2]);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3: // get
                        try {
                            System.out.println(obj_arr.get(Integer.parseInt(checker[1])));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4: // set
                        try {
                            obj_arr.set(Integer.parseInt(checker[1]), checker[2]);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5: // remove
                        try {
                            obj_arr.remove(checker[2]);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 6: // indexOf
                        System.out.println(obj_arr.indexOf(checker[1]));
                        break;
                    case 7: // size
                        System.out.println(obj_arr.size());
                        break;
                    case 8: // size
                        System.out.println(obj_arr.max_size());
                        break;
                    case 9: // isEmpty
                        if (obj_arr.isEmpty()) {
                            System.out.println("is empty");
                        } else {
                            System.out.println("not empty");
                        }
                        break;
                    case 10: // isFull
                        if (obj_arr.isFull()) {
                            System.out.println("is full");
                        } else {
                            System.out.println("not full");
                        }
                        break;
                    case 11: // show
                        obj_arr.show();
                        break;
                    case 13: // sort_bubble
                        obj_arr.sort_bubble();
                        break;
                    case 14: // sort_shell
                        obj_arr.sort_shell();
                        break;
                }
            }
        } while (!checker[0].equals("-99"));
        input.close();
    }
}

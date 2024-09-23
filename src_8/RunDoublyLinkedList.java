import java.util.Scanner;
public class RunDoublyLinkedList {
    public void running(){
        String[] checker = new String[3];
        checker[0] = "1";
        Scanner input = new Scanner(System.in);
        DoublyLinkedList objlinklist = new DoublyLinkedList();
        do {
            checker = input.nextLine().split(" ");
            switch (Integer.parseInt(checker[0])) {
                case 1: // add
                    objlinklist.add(checker[1]);
                    break;
                case 2: // add index
                    try {
                        objlinklist.add(Integer.parseInt(checker[1]), checker[2]);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3: // get
                    try {
                        System.out.println(objlinklist.get(Integer.parseInt(checker[1])));
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4: // set
                    try {
                        objlinklist.set(Integer.parseInt(checker[1]), Integer.parseInt(checker[2]));
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5: // remove
                    objlinklist.remove(Integer.parseInt(checker[1]));
                    break;
                case 6: // find
                    if(objlinklist.find(Integer.parseInt(checker[1]))){
                        System.out.println("found");
                    }else{
                        System.out.println("not found");
                    }

                    break;
                case 7: // size
                    System.out.println(objlinklist.size());
                    break;
                case 8: // isEmpty
                    if(objlinklist.isEmpty()){
                        System.out.println("is empty");
                    }else{
                        System.out.println("not empty");
                    }
                    break;
                case 9: // show
                    objlinklist.show();
                    break;
                case 10: // show_backward
                    objlinklist.show_backward();
                    break;
                case 12: // sort_bubble
                    objlinklist.sort_bubble();
                    break;
                case 13: // sort_shell
                    objlinklist.sort_shell();
                    break;
            }
        } while (!checker[0].equals("-99"));
    }
}

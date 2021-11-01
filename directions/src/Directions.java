import java.util.ArrayList;
import java.util.Arrays;


public class Directions {
    /*Directions "North", "South", opposites "West", "East"
     * String[] plan = {"North","South", "South", "East","West", "North", "West"}; better
     *  String[] plan = { "West"};
     * Write a function that returns the needed directions */
    
    public static void main(String[] args) {
        String[] plan = {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"};

        System.out.println(Arrays.toString(dirReduction(plan)));
    }

    public static String[] dirReduction(String[] arr) {
        ArrayList<String> arrList = new ArrayList<String>();

        for(int i=0; i<arr.length; i++) {

            if(
                    ("NORTH".equals(arr[i]) && arrList.size()>0 && "SOUTH".equals(arrList.get(arrList.size()-1)) )
                            ||
                            ("SOUTH".equals(arr[i]) && arrList.size()>0 && "NORTH".equals(arrList.get(arrList.size()-1)))
                            ||
                            ("EAST".equals(arr[i]) && arrList.size()>0 && "WEST".equals(arrList.get(arrList.size()-1)))
                            ||
                            ("WEST".equals(arr[i]) && arrList.size()>0 && "EAST".equals(arrList.get(arrList.size()-1)))
            ) {
                arrList.remove(arrList.size()-1);
                //if before elements is directly opposite thing, it will be removed with this thing
            }
            else {
                arrList.add(arr[i]);
                //else this will be inserted
            }
        }
        return arrList.toArray(new String[arrList.size()]);
    }
}
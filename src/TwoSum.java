import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class TwoSum {

    /*
        * params:
            * List<Integer> nums - List of numbers to be searched from
            * int target - target value that the values at the two indicies must add up to
        * description: searches the parameter 'nums'
        * return: ArrayList<Integer> with the two indicies; the indicies will be -1 if there is no two values found
     */
    public List<Integer> twoSum(List<Integer> nums, int target) {
        ArrayList<Integer> result = new ArrayList<Integer>(2);
        for(int i = 0; i < nums.size(); i++) {
            for(int x = 0; x < nums.size(); x++) {
                if(nums.get(i) + nums.get(x) == target && i != x && !nums.get(i).equals(nums.get(x))) {
                    result.add(i);
                    result.add(x);
                    return result;
                }
            }
        }
        result.add(-1);
        result.add(-1);
        return result;
    }

    /*
        * params: none
        * description: gets inputs from the user for the List to be searched
        * return: ArrayList<Integer>
    */
    private ArrayList<Integer> getArrayInputs() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        boolean isInputting = true;
        int i = 0;
        while(isInputting) {
            System.out.println("Enter a number to be added to the array, or 'd' to use the existing array: ");
            System.out.println("Current array: " + arr.toString());
            String input = scanner.nextLine();
            if(input.equals("d")) {
                isInputting = false;
            }
            else if(this.isInt(input)) {
                arr.add(i, Integer.parseInt(input));
                i++;
            }
            else {
                System.out.println("'" + input + "' " + "is not a number. Please enter a number.");
            }
        }
        return arr;
    }

    /*
        * params: none
        * description: gets input from the user for the target value
        * return: int
    */
    private int getTarget() {
        Scanner scanner = new Scanner(System.in);
        boolean isInputting = true;
        int target = -1;
        while(isInputting) {
            System.out.println("Enter the Two Sum target value: ");
            String input = scanner.nextLine();
            if(this.isInt(input)) {
                isInputting = false;
                target = Integer.parseInt(input);
            }
            else {
                System.out.println("'" + input + "' " + "is not a number. Please enter a number.");
            }
        }
        return target;
    }

    /*
        * params:
            * String input - input of type String, intended to be coming from the user
        * description: determines whether or not the input can be converted to an int
        * return: boolean
    */
    private boolean isInt(String input) {
        if(input == null) {
            return false;
        }
        try {
            Integer.parseInt(input);
        }
        catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        //instantiate
        TwoSum twoSum = new TwoSum();
        //print welcome msg
        System.out.println("~~ TWO SUM ~~");
        //get target and List values
        int target = twoSum.getTarget();
        ArrayList<Integer> arr = twoSum.getArrayInputs();
        //print result
        System.out.println("Result: " + twoSum.twoSum(arr, target));
    }
}

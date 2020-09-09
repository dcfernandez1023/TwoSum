import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class TwoSum {

    public ArrayList<Integer> twoSum(List<Integer> nums, int target) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        System.out.println(result.size());
        for(int i = 0; i < nums.size(); i++) {
            for(int x = 0; x < nums.size(); x++) {
                if(nums.get(i) + nums.get(x) == target && i != x) {
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
        TwoSum twoSum = new TwoSum();
        System.out.println("~~ TWO SUM ~~");
        int target = twoSum.getTarget();
        ArrayList<Integer> arr = twoSum.getArrayInputs();
        System.out.println("Result " + twoSum.twoSum(arr, target));
    }
}

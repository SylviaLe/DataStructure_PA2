import java.util.Scanner;
public class BracketMatcher
{
    
    private static char[] opening = {'(','[','{','<'};  // create an array of opening brackets
    private static char[] ending = {')',']','}','>'};  // create an array of closing brackets
    private static SinglyLinkedStack<Character> stack = new SinglyLinkedStack<>();
    
    private static boolean isOpeningBracket(char c)  //since not used elsewhere, declared as private
    {
        // convert char array to String using method valueOf(char[] data)
        if (String.valueOf(opening).indexOf(c) != -1) //if the char c is presented in the hardcoded brackets
            return true;
        return false;
    }

    private static boolean isClosingBracket(char c) //similar explanation above
    {
        if (String.valueOf(ending).indexOf(c) != -1)
            return true;
        return false;
    }
    private static boolean corresponds(char open, char close)
    {
        if (String.valueOf(opening).indexOf(open) == String.valueOf(ending).indexOf(close))  //if the index of the bracket in the hardcode is similar
            return true;                        //then it's a match
        return false;
    }

    public static boolean checkBrackets(String s)
    {
        int current = 0;
        for(int i = 0; i < s.length(); i++)  //loop through the entire string
        {
            if(isOpeningBracket(s.charAt(i)))
            {
                stack.push(s.charAt(i));  //if an opening bracket is encountered, push
                current = i;
            }
            else if((isClosingBracket(s.charAt(i))))
            {
                if(stack.isEmpty()) //the only case that this will be executed is when the number of closing brackets > number opening brackets.
                {                   
                    System.out.println("Error at position " + i + ':' + s.charAt(i)); //so the prob is at the final bracket
                    return false;
                }
                else if(!corresponds(s.charAt(i), stack.pop()))  //pop() is called here, that's why the list can be empty at the end
                {
                    System.out.println("Error at position " + i + ':' + s.charAt(i));  //error will be at the place where return false
                    return false;
                }
            }
        }
        if(stack.size() > 0) System.out.println("Error at position " + (current - stack.size() + 1) + ':' + s.charAt(current - stack.size() + 1)); // if opening brackets > closing brackets
        return stack.isEmpty();  //add some line to indicate if it's a match
    }


}

class BracketMatcherApp
{
    public static void main(String[] args)
    {
        BracketMatcher myMatcher  = new BracketMatcher(); //Create an instance of the BracketMatcher class
        Scanner input = new Scanner(System.in);
        System.out.print ("Enter the string of brackets: ");
        String brackets = input.next();
        if (myMatcher.checkBrackets(brackets) == true)
        {
            System.out.println("All perfectly matched!");  //special for success case
        }
        input.close();  //java generated a warning if the scanner is not closed
    }

}

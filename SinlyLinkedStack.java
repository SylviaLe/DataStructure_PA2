import java.util.Scanner;

/**
 * A public class that performs bracket matching task
 */
public class BracketMatcher
{
    //The array of characters (of type char) holding the opening brackets    
    private char[] opening = {'(','[','{','<'};  

    //The array of characters holding the corresponding closing brackets 
    private char[] ending = {')',']','}','>'}; 

    //New empty stack implemented using singly linked list
    private SinglyLinkedStack<Character> stack = new SinglyLinkedStack<>();

    //New empty stack implemented using singly linked list to store corresponding indices of elements in stack
    private SinglyLinkedStack<Integer> indices = new SinglyLinkedStack<>();
    
    /**
     * Return whether a character is an opening bracket
     * @param c a character from the input string
     * @return true iff the character c is an opening bracket, false otherwise
    */ 
    private boolean isOpeningBracket(char c)  //since not used elsewhere, declared as private
    {
        // convert char array to String using method valueOf(char[] data)
        if (String.valueOf(opening).indexOf(c) != -1) //if the char c is presented in the hardcoded brackets
            return true;
        return false;
    }

    /**
     * Return whether a character is a closing bracket
     * @param c a character from the input string
     * @return true iff the character c is a closing bracket, false otherwise
    */ 
    private boolean isClosingBracket(char c) //similar explanation above
    {
        if (String.valueOf(ending).indexOf(c) != -1)
            return true;
        return false;
    }

    /**
     * Return whether an opening bracket character corresponds to the closing bracket character close
     * @param open an opening bracket character
     * @param close a closing bracket character
     * @return true iff the character open is a bracket that corresponds to the closing bracket character close
    */ 
    private boolean corresponds(char open, char close)
    {
        if (String.valueOf(opening).indexOf(open) == String.valueOf(ending).indexOf(close))  //if the index of the bracket in the hardcode is similar
            return true;                        //then it's a match
        return false;
    }

    /**
     * Return whether a string has brackets that are all matched up properly
     * @param s a String object
     * @return true iff the string s has brackets that are all matched up properly
    */
    public boolean checkBrackets(String s)
    {
        for(int i = 0; i < s.length(); i++)  //loop through the entire string
        {
            if(isOpeningBracket(s.charAt(i)))
            {
                stack.push(s.charAt(i));  //if an opening bracket is encountered, push
                indices.push(i);
            }
            else if((isClosingBracket(s.charAt(i))))
            {
                if(stack.isEmpty()) //the only case that this will be executed is when the number of closing brackets > number opening brackets.
                {                   
                    System.out.println("Error at position " + i + ':' + s.charAt(i)); //so the prob is at the final bracket
                    return false;
                }
                else if(!corresponds(stack.pop(), s.charAt(i)) || indices.pop() == -1)  //pop() is called here, that's why the list can be empty at the end
                {
                    System.out.println("Error at position " + i + ':' + s.charAt(i));  //error will be at the place where return false
                    return false;
                }
            }
        }

        if(stack.size() > 0) 
        {
            while(stack.size() != 1) 
            {
                stack.pop();
                indices.pop();
            }
            System.out.println("Error at position " + indices.pop() + ':' + stack.pop()); // if opening brackets > closing brackets
            return false; 
        }
        else
            return true; // if all brackets are matched up correctly
    }
}

/**
 * Test the class by performing a series of operations
*/
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

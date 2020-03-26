public class BracketMatcher
{
    private static String opening = "([{<";  
    private static String ending = ")]}>";
    private static SinglyLinkedStack<Character> stack = new SinglyLinkedStack<>();
    private static boolean isOpeningBracket(char c)
    {
        String temp = Character.toString(c);
        if (opening.indexOf(temp) != -1)
            return true;
        return false;
    }

    private static boolean isClosingBracket(char c)
    {
        if (ending.indexOf(c) != -1)
            return true;
        return false;
    }
    private static boolean corresponds(char open, char close)
    {
        if (opening.indexOf(open) == ending.indexOf(close))
            return true;
        return false;
    }

    public static boolean checkBrackets(String s)
    {
        for(int i = 0; i < s.length(); i++)
        {
            if(isOpeningBracket(s.charAt(i)))
            {
                stack.push(s.charAt(i));
            }
            else if((isClosingBracket(s.charAt(i))))
            {
                if(stack.isEmpty())
                {
                    return false;
                }
                else if(!corresponds(s.charAt(i), stack.pop()))
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}

class BracketMatcherApp
{
    public static void main(String[] args)
    {

    }
}
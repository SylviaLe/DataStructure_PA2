public class BracketMatcher
{
    private String opening = "([{<";  
    private String ending = ")]}>";
    private SinglyLinkedStack<Character> stack = new SinglyLinkedStack<>();
    private boolean isOpeningBracket(char c)
    {
        String temp = Character.toString(c);
        if (opening.indexOf(temp) != -1)
            return true;
        return false;
    }

    private boolean isClosingBracket(char c)
    {
        if (ending.indexOf(c) != -1)
            return true;
        return false;
    }
    private boolean corresponds(char open, char close)
    {
        if (opening.indexOf(open) == ending.indexOf(close))
            return true;
        return false;
    }

    private boolean checkBrackets(String s)
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
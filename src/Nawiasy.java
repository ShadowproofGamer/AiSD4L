public class Nawiasy {

    public static boolean nawiasOtwierajacy(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    public static boolean nawiasZamykajacy(char ch){
        return ch == ')' || ch == ']' || ch == '}';
    }

    public static boolean nawiasyZrownowazone(String wyrazenie) throws FullStackException, EmptyStackException {
        ArrayStack<Character> characterStack = new ArrayStack<>(wyrazenie.length());
        char[] chTable = wyrazenie.toCharArray();
        for (char ch : chTable) {
            if (nawiasOtwierajacy(ch)) {
                characterStack.push(ch);
            }else if (nawiasZamykajacy(ch)){
                if (characterStack.isEmpty())return false;
                switch (ch){
                    case ')':
                        if (characterStack.top()=='('){
                            characterStack.pop();
                        }else {return false;}
                        break;
                    case ']':
                        if (characterStack.top()=='['){
                            characterStack.pop();
                        }else {return false;}
                        break;
                    case '}':
                        if (characterStack.top()=='{'){
                            characterStack.pop();
                        }else {return false;}
                        break;
                }
            }
        }
        return characterStack.isEmpty();
    }



}

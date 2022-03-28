import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //test1();
        //test2(10);
        //System.out.println(test3());
        //System.out.println(test4());
        test5(10);

    }
    //test klasy Nawiasy
    public static void test1(){
        try{
            System.out.println("test1: ");
            System.out.println(Nawiasy.nawiasyZrownowazone("(w*[x+y]/z-[p/{r-q}])"));
            System.out.println("test2: ");
            System.out.println(Nawiasy.nawiasyZrownowazone("(w*[x+y])/z-[p/{r-q}])"));

        } catch (EmptyStackException | FullStackException e) {
            e.printStackTrace();
            System.out.println("StackException");
        }
    }
    //test metody reverse()
    public static void test2(int n){
        ArrayStack<Integer> asi = new ArrayStack<>(n);
        try {
            for (int i = 0; i < n; i++) {
                asi.push(i);
            }
            asi.reverse();
            for (int i = 0; i < n; i++) {
                System.out.println(asi.pop());
            }
        } catch (FullStackException | EmptyStackException e) {
            e.printStackTrace();
            System.out.println("StackException");
        }

    }
    //test sprawdzania czy jest palindromem BEZ reverse()
    public static boolean test3(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Napisz coś, żeby sprawdzić czy jest palindromem:");
        String pal = scan.next();
        ArrayStack<Character> asc = new ArrayStack<>(pal.length());
        char[] cht = pal.toCharArray();
        try{
            for (char ch : cht) {
                asc.push(ch);
            }
            for (int i = 0; i < pal.length(); i++) {
                if (cht[i]!=asc.pop())return false;
            }
        } catch (EmptyStackException | FullStackException e) {
            e.printStackTrace();
            System.out.println("StackException");
        }
        return true;
    }
    //test sprawdzania czy jest palindromem Z reverse()
    public static boolean test4(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Napisz coś, żeby sprawdzić czy jest palindromem:");
        String pal = scan.next();
        ArrayStack<Character> asc = new ArrayStack<>(pal.length());
        ArrayStack<Character> asc2 = new ArrayStack<>(pal.length());
        char[] cht = pal.toCharArray();
        try{
            for (char ch : cht) {
                asc.push(ch);
                asc2.push(ch);
            }
            asc.reverse();
            for (int i = 0; i < pal.length(); i++) {
                if (asc2.pop()!=asc.pop())return false;
            }
        } catch (EmptyStackException | FullStackException e) {
            e.printStackTrace();
            System.out.println("StackException");
        }
        return true;
    }
    //test przenoszenia stosu z wykorzystaniem reverse() i stosu pomocnicznego
    public static void test5(int n){
        ArrayStack<Integer> s1 = new ArrayStack<>(n);
        ArrayStack<Integer> s2 = new ArrayStack<>(n);
        try{
            //generowanie elementów w s1
            for (int i = 0; i < n; i++) {
                s1.push(i);
            }
            s1.reverse();
            //przepisywanie z s1 po reverse() do s2
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            //wyswietlanie wyniku
            while (!s2.isEmpty()){
                System.out.println(s2.pop());
            }
        } catch (EmptyStackException | FullStackException e) {
            e.printStackTrace();
            System.out.println("StackException");
        }

    }
    //test przenoszenia stosu z wykorzystaniem reverse() i stosu pomocnicznego
    public static void test6(int n){
        ArrayStack<Integer> s1 = new ArrayStack<>(n);
        ArrayStack<Integer> s2 = new ArrayStack<>(n);
        try{
            //generowanie elementów w s1
            for (int i = 0; i < n; i++) {
                s1.push(i);
            }
            s1.reverse();
            //przepisywanie z s1 po reverse() do s2
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            //wyswietlanie wyniku
            while (!s2.isEmpty()){
                System.out.println(s2.pop());
            }
        } catch (EmptyStackException | FullStackException e) {
            e.printStackTrace();
            System.out.println("StackException");
        }

    }
}

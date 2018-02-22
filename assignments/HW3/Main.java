/*
public MyString(char[] chars);
public char charAt(int index);
public int length();
public MyString substring(int begin, int end);
public MyString toLowerCase();
public MyString toUpperCase();
public int compareTo(MyString s);
public MyString getMyString();
public String toString();
public static MyString valueOf(int i);
*/

class Main {
  public static void main(String [] args) {
    MyString myStr = new MyString("Oleksandr the Great".toCharArray());

    System.out.println(myStr.charAt(4));
    System.out.println(myStr.length());
    System.out.println(myStr.substring(0,8));
    System.out.println(myStr.toLowerCase());
    System.out.println(myStr.toUpperCase());
    System.out.println(myStr.compareTo(new MyString("Oleksandr".toCharArray())));
    System.out.println(myStr.compareTo(new MyString("Alex".toCharArray())));
    System.out.println(myStr.compareTo(new MyString("Olexandr".toCharArray())));
    System.out.println(myStr.getMyString().toString());
    System.out.println(MyString.valueOf(2406).toString());

  }
}

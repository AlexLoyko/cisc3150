import java.util.ArrayList;
import java.util.Arrays;

class MyString {
  private char [] myString;

  public MyString(char [] chars){
    this.myString = chars;
  }

  public char charAt(int index) throws RuntimeException {
    if (index < this.myString.length)
      return myString[index];
    else
      throw new RuntimeException("Index is out of range: " + index);
  }

  public int length() {
    return this.myString.length;
  }

  public MyString substring(int begin, int end) throws RuntimeException {
    if (begin < 0 || end >= this.myString.length)
      throw new RuntimeException("One of the indeces is out of range.");

    if (begin > end) {
      throw new RuntimeException("The starting index cannot be greater than the ending index.");
    }

    return new MyString(Arrays.copyOfRange(this.myString, begin, end));
  }

  public MyString toUpperCase() {
    char [] lowerCase = new char [this.myString.length];

    for (int i = 0; i < this.myString.length; i++)
      if (Character.isAlphabetic((int)this.myString[i]) && (int)this.myString[i] > 90)
        lowerCase[i] = (char)((int)this.myString[i] - 32);
      else
        lowerCase[i] = this.myString[i];

    return new MyString(lowerCase);
  }

  public MyString toLowerCase() {
    char [] upperCase = new char [this.myString.length];

    for (int i = 0; i < this.myString.length; i++)
      if (Character.isAlphabetic((int)this.myString[i]) && (int)this.myString[i] < 91)
        upperCase[i] = (char)((int)this.myString[i] + 32);
      else
        upperCase[i] = this.myString[i];

    return new MyString(upperCase);
  }

  public int compareTo(MyString s) {
    char [] second = s.myString;
    int smallerLength = Math.min(s.myString.length, this.myString.length);

    for (int i = 0; i < smallerLength; i++) {
      if (this.myString[i] == second[i])
        continue;
      else if (this.myString[i] < second[i])
        return -1;
      else
        return 1;
    }

    return this.myString.length - s.myString.length;
  }

  public MyString getMyString() {
    return new MyString(this.myString);
  }

  public String toString() {
    return new String(this.myString);
  }

  public static MyString valueOf(int i) {
    ArrayList<Integer> digitsReversed = new ArrayList<Integer>();
    digitsReversed.add(i % 10);

    for (int j = 10; i / j != 0; j *= 10) {
      digitsReversed.add(i / j);
    }

    char [] str = new char[digitsReversed.size()];

    for (int j = digitsReversed.size() - 1; j >= 0; j--)
      str[digitsReversed.size() - 1 - j] = (char)((int)digitsReversed.get(j) + (int)('0'));

    return new MyString(str);
  }
}

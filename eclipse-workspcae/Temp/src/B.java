class MCZ24 {
  public static void main (String[] args) {
    char a = 0x61;      // 1
    char b = '\62';    // 2
    char c = '\062';   // 3
    char d = 0x0031;   // 4
    String e = "\u0031"; // 5
   

    System.out.print(""+a+b+c+d+e);
}}

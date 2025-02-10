package katas.fundamentals;

public class DRoot {
    public static int digital_root(int n) {
        while ( n > 9 ) {
            n = recuriveRoot(n, 0);
        }
        return n;
    }

    private static int recuriveRoot(int n, int acc) {
        if (n < 10) { return acc + n; }
        return recuriveRoot(n / 10 , acc + n % 10 );
    }
}

/*
public static int digital_root(int n) {
    return (n < 10) ? n : digital_root(n / 10 + n % 10);
}

  public static int digital_root(int n) {
    return (n != 0 && n%9 == 0) ? 9 : n % 9;
  }
 */

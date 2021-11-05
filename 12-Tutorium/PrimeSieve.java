public class PrimeSieve {
  private final boolean[] sieve;
  private int next;

  public PrimeSieve(int max) {
    this.sieve = new boolean[max];
    this.sieve[0] = true;
    this.sieve[1] = true;
    this.next = 2;
  }

  public boolean isPrime(int n) {
    if (n >= this.sieve.length) {
      throw new IndexOutOfBoundsException(n + "");
    }
    int counter = 0;
    int semiCounter = 0;
    int totalCounter = 0;
    if (n > this.next) {
      for (int i = this.next; i <= n; i++) {
        counter += 1;
        if (!this.sieve[i]) {
          semiCounter += 1;
          for (int j = 2 * i; j < this.sieve.length; j += i) {
            totalCounter += 1;
            this.sieve[j] = true;
          }
        }
      }
      this.next = n;
    }
    System.out.format("%d; %d; %d\n", counter, semiCounter, totalCounter);
    return !this.sieve[n];
  }

  public static void main(String[] args) {
    PrimeSieve sieve = new PrimeSieve(5500);
    System.out.println(sieve.isPrime(1213));
    System.out.println(sieve.isPrime(501));
    System.out.println(sieve.isPrime(5011));
  }
}
public class PerformanceTest {
  public static void main(String[] args) {
    String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".repeat(1000); // Increase size
    
    String bestCase = "ABC"; 
    String worstCase = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";

    // Average execution time for best case
    long totalBestTime = 0;
    for (int j = 0; j < 1000; j++) {
        long startTime = System.nanoTime();
        match(text, bestCase);
        long endTime = System.nanoTime();
        totalBestTime += (endTime - startTime);
    }
    System.out.println("Average best-case execution time: " + (totalBestTime / 1000) + " nanoseconds");

    // Average execution time for worst case
    long totalWorstTime = 0;
    for (int j = 0; j < 1000; j++) {
        long startTime = System.nanoTime();
        match(text, worstCase);
        long endTime = System.nanoTime();
        totalWorstTime += (endTime - startTime);
    }
    System.out.println("Average worst-case execution time: " + (totalWorstTime / 1000) + " nanoseconds");
  }

  public static int match(String text, String pattern) {
    for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
      if (isMatched(i, text, pattern))
        return i;
    }
    return -1;
  }
	
  private static boolean isMatched(int i, String text, String pattern) {
    for (int k = 0; k < pattern.length(); k++) {
      if (pattern.charAt(k) != text.charAt(i + k)) {
        return false;
      }
    }
    return true;
  }
}



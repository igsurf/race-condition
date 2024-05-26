public class App {
    
    private static int counter = 0;

    public static void main(String[] args) {
        // Number of threads
        int numberOfThreads = 100;

        // Number of increments per thread
        int incrementsPerThread = 1000;

        // Create and start threads
        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(new IncrementTask(incrementsPerThread));
            threads[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < numberOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Print the final counter value
        System.out.println("Final counter value: " + counter);
    }

    // Task to increment the counter
    static class IncrementTask implements Runnable {
        private int increments;

        IncrementTask(int increments) {
            this.increments = increments;
        }

        @Override
        public void run() {
            for (int i = 0; i < increments; i++) {
                counter++;
            }
        }
    }
}

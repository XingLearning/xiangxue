package xyz.yangweixing.thread;

/**
 * <p>
 * Description: 守护线程的使用
 * </p>
 *
 * @author qiwen
 * @version 1.0.0
 * @date 2020/1/3 11:23
 * @see xyz.yangweixing.thread
 */
public class DaemonThread {

    private static class UseThread extends Thread{
        @Override
        public void run() {
            try {
                while (!isInterrupted()) {

                    System.out.println(Thread.currentThread().getName()
                            + " I am extends Thread.");
                }
                System.out.println(Thread.currentThread().getName()
                        + " interrupt flag is " + isInterrupted());
            } finally {
                //守护线程中finally不一定起作用
                System.out.println(" .............finally");
            }
        }
    }

    public static void main(String[] args)
            throws InterruptedException{
        UseThread useThread = new UseThread();
        useThread.setDaemon(true);
        useThread.start();
        Thread.sleep(5);
        useThread.interrupt();
    }
}

package com.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;

public class Main {
    static class MyThread implements Runnable {
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            Thread.currentThread().setName("MyThread" +name);
            // 做点事情
            try {
                Thread.sleep(1*100);

                System.out.println(name + " finished job!") ;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThread2 implements Runnable {
        private String name;
        private static int index = 0;

        public MyThread2(String name) {
            this.name = name;
        }

        @Override
        public void run() {
           while(true){
               index ++;
               String newname = "Sub Thread" + name+"--"+index;
               Thread.currentThread().setName("MyThread2" +newname);
               System.out.println(newname+" 当前线程池大小[" + executor.getPoolSize() + "],当前队列大小[" + executor.getQueue().size() + "]" + ",current active threads:" + executor.getActiveCount() + ",current tasks count:" + executor.getTaskCount());
                Thread t = new Thread(new MyThread(newname));
               try {
                    executor.execute(t);


                   Thread.sleep(2*100);
                   System.out.println("waited for thread : "+ newname);
               } catch (Exception e) {
                   System.out.println("ERROR: "+newname+" 当前线程池大小[" + executor.getPoolSize() + "],当前队列大小[" + executor.getQueue().size() + "]" + ",current active threads:" + executor.getActiveCount() + ",current tasks count:" + executor.getTaskCount());

                   e.printStackTrace();
                   //throw new RuntimeException(e);
                   System.exit(0);
               }
           }

        }
    }

    private static int executeProgram = 0;
    private static int produceTaskMaxNumber = 100;
    private static int coresize = 50;
    private static int maxSize = 100;
    private static int queueSize = 5;
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(coresize, maxSize, 6000 * 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(50));//,new ArrayBlockingQueue<Runnable>(queueSize));
    private static ThreadPoolExecutor executor2 = new ThreadPoolExecutor(coresize, maxSize, 6000 * 1000, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(queueSize));


    public static void main(String[] args) {

	// write your code here


            for (int i = 0; i < produceTaskMaxNumber; i++) {

                    executor2.execute(new MyThread2("Master Thread" + i));

            }

        // 关闭线程池
        //executor2.shutdown();

    }
}

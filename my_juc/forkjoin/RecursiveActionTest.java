package my_juc.forkjoin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;


/**
 * @author gongxb
 *
 * 2018��1��21��
 */
public class RecursiveActionTest { 
	



    /**
     Fork/Join ģʽ��ʹ�÷�ʽ�ǳ�ֱ�ۡ����ȣ�������Ҫ��дһ�� ForkJoinTask �����������ķָ�м����ĺϲ��ȹ�����������ǽ���� ForkJoinTask ���� ForkJoinPool �����Ӧ�õ�ִ�С�
     ͨ�����ǲ���ֱ�Ӽ̳� ForkJoinTask����������̫��ĳ��󷽷�������ض������⣬���ǿ���ѡ�� ForkJoinTask �Ĳ�ͬ�������������RecursiveAction �� ForkJoinTask ��һ�����࣬��������һ����򵥵� ForkJoinTask������Ҫ����ֵ����������ִ�����֮�󣬲���Ҫ�����м�������ϡ�������Ǵ� RecursiveAction ��ʼ�̳У���ô����ֻ��Ҫ���� protected void compute() ���������棬������������ôΪ���������㷨����һ�� ForkJoinTask �����ࣺ
     */

    public static class SortTask extends RecursiveAction {

        final long[] array;
        final int lo;
        final int hi;
        private int THRESHOLD = 20; //For demo only

        public SortTask(long[] array) {
            this.array = array;
            this.lo = 0;
            this.hi = array.length - 1;
        }

        public SortTask(long[] array, int lo, int hi) {
            this.array = array;
            this.lo = lo;
            this.hi = hi;
        }

        @Override
        protected void compute() {
            if (hi - lo < THRESHOLD) {
                sequentiallySort(array, lo, hi);
                System.out.println("array" + Arrays.toString(array));
            } else {
                int pivot = partition(array, lo, hi);
                System.out.println("pivot = " + pivot + ", low = " + lo + ", high = " + hi);
                System.out.println("array" + Arrays.toString(array));
                invokeAll(new SortTask(array, lo, pivot - 1), new SortTask(array, pivot + 1, hi));
            }
        }

        private int partition(long[] array, int lo, int hi) {
            long x = array[hi];
            int i = lo - 1;
            for (int j = lo; j < hi; j++) {
                if (array[j] <= x) {
                    i++;
                    swap(array, i, j);
                }
            }
            swap(array, i + 1, hi);
            return i + 1;
        }

        private void swap(long[] array, int i, int j) {
            if (i != j) {
                long temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        private void sequentiallySort(long[] array, int lo, int hi) {
            Arrays.sort(array, lo, hi + 1);//Only one question!
        }

    }

    public static void main(String... args) throws Exception {
        long[] array = new long[100];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextLong() % 50; //For demo only
        }
        ForkJoinTask sort = new SortTask(array);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.execute(sort);
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(30, TimeUnit.SECONDS);
    }

    /**
     ���ͣ�
     SortTask ����ͨ�� partition() ����������ֳ��������֡�
     ������������񽫱����ɲ��ֱ�����������������֡����������㹻Сʱ���ٽ���ָ�Ϊ��С�����񷴶��������ܵĽ��͡�
     ��ˣ���������ʹ��һ�� THRESHOLD���޶����������ģ��Сʱ��ʹ��ֱ�����򣬶������ٽ���ָ��Ϊ��С������
     RecursiveAction �ṩ�ķ�����
        invokeAll()���������е����񣬲��������������������󷵻ء��������һ����������쳣�����������е�����ȡ����invokeAll() �Ĳ�������������������顣
        execute()���� ForkJoinTask ��Ķ����ύ�� ForkJoinPool��ForkJoinPool �����̿�ʼִ�� ForkJoinTask��
        shutdown()��ִ�д˷���֮��ForkJoinPool ���ٽ����µ����񣬵����Ѿ��ύ��������Լ���ִ�С����ϣ������ֹͣ���е����񣬿��Գ��� shutdownNow() ������
        awaitTermination()��������ǰ�߳�ֱ�� ForkJoinPool �����е�����ִ�н�����
     */


}

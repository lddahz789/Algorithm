package com.algorithm.heap;

public class MaxHeap<T extends Comparable> {
	private T[] data;
	private int count;

	// 构造函数, 构造一个空堆, 可容纳capacity个元素
	@SuppressWarnings("unchecked")
	public MaxHeap(int capacity) {
		data = (T[]) new Comparable[capacity + 1];
		count = 0;
	}

	// 返回堆中的元素个数
	public int size() {
		return count;
	}

	// 返回一个布尔值, 表示堆中是否为空
	public boolean isEmpty() {
		return count == 0;
	}

	public void insert(T item) {
		data[count + 1] = item;
		count++;
		shiftUp(count);
	}

	@SuppressWarnings("unchecked")
	private void shiftUp(int k) {
		while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
			swap(k / 2, k);
			k /= 2;
		}
	}

	// 交换堆中索引为i和j的两个元素
	private void swap(int i, int j) {
		T t = data[i];
		data[i] = data[j];
		data[j] = t;
	}

	// 从最大堆中取出堆顶元素, 即堆中所存储的最大数据
	public T extractMax() {
		assert count > 0;
		T ret = data[1];

		swap(1, count);
		count--;
		shiftDown(1);

		return ret;
	}

	private void shiftDown(int k) {
		while (2 * k <= count) {
			int j = 2 * k; // 在此轮循环中,data[k]和data[j]交换位置
			if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0)
				j++;
			// data[j] 是 data[2*k]和data[2*k+1]中的最大值

			if (data[k].compareTo(data[j]) >= 0)
				break;
			swap(k, j);
			k = j;
		}
	}

	// 测试 MaxHeap
	public static void main(String[] args) {

		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
		int N = 50; // 堆中元素个数
		int M = 100; // 堆中元素取值范围[0, M)
		for (int i = 0; i < N; i++)
			maxHeap.insert((int) (Math.random() * M));
		System.out.println(maxHeap.size());

	}
}

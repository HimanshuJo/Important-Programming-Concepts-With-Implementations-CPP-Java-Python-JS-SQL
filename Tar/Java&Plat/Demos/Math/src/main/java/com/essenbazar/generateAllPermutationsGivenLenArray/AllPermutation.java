package com.essenbazar.generateAllPermutationsGivenLenArray;

/*
 * Order matters: (1, 2) and (2, 1) are different
 */

import java.util.ArrayList;
import java.util.List;

public class AllPermutation {

	private final int Arr[];
	private int Indexes[];
	private int Increase;

	private static final List<List<Integer>> llist = new ArrayList<>();

	public AllPermutation(int arr[]) {
		this.Arr = arr;
		this.Increase = -1;
		this.Indexes = new int[this.Arr.length];
	}

	public void GetFirst() {
		this.Indexes = new int[this.Arr.length];
		for (int i = 0; i < Indexes.length; ++i) {
			this.Indexes[i] = i;
		}
		this.Increase = 0;
		this.Output();
	}

	public boolean HasNext() {
		return this.Increase != (this.Indexes.length - 1);
	}

	public void GetNext() {
		if (this.Increase == 0) {
			this.Swap(this.Increase, this.Increase + 1);
			this.Increase += 1;
			while (this.Increase < this.Indexes.length - 1
					&& this.Indexes[this.Increase] > this.Indexes[this.Increase + 1]) {
				++this.Increase;
			}
		} else {
			if (this.Indexes[this.Increase + 1] > this.Indexes[0]) {
				this.Swap(this.Increase + 1, 0);
			} else {
				int start = 0;
				int end = this.Increase;
				int mid = (start + end) / 2;
				int tVal = this.Indexes[this.Increase + 1];
				while (!(this.Indexes[mid] < tVal && this.Indexes[mid - 1] > tVal)) {
					if (this.Indexes[mid] < tVal) {
						end = mid - 1;
					} else {
						start = mid + 1;
					}
					mid = (start + end) / 2;
				}
				this.Swap(this.Increase + 1, mid);
			}
			for (int i = 0; i <= this.Increase / 2; ++i) {
				this.Swap(i, this.Increase - i);
			}
			this.Increase = 0;
		}
		this.Output();
	}

	private void Output() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < this.Indexes.length; ++i) {
			list.add(this.Arr[this.Indexes[i]]);
		}
		llist.add(list);
	}

	private void Swap(int p, int q) {
		int tmp = this.Indexes[p];
		this.Indexes[p] = this.Indexes[q];
		this.Indexes[q] = tmp;
	}

	public static void main(String args[]) {
		int[] arr = { 1, 2, 3 };
		AllPermutation perm = new AllPermutation(arr);
		perm.GetFirst();
		while (perm.HasNext()) {
			perm.GetNext();
		}
		System.out.println(llist.toString());
	}
}

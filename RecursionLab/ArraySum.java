public class ArraySum {
	public static int sumOfArray(Integer[] a, int index) {
		if(index == 0) {
			return a[0];
		} else {
			return a[index] + sumOfArray(a, (index-1));
		}
	}
}

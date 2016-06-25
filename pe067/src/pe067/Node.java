package pe067;

public class Node {
	private long value;
	private long maxSum;
	
	public  Node(long value) {
		this.value = value;
		this.maxSum = 0;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", maxSum=" + maxSum + "]";
	}

	public long getValue() {
		return value;
	}

	public long getMaxSum() {
		return maxSum;
	}

	public void setMaxSum(long maxSum) {
		this.maxSum = maxSum;
	}
}

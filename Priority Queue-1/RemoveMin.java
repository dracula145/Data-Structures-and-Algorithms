import java.util.*;

public class RemoveMin {
    private ArrayList<Integer> heap;

	public RemoveMin() {
		heap = new ArrayList<Integer>();
	}

	boolean isEmpty() {
		return heap.size() == 0;
	}

	int size() {
		return heap.size();
	}

	int getMin() throws PriorityQueueException {
		if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}

	void insert(int element) {
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex > 0) {
			if (heap.get(childIndex) < heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {
				return;
			}
		}
	}

	// swap first and last element and keep on swapping parent with minimum child
	int removeMin()throws PriorityQueueException {
		if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
		}
		int res=getMin();
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        
        //Traverse from root to leaf, and swap values if needed to maintain min. heap order property
        int parentIndex=0;
        int leftChildIndex = 2*parentIndex+1, rightChildIndex = 2*parentIndex+2;
        while(leftChildIndex < heap.size())
        {
            int minIndex=parentIndex;
            
            if(heap.get(minIndex) > heap.get(leftChildIndex)) minIndex = leftChildIndex;
            
            if(rightChildIndex < heap.size() && heap.get(minIndex) > heap.get(rightChildIndex))
			 minIndex = rightChildIndex;
            
            if(minIndex == parentIndex) return res; //if no swapping was done then parent in the minimum so return
            
            int temp=heap.get(parentIndex);
            heap.set(parentIndex,heap.get(minIndex));
            heap.set(minIndex,temp);
            
            parentIndex=minIndex;
            leftChildIndex=2*parentIndex+1;
            rightChildIndex=2*parentIndex+2;
        }
        return res;
	}
}

class PriorityQueueException extends Exception {

}

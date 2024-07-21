package priorityqueue;

// import java.lang.reflect.InaccessibleObjectException;
import java.util.Comparator;

import app.Patient;

public class Heap<T> implements PriorityQueueADT<T> {

  private int numElements;
  private T[] heap;
  private boolean isMaxHeap;
  private Comparator<T> comparator;
  private final static int INIT_SIZE = 5;

  /**
   * Constructor for the heap.
   * @param comparator comparator object to define a sorting order for the heap elements.
   * @param isMaxHeap Flag to set if the heap should be a max heap or a min heap.
   */
  public Heap(Comparator<T> comparator, boolean isMaxHeap) {
      //TODO: Implement this method.
    
      this.comparator = comparator;
      this.isMaxHeap = isMaxHeap;
      this.heap = (T[]) new Patient[INIT_SIZE];
      this.numElements = 0;

  }

  private void swap(int i1, int i2, T[] heap){
    T temp = heap[i1];
    heap[i1] = heap[i2];
    heap[i2] = temp;
  }


  /**
   * This results in the entry at the specified index "bubbling up" to a location
   * such that the property of the heap are maintained. This method should run in
   * O(log(size)) time.
   * Note: When enqueue is called, an entry is placed at the next available index in 
   * the array and then this method is called on that index. 
   *
   * @param index the index to bubble up
   * @throws IndexOutOfBoundsException if invalid index
   */
  public void bubbleUp(int index) {
      //TODO: Implement this method.
      if(index < 0 || index > numElements)
      throw new IndexOutOfBoundsException();

    if(index == 0){
      return;
    }

    int parI = (index-1)/2;
    if(compareElements(heap[parI], heap[index]) >= 0){
      return;
    }
    if(compareElements(heap[parI], heap[index]) < 0){
      swap(parI, index, heap);
      index = parI;
    }
    bubbleUp(index);
  }

  /**
   * This method results in the entry at the specified index "bubbling down" to a
   * location such that the property of the heap are maintained. This method
   * should run in O(log(size)) time.
   * Note: When remove is called, if there are elements remaining in this
   *  the bottom most element of the heap is placed at
   * the 0th index and bubbleDown(0) is called.
   * 
   * @param index
   * @throws IndexOutOfBoundsException if invalid index
   */
  public void bubbleDown(int index) {
      //TODO: Implement this method.
      if(index < 0 || index > numElements)
      throw new IndexOutOfBoundsException();

      int child1 = (2 * index) + 1;
      int child2 = (2 * index) + 2;

      if(child1 >= numElements){
        return;
      }
      if(child2 >= numElements){
        if(compareElements(heap[index], heap[child1]) < 0){
          swap(child1, index, heap);
          index = child1;
          return;
        }
      }

      else if(compareElements(heap[index], heap[child1]) < 0 || compareElements(heap[index], heap[child2]) < 0){
        if(compareElements(heap[child1], heap[child2]) > 0){
          swap(child1, index, heap);
          index = child1;
          bubbleDown(index);
        }
        else{
          swap(child2, index, heap);
          index = child2;
          bubbleDown(index);
        }
      }


  }

  /**
   * Test for if the queue is empty.
   * @return true if queue is empty, false otherwise.
   */
  public boolean isEmpty() {
      //TODO: Implement this method.

    return numElements == 0;
  }

  /**
   * Number of data elements in the queue.
   * @return the size
   */
  public int getSize(){
      //TODO: Implement this method.
        return numElements;
  }

  /**
   * Compare method to implement max/min heap behavior. It changes the value of a variable, compareSign, 
   * based on the state of the boolean variable isMaxHeap. It then calls the compare method from the 
   * comparator object and multiplies its output by compareSign.
   * @param element1 first element to be compared
   * @param element2 second element to be compared
   * @return positive int if {@code element1 > element2}, 0 if {@code element1 == element2}, 
   * negative int otherwise (if isMaxHeap),
   * return negative int if {@code element1 > element2}, 0 if {@code element1 == element2}, 
   * positive int otherwise (if ! isMinHeap).
   */
  public int compareElements(T element1 , T element2) {
    int result = 0;
    int compareSign =  -1;
    if (isMaxHeap) {
      compareSign = 1;
    }
    result = compareSign * comparator.compare(element1, element2);
    return result;
  }

  /**
   * Return the element with highest (or lowest if min heap) priority in the heap 
   * without removing the element.
   * @return T, the top element
   * @throws QueueUnderflowException if empty
   */
  public T peek() throws QueueUnderflowException {
      //TODO: Implement this method.
      if(isEmpty()){
        throw new QueueUnderflowException();
      }

    return heap[0];
  }  

  /**
   * Removes and returns the element with highest (or lowest if min heap) priority in the heap.
   * @return T, the top element
   * @throws QueueUnderflowException if empty
   */
  public T dequeueElement() throws QueueUnderflowException{
    
      //TODO: Implement this method.
      if(isEmpty())
      throw new QueueUnderflowException();

      T data = heap[0];
      numElements--;
      swap(0, numElements, heap);
      heap[numElements] = null;
      bubbleDown(0);

    return data;
  }

  /**
   * Enqueue the element.
   * @param the new element
   */
  public void enqueueElement(T newElement) {
      //TODO: Implement this method.
      if(numElements == heap.length){
        T[] heap2 = (T[]) new Patient[2 * heap.length];
        for (int i = 0; i < numElements; i++){
          heap2[i] = heap[i];
        }
        heap = heap2;
      }
      heap[numElements] = newElement;
      bubbleUp(numElements);
      numElements++;
      
      

  }


}

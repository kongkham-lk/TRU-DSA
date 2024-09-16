package jsjf;

import jsjf.exceptions.EmptyCollectionException;

/**
 * An array implementation of a stack in which the bottom of the stack is fixed at index 0.
 * 
 * 
 * @author Java Foundations
 * @version 4.0
 */
public class DroupOutArrayStack<T> extends ArrayStack<T> {
    int tail = 0;

    /**
     * Creates an empty stack using the default capacity.
     */
    public DroupOutArrayStack() {
        super();
    }

    /**
     * Creates an empty stack using the specified capacity.
     * 
     * @param initialCapacity the initial size of the array
     */
    public DroupOutArrayStack(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * Adds the specified element to the top of this stack, expanding
     * the capacity of the array if necessary.
     * 
     * @param element generic element to be pushed onto stack
     */
    public void push(T element) {
        if (top == stack.length) {
            // reset tail when tail exceed the stack size
            if (tail == stack.length)
                tail = 0;

            stack[tail] = element;
            tail++;
        } else {
            stack[top] = element;
            top++;
        }
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it.
     * 
     * @return element removed from top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T pop() throws EmptyCollectionException {
        if (top == stack.length) {
            // move tail to the end of array after the index 0 of array is remove.
            // so that the next pop will be point to the next new element which is at the end of the stack.
            if (tail == 0)
                tail = stack.length;

            tail--;

            T result = stack[tail];
            stack[tail] = null;

            return result;
        }
        else
            return super.pop();
    }

    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.
     * 
     * @return element on top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T peek() throws EmptyCollectionException {
        if (top == stack.length && tail != 0)
            return stack[tail - 1];

        return stack[top - 1];
    }

    /**
     * Returns true if this stack is empty and false otherwise.
     * 
     * @return true if this stack is empty
     */
    public boolean isEmpty() {
        if (top == stack.length)
            return tail == 0;
        else
            return top == 0;
    }

    /**
     * Returns the number of elements in this stack.
     * 
     * @return the number of elements in the stack
     */
    public int size() {
        if (top == stack.length && tail != 0)
            return tail;
        else
            return top;
    }

    /**
     * Returns a string representation of this stack.
     * 
     * @return a string representation of the stack
     */
    public String toString() {
        String result = "";
        int target = 0;

        // When stack is not full yet, use top to as tail instead,
        // tail will be only work after stack is full and new elements is keeping push into the stack.
        if (top != stack.length)
            target = top;
        else
            target = tail;

        // Since implementing push the same as circular array, tail index is not necessary point behind head index.
        // Thus when printing stack's element from top to bottom need to devided into 2 for loops.
        // Getter tail to the first element of stack then getting the last element of stack to the index before tail which is head.
        for (int i = target - 1; i >= 0; i--) {
            if (stack[i] == null)
                continue;
                
            result += stack[i] + " ";
        }
        for (int i = top - 1; i >= target; i--) {
            if (stack[i] == null)
                continue;
                
            result += stack[i] + " ";
        }

        return result;
    }
}

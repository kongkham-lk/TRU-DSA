package jsjf;

/**
 * Represents a linked implementation of a stack.
 *
 * @author Java Foundations 
 * @version 4.0
 */
public class DropOutLinkedStack<T> extends LinkedStack<T>
{
    private static int LIMIT_COUNT = 100;

	/**
	 * Creates an empty stack.
	 */
	public DropOutLinkedStack()
	{
        this(LIMIT_COUNT);
	}

	/**
	 * Creates an empty stack.
	 */
	public DropOutLinkedStack(int limtiCount)
	{
        super();
        LIMIT_COUNT = limtiCount;
	}

	/**
	 * Adds the specified element to the top of this stack.
	 * @param element element to be pushed on stack
	 */
	public void push(T element)
	{
        if (count == LIMIT_COUNT) {
            LinearNode<T> curr = top;
    
            while (curr.getNext().getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(null);
            count--;
        }
        super.push(element);
	}
}

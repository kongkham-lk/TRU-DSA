package jsjf;

public class Test {
    public static void main(String[] args) {

        int size = 3;
        Integer[] inputs = new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println("\nInputs sample: " + grabAllElFromArray(inputs));

        System.out.println("\n------------- Test ArrayStack's method!!! -------------\n");

        // initialized with only size of 3 in order to test expandCapacity method when push
        ArrayStack<Integer> stackArray = new ArrayStack<>(size);
        testLogic(stackArray, inputs, size);

        System.out.println("\n----------- Test DroupOutStack's method !!! -----------\n");

        // initialized with only size of 3 in order to test expandCapacity method when push
        DroupOutArrayStack<Integer> stackDropOut = new DroupOutArrayStack<>(size);
        testLogic(stackDropOut, inputs, size);
    }

    private static String grabAllElFromArray(Integer[] inputs) {
        String result = "";
        
        for (int i = 0; i < inputs.length; i++)
            result += inputs[i] + " ";

        return result;
    }

    /**
     * Helper function for testing all the ArrayStack's and DroupOutArrayStack's methods
     * @param <T>
     * @param stack
     * @param inputs
     * @param size
     */
    private static <T> void testLogic(StackADT<T> stack, T[] inputs, int size) {
        System.out.println("Initial stack's el: " + stack);
        System.out.println("Initial stack size: " + size);
        System.out.println("isEmpty:            " + stack.isEmpty() + "\n");

        for (int i = 0; i < inputs.length; i++) {
            stack.push(inputs[i]);

            if (stack.size() % size == 0) {
                // print out when fill up all the stack
                System.out.println("Total push of el:   " + stack);
            }
        }
        // print again after push more element to the stack that is already full
        System.out.println("\nPush more:          " + stack);
        System.out.println("Top point at:       " + stack.size());
        System.out.println("Peek:               " + stack.peek());
        System.out.println("Pop:                " + stack.pop());
        System.out.println("Pop:                " + stack.pop());
        System.out.println("After pop, top at:  " + stack.size());
        System.out.println("After pop, remain:  " + stack);
        System.out.println("isEmpty:            " + stack.isEmpty());
    }
}
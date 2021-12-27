package chapter03;

import java.lang.reflect.Array;
import java.util.Stack;

/**
 * Three in One: Describe how you could use a single array to implement three stacks.
 * Hints: #2, #72, #38, #58
 * <p>
 * My Approach 3 days
 *
 */
public class Q01<E> {

    private static class StackInfo {
        private int startIndex, size, capacity;

        public StackInfo(int startIndex, int capacity) {
            this.startIndex = startIndex;
            this.size = 0;
            this.capacity = capacity;
        }
    }

    private StackInfo[] stackInfos;
    private E[] arrayOfStacks;

    public Q01(int numberOfStacks, int sizeOfEachStack, E elementType) {
        this.stackInfos = new StackInfo[numberOfStacks];
        arrayOfStacks = (E[]) Array.newInstance(elementType.getClass(), numberOfStacks * sizeOfEachStack);

        for (int stackNumber = 0; stackNumber < numberOfStacks; stackNumber++) {
            int startIndex = (stackNumber * sizeOfEachStack);
            int sizeOfStack = sizeOfEachStack;
            StackInfo stackInfo = new StackInfo(startIndex, sizeOfEachStack);
            stackInfos[stackNumber] = stackInfo;
        }
    }

    //returns true if current stack's size is at its limit.
    private boolean full(StackInfo stackInfo) {
        return stackInfo.size == stackInfo.capacity;
    }

    //Creates a new array with the desired stack's size increased
    public void resize(int stackIndex) {
        StackInfo stackInfo = stackInfos[stackIndex];
        stackInfo.capacity *= 2; //copy current stack's contents first
        int startIndex = stackInfo.startIndex;

        //gets the new array's size
        int newArrayCapacity = 0;
        for (int stackNumber = 0; stackNumber < stackInfos.length; stackNumber++)
            newArrayCapacity += stackInfos[stackNumber].capacity;

        //copies all elements into the new array
        E[] newArrayOfStacks = (E[]) Array.newInstance(arrayOfStacks[0].getClass(), newArrayCapacity);

        System.arraycopy(arrayOfStacks, 0, newArrayOfStacks, 0, stackInfos[0].capacity);
        for(int stackNumber = 1; stackNumber < stackInfos.length; stackNumber++) { //changes the startIndex of each stack
            int newStartIndex = stackInfos[stackNumber-1].startIndex + stackInfos[stackNumber - 1].size + 1;
            StackInfo currentStack = stackInfos[stackNumber];
            currentStack.startIndex = newStartIndex;
            E[] currentStackToArray = (E[]) Array.newInstance(arrayOfStacks[0].getClass(), currentStack.capacity);

            System.arraycopy(currentStackToArray, 0, newArrayOfStacks, newStartIndex, currentStack.capacity); //copies stack from new starting point.
        }

        this.arrayOfStacks = newArrayOfStacks;
    }

    /**
     * Adds a given new element to the stack, given the stack's number
     *
     * @param stackIndex the stack to add the element to, i.e., 1 = stack at index 0.
     * @param element     is the element to add to the desired stack.
     */
    public void add(int stackIndex, E element) {
        int stackNumber = stackIndex - 1;
        StackInfo stackInfo = stackInfos[stackNumber]; //get desired stack to add element to

        if (full(stackInfo))
            resize(stackNumber);

        int index = stackInfo.startIndex + stackInfo.size; //index in the array that the stack belongs to.
        arrayOfStacks[index] = element;
        stackInfo.size++;
    }
}

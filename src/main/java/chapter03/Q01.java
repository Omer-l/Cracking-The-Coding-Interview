package chapter03;

import java.lang.reflect.Array;

/**
 * Three in One: Describe how you could use a single array to implement three stacks.
 * Hints: #2, #72, #38, #58
 *
 * My Approach
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
    private  E[] values;

    public Q01(int numberOfStacks, int sizeOfEachStack, E elementType) {
        this.stackInfos = new StackInfo[numberOfStacks];
        values = (E[]) Array.newInstance(element.getClass(), numberOfStacks * sizeOfEachStack);

        for (int stackNumber = 0; stackNumber < numberOfStacks; stackNumber++) {
            int startIndex = (stackNumber * sizeOfEachStack);
            int sizeOfStack = sizeOfEachStack;
            StackInfo stackInfo = new StackInfo(startIndex, sizeOfEachStack);
            stackInfos[stackNumber] = stackInfo;
        }
    }

    public void resize(int stackNumber) {
//        if(stackNumber == 1) {
//            E[] newThreeStack = (E[]) //            System.arraycopy(threeStac//            System.arraycopy(threeStac//            System.arraycopy(threeStac//        } else if(stackNumber == 2) {
//            E[] newThreeStack = (E[]) /            System.arraycopy(threeStac/            System.arraycopy(threeStac/            System.arraycopy(threeStac/        }
    }
    public void add(int stackNumber) {
//        if(stackNumber)
    }
}

package chapter01;

import java.util.Arrays;

/**
 * Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 * Hints: #51, # 100
 *
 * My Approach 7 days
 * Starting from the outermost layer, working inwards iteratively.
 * temp = top.
 * left -> top
 * bottom -> left
 * right -> bottom
 * temp -> top
 */
public class Q01_07 {
    private int[][] image4Byte;

    public Q01_07(int[][] image4Byte) {
        this.image4Byte = image4Byte;
    }

    public Q01_07() {
        this.image4Byte = initialiseRandomMatrix(4, 4);
    }

    private int[][] initialiseRandomMatrix(int numberOfRows, int numberOfColumns) {
        int[][] image4ByteMatrix = new int[numberOfRows][numberOfColumns];

        for (int rowIndex = 0; rowIndex < image4ByteMatrix.length; rowIndex++)
            for (int columnIndex = 0; columnIndex < image4ByteMatrix[0].length; columnIndex++)
                image4ByteMatrix[rowIndex][columnIndex] = (int) (Math.random() * 16);
        return image4ByteMatrix;
    }

    /**
     * Rotates image by 90 by rotating the matrix
     * @return  a rotated image
     */
    public int[][] rotate90() {

        int layer = 1;
        //layer 0
        for(int elementIndex = 0; elementIndex < image4Byte.length - layer; elementIndex++) {
            int temp = image4Byte[layer - 1][elementIndex];
            image4Byte[layer - 1][elementIndex] = image4Byte[image4Byte.length - elementIndex - layer][layer - 1];//left to top
            image4Byte[image4Byte.length - elementIndex - layer][layer - 1] = image4Byte[image4Byte.length - layer][image4Byte.length - elementIndex - layer]; //bottom to left
            image4Byte[image4Byte.length - layer][image4Byte.length - elementIndex - layer] = image4Byte[elementIndex][image4Byte.length - 1];//right to bottom
            image4Byte[elementIndex][image4Byte.length - 1] = temp; //top to right
            System.out.println("AFTER 1 ELEMENT MOVE:");
            printRows(image4Byte);
        }

        System.out.println("AFTER 90 DEGREE ROTATION:");
        printRows(image4Byte);
        System.out.println("=======================================NEXT LAYER!!!");
        layer = 2;
        //layer 0
        for(int elementIndex = 0; elementIndex < image4Byte.length - layer - 1; elementIndex++) {
            int temp = image4Byte[layer - 1][elementIndex + layer - 1];
            image4Byte[layer - 1][elementIndex + layer - 1] = image4Byte[image4Byte.length - elementIndex - layer][layer - 1];  //left to top
            image4Byte[image4Byte.length - elementIndex - layer][layer - 1] = image4Byte[image4Byte.length - layer][image4Byte.length - elementIndex - layer];//bottom to left
            image4Byte[image4Byte.length - layer][image4Byte.length - elementIndex - layer] = image4Byte[layer - 1][image4Byte.length - layer]; //right to bottom
            image4Byte[layer - 1][image4Byte.length - layer] = temp; //top to right
            System.out.println("AFTER 1 ELEMENT MOVE:");
            printRows(image4Byte);
        }

        System.out.println("AFTER 90 DEGREE ROTATION:");
        printRows(image4Byte);

    return image4Byte;
    }

    private void printRows(int[][] arr) {
        for (int rowIndex = 0; rowIndex < image4Byte.length; rowIndex++)
                System.out.println(Arrays.toString(arr[rowIndex]));
    }
}
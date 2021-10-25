package packname;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws IOException {

// Ejercicio 0
        String x = "string hola";
        String reversedString = reverseString(x);
        System.out.println(reversedString);

// Ejercicio 1
        String[] array = {"First", "Second", "Third", "Fourth"};
        showArrayValues(array);

// Ejercicio 2
        int[][] biArray = {
                {1,2,3,4},
                {2,3,4,5},
                {3,4,5,6},
                {60,65,70,75}
        };

        printBidimensionalArray(biArray);


// Ejercicio 3
        Vector<String> myVector = new Vector<>(5);
        myVector.add("First");
        myVector.add("Second");
        myVector.add("Third");
        myVector.add("forth");
        myVector.add("Fifth");
        myVector.remove(2);
        myVector.remove(3);
        System.out.println(myVector);

        // Ejercicio 5

        ArrayList<String> aList = new ArrayList<>(4);
        aList.add("Primero");
        aList.add("Segundo");
        aList.add("Tercero");
        aList.add("Cuarto");

        LinkedList<String> lList = new LinkedList<>();

        copyArrayToLinked(aList, lList);

        System.out.print("ArrayList: ");
        printCollectionValues(aList);
        System.out.println();
        System.out.print("LinkedList: ");
        printCollectionValues(lList);


//        Ejercicio 6

        ArrayList<Integer> intAList = new ArrayList<>(10);

        fillArrayList(intAList, 10);

        removeEvensAndPrintOdds(intAList);
        System.out.println();


//        Ejercicio 7

        try {
            System.out.println(dividePorCero(1,0));
        } catch (Exception e){
            System.out.println("Esto no puede hacerse");
        } finally {
            System.out.println("Demo de codigo");
        }

        //    Ejercicio 8
        String fileInput = "path";
        String fileOutput = "path";
        copiarFichero(fileInput, fileOutput);




    }





// -------------- Functions ----------------


// Ejercicio 0
    /**
     * Devuelva una cadena al revés
     * @param string String
     * @return reversed String
     */
    private static String reverseString(String string) {
        String reversedString = "";
        for (int i = string.length() - 1 ; i >= 0 ; i--) {
            reversedString = reversedString.concat(String.valueOf(string.charAt(i)));
        }

        return reversedString;
    }

    //Ejercicio 1

    /**
     * Muestra los valores de un array
     * @param array Array
     */
    private static void showArrayValues(String[] array) {
        for (String el : array) {
            System.out.println(el);
        }
    }

    // Ejercicio 2

    /**
     * Muestra los valores de un array 2D
     * @param biArray 2D array
     */
    private static void printBidimensionalArray(int[][] biArray) {
        String row = "";
        for (int i = 0 ; i < biArray.length ; i++) {
            for (int j = 0 ; j < biArray[1].length ; j++){
                System.out.printf("%d ", biArray[i][j]);
            }
            System.out.println(row);
        }
    }

    //    Ejercicio 5

    /**
     * Muestra valores de una Collection
     * @param collection Any type of Collection
     */
    private static void printCollectionValues(Collection<String> collection) {
        for (String el : collection) {
            System.out.print(el + " ");
        }
    }

    /**
     * Copia los valores de ArrayList a LinkedList
     * @param aList Array List
     * @param lList Linked List
     */
    private static void copyArrayToLinked(ArrayList<String> aList, LinkedList<String> lList) {
        lList.addAll(aList);
    }

    //    Ejercicio 6

    /**
     * Elemina los pares de un ArrayList y muestra el ArrayList final
     * @param intAList ArrayList of Integers
     */
    private static void removeEvensAndPrintOdds(ArrayList<Integer> intAList) {
        for (int i = intAList.size() - 1; i >= 0 ; i--) {
            if (intAList.get(i) % 2 == 0) {
                intAList.remove(i);
            }
        }
        System.out.println("Array List without evens:");
        for (int el: intAList
        ) {
            System.out.print(el + " ");
        }
    }

    private static void fillArrayList(ArrayList<Integer> arrayList, int size) {
        for (int i = 0 ; i < size ; i++) {
            arrayList.add(i + 1);
        }

    }

    //    Ejercicio 7


    private static double dividePorCero(int a, int b) throws ArithmeticException {
        try {
            return  a / b;
        } catch (Exception e) {
            throw new ArithmeticException();
        }

    }

//    Ejercicio 8
    
    private static void copiarFichero(String fileInput, String fileOutput) throws IOException {
        InputStream fileIn = new FileInputStream(fileInput);
        BufferedInputStream bufferedFileIn = new BufferedInputStream(fileIn);

        try {
            byte[] datos = bufferedFileIn.readAllBytes();
            PrintStream fileOut = new PrintStream(fileOutput);

            fileOut.writeBytes(datos);
        } catch (IOException e) {
            System.out.println("Vaya, se me da un error de IO");
        }


    }

}

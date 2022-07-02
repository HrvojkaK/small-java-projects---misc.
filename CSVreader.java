package com.CSVreaderBuffer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//
//reads a csv file and finds the max value of the real numbers in the first column
//

public class CSVreader {

    public static void main(String[] args) {
        String path = "src/cjenik.csv";//"cjenik.csv"; //or whichever filename&path
        String line;
        Double maxValue = Double.NEGATIVE_INFINITY; // -Double.MAX_VALUE
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
      //      br.readLine(); // skips the 1st line (headeri)
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()){ //no empty lines
                    String[] values = line.split(",");

                    try{
                        double currentValue = Double.parseDouble(values[0]);
//                        System.out.println(currentValue + " je od str: " + values[0] + " i 4-i col.: " + values[4]);
                        System.out.println("old maxValue: " + maxValue + " and current value: " + currentValue);
                        if(currentValue> maxValue) { maxValue = currentValue; }
                    } catch (NumberFormatException e) {
                        System.out.println("Caught str->double; exception: " + e);
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Array out of bounds exception caught: " + e);
                    } catch (Exception e) {
                        System.out.println("Caught exception: " + e); //NullPointerException , NumberFormatException
                    }

                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            System.out.println("caught exc file not found"); //
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("exc 2, IO exc"); //
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("some exception"); //
        }
        System.out.println("Max val: " + maxValue);
    } //return sth;
}
package ru.id61890868.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHelper {

    public static String inputSting(String prompt){
        String inputLine = null;
        System.out.print(prompt);
        try{
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            inputLine = input.readLine();
            if(inputLine.length() == 0){
                return "";
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        return inputLine;
    }

    public static String inputSting(){
        return inputSting("");
    }
}

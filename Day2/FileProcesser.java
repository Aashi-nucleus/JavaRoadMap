package JavaRoadmap.Day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



import JavaRoadmap.CustomException.InvalidDataFormatException;

public class FileProcesser {
    
    public static void main(String[] args) {
        String filePath="Test.txt";
        BufferedReader reader=null;
        try{

            reader=new BufferedReader(new FileReader(filePath));
            String line;
            List<Integer> numbers=new ArrayList<>();
            while((line=reader.readLine())!=null){
                try{

                        int num=parseLineToInt(line);
                        numbers.add(num);
                }
                catch(InvalidDataFormatException e){
                    System.out.println(e.getMessage());

                }
            }
            System.out.println("Parsed numbers are:"+ numbers);
            
        

        }
        catch(FileNotFoundException e){
            System.out.println("File not found error"+e.getMessage());
        }
        catch(IOException e){
            System.out.println("IO excetion occured"+e.getMessage());
        }
        finally{
            try{
                if(reader!=null){
                    reader.close();
                    System.out.println("file reader closed");
                }
            }
            catch(IOException e){
                System.out.println("error occured while closing reader");
            }
        }


    }
    public static int parseLineToInt(String line) throws InvalidDataFormatException{
        try{
            return Integer.parseInt(line.trim());
        } 
        catch(NumberFormatException e)
        {
            throw new InvalidDataFormatException("Invalid format");
        }
    }

}




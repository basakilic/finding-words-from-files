package datastructuresproject2.part2;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Menu {
    public static ReadFile r = new ReadFile();
    
        public void intro(){
        System.out.print("-------------------------------------\n"
                + "Welcome to Word FROM File !\n"
                + "-------------------------------------\n"
                + "You can search a word from multiple files. \n"
                + "Enter a word, and see the files !\n"
                + "-------------------------------------\n");
        menu();
    }        
        
        public void menu(){
            Scanner input = new Scanner(System.in);
            r.readFile();
            System.out.print("-------------------------------------\n"
                + "1. Search a word \n"
                + "2. Quit \n"
                + "Choose the option that you want: ");
            int option = -1;
            try{
                option = input.nextInt();
            }catch(InputMismatchException exception){
                System.out.println("This is not an integer");
            }
                System.out.println(r.sch); // just for check the files names are correct ! 
                
        while (true) {
            if (option == 2) {
                System.out.println("You choose to quit, GOODBYE.");
                break;
            } else if (option == 1) {
                try{
                    System.out.print("Enter a word: ");
                    String word = input.next();
                    System.out.println("This word has been appeared in the following text files: "+r.sch.returnValues(word).toString());
                }catch(Exception e){
                    System.out.println("No text files includes this word.");
            }
            } else if (option==2){
                System.out.println("-------------------------------------");
            }else{
                System.out.println("Invalid option! Please enter a valid option :(");
            }
            menu();
            break;
        }
    }        
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petdatabase;
import java.util.*;
import java.io.*;

/**
 *
 * @author Dan Sullivan
 */
public class PetDatabase {

    /**
     * @param args the command line arguments
     */

    Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Pet> pets = new ArrayList<Pet>();
        Scanner f = new Scanner(new File(database.txt));
        while(f.hasNextLine()){
            String[] arr = f.nextLine().split(" ");
            
            Pet q = new Pet(arr[0], arr[1]);
            
            pets.add(q);
            
        }
        f.close();
        
        
        while(true){
            System.out.println("What would you like to do?");
            System.out.println("1) View all pets");
            System.out.println("2) Add new pet");
            System.out.println("3) Remove a pet");
            System.out.println("4) Exit Program");
            
            int j = input.nextInt();
            input.nextLine();
            
            if (j == 1){
                System.out.println("+----------------------+");
                System.out.println("| ID | NAME      | AGE |");
                System.out.println("+----------------------+");
                for(int i=0; i < pets.size();i++){
                    String a = String.format("%2s", i);
                    String b = String.format("%-10s", pets.get(i).getName());
                    String c = String.format("%3s", pets.get(i).getAge());
                    System.out.println("|" + a + "|" + b + "|" + c "|");

                }
                System.out.println("+----------------------+");
                System.out.println(pets.size() +" rows in set");
            }
            else if(j == 2){
                if(pets.size()>=5){
                    System.out.println("Pet list is full");
                }
                else{
                while(true){
                    System.out.print("Eneter name ");
                    String k = input.nextLine();
                    if("done".equals(k)){
                        break;
                        
                    }
                    else{
                        System.out.print("Enter age ");
                        int l = input.nextInt();
                        input.nextLine();
                        if(l<1 || l>20){
                            System.out.println("Please enter a valid age");
                        }
                        else{
                            String p = Integer.toString(l);
                        Pet c = new Pet(k,p);
                        
                        pets.add(c);
                        }
                    }

                }
                }  
            }
            
            else if(j == 3){
                
                System.out.print("Enter the ID of the Pet to be removed");
                int i = input.nextInt();
                input.nextLine();
                if(i<0 || i>= pets.size()){
                    System.out.println("Please enter a valid ID");
                }
                else{
                pets.remove(i);
                }
            }
            
            else if (j == 4){
                FileOutputStream m = new FileOutputStream(database.txt);
                ObjectOutputStream out = new ObjectOutputStream(m);
                out.writeObject(pets);
                out.close();
                
                System.out.println("Thank You");
                break;
            }
            
        }
    }
    
    
}

class Pet{
    private static String name;
    private static String age;
    
    public Pet(String x, String y){
        name = x;
        age = y;
    }
    
    public String getName(){
        return name;
        
}
    public String getAge(){
        return age;
    }
    
    public void setName(String x){
        name = x;
    }
    
    public void setAge(String x){
        age = y;
    }
}



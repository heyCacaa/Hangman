// LO01 - 2501983433 - Lianca Valencia

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Hangman{
    static String isiData;
    static Scanner scan = new Scanner(System.in);
    static ArrayList<String> data = new ArrayList<String>();
    
    public static void addData(){
        System.out.println();
        System.out.print("Masukkan data [5-50 karakter]: ");
        isiData = scan.nextLine();

        if(data.contains(isiData)){
            System.out.println("Data sudah ada!");
        }

        if(isiData.length() >= 5 && isiData.length() <= 50 && !data.contains(isiData)){
            data.add(isiData);
        } else {
            addData();
        }
    }
    public static void main(String[] args) {
        int input;

        do{
            System.out.println();
            System.out.println("Menu: ");
            System.out.println("1. Add data");
            System.out.println("2. Look data");
            System.out.println("3. Game");
            System.out.println("4. Exit");
            System.out.print("Pilih Menu: ");
            input = scan.nextInt();
            scan.nextLine();
            
            boolean kosong = data.isEmpty();
            Random r = new Random();
            
            switch(input){
                case 1:
                    addData();
                    break;
                case 2:
                   if (kosong == true){
                        System.out.println("There is no data");
                        addData();
                   } else {
                        Collections.sort(data);
                        System.out.println("Sorted in Ascending order : " +data);
                   }
                   break;
                case 3:
                    if (kosong == true){
                        System.out.println("There is no data");
                        addData();
                    } else {
                        int index = r.nextInt(data.size());
                        String randomPick = data.get(index);
                        int len = randomPick.length();
                        
                        char[] kata = randomPick.toCharArray();
                        for(int i = 0 ; i < len ; i++){
                            kata[i] = '-';
                        }
                        
                        int flag = 0;
                        do{
                            System.out.println();
                            System.out.println(kata);
                            System.out.print("Tekan huruf: ");
                            
                            String huruf = scan.nextLine();
                            if(huruf.length() != 1){
                                System.out.println("Masukkan 1 huruf saja!");
                            }
                            
                            if(!randomPick.contains(huruf)){
                                System.out.println("Huruf '" + huruf + "' tidak ada di kata tersebut!");
                            }

                            for(int i = 0 ; i < len ; i++){
                                if(huruf.charAt(0) == randomPick.charAt(i) && huruf.length() == 1){
                                    kata[i] = huruf.charAt(0);
                                }
                            }

                            if(randomPick.equals(new String(kata))){
                                System.out.println();
                                System.out.println(kata);
                                System.out.println("Selamat!");
                                System.out.println();
                                flag = 1;
                            }
                        } while(flag != 1);
                    }
                    break;
            }
        } while(input != 4);
    }
}
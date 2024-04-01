import java.util.*;
public class Alpha{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String st = sc.nextLine();
        int alpha, digits, spcl;
        alpha = digits = spcl = 0;
        for(int i = 0; i < st.length(); i++){
            char c = st.charAt(i);
            if(Character.isLetter(c)){
                alpha++;
            }
            else if(Character.isDigit(c)){
                digits++;
            }
            else{
                spcl++;
            }
        }
        sc.close();
        System.out.println("Number of alphabets:" + alpha);
        System.out.println("Number of digits:" + digits);
        System.out.println("Number of special characters:" + spcl);
    }
}
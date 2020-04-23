import java.util.Scanner;

public class app {

    static String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
                                "p", "q", "r", "s", "t", "u", "v", "x", "y", "z"};

    public static void main(String[] args){
        Scanner usrInput = new Scanner(System.in);
        System.out.println("What will the computer come up with!");
        System.out.print("The range you want your word to go: ");
        int wordLength = usrInput.nextInt();
        String word = strOfLetters(genRandomNumber(wordLength));
        System.out.println("Computer thinks: " + word);
        String partOfStr = returnPartOfStr(word);
        System.out.println("This is your part: " + partOfStr);
        String newWord = returnFromALetter(word);
        System.out.println("Your new word: " + newWord);
        if(equals(word, newWord)){
            System.out.println("The two words are equal!");
        }
        else{
            System.out.println("The two words are not equal!");
        }
        System.out.println(whichGoesFirst(word, newWord));


    }

    private static int genRandomNumber(int range){
        return (int)((Math.random() * range) + 1);
    }

    private static String strOfLetters(int num){
        String jumble = "";
        int randomNum;
        for(int i = 0; i < num; i ++){
            randomNum = (int)(Math.random() * 25);
            if(jumble.contains(alphabet[randomNum])){
                randomNum = (int)(Math.random() * 25);
            }
            else {
                jumble += alphabet[randomNum];
            }

        }
        return jumble;
    }

    private static String returnPartOfStr(String str){
        String returnStr = "None";
        Scanner usrInput = new Scanner(System.in);
        System.out.print("Which part do you want to take out? \n" +
                            "You can say front, middle or end: ");
        String partStr = usrInput.nextLine();
        while(true) {
            if (partStr.equals("front")) {
                int strLen = str.length();
                if((strLen%2) == 0){
                    returnStr = str.substring(0, ((strLen/2) - 1));

                }
                else{
                    returnStr = str.substring(0, strLen/2);
                }
                break;
            } else if (partStr.equals("middle")) {
                int strLen = str.length();
                if((strLen%2) == 0){
                    returnStr = str.substring((strLen/2), ((strLen/2)) + 2);
                }
                else{
                    returnStr = str.substring((strLen/2), ((strLen/2)) + 1);
                }
                break;
            } else if (partStr.equals("end")) {
                int strLen = str.length();
                if((strLen%2) == 0){
                    returnStr = str.substring((strLen/2) + 1);
                }
                else{
                    returnStr = str.substring((strLen/2) + 2);
                }
                break;
            }
        }
        return returnStr;
    }

    private static String returnFromALetter(String str){
        Scanner usrInput = new Scanner(System.in);
        System.out.print("Which letter do you want to return from: ");
        String returnFrom = usrInput.nextLine();
        int intOfReturnFrom = str.indexOf(returnFrom);
        return str.substring(intOfReturnFrom);
    }

    private static boolean equals(String strOne, String strTwo){
        boolean returnBool;
        returnBool = strOne.equals(strTwo);
        return returnBool;
    }

    private static String whichGoesFirst(String strOne, String strTwo){
        String returnStr;
        if(strOne.compareTo(strTwo) < 0){
            returnStr = ("Lexicographically first is " + strOne + ", then is " + strTwo);
        }
        else if(strOne.compareTo(strTwo) > 0){
            returnStr = ("Lexicographically first is " + strTwo + ", then is " + strOne);
        }
        else{
            returnStr = "Lexicographically too both are the same string!";
        }
        return returnStr;
    }




}

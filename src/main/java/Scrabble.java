
import com.sun.deploy.cache.BaseLocalApplicationProperties;

import java.util.HashMap;


public class Scrabble {

    private final String finalWord;
    private final Character[] letterArray = {'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T', 'D',
            'G', 'B', 'C', 'M', 'P', 'F', 'H', 'V', 'W', 'Y', 'K', 'J', 'X', 'Q', 'Z'};
    private final Integer[] scoreArray = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2,
            3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 8, 8, 10, 10};
    private int finalScore;
    public Character[] charDouble;
    public Character[] charTriple;
    private boolean dWord;
    private boolean tWord;
    private int dLetterCount;
    private int tLetterCount;
    private final HashMap<Character, Integer> letterValues = createHash();


    // constructor expecting one argument
    public Scrabble(String word){
        this.finalWord = (word == null) ? "": word.toUpperCase();
    }


    public Scrabble(String word, Character[] charDouble, Character[] charTriple, boolean dWord, boolean tWord) {
        this.finalWord = (word == null) ? "": word.toUpperCase();
        this.charDouble = charDouble;
        this.charTriple = charTriple;
        this.dWord = dWord;
        this.tWord = tWord;
    }


    private HashMap<Character, Integer> createHash(){
        HashMap<Character, Integer> valueAssign = new HashMap();
        for (int i =0; i<letterArray.length; i++) {
            valueAssign.put(letterArray[i],scoreArray[i]);
        }
        return valueAssign;
    };


    int score(){
        for (int i=0; i<finalWord.length(); i++) { char c = finalWord.charAt(i);
                if (charDouble != null && charDouble.length > 0 && c==charDouble[0] && dLetterCount!= 1){ runDouble(letterValues, c);}
                else if (charTriple != null && charTriple.length > 0 && c ==charTriple[0] && tLetterCount!=1) {runTriple(letterValues, c);}
                else {finalScore+=letterValues.get(c);
            }
        }
        return getFinalScore();
    }




    private void runTriple(HashMap<Character, Integer> letterValues, char c) {
        finalScore+=((letterValues.get(c)*3));
        tLetterCount +=1;
        }

    private void runDouble(HashMap<Character, Integer> letterValues, char c) {
        finalScore+=((letterValues.get(c)*2));
        dLetterCount +=1;
    }


    //was static below
    private int getFinalScore() {
        if (dWord) {
            finalScore*=2;}
        else if (tWord) {
            finalScore*=3;
        }
        return finalScore;
    }


    public static void main(String[] args) {
        return;
    };
}






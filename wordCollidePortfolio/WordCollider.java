
/**
 * Write a description of class WordCollider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordCollider
{
    // instance variables - replace the example below with your own
    private Text word1;
    private Text word2;
    // the characters contained in word1
    private Text[] charWord1;
    // the characters contained in word2
    private Text[] charWord2;

    /**
     * Constructor for objects of class WordCollider
     */
    public WordCollider(String w1, String w2)
    {
        // initialise instance variables
        word1 = new Text(w1);
        word1.randomizePosition();
        word1.changeColor("green");
        word1.changeSize(48);
        word1.makeVisible();
        word2 = new Text(w2);
        word2.randomizePosition();
        word2.changeColor("orange");
        word2.changeSize(48);
        word2.makeVisible();
        charWord1 = new Text[w1.length()];
        charWord2 = new Text[w2.length()];
        fillChars(charWord1, w1);
        fillChars(charWord2, w2);
    }

    private void fillChars(Text[] a, String w) {
        char[] cs = w.toCharArray();
        for (int i=0; i<a.length; i++) {
            a[i] = new Text(""+cs[i]);
            a[i].changeSize(48);
            a[i].changeColor("red");
        }
    }

    /**
     * Randomize the position of the two words repeatedly and stop
     * when the bounding box of the two words overlaps.
     */
    public void animate()
    {
        while (checkOverlap(word1, word2) == false) //if word 1 and word 2 is false, then word1 and word3 will be randomised. if there is no overlap, it will randomize word1 and word2 and randomise letters until the overlap is complete.
        {
            word1.randomizePosition();
            word2.randomizePosition();
        }
        
        for (Text letter: charWord1) // when it overlaps, it becomes visible. 
        {
            letter.randomizePosition();
            letter.makeVisible();
        }
        
        for (Text letter: charWord2)
        {
            letter.randomizePosition();
            letter.makeVisible();
        }
    }
    
    /**; charWord1)
     * erase the words and any other characters on the display
     */
    public void clearDisplay() {
        word1.makeInvisible();
        word2.makeInvisible();
        
        for (Text letter:charWord1)
        {
            letter.makeInvisible();
        }
        
         for (Text letter:charWord2)
        {
            letter.makeInvisible();
        }
    }

    /**
     * check if the bounding box of the two words overlaps.
     * @return true when the words overlap and false otherwise.
     */
    private Boolean checkOverlap(Text word1, Text word2) {
        int x= word1.getXPosition();
        int y= word1.getYPosition();
        int x0= word2.getXPosition();
        int y0= word2.getYPosition();
        int w= word1.getTextWidth();
        int h=word1.getTextHeight();
        int w0= word2.getTextWidth();
        int h0= word2.getTextHeight();
        if (x0+4<x && x<x0+w0-4 && y0-h0+4<y-h && y-h<y0-4){ //on this section we are besically focusing on the top left corner of word1. and the position of is greater than x position of word2.i did not have to include the numbers but it makes it easier to see that it overlaps.
            return true;
        }
         return false;
  
}
}
   
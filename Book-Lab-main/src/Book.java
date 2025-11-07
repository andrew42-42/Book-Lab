//A few assumptions.......

//Words will be separated by spaces. 
//There can be punctuation in a word, we will only add/keep punctuation at the end of a string if it is at the end of a string.
//    for examples: Hello.==> Ellohay.    Good-bye! ==> Ood-byegay!    so... ==> osay...

public class Book
{
  public String pigLatin(String word)
  {
    String pig = "";
    String vowels = "aeiouyAEIOUY";
    String digits = "1234567890";
    word.toLowerCase();
    if(word.length() == 0){
      pig = word;
    }
    else if(digits.contains(word.substring(0,1))){
      pig = word;
    }
    else if(vowels.contains(word.substring(0,1))){
      pig = word + "yay";
    }
    else if(word.length() == 1){
      pig = word + "ay";
    }
    else{
      for(int i=word.length()-1; i>=0; i--){
        if(vowels.indexOf(word.substring(i, i+1)) >= 0){
          String left = word.substring(0,i);
          String right = word.substring(i);
          pig = right + left + "ay";
        }
      }
    }
    return pig;
  }
  
  public int endPunctuation(String word)  //return the index of where the punctuation is at the end of a String. If it is all punctuation return 0, if there is no punctuation return -1
  {

    return -1;
  }

  public String translateWord(String word)    //to share with class
  {
    if(word.length() <= 0){
      return word;
    }
    else{
      String convertedWord = "";
      String punctuation = "!.,;:@#$%^&*()-_'?";
      String base = word;
      String endPunc = "";
      int earliestPunc = 999;
      Character firstLetter = word.charAt(0);
      int puncCount = -1;
      base.toLowerCase();

      if(punctuation.contains(word.substring(word.length()-1))){
        for(int i=0; i<word.length(); i++){
          if(punctuation.contains(word.substring(i,i+1))){
            endPunc+=word.substring(i,i+1);
            earliestPunc = i;
            puncCount++;
            if(i<=earliestPunc){
              base = word.substring(0,i-puncCount).toLowerCase();
            }
          }
        }
      }

      convertedWord = pigLatin(base) + endPunc;
      
      if(Character.isUpperCase(firstLetter)){
      convertedWord = (pigLatin(base)).substring(0,1).toUpperCase() + (pigLatin(base)).substring(1).toLowerCase() + endPunc;
      }

      return convertedWord;

    }
  }

  public String translateSentence(String sentence)
  {
    String retSentence = "";
    int space = sentence.indexOf(" ");
    while(space>-1){
      retSentence += translateWord(sentence.substring(0, space)) + " ";
      sentence = sentence.substring(space + 1);
      space = sentence.indexOf(" ");
    }
    if(sentence.length() > 1){
      retSentence += translateWord(sentence);
    }


    return retSentence;
  }
}  

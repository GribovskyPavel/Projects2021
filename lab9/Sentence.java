package by.bsu.lab9;
import java.util.ArrayList;

public class Sentence extends Word{
    private final ArrayList<Word> Words;
    private final ArrayList<Word> Spaces;
    private final boolean firstIsWord;

    public Sentence(String sentence) {
        super();
        this.Words = new ArrayList<>();
        this.Spaces = new ArrayList<>();
        int indexBegin = 0;
        int indexEnd;
        int spaceCounter = 0;
        Symbol space = new Symbol(' ');
        this.firstIsWord = sentence.charAt(0) != space.getSymbol();
        for (int i = 0; i < sentence.length(); i++) {
            if(sentence.charAt(i) == space.getSymbol() || i == sentence.length()-1){
                indexEnd = i;
                if(i == sentence.length()-1){
                    indexEnd++;
                }
                Word word = new Word(sentence.substring(indexBegin,indexEnd));
                if(!word.getWord().equals("") && !word.getWord().contains(" ")){
                    Words.add(word);
                }
                if(i != sentence.length()-1) {
                    indexBegin = indexEnd + 1;
                }
            }
        }
        for (int i = 0; i < sentence.length(); i++) {
            if(sentence.charAt(i) == space.getSymbol()){
                spaceCounter++;
            }
            else if(spaceCounter != 0){
                Word spaces = new Word();
                String str = "";
                for (int j = 0; j < spaceCounter; j++) {
                    str+=" ";
                }
                spaces.setWord(str);
                Spaces.add(spaces);
                spaceCounter = 0;
            }
            if(i==sentence.length()-1){
                Word spaces = new Word();
                String str = "";
                for (int j = 0; j < spaceCounter; j++) {
                    str+=" ";
                }
                spaces.setWord(str);
                Spaces.add(spaces);
            }
        }
    }

    public void firstLastChange(){
        Word firstWord = new Word(Words.get(0).getWord());
        Word lastWord = new Word(Words.get(Words.size()-1).getWord());
        this.Words.remove(0);
        this.Words.add(0,lastWord);
        this.Words.remove(Words.size()-1);
        this.Words.add(Words.size(),firstWord);
    }
    public String createSentence(){
        String sentence = "";
        if(Words.size() == Spaces.size() && firstIsWord) {
            for (int i = 0; i < Words.size(); i++) {
                sentence += Words.get(i).getWord();
                sentence += Spaces.get(i).getWord();
            }
            sentence += ".";
            return sentence;
        }
        if(Words.size() != Spaces.size() && firstIsWord) {
            for (int i = 0; i < Spaces.size(); i++) {
                sentence += Words.get(i).getWord();
                sentence += Spaces.get(i).getWord();
            }
            sentence += Words.get(Spaces.size()).getWord();
            sentence += ".";
            return sentence;
        }
        if(Words.size() == Spaces.size() && !firstIsWord) {
            for (int i = 0; i < Words.size(); i++) {
                sentence += Spaces.get(i).getWord();
                sentence += Words.get(i).getWord();
            }
            sentence += ".";
            return sentence;
        }
        if(Words.size() != Spaces.size() && !firstIsWord) {
            for (int i = 0; i < Words.size(); i++) {
                sentence += Spaces.get(i).getWord();
                sentence += Words.get(i).getWord();
            }
            sentence += Spaces.get(Words.size()).getWord();
            sentence += ".";
            return sentence;
        }
        return sentence;
    }
    public String createSentenceWithoutSpaces(){
        String sentence = "";
        for (int i = 0; i < Words.size(); i++) {
            sentence += Words.get(i).getWord();
            if(i!=Words.size()-1) {
                sentence += " ";
            }
        }
        sentence += ".\n";
        return sentence;
    }
}

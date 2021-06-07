package by.bsu.mmf.Lab4.PartB;
/**
 * The functional part of the class Music
 * @author pavelgribovsky
 */
public class MusicAction extends Music{
    /**
     * The function initializes the objects of the class Music(further songs) randomly
     * @param Music Array of the objects of the class Music
     */
    public static void randomInitMusicObj(Music[] Music){
        int flag;
        for (int i = 0; i < Music.length; i++) {
            flag = (int)(8*Math.random())+1;
            switch (flag){
                case 1:{
                    Music[i] = new Classical();
                } break;
                case 2:{
                    Music[i] = new Country();
                } break;
                case 3:{
                    Music[i] = new Disco();
                } break;
                case 4:{
                    Music[i] = new Electronic();
                } break;
                case 5:{
                    Music[i] = new Hip_Hop();
                } break;
                case 6:{
                    Music[i] = new Indie();
                } break;
                case 7:{
                    Music[i] = new Jazz();
                } break;
                case 8:{
                    Music[i] = new Rock();
                } break;
                default:
                    System.out.println("Mistake in numeration!");
            }
        }
    }
    /**
     *The function sorts the songs by styles
     * @param Music Array of the objects of the class Music
     */
    public static void sortByStyle(Music[] Music, int numberStyles){
        System.out.println("---Sorting by style---");
        for (int i = 0; i < numberStyles; i++) {
            for (int j = 0; j < Music.length; j++) {
                switch(Music[j].getStyle()){
                    case "Electronic":{
                        if(i==0) System.out.println(Music[j]);
                    }break;
                    case "Disco":{
                        if(i==1) System.out.println(Music[j]);
                    }break;
                    case "Country":{
                        if(i==2) System.out.println(Music[j]);
                    }break;
                    case "Classical":{
                        if(i==3) System.out.println(Music[j]);
                    }break;
                    case "Rock":{
                        if(i==4) System.out.println(Music[j]);
                    }break;
                    case "Jazz":{
                        if(i==5) System.out.println(Music[j]);
                    }break;
                    case "Indie":{
                        if(i==6) System.out.println(Music[j]);
                    }break;
                    case "Hip_Hop":{
                        if(i==7) System.out.println(Music[j]);
                    }break;
                }
            }
        }
    }
    /**
     * The function outputs the songs in console
     * @param Music Array of the objects of the class Music
     */
    public static void outputArrMusicObj(Music[] Music) {
            System.out.println("---The array of the objects---");
            for (Music element : Music) {
                System.out.println(element);
            }
    }
    /**
     * The function counts the duration of all songs
     * @param Music Array of the objects of the class Music
     * @return int type
     */
    public static int wholeTimeOfSongsArrMusicObj(Music[] Music){
        int time = 0;
        for (Music element: Music) {
            time+=element.getLength();
        }
        return time;
    }
    /**
     * The function chooses those songs the duration of which is within the fixed limits
     * @param Music Array of the objects of the class Music
     * @param fixedLengthLeft The inf boarder of searching
     * @param fixedLengthRight The sup boarder of searching
     */
    public static void outputWithValueArrMusicObj(Music[] Music, int fixedLengthLeft, int fixedLengthRight ){
        System.out.println("---Finding the song with fixed length---");
        for (int i = 0; i < Music.length; i++) {
            if(Music[i].getLength()>=fixedLengthLeft && Music[i].getLength()<=fixedLengthRight){
                System.out.println(Music[i]);
            }
        }
    }
    /**
     * The function counts the memory of all songs
     * @param Music Array of the objects of the class Music
     * @return int type
     */
    public static int wholeMemoryOfSongsArrMusicObj(Music[] Music){
        System.out.println("---The size of the songs on disk---");
        int memory = 0;
        for (Music element: Music) {
            memory+=element.getMemoryInKb();
        }
        return memory;
    }
    /**
     * The function returns the result with memory of the song in standard view
     * @param memory The memory of the song
     * @return String type
     * @throws MusicException because of negative value of the 'memory'
     */
    public static String memoryInStView(int memory) throws MusicException{
        if(memory<0){
            throw new MusicException("Memory must be positive value!");
        }
        int Mb = 0;
        int Kb;
        while (true){
            if(memory>=1024){
                Mb++;
                memory-=1024;
            }
            if(memory<1024){
                Kb=memory;
                return Mb+"Mb "+Kb+"Kb";
            }
        }
    }
}

package by.bsu.mmf.Lab4.PartB;
import java.util.Objects;
/**
 * The class Music includes some sorting,
 * outputting, searching methods for the
 * work with its objects
 * @author pavelgribovsky
 */
public class Music {
    protected int length;
    protected int memoryInKb;
    protected String style;

    public Music() {
        this.length = (int)(Math.random()*300)+60;
        this.memoryInKb = 1024*(this.length)/60 + (int)(Math.random()*1000);
        this.style = "Unknown style";
    }

    public String getStyle(){
        return style;
    }
    public int getLength() {
        return length;
    }
    public int getMemoryInKb() {
        return memoryInKb;
    }

    @Override
    public String toString() {
        try {
            return "Music{" +
                    "length= " + length +
                    "sec, memory= " + MusicAction.memoryInStView(this.getMemoryInKb())+
                    ", style='" + style + '\'' +
                    '}';
        } catch (MusicException e) {
            e.printStackTrace();
        }
        return "Music{" +
                "length= " + length +
                ", style='" + style + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Music music = (Music) o;
        return length == music.length && Double.compare(music.memoryInKb, memoryInKb) == 0 && style.equals(music.style);
    }
    @Override
    public int hashCode() {
        return Objects.hash(length, memoryInKb, style);
    }
}

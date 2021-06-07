package by.bsu.mmf.Lab4.PartB;

public class MusicThread implements Runnable{
    private Music[] Mus;

    public MusicThread(Music[] mus) {
        Mus = mus;
    }
    @Override
    public void run() {
        MusicAction.outputArrMusicObj(Mus);
    }
}

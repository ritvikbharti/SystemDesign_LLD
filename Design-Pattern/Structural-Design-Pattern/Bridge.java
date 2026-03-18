

interface PlayQuality{
    void play(String tiltle);
}
interface VideoQuality{
    void load(String tiltle);
}

class SDQuality implements VideoQuality{
    public void load(String title){
        System.out.println("Streaming "+ title + " is Sd Quality");;
    }
}
class HDQuality implements VideoQuality{
    public void load(String title){
        System.out.println("Streaming "+ title + " in HD Quality");;
    }
}
class UltraHDQuality implements VideoQuality{
    public void load(String title){
        System.out.println("Streaming "+ title + " in 4k ultra HD Quality");;
    }
}

class WebHdPlayer implements PlayQuality{
    public void play(String title){
        System.out.println("Web Player: Playing "+ title + " in Hd");

    }


}

abstract class VideoPlayer{
    protected VideoQuality quality;
    public VideoPlayer(VideoQuality quality){
        this.quality = quality;
    }
    public abstract void play(String title);
}


class WebPlayer extends VideoPlayer{
      public WebPlayer(VideoQuality quality){
        super(quality);
    }
    public void play(String title){
     System.out.println("Web Platform");
     quality.load(title);

    }
}
class MobilePlayer extends VideoPlayer{
     public MobilePlayer(VideoQuality quality){
        super(quality);
    }
    public void play(String title){
        System.out.println("Mobile Platform");
        quality.load(title);
    }
}



public class Bridge{
    public static void main(String[] args) {
        // WebPlayer videoPlayer = new WebPlayer(new HDQuality());
        // videoPlayer.play("The pursuit of happiness");
        VideoPlayer videoPlayer = new WebPlayer(new HDQuality());
        videoPlayer.play("3 idiots");


    }
}
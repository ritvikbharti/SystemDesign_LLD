import java.util.HashMap;
import java.util.Map;

interface VideoDownloader{
    String downloadVideo(String videourl);
}
class RealVideoDownloader implements VideoDownloader{
    @Override
    public String downloadVideo(String videourl){
        System.out.println("Downloading video from url: "+ videourl);
        return "Video Content for " + videourl;
    }


}


class CachedVideoDownloader implements VideoDownloader{
    private RealVideoDownloader realDownloader;
    private Map<String,String> cache;
    public CachedVideoDownloader(){
        this.realDownloader = new RealVideoDownloader();
        this.cache = new HashMap<>();
    }

    @Override
    public String downloadVideo(String videourl){
        if(cache.containsKey(videourl)){

            System.out.println("Returning Cached Video for: "+ videourl);
            return cache.get(videourl);
        }
        System.out.println("Cache miss. Downloading..");
        String video = realDownloader.downloadVideo(videourl);
        cache.put(videourl, video);
        return video;

    }

}





public class Proxy {

    public static void main(String[] args) {
      RealVideoDownloader realVideoDownloader = new RealVideoDownloader();
      realVideoDownloader.downloadVideo("#proxy-pattern");

      RealVideoDownloader realVideoDownloader2 = new RealVideoDownloader();
      realVideoDownloader2.downloadVideo("#proxy-pattern");
    }
}
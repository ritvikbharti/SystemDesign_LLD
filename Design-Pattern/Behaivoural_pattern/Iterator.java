import java.util.ArrayList;
import java.util.List;

class Video{
    String title;
    public Video(String title){
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

}



interface PlaylistIterator{
    boolean hasNext();
    Video next();

}

// concrete iterrator- traversal algo 1
class YouTubePlaylistIterator implements PlaylistIterator{
    private List<Video> videos;
    private int position;
    public YouTubePlaylistIterator(List<Video> videos){
        this.videos = videos;
        this.position = 0;
    }
    @Override
    public boolean hasNext(){
        return position < videos.size();
    }
    @Override
    public Video next(){
        return hasNext() ? videos.get(position++) : null;
    }
}

interface Playlist{
    PlaylistIterator createIterator();
    // PlaylistIterator createCopyrightIterator();
}

class YouTubePlaylist implements Playlist{
    private List<Video> videos = new ArrayList<>();

    public void addVideo(Video video){
        videos.add(video);
    }
    @Override
    public PlaylistIterator createIterator(){
        return new YouTubePlaylistIterator(videos);
    }

    // @Override
    // public PlaylistIterator createCopyrightIterator(){
    //     // return new YouTubePlaylistCRightIterator(videos);
    // }
}

public class Iterator{
    public static void main(String[] args) {
        YouTubePlaylist playlist = new YouTubePlaylist();
        playlist.addVideo(new Video("LLD TUTORIAL"));
        playlist.addVideo(new Video("System Design Basics"));
        YouTubePlaylist playlist2 = new YouTubePlaylist();
        playlist2.addVideo(new Video("JAVA_SPRINGBOOT_TELLUSKO"));
        playlist2.addVideo(new Video("Spring Ai"));
        playlist2.addVideo(new Video("docker"));




// ----------------before Iterartor
              /*   for(Video v : playlist.getVideos()){
                    System.out.println(v.getTitle());
                }
                */

            PlaylistIterator iterator = playlist2.createIterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next().getTitle());
            }

    }
}
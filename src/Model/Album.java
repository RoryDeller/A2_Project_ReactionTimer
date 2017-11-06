package Model;

public class Album {

    private int albumID;
    private String albumName;

    public Album(int albumID, String albumName) {
        this.albumID = albumID;
        this.albumName = albumName;
    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
}

package Model;

public class Artist {

    private int artistID;
    private int albumID;
    private String artistFirstname;
    private String artistSurname;
    private String bandName;



    public Artist(int artistID, int albumID, String artistFirstname, String artistSurname, String bandName) {
        this.artistID = artistID;
        this.albumID = albumID;
        this.artistFirstname = artistFirstname;
        this.artistSurname = artistSurname;
        this.bandName = bandName;
    }



    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public int getAlbumID() {return albumID;}

    public void setAlbumID(int albumID) {this.albumID = albumID;}

    public String getArtistFirstname() {
        return artistFirstname;
    }

    public void setArtistFirstname(String artistFirstname) {
        this.artistFirstname = artistFirstname;
    }

    public String getArtistSurname() {
        return artistSurname;
    }

    public void setArtistSurname(String artistSurname) {
        this.artistSurname = artistSurname;
    }

    public String getBandName() {return bandName;}

    public void setBandName(String bandName) {this.bandName = bandName;}
}

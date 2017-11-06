package Model;

public class Artist {

    private int artistID;
    private String artistFirstname;
    private String artistSurname;

    public Artist(int artistID, String artistFirstname, String artistSurname) {
        this.artistID = artistID;
        this.artistFirstname = artistFirstname;
        this.artistSurname = artistSurname;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

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
}

package Model;

public class ArtistGenre {

    private int artistID;
    private int genreID;
    private String bandName;

    public ArtistGenre(int artistID, int genreID, String bandName) {
        this.artistID = artistID;
        this.genreID = genreID;
        this.bandName = bandName;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }
}

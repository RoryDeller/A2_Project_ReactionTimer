package Model;

public class MusicFiles {

    private int fileID;
    private String fileType;
    private String songName;

    public MusicFiles(int fileID, String fileType, String songName) {
        this.fileID = fileID;
        this.fileType = fileType;
        this.songName = songName;
    }

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
}

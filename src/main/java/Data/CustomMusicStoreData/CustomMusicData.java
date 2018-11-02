package Data.CustomMusicStoreData;

public enum CustomMusicData {
    SONG_NAME("saga");

    public String getSongName() {
        return songName ;
    }

    private String songName;


    CustomMusicData(String songName){
        this.songName=songName;
    }
}

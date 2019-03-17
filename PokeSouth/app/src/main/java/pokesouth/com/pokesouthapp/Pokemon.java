package pokesouth.com.pokesouthapp;

public class Pokemon {

    private String Name;
    private String CP;
    private int Photo;
    private int StatPhoto;

    public Pokemon() {
    }

    public Pokemon(String name, String CP, int photo, int statPhoto) {
        Name = name;
        this.CP = CP;
        Photo = photo;
        StatPhoto = statPhoto;
    }

    public String getName() {
        return Name;
    }

    public String getCP() {
        return CP;
    }

    public int getPhoto() {
        return Photo;
    }

    public int getStatPhoto(){
        return StatPhoto;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

    public void setStatPhoto(int statPhoto){
        StatPhoto = statPhoto;
    }
}

package location;

public abstract class NormalLoc extends Location {
    public NormalLoc(String name, String feature){
        this.name = name;
        this.feature = feature;
    }

    @Override
    public String toString(){
        return "Name of location: " + name + "\nProperty of Location: " + feature;
    }
}

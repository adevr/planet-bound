package logic.data.resources;

public class Resource {

    private boolean converted = false;
    private boolean collected = false;

    public Resource(){}

    public boolean isConverted()
    {
        return converted;
    }

    public void convert()
    {
        this.converted = true;
    }

    public boolean isCollected()
    {
        return collected;
    }

    public void collect()
    {
        this.collected = true;
    }

}

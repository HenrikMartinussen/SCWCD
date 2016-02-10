package info.martinussen.scwcd.hfsj.ch4.testdriver;

public abstract class Page {
    private String title;

    public void setTitle(String title){
        this.title = title;
    }

    public boolean titleContainsIgnoreCase(String fragment){
        final boolean returnValue;
        if (title.toLowerCase().contains(fragment.toLowerCase())){
            returnValue = true;
        } else {
            returnValue = false;
        }
        return returnValue;
    }

}

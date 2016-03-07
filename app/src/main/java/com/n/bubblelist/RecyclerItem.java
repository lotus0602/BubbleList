package com.n.bubblelist;

/**
 * Created by N on 2015-10-12.
 */
public class RecyclerItem {
    private int resource_ID;
    private int count;

    public RecyclerItem(int resource_ID, int count){
        this.resource_ID = resource_ID;
        this.count = count;
    }

    public int getResource_ID(){
        return resource_ID;
    }
    public int getCount(){
        return count;
    }
    public void setResource_ID(int resource_ID){
        this.resource_ID = resource_ID;
    }
    public void setCount(int count){ this.count = count;}
    public void upCount(){this.count++;}
}

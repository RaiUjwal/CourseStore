package org.sddtu.exampleproject.DataProviders;

/**
 * Created by mohitkumar on 07/01/17.
 */

public class FlipViewData {

    private String place;
    private int imagesrc;
    private String buttext;
    private String swipetext;

    public FlipViewData(String place,String buttext,String swipetext,int imagesrc)
    {
        this.place = place;
        this.imagesrc = imagesrc;
        this.buttext = buttext;
        this.swipetext = swipetext;
    }

    public String getButtext() {
        return buttext;
    }

    public String getSwipetext() {
        return swipetext;
    }

    public void setSwipetext(String swipetext) {
        this.swipetext = swipetext;
    }

    public void setButtext(String buttext) {
        this.buttext = buttext;
    }

    public int getImagesrc() {
        return imagesrc;
    }

    public String getPlace() {
        return place;
    }

    public void setImagesrc(int imagesrc) {
        this.imagesrc = imagesrc;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}

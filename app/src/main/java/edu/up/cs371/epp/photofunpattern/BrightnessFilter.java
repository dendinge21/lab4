package edu.up.cs371.epp.photofunpattern;

import android.graphics.Color;

/**
 *  class BrightFilter changes the image manipulation behavior of its parent
 *  PhotoFilter to increase an image brightness by value of 100.
 *
 *  @author Edward C. Epp
 *  @version November 2017
 *  https://github.com/edcepp/PhotoFunPattern
 */

public class BrightnessFilter extends PhotoFilter {

    private final int ADJUSTMENT = 100;

    /*
    * tranformPixel This method overrides the transformPixel in the parent
    * class. It adds 100 to each RGB color component. The maxium value of each
    * component is limited to 255
    *
    * @param inPixel is a 32 bit pixel that contains RGB color values
    * @return a new Pixel in which each of the RGB components has been increased
    */
    public int transformPixel(int pixel1, int pixel2, int pixel3, int pixel4, int pixel5, int pixel6, int pixel7, int pixel8, int pixel9) {
        int red = constrain(Color.red(pixel1) + ADJUSTMENT);
        int green = constrain(Color.green(pixel1) + ADJUSTMENT);
        int blue = constrain(Color.blue(pixel1) + ADJUSTMENT);
        int outPixel = Color.argb(Color.alpha(pixel1), red, green, blue);
        return outPixel;
    }

}

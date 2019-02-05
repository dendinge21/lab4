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

public class WestEdgeFilter extends PhotoFilter {


    /*
    * tranformPixel This method overrides the transformPixel in the parent
    * class. It adds 100 to each RGB color component. The maxium value of each
    * component is limited to 255
    *
    * @param inPixel is a 32 bit pixel that contains RGB color values
    * @return a new Pixel in which each of the RGB components has been increased
    */
    public int transformPixel(int pixel1, int pixel2, int pixel3, int pixel4, int pixel5, int pixel6, int pixel7, int pixel8, int pixel9) {
        int outPixel = (pixel1 + pixel2 + -1*pixel3 + pixel4 + -2*pixel5 + -1*pixel6 + pixel7 + pixel8 + -1*pixel9)/9;
        int red = constrain(Color.red(outPixel));
        int green = constrain(Color.green(outPixel));
        int blue = constrain(Color.blue(outPixel));
        int average = (red+green+blue)/3;
        return Color.argb(Color.alpha(pixel5), average,average,average);
    }

}

package edu.up.cs371.epp.photofunpattern;

import android.graphics.Color;

/**
 *  class GrayFilter changes the image manipulation behavior of its parent
 *  PhotoFilter to convert the image to gray scale.
 *
 *  @author Edward C. Epp
 *  @version November 2017
 *  https://github.com/edcepp/PhotoFunPattern
 */

public class SmoothFilter extends PhotoFilter {

    /*
    * tranformPixel This method overrides the transformPixel in the parent
    * class. It transforms a color pixel to gray by averaging its three RGB
    * components.
    *
    * @param inPixel is a 32 bit pixel that contains RGB color values
    * @return a new Pixel in which each of the RGB components is their averaged
    * value
    */
    public int transformPixel(int pixel1, int pixel2, int pixel3, int pixel4, int pixel5, int pixel6, int pixel7, int pixel8, int pixel9) {
       // pixel5 = (pixel1 +pixel2+pixel3+pixel4+pixel5+pixel6+pixel7+pixel8+pixel9)/9;
        int redAvg = (Color.red(pixel1)+ Color.red(pixel2)+Color.red(pixel3)+Color.red(pixel4)+Color.red(pixel5)+Color.red(pixel6)+Color.red(pixel7)+Color.red(pixel8)+Color.red(pixel9))/9;
        int blueAvg = (Color.blue(pixel1)+ Color.blue(pixel2)+Color.blue(pixel3)+Color.blue(pixel4)+Color.blue(pixel5)+Color.blue(pixel6)+Color.blue(pixel7)+Color.blue(pixel8)+Color.blue(pixel9))/9;
        int greenAvg = (Color.green(pixel1)+ Color.green(pixel2)+Color.green(pixel3)+Color.green(pixel4)+Color.green(pixel5)+Color.green(pixel6)+Color.green(pixel7)+Color.green(pixel8)+Color.green(pixel9))/9;

      //  int intensity = (Color.red(redAvg) + Color.green(pixel5) +
               //Color.blue(pixel5));
        return Color.argb(Color.alpha(pixel5), redAvg ,greenAvg,blueAvg);
    }

}

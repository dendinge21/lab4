package edu.up.cs371.epp.photofunpattern;

import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.graphics.Bitmap;
        import android.graphics.drawable.BitmapDrawable;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
        import android.widget.Button;
        import android.view.View;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 *  class PhotoFun controls this photo manipulation app.
 *
 *  @author  Edward C. Epp
 *  @version November 2017
 *   https://github.com/edcepp/PhotoFunPattern
 *
 */

public class PhotoFun extends AppCompatActivity {

    // Image resources
    private Bitmap myOriginalBmp;
    private ImageView myNewImageView;

    //public PhotoFun(ArrayList<Bitmap> myImageBmps) {
       // this.myImageBmps = myImageBmps;
   // }

    /*
    * onCreate This constructor lays out the user interface, initializes the
    * original image and links buttons to their actions.
    *
    * @param savedInstanceState Required by parent object
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_fun);

        ImageView originalImageView =
                (ImageView) findViewById(R.id.originalImage);
        myOriginalView = originalImageView;
        BitmapDrawable originalDrawableBmp =
                (BitmapDrawable) originalImageView.getDrawable();
        myOriginalBmp = originalDrawableBmp.getBitmap();

        myNewImageView = (ImageView) findViewById(R.id.newImage);

        Button grayFilterButton =
                (Button) findViewById(R.id.grayFilterButton);
        grayFilterButton.setOnClickListener(new grayFilterButtonListener());
        Button westEdgeFilterButton =
                (Button) findViewById(R.id.westEdgeFilterButton);
        westEdgeFilterButton.setOnClickListener
                (new westEdgeFilterButtonListener());
        Spinner spinnerButton = (Spinner) findViewById(R.id.imageNames);


            initSpinner();
            initImageArray();
            // initImageArray();
            //spinnerButton
       // spinnerButton.onItemSelected();

    }

    /*
    * class grayFilterButtonListener this inner class defines the action for
    * the gray filter button.
    */
    private class grayFilterButtonListener implements View.OnClickListener {
        public void onClick(View button) {
            SmoothFilter filter = new SmoothFilter();
            myNewImageView.setImageBitmap(filter.apply(myOriginalBmp));
        }
    }

    /*
    * class grayFilterButtonListener this inner class defines the action for the
    * brightness filter
    * button.
    */
    private class westEdgeFilterButtonListener
            implements View.OnClickListener {
        public void onClick(View button) {
            WestEdgeFilter filter = new WestEdgeFilter();
            myNewImageView.setImageBitmap(filter.apply(myOriginalBmp));
        }
    }
    //private Bitmap myOriginalBmp;
    private ImageView myOriginalView;
    //private ImageView myNewImageView;

    private String[] myImageNames;
    private ArrayList<Bitmap> myImageBmps;

    private void initSpinner (){
        Spinner spinner = (Spinner) findViewById(R.id.imageNames);
        myImageNames =
                getResources().getStringArray(R.array.imageNames);
        ArrayAdapter adapter = new ArrayAdapter<String> (this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                myImageNames);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener
                (new MySpinnerListener());
    }

    private void initImageArray () {
        myImageBmps = new ArrayList<Bitmap>();
        TypedArray imageIds =
                getResources().obtainTypedArray(R.array.imageIdArray);

        for (int i = 0; i < myImageNames.length; i++) {
            int id = imageIds.getResourceId(i, 0);
            if (id == 0)
                id = imageIds.getResourceId(0, 0);
            Bitmap bmp =
                    BitmapFactory.decodeResource(getResources(), id);
            myImageBmps.add(bmp);
        }
    }

    private class MySpinnerListener implements
            AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parentView,
                                   View selectedItemView,
                                   int position,
                                   long id) {
            myOriginalView.setImageBitmap
                    (myImageBmps.get(position));
            BitmapDrawable originalDrawableBmp =
                    (BitmapDrawable) myOriginalView.getDrawable();
            myOriginalBmp = originalDrawableBmp.getBitmap();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

}


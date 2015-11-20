package fr.remy_drouet.taquin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.BoringLayout;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Rémy on 19/11/2015.
 */
public class TaquinAdapter extends BaseAdapter {
    private Context mContext;
    private  int size;
    private Bitmap bmp;
    private Bitmap[] samples;
    private DisplayMetrics windowsSize;

    public TaquinAdapter(Context c,int s, Bitmap b, DisplayMetrics dm){
        mContext = c;
        size = s;
        bmp = b;
        windowsSize = dm;
        createPictureSamples();
    }
    @Override
    public int getCount() {
        return samples.length;
    }

    @Override
    public Object getItem(int position) {
        return samples[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setAdjustViewBounds(true);
            imageView.setPadding(5,5,5,5);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageBitmap(samples[position]);
        return imageView;
    }

    private void createPictureSamples(){
        samples = new Bitmap[size*size];
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                samples[i*size+j] = Bitmap.createBitmap(bmp, j*bmp.getWidth()/size, i*bmp.getHeight()/size,bmp.getWidth()/size,bmp.getHeight()/size);
                samples[i*size+j] = Bitmap.createScaledBitmap(samples[i * size + j], windowsSize.widthPixels / size, windowsSize.widthPixels / size, true);
                if(i+j==2*(size-1)){
                    samples[i*size+j] = Bitmap.createBitmap(windowsSize.widthPixels / size, windowsSize.widthPixels / size, Bitmap.Config.ALPHA_8);
                }
            }
        }

        System.out.println("Samples : "+samples.length);
    }
}

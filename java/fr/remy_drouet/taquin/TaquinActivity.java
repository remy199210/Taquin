package fr.remy_drouet.taquin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class TaquinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GridView grille = (GridView) findViewById(R.id.maGrille);

        Bitmap bmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.chat);
        //         pour récupérer la taille de l'écran
        Display d = getWindowManager().getDefaultDisplay();
        DisplayMetrics m = new DisplayMetrics();
        d.getMetrics(m);
        grille.setAdapter(new TaquinAdapter(this, 4, bmp, m));
        grille.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(TaquinActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

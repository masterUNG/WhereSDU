package appewtc.masterung.wheresdu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import appewtc.masterung.wheresdu.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Show Fragment
        if (savedInstanceState == null) {

            MainFragment mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentContent, mainFragment).commit();

        }


    }   // Main Method

}   // Main Class

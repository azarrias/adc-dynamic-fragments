package es.pue.android.dynamicfragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm = getSupportFragmentManager();
    Fragment fragment = fm.findFragmentById(R.id.main_container);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (fragment == null){
            fragment = new BlankFragment();
            fm.beginTransaction()
                    .add(R.id.main_container, fragment)
                    .commit();
        }
    }

    public void removeFragment(View view){
        fm.beginTransaction()
                .remove(fragment)
                .commit();
    }
}

package afifi.neveen.neveentaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //start next activity (screen) automatically  after period of time
        Handler h=new Handler();
        Runnable r=new Runnable() {
            @Override
            public void run() {
                //فحص هل تم الدخول مسبقا؟
                FirebaseAuth auth=FirebaseAuth.getInstance();
                if(auth.getCurrentUser()==null)
                {
                    //to open new activity          from current        to next
                    Intent i = new Intent(SplashScreen.this, SignInActivity.class);
                    startActivity(i);
                    //to close current activity
                    finish();
                }
                else
                {
                    //to open new activity          from current        to next
                    Intent i = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(i);
                    //to close current activity
                    finish();
                }
            }
        };
        h.postDelayed(r,3000);


    }
}
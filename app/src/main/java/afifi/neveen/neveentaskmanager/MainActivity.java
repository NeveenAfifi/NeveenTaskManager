





package afifi.neveen.neveentaskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //تقوم ببناء شاشة التنسيق وكل الكائنات التي تحويها
        setContentView(R.layout.activity_main);
        //crwat kjsdnfjsjdfkjsdfnkj
        AddTaskActivity a = new AddTaskActivity();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId()==R.id.itmSettings)
        {
            Intent i=new Intent(MainActivity.this,SittingsActivity.class);
            startActivity(i);
        }
        if (item.getItemId()==R.id.itmSignOut)
        {
            //تسجيل الخروج
            FirebaseAuth.getInstance().signOut();
            finish();

        }
        return true;

    }

}
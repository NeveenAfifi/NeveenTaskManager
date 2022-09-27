





package afifi.neveen.neveentaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //تقوم ببناء شاشة التنسيق وكل الكائنات التي تحويها
        setContentView(R.layout.activity_main);
        //crwat kjsdnfjsjdfkjsdfnkj
        AddTaskActivity a = new AddTaskActivity();
    }
}
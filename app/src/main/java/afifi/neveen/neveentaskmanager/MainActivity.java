





package afifi.neveen.neveentaskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
           // FirebaseAuth.getInstance().signOut();
          //  finish();
         //1 تجهيز البنّاء للديالوج
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("Signning out");
            builder.setMessage("are you sure");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    //اخفاء الديالوج
                    dialogInterface.dismiss();
                    //تسجيل الخروح من الحساب
                    FirebaseAuth.getInstance().signOut();
                    //الخروج من الشاشة
                    finish();
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    dialogInterface.cancel();

                }
            });
            //بناء الديالوج
            AlertDialog dialog=builder.create();
            dialog.show();

        }


        return true;

    }

    private void readMahamatFromFireBase()
    {
        //موشر لجذر قاعدة البيانات التالبعة للمشروع
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        //listener لمراقبة اي تغيير يحدث تحت الجذر المحدد
        //اي تغيير بقيمة صفة او حذف او اضافة كائن يتم اعلام ال listener
        //عندها يتم تنزيل كل المعطيات الموجودة تحت الجذر
        reference.child("mahamat").addValueEventListener(new ValueEventListener() {
            /**
             * دالة معالجة حدث عند تغيير اي قيمة
             * @param snapshot يحوي نسخة عن كل المعطيات تحت العنوان المراقب
             */
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
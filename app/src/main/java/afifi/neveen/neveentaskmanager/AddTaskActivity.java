package afifi.neveen.neveentaskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import afifi.neveen.neveentaskmanager.Data.Mahama;

/**
 * koko
 */
public class AddTaskActivity extends AppCompatActivity {

    private TextInputEditText etTitle,etSubject;
    private Button btnSave,btnCancel;
    private ImageView image;
    private SeekBar sbImpportant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        etTitle=findViewById(R.id.etTitle);
        etSubject=findViewById(R.id.etSubject);
        sbImpportant=findViewById(R.id.skImportant);
        btnSave=findViewById(R.id.btnSave);
        btnCancel=findViewById(R.id.btnCancel);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAndSave();
            }
        });

    }

    private void checkAndSave()
    {
        //استخراج القيم من صفحة لاضافة
        String title=etTitle.getText().toString();
        String subj=etSubject.getText().toString();
        int imp=sbImpportant.getProgress();
        //بناء الكائن واعطاؤه قيم الصفات
        Mahama m=new Mahama();
        m.setTitle(title);
        m.setSubject(subj);
        m.setImportant(imp);
        //استخراج الرقم المميز للمستعمل UID
        //                                      مستخدم دخل مسبقا
        String owner = FirebaseAuth.getInstance().getCurrentUser().getUid();
        m.setOwner(owner);
        //انتاج الرقم المميز للمهمةالتي سيتم اضافتها
        String key = FirebaseDatabase.getInstance().getReference().
                    child("mahamat").
                      //اضافة قيمة جديدة
                child(owner).push().getKey();
        m.setKey(key);
        //حفظ بالخادم
        //   عنوان جذر شجرة المعطيات
        FirebaseDatabase.getInstance().getReference().
                child("mahamat").//جذر جديد تحته يتم تخزين المهمات
                child(owner).
                child(key).
                setValue(m).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            finish();
                            Toast.makeText(AddTaskActivity.this, "added succesfully",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(AddTaskActivity.this, "add Failled",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

    /**
     * dsdgsdg
     * @param a ggggg
     * @param x hhhhh
     * @return kkkkk
     */
    public int dodo(double a, char x)
    {
 return 0;
    }
}
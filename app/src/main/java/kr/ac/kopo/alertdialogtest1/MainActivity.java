package kr.ac.kopo.alertdialogtest1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this); // 문맥객체로 사용가능 : 액티비티 클래스를 앞에 붙여야 문맥객체로써 사용가능
                dlg.setTitle("인공지능소프트웨어과 공지사항");
                dlg.setMessage("513호에 학과 학생이 만약에 있다면 우리과 학생이 사용해야 한다고 친절하게 양해를 구하면 됩니다.");
                dlg.setIcon(R.drawable.kitty);
                dlg.setPositiveButton("확인",null);
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "취소버튼이 선택되었습니다.",Toast.LENGTH_SHORT).show(); //show를 해야이 Toast가 보인다
                    }
                });
                dlg.show();
            }
        });
    }
}
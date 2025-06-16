package kr.ac.kopo.alertdialogtest1;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView; // 이미지뷰 전역 선언

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
        imageView = findViewById(R.id.imgview1);  // 이미지뷰 연결

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] foodItems = {"떡볶이", "무침만두", "순대"};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("인공지능소프트웨어과 공지사항");
                dlg.setItems(foodItems, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btn1.setText(foodItems[which]);
                        // 이미지 변경
                        switch (which) {
                            case 0: // 떡볶이
                                imageView.setImageResource(R.drawable.ddok);
                                break;
                            case 1: // 무침만두
                                imageView.setImageResource(R.drawable.dumpling);
                                break;
                            case 2: // 순대
                                imageView.setImageResource(R.drawable.sundae);
                                break;
                        }
                    }
                });
                dlg.setIcon(R.drawable.kitty);
                dlg.setPositiveButton("닫기", null);
                dlg.show();
            }
        });
    }
}

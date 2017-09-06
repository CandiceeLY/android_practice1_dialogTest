package com.example.luyue.test;

//import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonTISHI = (Button) this.findViewById(R.id.ButtonTISHI); //提示按键
        buttonTISHI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("这是一个普通的对话框")//显示的消息内容
                        .setTitle("对话框");//对话框标题

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了确认按钮", Toast.LENGTH_LONG).show();

                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了取消按钮", Toast.LENGTH_LONG).show();

                    }
                });

                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了忽略按钮", Toast.LENGTH_LONG).show();

                    }
                });
                builder.show();
            }
        });

        Button buttonDENGLU = (Button) findViewById(R.id.ButtonDENGLU); //登陆按键
        buttonDENGLU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // Get the layout inflater
                LayoutInflater inflater = getLayoutInflater();
                final View loginview = inflater.inflate(R.layout.login, null);  //抓取login.xml文件里的
                builder.setView(loginview)
                        .setTitle("Login")
                        // Add action buttons
                        .setPositiveButton(R.string.login, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // login
                                EditText editTextUserId =(EditText)loginview.findViewById(R.id.editTextUserId);   //得到用户名
                                String str1=editTextUserId.getText().toString();
                                EditText editTextPwd =(EditText)loginview.findViewById(R.id.editTextPwd);   //得到密码
                                String str2=editTextPwd.getText().toString();
                                if(!str1.equals("abc") || !str2.equals("123")){
                                    Toast.makeText(MainActivity.this, "用户登陆失败！", Toast.LENGTH_LONG).show();

                                }
                                else Toast.makeText(MainActivity.this, "用户登陆成功！", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //cancel
                            }
                        });
                builder.show();
            }


        });


    }
}

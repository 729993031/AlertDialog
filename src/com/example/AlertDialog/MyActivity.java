package com.example.AlertDialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

public class MyActivity extends Activity {
    TextView show;
    String[] items = new String[] {
            "疯狂Java讲义", "疯狂Ajax讲义",
            "轻量级Java EE企业应用实战",
            "疯狂Android讲义" };



    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        show=(TextView)findViewById(R.id.show);

    }

    public void simple(View source)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this)
                .setTitle("简单对话框")
                .setIcon(R.drawable.tools)
                .setMessage("对话框测试内容\n 第二行内容");
                setPositiveButton(builder);
        // 为AlertDialog.Builder添加“取消”按钮
                setNegativeButton(builder)
                        .create()
                        .show();
    }
    public void simpleList(View source)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this)
                .setTitle("简单列表对话框")
                .setIcon(R.drawable.tools)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        show.setText("你选中了《"+items[which]+"》");
                    }
                });
        setPositiveButton(builder);
        setNegativeButton(builder)
                .create()
                .show();
    }
    public void singleChoice(View source)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this)
                .setTitle("单选列表对话框")
                .setIcon(R.drawable.tools)
                .setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        show.setText("你选中了《"+items[which]+"》");
                    }
                });
        setPositiveButton(builder);
        setNegativeButton(builder)
                .create()
                .show();
    }
    public void multiChoice(View source)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this)
                .setTitle("多选列表项对话框")
                .setIcon(R.drawable.tools)
                .setMultiChoiceItems(items,new boolean[]{false,true,false,true},null);
        setPositiveButton(builder);
        setNegativeButton(builder)
                .create()
                .show();
    }
    public void customList(View source)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this)
                .setTitle("自定义列表项对话框")
                .setIcon(R.drawable.tools)
                .setAdapter(new ArrayAdapter<String>(this,R.layout.array_item,items),null);
        setPositiveButton(builder);
        setNegativeButton(builder)
                .create()
                .show();
    }
    public void customView(View source)
    {
        TableLayout loginForm=(TableLayout)getLayoutInflater().inflate(R.layout.login,null);
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.tools)
                .setTitle("自定义view对话框")
                .setView(loginForm)
                .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .create()
                .show();
    }
   private AlertDialog.Builder setPositiveButton(
           AlertDialog.Builder builder
   )
   {
       return  builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               show.setText("单击了【确定】按钮！");

           }
       });
   }
    private AlertDialog.Builder setNegativeButton(
            AlertDialog.Builder builder
    )
    {
        return builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("单击了【取消】按钮");
            }
        });
    }
}


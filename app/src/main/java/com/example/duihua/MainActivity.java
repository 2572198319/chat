package com.example.duihua;

import java.util.ArrayList;
import java.util.List;



import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
    private ListView listview;//列表
    private EditText neirong;//内容
    private Button fasong;//按钮
    private List<JavaBean> list = new ArrayList<JavaBean>();//填充数据的list集合
    private MainAdapten adapten; //构建数据源
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        listview = (ListView) findViewById(R.id.wo);
        //构建adapten数据源
        adapten = new MainAdapten(list, this);
        listview.setAdapter(adapten);
        neirong = (EditText) findViewById(R.id.neirong);
        fasong = (Button) findViewById(R.id.fasong);

        fasong.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //String text = ;
                //实例化Bean文件
                JavaBean javaBean = new JavaBean();
                //取当前文本内容并利用set方法赋值
                javaBean.setNeirong(neirong.getText().toString());
                javaBean.setTime(System.currentTimeMillis()+"");
                list.add(javaBean);
                //更新数据源
                adapten.setList(list);
                adapten.notifyDataSetChanged();
                //列表显示最后一条数据
                listview.setSelection(list.size()-1);
                //发送完毕之后要让输入框清空
                neirong.setText("");
            }
        });



    }

}

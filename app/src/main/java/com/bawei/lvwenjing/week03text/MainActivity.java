package com.bawei.lvwenjing.week03text;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bawei.lvwenjing.week03text.dao.SqlDao;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends Activity {

    private List<Bean.DatalistBean> datalist;
    private SqlDao sqlDao;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        geturl();
        sqlDao = new SqlDao(MainActivity.this);
        setContentView(R.layout.activity_main);
        Button bt = (Button) findViewById(R.id.bt);
        Button shellby = (Button) findViewById(R.id.shellbt);
        Button showphone = (Button) findViewById(R.id.showphone);
        iv = (ImageView) findViewById(R.id.iv);
        showphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Glide.with(MainActivity.this).load("http://img.dianfu.net/img/20170216/40799f98cfc235f2a2eb46837d5cff84.jpg").into(iv);
            }
        });
        ListView lv = (ListView) findViewById(R.id.lv);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Bean.DatalistBean beans : datalist) {
                    String course_name = beans.getCourse_name();
                    String course_price = beans.getCourse_pic();

                    boolean insert = sqlDao.insert(course_name, course_price);
                    if (insert == true) {
                        Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        shellby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Beans> select = sqlDao.select();
                Toast.makeText(MainActivity.this, select.get(0).getCourse_name(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void geturl() {
        try {
            String s = new Asytask().execute("http://www.meirixue.com/api.php?c=list&a=index").get();
            Gson gson = new Gson();
            Bean bean = gson.fromJson(s, Bean.class);
            datalist = bean.getDatalist();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

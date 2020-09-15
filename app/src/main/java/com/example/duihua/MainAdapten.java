package com.example.duihua;

import java.util.List;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapten extends BaseAdapter{
    private List<JavaBean> list;
    private Context context;

    public MainAdapten(List<JavaBean> list,Context context){
        this.context = context;
        this.list = list;
    }

    public void setList(List<JavaBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Hui hui;
        if(convertView == null){
            hui = new Hui();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_chatqipao, null);
            hui.chatneirong = (TextView) convertView.findViewById(R.id.tv_chatneirong);
            hui.chattime = (TextView) convertView.findViewById(R.id.tv_chattime);
            hui.tou = (ImageView) convertView.findViewById(R.id.iv_chattou);

            convertView.setTag(hui);
        }else{
            hui = (Hui) convertView.getTag();
        }
        JavaBean javaBean  = list.get(position);
        hui.chatneirong.setText("我是"+javaBean.getNeirong());
        hui.chattime.setText(javaBean.getTime());
        //javaBean.setTime(javaBean.getTime());

        return convertView;
    }

    class Hui{
        ImageView tou,tupian;
        TextView chattime,chatneirong;
    }
}

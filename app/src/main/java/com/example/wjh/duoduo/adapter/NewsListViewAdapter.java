package com.example.wjh.duoduo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wjh.duoduo.R;
import com.example.wjh.duoduo.bean.News;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 建辉 on 2016/7/26.
 */
public class NewsListViewAdapter extends BaseAdapter {

    private List<News> filterList;
    private Context context;
    private LayoutInflater inflater;

    public NewsListViewAdapter(List<News> filterList, Context context) {
        this.filterList = filterList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return filterList !=null?filterList.size():0;
    }

    @Override
    public Object getItem(int position) {
        return filterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.news_listview_item,null);
            viewHolder = new ViewHolder();
            viewHolder.title_item = (TextView) convertView.findViewById(R.id.title_item);
            viewHolder.contents_item = (TextView) convertView.findViewById(R.id.contents_item);
            viewHolder.contents_item2 = (TextView) convertView.findViewById(R.id.contents_item2);
            viewHolder.image_item = (ImageView) convertView.findViewById(R.id.contents_item);
            convertView.setTag(convertView);
        }else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        News news = filterList.get(position);
        String newsauthor_content = news.getNewsauthor_content();
        String newstype_content = news.getNewstype_content();
        String title = news.getTitle();

        viewHolder.title_item.setText(title);
        viewHolder.contents_item.setText(newstype_content);
        viewHolder.contents_item2.setText(newsauthor_content);

        String cover = news.getCover();
        Picasso.with(context).load(cover).into(viewHolder.image_item);


        return convertView;
    }

    static class ViewHolder{

        TextView  title_item,contents_item,contents_item2;
        ImageView image_item;

    }



}

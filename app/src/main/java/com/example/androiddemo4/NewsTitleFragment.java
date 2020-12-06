package com.example.androiddemo4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NewsTitleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag,container,false);
        RecyclerView newsTitleRecyclerView = (RecyclerView) view.findViewById(R.id.news_title_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        newsTitleRecyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(getNews());
        newsTitleRecyclerView.setAdapter(adapter);
        return view;
    }

    private List<News> getNews() {
        List<News> newsList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
           News news = new News();
           news.setTitles("#震惊，一高中居然...");
           news.setContent("一高中居然这样做！");
           newsList.add(news);
        }
        return newsList;
    }



    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

        private List<News> mNewsList;

        public NewsAdapter(List<News> newsList){
            mNewsList = newsList;
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }



        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            News news = mNewsList.get(position);
            holder.newsTitleText.setText(news.getTitles());
            holder.newsImage.setImageResource(news.getImageId());
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView newsTitleText;
            ImageView newsImage;
            public ViewHolder(View view){
                super(view);
                newsTitleText = (TextView) view.findViewById(R.id.news_title);
                newsImage = (ImageView) view.findViewById(R.id.news_image);
            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = mNewsList.get(holder.getAdapterPosition());
                    NewsContentActivity.actionStart(getActivity(),news.getTitles(),news.getContent());
                }
            });
            return holder;
        }


    }
}

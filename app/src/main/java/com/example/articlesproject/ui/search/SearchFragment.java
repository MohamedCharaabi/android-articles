package com.example.articlesproject.ui.search;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.articlesproject.R;
import com.example.articlesproject.model.Article;
import com.example.articlesproject.ui.home.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private SearchViewModel mViewModel;
    private RecyclerView categoryRecycler, recommendedRecycler;

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.search_fragment, container, false);

        //        categories
        categoryRecycler = root.findViewById(R.id.rv_search_category);

        List<String> categories = new ArrayList<>();
        categories.add("Tech");
        categories.add("Sport");
        categories.add("Entertainment");
        categories.add("News");
        categories.add("Business");
        categories.add("Productivity");


        CategoryAdapter categoryAdapter = new CategoryAdapter(categories);

        categoryRecycler.setHasFixedSize(true);
        categoryRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        categoryRecycler.setAdapter(categoryAdapter);

    //Recommended
        recommendedRecycler = root.findViewById(R.id.rv_search_recommended);

        List<Article> data = new ArrayList<>();
        data.add(new Article("Why the Last Week of the Year is Crucial to Our Success", "Rachella Angel", "14h", "Time Management", "50", R.drawable.rachella_cover_image, R.drawable.rachella_angel_profile, "I have always loved the last week of the year, the closing of one book leading to the opening of the next one. However, I’ve been pickier about using the time given in the past few years. While I try to make the best of every day, I focus on this week, maybe more than other weeks of the year. So here are three ways to make the best use of the transition period.", R.drawable.rachella_body_image));
        data.add(new Article("How to Read More as a Working Parent", "Alison McBain", "1h", "Reading", "20", R.drawable.alison_cover_image, R.drawable.alison_mcbain_profile, "A decade ago, I used to read a book a day. And now I’m wondering how I did it since there never seems to be enough time in the day to just breathe." +
                "Of course, that was before distractions such as kids, freelance working from home, streaming TV, and did I mention kids? Back then, my life was simpler and the sections of it were more compartmentalized— go to work, come home, read a book to relax." +
                "Many of the writers I know are procrastinators, and maybe that’s a part of my problem, too. When the kitchen could use cleaning, I work on my manuscript. When I have a deadline to write a story, I clean the kitchen. Eventually, everything gets done, but usually not in the order that I’m supposed to be doing it.", R.drawable.alison_body_image));
        data.add(new Article("Product Manager vs. Project Manager", "Julius Uy", "24h", "Product Management", "30", R.drawable.julius_body_image, R.drawable.julius_uy_profile, "A decade ago, I used to read a book a day. And now I’m wondering how I did it since there never seems to be enough time in the day to just breathe.\n" +
                "Of course, that was before distractions such as kids, freelance working from home, streaming TV, and did I mention kids? Back then, my life was simpler and the sections of it were more compartmentalized— go to work, come home, read a book to relax." +
                "Many of the writers I know are procrastinators, and maybe that’s a part of my problem, too. When the kitchen could use cleaning, I work on my manuscript. When I have a deadline to write a story, I clean the kitchen. Eventually, everything gets done, but usually not in the order that I’m supposed to be doing it.", R.drawable.julius_body_image));


        RecommendedAdapter recommendedAdapter = new RecommendedAdapter(data);

        recommendedRecycler.setHasFixedSize(true);
        recommendedRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recommendedRecycler.setAdapter(recommendedAdapter);



        return  root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SearchViewModel.class);
        // TODO: Use the ViewModel
    }

}
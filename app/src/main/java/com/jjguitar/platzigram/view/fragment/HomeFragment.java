package com.jjguitar.platzigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjguitar.platzigram.R;
import com.jjguitar.platzigram.adapter.PictureAdapterRecyclerView;
import com.jjguitar.platzigram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar(getResources().getString(R.string.home_navigationbar), false, view);
        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buildPictures(), R.layout.cardview_picture, getActivity());

        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }

    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("https://www.nationalgeographic.com.es/medio/2018/02/27/playa-de-isuntza-lekeitio__1280x720.jpg", "Uriel Ramirez", "4 días", "3 Me gusta"));
        pictures.add(new Picture("https://i.ytimg.com/vi/hW9PUzl7j9w/maxresdefault.jpg", "Santi Bernal", "7 días", "6 Me gusta"));
        pictures.add(new Picture("https://www.dzoom.org.es/wp-content/uploads/2017/07/seebensee-2384369-810x540.jpg", "Stell Gómez", "1 días", "10 Me gusta"));
        pictures.add(new Picture("https://www.nationalgeographic.com.es/medio/2019/04/17/monument-valley-estadosunidos_17335d05_800x533.jpg", "Juan Perez", "11 días", "6 Me gusta"));
        pictures.add(new Picture("https://miviaje.com/wp-content/uploads/2017/12/landmannalaugar-en-islandia.jpg", "Jhon T", "9 días", "100 Me gusta"));
        return pictures;
    }

    public void showToolbar(String title, boolean upBotton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upBotton);
    }
}

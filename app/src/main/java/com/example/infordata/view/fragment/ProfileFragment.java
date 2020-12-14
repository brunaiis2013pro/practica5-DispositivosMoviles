package com.example.infordata.view.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.infordata.R;
import com.example.infordata.adapter.CardViewAdapter;
import com.example.infordata.model.Image;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        //toolbar
        showToolBar("", false, view);

        //recyclerview
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_profile);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        CardViewAdapter cardViewAdapter = new CardViewAdapter(buidImages(), R.layout.cardview_image, getActivity());
        recyclerView.setAdapter(cardViewAdapter);

        return view;
    }

    public void showToolBar(String titulo, boolean botonSubir, View view){
        Toolbar toolbar = view.findViewById(R.id.toolbar_image_profile);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(botonSubir);
    }

    public ArrayList<Image> buidImages() {
        ArrayList<Image> images = new ArrayList<>();

        images.add(new Image("https://dota2hq.eu/_ph/1/961127099.jpg","Juan Taboada"," 3 dias","2 me gusta"));

        images.add(new Image("https://www.hdfondos.org/file/20545/728x410/16:9/dota-2-riki-ursa_17173799.jpg","Juan Flores"," 2 dias","3 me gusta"));

        images.add(new Image("https://besthqwallpapers.com/Uploads/17-4-2019/87715/juggernaut-warrior-with-sword-dota-2-monster-artwork.jpg","Pedro Rodriguez"," 1 dias","1 me gusta"));

        images.add(new Image("https://i.pinimg.com/originals/e7/d2/da/e7d2da2328e48ce32b4bbe5c106c3b81.jpg","Mario Sanchez"," 8 dias","5 me gusta"));

        images.add(new Image("https://www.hdfondos.org/file/12376/728x410/16:9/dota-2-heroes_438485392.jpg","Daniel Quispe"," 6 dias","7 me gusta"));

        images.add(new Image("https://www.hdfondos.org/file/29620/728x410/16:9/dota-2-rogue-knight_941163805.jpg♠","Wilfredo Morales"," 4 dias","8 me gusta"));


        return images;
    }
}
package com.amjustice.gadsleaderboard.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.amjustice.gadsleaderboard.Api.ApiClient;
import com.amjustice.gadsleaderboard.Api.LeadersClient;
import com.amjustice.gadsleaderboard.Adapters.LearningLeaderRecyclerAdapter;
import com.amjustice.gadsleaderboard.Models.LearningLeader;
import com.amjustice.gadsleaderboard.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LearningLeadersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class LearningLeadersFragment extends Fragment {

    private View mView;
    private ApiClient mApiClient;
    private LearningLeaderRecyclerAdapter mLearningLeaderRecyclerAdapter;
    private RecyclerView mRecyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LearningLeadersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LearningLeadersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LearningLeadersFragment newInstance(String param1, String param2) {
        LearningLeadersFragment fragment = new LearningLeadersFragment();
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
        mView = inflater.inflate(R.layout.fragment_learning_leaders, container, false);
        mApiClient = LeadersClient.buildService(ApiClient.class);
        mRecyclerView = mView.findViewById(R.id.list_learning_leaders);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mLearningLeaderRecyclerAdapter = new LearningLeaderRecyclerAdapter(getContext());
        populateLearningLeaders();
        return mView;
    }

    private void populateLearningLeaders() {

        Call<List<LearningLeader>> call = mApiClient.getLearningLeaders();

        call.enqueue(new Callback<List<LearningLeader>>() {
            @Override
            public void onResponse(Call<List<LearningLeader>> call, Response<List<LearningLeader>> response) {
                List<LearningLeader> learningLeadersList = response.body();
                mLearningLeaderRecyclerAdapter.setData(learningLeadersList);
                mRecyclerView.setAdapter(mLearningLeaderRecyclerAdapter);
            }

            @Override
            public void onFailure(Call<List<LearningLeader>> call, Throwable t) {
                    Toast.makeText(getActivity().getApplicationContext(), "Could not load leaders' informations, Please verify your internet connection !", Toast.LENGTH_LONG).show();
            }
        });

    }


}

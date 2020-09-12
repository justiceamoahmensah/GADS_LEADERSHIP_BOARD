package com.amjustice.gadsleaderboard.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amjustice.gadsleaderboard.Models.SkillIqLeader;
import com.amjustice.gadsleaderboard.R;

import java.util.List;



public class SkillIqLeaderRecyclerAdapter extends RecyclerView.Adapter<SkillIqLeaderRecyclerAdapter.ViewHolder> {

    private final Context mContext;
    private List<SkillIqLeader> mSkillIqLeaders;
    private final LayoutInflater mLayoutInflater;

    public SkillIqLeaderRecyclerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void setData(List<SkillIqLeader> skillIqLeaders) {
        mSkillIqLeaders = skillIqLeaders;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.skill_iq_leader_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SkillIqLeader skillIqLeader = mSkillIqLeaders.get(position);
        holder.mSkillIqLeaderName.setText(skillIqLeader.getName());
        String scoreIqAndCountryText = skillIqLeader.getScore() + " skill IQ Score, " + skillIqLeader.getCountry();
        holder.mSkillIqLeaderScoreCountry.setText(scoreIqAndCountryText);
    }

    @Override
    public int getItemCount() {
        return mSkillIqLeaders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mSkillIqLeaderName;
        private final TextView mSkillIqLeaderScoreCountry;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mSkillIqLeaderName = itemView.findViewById(R.id.skill_iq_leader_name);
            mSkillIqLeaderScoreCountry = itemView.findViewById(R.id.skill_iq_score_country);
        }
    }
}

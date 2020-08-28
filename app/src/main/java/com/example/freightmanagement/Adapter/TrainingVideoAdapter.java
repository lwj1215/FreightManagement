package com.example.freightmanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.R;
import com.pili.pldroid.player.widget.PLVideoView;

import java.util.List;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class TrainingVideoAdapter extends RecyclerView.Adapter<TrainingVideoAdapter.TrainingViewHolder> {
    private final LayoutInflater layoutInflater;
    private Context context;
    private List<String> dataList;

    public TrainingVideoAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public TrainingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TrainingVideoAdapter.TrainingViewHolder(layoutInflater.inflate(R.layout.item_training_video, parent, false));
    }

    @Override
    public void onBindViewHolder(TrainingViewHolder holder, int position) {
//        MediaController mMediaController = new MediaController(this);
//        mVideoView.setMediaController(mMediaController);
    }

    @Override
    public int getItemCount() {
        return null == dataList || dataList.size() == 0 ? 0 : dataList.size();

    }

    public class TrainingViewHolder extends RecyclerView.ViewHolder {
        PLVideoView videoView;
        private View itemView;

        public TrainingViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            videoView = itemView.findViewById(R.id.PLVideoView);
        }
    }
}

package helper;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sple.slidingpanellayout_example.Main;
import com.sple.slidingpanellayout_example.R;

public class RecyclerHolder extends RecyclerView.ViewHolder {//implements View.OnClickListener {

    public LinearLayout llContainer;

    public TextView tvData;

    public RecyclerHolder(View _v) {
        super(_v);

        //_v.setOnClickListener(this);

        if(_v == null) {
            return;
        }

        tvData = (TextView) _v.findViewById(R.id.tvData);
    }

    /*@Override
    public void onClick(View v) {
        Context mainContext = v.getContext();

        if(mainContext instanceof Main && tvData != null) {
            ((Main) mainContext).initPager(String.valueOf(tvData.getText()));
        }
    }*/
}

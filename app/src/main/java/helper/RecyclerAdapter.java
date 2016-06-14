package helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.sple.slidingpanellayout_example.Main;
import com.sple.slidingpanellayout_example.R;

import java.util.ArrayList;
import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder> {

    protected Context mainContext;

    protected List<String> itemList;

    protected int lastPosition = 0;

    public RecyclerAdapter(Context _context) {
        mainContext = _context;

        lastPosition = 0;
    }

    public void addItem(String _item) {
        if(itemList == null) {
            itemList = new ArrayList<>();
        }

        if(_item != null && _item.length() > 0) {
            itemList.add(_item);
        }

    }

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_item, viewGroup, false);

        return new RecyclerHolder(v);
    }

    /**
     * Заполнение виджетов View данными из элемента списка с номером i
     */
    @Override
    public void onBindViewHolder(final RecyclerHolder favoriteHolder, final int position) {

        String item = (String)getItem(position);
        if(item != null && item.length() > 0) {
            favoriteHolder.tvData.setText(item);
        }

       favoriteHolder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(mainContext instanceof Main) {
                   ((Main) mainContext).initPager(position);
               }
           }
       });

        setAnimation(favoriteHolder.itemView, position);
    }

    @Override
    public int getItemCount() {
        if(itemList != null) {
            return itemList.size();
        } else {
            return 0;
        }
    }

    public Object getItem(int position) {
        if(itemList != null && position >= 0 && position < itemList.size()) {
            return itemList.get(position);
        }

        return null;
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (viewToAnimate != null)
        {
            Animation animation = AnimationUtils.loadAnimation(mainContext, R.anim.fade_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}


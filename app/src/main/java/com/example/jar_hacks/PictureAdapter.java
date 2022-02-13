package com.example.jar_hacks;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PictureAdapter extends ArrayAdapter<Picture> {
    private Context mContext;
    private List<Picture> picturesList = new ArrayList<>();

    public PictureAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<Picture> list) {
        super(context, 0 , list);
        mContext = context;
        picturesList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);

        Picture currentPicture = picturesList.get(position);

        TextView picName = (TextView) listItem.findViewById(R.id.textView_pic);
        picName.setText(currentPicture.getImageB64());

        TextView descName = (TextView) listItem.findViewById(R.id.textView_desc);
        descName.setText(currentPicture.getDesc());

        return listItem;
    }
}

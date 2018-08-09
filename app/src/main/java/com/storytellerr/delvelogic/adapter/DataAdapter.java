package com.storytellerr.delvelogic.adapter;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.storytellerr.delvelogic.BottomSheet;
import com.storytellerr.delvelogic.R;
import com.storytellerr.delvelogic.model.Android;
import com.storytellerr.delvelogic.model.User;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<Android> mAndroidList;
    private android.content.Context con;

    public DataAdapter(ArrayList<Android> androidList ,android.content.Context context) {
        mAndroidList = androidList;
        con=context;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Bundle args = new Bundle();

        holder.fromtext.setText(mAndroidList.get(position).getFromName());
        holder.totxt.setText(mAndroidList.get(position).getToName());
        String  price =  mAndroidList.get(position).getPrice();
        if(price=="")
            price="-";
        holder.price.setText(" \u20B9" + price);
        User userdata = mAndroidList.get(position).getUser();
        holder.usrname.setText(userdata.getName());
        Picasso.get()
                .load(userdata.getImage())
                .resize(50, 50)
                .centerCrop()
                .into(holder.img);
        final String imageLink =userdata.getImage();
        final String carModel = mAndroidList.get(position).getCarModel();
        final String startTime = mAndroidList.get(position).getStartTime();
        final String returnTime = mAndroidList.get(position).getReturnTime();
        final String chargePrice = price;
        final  String fromName = mAndroidList.get(position).getFromName();
        final String toName = mAndroidList.get(position).getToName();
        final String usrName = userdata.getName();
        final String contact = userdata.getContact();
        holder.viewclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("dc","f");
                BottomSheet bottomSheet = new BottomSheet();
                args.putString("imageLink",imageLink);
                args.putString("carModel",carModel);
                args.putString("startTime",startTime);
                args.putString("returnTime",returnTime);
                args.putString("chargePrice",chargePrice);
                args.putString("fromName",fromName);
                args.putString("toName",toName);
                args.putString("usrName",usrName);
                args.putString("contact",contact);

                Log.d("FDzsd",toName);
                bottomSheet.setArguments(args);
                bottomSheet.show((((FragmentActivity)con).getSupportFragmentManager()),bottomSheet.getTag());

            }
        });


    }

    @Override
    public int getItemCount() {
        return mAndroidList.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView fromtext,totxt,price,usrname;
        private ImageView img;
        private View viewclick;
        public ViewHolder(View view) {
            super(view);
            viewclick =view.findViewById(R.id.parentcard);
            usrname = view.findViewById(R.id.userName);
            fromtext = (TextView)view.findViewById(R.id.textViewfrom);
            totxt = (TextView)view.findViewById(R.id.textViewto);
            price = (TextView)view.findViewById(R.id.price);
            img = (ImageView)view.findViewById(R.id.profile_image);



        }


    }
}

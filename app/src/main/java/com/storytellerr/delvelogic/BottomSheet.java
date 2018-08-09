package com.storytellerr.delvelogic;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BottomSheet extends BottomSheetDialogFragment {
    public BottomSheet() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.bottom_sheet, container, false);
        Bundle mArgs = getArguments();
        String imageLink = mArgs.getString("imageLink");
        String carModel = mArgs.getString("carModel");
        String startTime = mArgs.getString("startTime");
        String returnTime = mArgs.getString("returnTime");
        String chargePrice = mArgs.getString("chargePrice");
        String fromName = mArgs.getString("fromName");
        String toName = mArgs.getString("toName");
        String usrName = mArgs.getString("usrName");
        String contactNumber = mArgs.getString("contact");
        Log.d("F",toName);


        //String stars = mArgs.getString("stars");
       TextView usrname= v.findViewById(R.id.userName);
       ImageView usrimage=v.findViewById(R.id.usrImage);
       TextView carmodel = v.findViewById(R.id.carModel);
       TextView starttime = v.findViewById(R.id.startTime);
       TextView returntime = v.findViewById(R.id.returnTime);
       TextView charge = v.findViewById(R.id.chargePrice);
       TextView fromname =v.findViewById(R.id.fromName);
       TextView toname =v.findViewById(R.id.toName);
       TextView contactnumber =v.findViewById(R.id.contact);



       usrname.setText(usrName);
        carmodel.setText("Car"+carModel);
        starttime.setText(startTime);
        returntime.setText(returnTime);
        charge.setText("price:"+" \u20B9"+chargePrice);
        fromname.setText(fromName);
        toname.setText(toName);
        contactnumber.setText(contactNumber);
        Picasso.get()
                .load(imageLink)
                .resize(50, 50)
                .centerCrop()
                .into(usrimage);


        return v;
    }



}
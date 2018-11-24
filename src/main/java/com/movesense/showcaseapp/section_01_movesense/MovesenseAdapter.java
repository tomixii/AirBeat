package com.movesense.showcaseapp.section_01_movesense;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.movesense.showcaseapp.R;
import com.movesense.showcaseapp.model.RxBleDeviceWrapper;
import com.polidea.rxandroidble.RxBleDevice;

import java.util.ArrayList;

public class MovesenseAdapter extends RecyclerView.Adapter<MovesenseAdapter.ViewHolder> {

    private ArrayList<RxBleDeviceWrapper> mMovesenseModelArrayList;
    private View.OnClickListener mOnClickListener;

    public MovesenseAdapter(ArrayList<RxBleDeviceWrapper> movesenseModelArrayList, View.OnClickListener onClickListener) {
        mMovesenseModelArrayList = movesenseModelArrayList;
        mOnClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movesense, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RxBleDevice rxBleDevice = mMovesenseModelArrayList.get(position).getRxBleDevice();

        holder.name.setText(rxBleDevice.getName());
        holder.address.setText(rxBleDevice.getMacAddress());
        holder.rssi.setText("Rssi: " + mMovesenseModelArrayList.get(position).getRssi() + " dBm");
        holder.itemView.setTag(rxBleDevice);
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return mMovesenseModelArrayList.size();
    }

    public void add(RxBleDeviceWrapper rxBleDeviceWrapper) {
        if (!mMovesenseModelArrayList.contains(rxBleDeviceWrapper)) {
            mMovesenseModelArrayList.add(rxBleDeviceWrapper);

            notifyItemChanged(mMovesenseModelArrayList.size());
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView address;
        private TextView rssi;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.movesense_name);
            address = itemView.findViewById(R.id.movesense_address);
            rssi = itemView.findViewById(R.id.movesense_rsid);
        }
    }
}

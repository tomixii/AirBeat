// Generated code from Butter Knife. Do not modify!
package com.movesense.showcaseapp.section_02_multi_connection.connection;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.movesense.showcaseapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MultiConnectionActivity_ViewBinding implements Unbinder {
  private MultiConnectionActivity target;

  private View view2131165211;

  private View view2131165212;

  private View view2131165344;

  private View view2131165345;

  @UiThread
  public MultiConnectionActivity_ViewBinding(MultiConnectionActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MultiConnectionActivity_ViewBinding(final MultiConnectionActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.add_movesense1Ll, "field 'mAddMovesense1Ll' and method 'onViewClicked'");
    target.mAddMovesense1Ll = Utils.castView(view, R.id.add_movesense1Ll, "field 'mAddMovesense1Ll'", LinearLayout.class);
    view2131165211 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.add_movesense2Ll, "field 'mAddMovesense2Ll' and method 'onViewClicked'");
    target.mAddMovesense2Ll = Utils.castView(view, R.id.add_movesense2Ll, "field 'mAddMovesense2Ll'", LinearLayout.class);
    view2131165212 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mMultiConnectionAddDeviceTv1 = Utils.findRequiredViewAsType(source, R.id.multiConnection_addDevice_Tv_1, "field 'mMultiConnectionAddDeviceTv1'", TextView.class);
    target.mMultiConnectionSelectedDeviceNameTv1 = Utils.findRequiredViewAsType(source, R.id.multiConnection_selectedDeviceName_Tv_1, "field 'mMultiConnectionSelectedDeviceNameTv1'", TextView.class);
    target.mMultiConnectionSelectedDeviceSerialTv1 = Utils.findRequiredViewAsType(source, R.id.multiConnection_selectedDeviceSerial_Tv_1, "field 'mMultiConnectionSelectedDeviceSerialTv1'", TextView.class);
    target.mMultiConnectionSelectedDeviceInfoLl1 = Utils.findRequiredViewAsType(source, R.id.multiConnection_selectedDeviceInfo_Ll_1, "field 'mMultiConnectionSelectedDeviceInfoLl1'", LinearLayout.class);
    target.mMultiConnectionAddDeviceTv2 = Utils.findRequiredViewAsType(source, R.id.multiConnection_addDevice_Tv_2, "field 'mMultiConnectionAddDeviceTv2'", TextView.class);
    target.mMultiConnectionSelectedDeviceNameTv2 = Utils.findRequiredViewAsType(source, R.id.multiConnection_selectedDeviceName_Tv_2, "field 'mMultiConnectionSelectedDeviceNameTv2'", TextView.class);
    target.mMultiConnectionSelectedDeviceSerialTv2 = Utils.findRequiredViewAsType(source, R.id.multiConnection_selectedDeviceSerial_Tv_2, "field 'mMultiConnectionSelectedDeviceSerialTv2'", TextView.class);
    target.mMultiConnectionSelectedDeviceInfoLl2 = Utils.findRequiredViewAsType(source, R.id.multiConnection_selectedDeviceInfo_Ll_2, "field 'mMultiConnectionSelectedDeviceInfoLl2'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.multiConnection_connect_Tv, "field 'mMultiConnectionConnectTv' and method 'onViewClicked'");
    target.mMultiConnectionConnectTv = Utils.castView(view, R.id.multiConnection_connect_Tv, "field 'mMultiConnectionConnectTv'", TextView.class);
    view2131165344 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.multiConnection_save_Tv, "field 'mMultiConnectionSaveTv' and method 'onViewClicked'");
    target.mMultiConnectionSaveTv = Utils.castView(view, R.id.multiConnection_save_Tv, "field 'mMultiConnectionSaveTv'", TextView.class);
    view2131165345 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mMultiConnectionStatusTv = Utils.findRequiredViewAsType(source, R.id.multiConnection_status_tv, "field 'mMultiConnectionStatusTv'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MultiConnectionActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mAddMovesense1Ll = null;
    target.mAddMovesense2Ll = null;
    target.mMultiConnectionAddDeviceTv1 = null;
    target.mMultiConnectionSelectedDeviceNameTv1 = null;
    target.mMultiConnectionSelectedDeviceSerialTv1 = null;
    target.mMultiConnectionSelectedDeviceInfoLl1 = null;
    target.mMultiConnectionAddDeviceTv2 = null;
    target.mMultiConnectionSelectedDeviceNameTv2 = null;
    target.mMultiConnectionSelectedDeviceSerialTv2 = null;
    target.mMultiConnectionSelectedDeviceInfoLl2 = null;
    target.mMultiConnectionConnectTv = null;
    target.mMultiConnectionSaveTv = null;
    target.mMultiConnectionStatusTv = null;

    view2131165211.setOnClickListener(null);
    view2131165211 = null;
    view2131165212.setOnClickListener(null);
    view2131165212 = null;
    view2131165344.setOnClickListener(null);
    view2131165344 = null;
    view2131165345.setOnClickListener(null);
    view2131165345 = null;
  }
}

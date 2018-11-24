// Generated code from Butter Knife. Do not modify!
package com.movesense.showcaseapp.section_01_movesense.tests;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.movesense.showcaseapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ImuActivity_ViewBinding implements Unbinder {
  private ImuActivity target;

  private View view2131165302;

  private View view2131165303;

  private View view2131165453;

  @UiThread
  public ImuActivity_ViewBinding(ImuActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ImuActivity_ViewBinding(final ImuActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.imu6_radioBtn, "field 'mImu6RadioBtn' and method 'onImuRadioGroupChange'");
    target.mImu6RadioBtn = Utils.castView(view, R.id.imu6_radioBtn, "field 'mImu6RadioBtn'", RadioButton.class);
    view2131165302 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.onImuRadioGroupChange(p0, p1);
      }
    });
    view = Utils.findRequiredView(source, R.id.imu9_radioBtn, "field 'mImu9RadioBtn' and method 'onImuRadioGroupChange'");
    target.mImu9RadioBtn = Utils.castView(view, R.id.imu9_radioBtn, "field 'mImu9RadioBtn'", RadioButton.class);
    view2131165303 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.onImuRadioGroupChange(p0, p1);
      }
    });
    target.mConnectedDeviceNameTextView = Utils.findRequiredViewAsType(source, R.id.connected_device_name_textView, "field 'mConnectedDeviceNameTextView'", TextView.class);
    target.mConnectedDeviceSwVersionTextView = Utils.findRequiredViewAsType(source, R.id.connected_device_swVersion_textView, "field 'mConnectedDeviceSwVersionTextView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.switchSubscription, "field 'mSwitchSubscription' and method 'onSwitchCheckedChange'");
    target.mSwitchSubscription = Utils.castView(view, R.id.switchSubscription, "field 'mSwitchSubscription'", SwitchCompat.class);
    view2131165453 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.onSwitchCheckedChange(p0, p1);
      }
    });
    target.mLinearaccXAxisTextView = Utils.findRequiredViewAsType(source, R.id.linearacc_x_axis_textView, "field 'mLinearaccXAxisTextView'", TextView.class);
    target.mLinearaccYAxisTextView = Utils.findRequiredViewAsType(source, R.id.linearacc_y_axis_textView, "field 'mLinearaccYAxisTextView'", TextView.class);
    target.mLinearaccZAxisTextView = Utils.findRequiredViewAsType(source, R.id.linearacc_z_axis_textView, "field 'mLinearaccZAxisTextView'", TextView.class);
    target.mGyroXAxisTextView = Utils.findRequiredViewAsType(source, R.id.gyro_x_axis_textView, "field 'mGyroXAxisTextView'", TextView.class);
    target.mGyroYAxisTextView = Utils.findRequiredViewAsType(source, R.id.gyro_y_axis_textView, "field 'mGyroYAxisTextView'", TextView.class);
    target.mGyroZAxisTextView = Utils.findRequiredViewAsType(source, R.id.gyro_z_axis_textView, "field 'mGyroZAxisTextView'", TextView.class);
    target.mMagnXAxisTextView = Utils.findRequiredViewAsType(source, R.id.magn_x_axis_textView, "field 'mMagnXAxisTextView'", TextView.class);
    target.mMagnYAxisTextView = Utils.findRequiredViewAsType(source, R.id.magn_y_axis_textView, "field 'mMagnYAxisTextView'", TextView.class);
    target.mMagnZAxisTextView = Utils.findRequiredViewAsType(source, R.id.magn_z_axis_textView, "field 'mMagnZAxisTextView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ImuActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mImu6RadioBtn = null;
    target.mImu9RadioBtn = null;
    target.mConnectedDeviceNameTextView = null;
    target.mConnectedDeviceSwVersionTextView = null;
    target.mSwitchSubscription = null;
    target.mLinearaccXAxisTextView = null;
    target.mLinearaccYAxisTextView = null;
    target.mLinearaccZAxisTextView = null;
    target.mGyroXAxisTextView = null;
    target.mGyroYAxisTextView = null;
    target.mGyroZAxisTextView = null;
    target.mMagnXAxisTextView = null;
    target.mMagnYAxisTextView = null;
    target.mMagnZAxisTextView = null;

    ((CompoundButton) view2131165302).setOnCheckedChangeListener(null);
    view2131165302 = null;
    ((CompoundButton) view2131165303).setOnCheckedChangeListener(null);
    view2131165303 = null;
    ((CompoundButton) view2131165453).setOnCheckedChangeListener(null);
    view2131165453 = null;
  }
}

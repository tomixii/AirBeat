// Generated code from Butter Knife. Do not modify!
package com.movesense.showcaseapp.section_01_movesense.tests;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jjoe64.graphview.GraphView;
import com.movesense.showcaseapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EcgActivityGraphView_ViewBinding implements Unbinder {
  private EcgActivityGraphView target;

  private View view2131165453;

  private View view2131165441;

  private View view2131165273;

  @UiThread
  public EcgActivityGraphView_ViewBinding(EcgActivityGraphView target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EcgActivityGraphView_ViewBinding(final EcgActivityGraphView target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.switchSubscription, "field 'mSwitchSubscription' and method 'onCheckedChanged'");
    target.mSwitchSubscription = Utils.castView(view, R.id.switchSubscription, "field 'mSwitchSubscription'", SwitchCompat.class);
    view2131165453 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.onCheckedChanged(p0, p1);
      }
    });
    target.mGraphView = Utils.findRequiredViewAsType(source, R.id.ecg_lineChart, "field 'mGraphView'", GraphView.class);
    target.mConnectedDeviceNameTextView = Utils.findRequiredViewAsType(source, R.id.connected_device_name_textView, "field 'mConnectedDeviceNameTextView'", TextView.class);
    target.mConnectedDeviceSwVersionTextView = Utils.findRequiredViewAsType(source, R.id.connected_device_swVersion_textView, "field 'mConnectedDeviceSwVersionTextView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.spinner, "field 'mSpinner' and method 'onItemSelected'");
    target.mSpinner = Utils.castView(view, R.id.spinner, "field 'mSpinner'", Spinner.class);
    view2131165441 = view;
    ((AdapterView<?>) view).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> p0, View p1, int p2, long p3) {
        target.onItemSelected(p0, p1, p2, p3);
      }

      @Override
      public void onNothingSelected(AdapterView<?> p0) {
      }
    });
    target.mEcgNote = Utils.findRequiredViewAsType(source, R.id.ecg_note, "field 'mEcgNote'", TextView.class);
    target.mEcgSpinnerText = Utils.findRequiredViewAsType(source, R.id.ecg_spinnerText, "field 'mEcgSpinnerText'", TextView.class);
    target.mEcgSwitchContainer = Utils.findRequiredViewAsType(source, R.id.ecg_switchContainer, "field 'mEcgSwitchContainer'", LinearLayout.class);
    target.mHeartRateTextView = Utils.findRequiredViewAsType(source, R.id.heart_rate_textView, "field 'mHeartRateTextView'", TextView.class);
    target.mRrTextView = Utils.findRequiredViewAsType(source, R.id.rr_textView, "field 'mRrTextView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ecg_changeScreenOrientation, "method 'onScreenOrientationChangeClick'");
    view2131165273 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onScreenOrientationChangeClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    EcgActivityGraphView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSwitchSubscription = null;
    target.mGraphView = null;
    target.mConnectedDeviceNameTextView = null;
    target.mConnectedDeviceSwVersionTextView = null;
    target.mSpinner = null;
    target.mEcgNote = null;
    target.mEcgSpinnerText = null;
    target.mEcgSwitchContainer = null;
    target.mHeartRateTextView = null;
    target.mRrTextView = null;

    ((CompoundButton) view2131165453).setOnCheckedChangeListener(null);
    view2131165453 = null;
    ((AdapterView<?>) view2131165441).setOnItemSelectedListener(null);
    view2131165441 = null;
    view2131165273.setOnClickListener(null);
    view2131165273 = null;
  }
}

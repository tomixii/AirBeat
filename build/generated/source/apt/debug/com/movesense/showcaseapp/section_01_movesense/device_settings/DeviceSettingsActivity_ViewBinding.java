// Generated code from Butter Knife. Do not modify!
package com.movesense.showcaseapp.section_01_movesense.device_settings;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.movesense.showcaseapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DeviceSettingsActivity_ViewBinding implements Unbinder {
  private DeviceSettingsActivity target;

  private View view2131165255;

  private View view2131165248;

  private View view2131165250;

  private View view2131165253;

  private View view2131165247;

  @UiThread
  public DeviceSettingsActivity_ViewBinding(DeviceSettingsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DeviceSettingsActivity_ViewBinding(final DeviceSettingsActivity target, View source) {
    this.target = target;

    View view;
    target.mDeviceSettingsUartStatusTv = Utils.findRequiredViewAsType(source, R.id.device_settings_uart_status_tv, "field 'mDeviceSettingsUartStatusTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.device_settings_uart_switch, "method 'onUartCheckedChange'");
    view2131165255 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.onUartCheckedChange(p0, p1);
      }
    });
    view = Utils.findRequiredView(source, R.id.device_settings_powerOffAfterReset_switch, "method 'onPowerOffCheckedChange'");
    view2131165248 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.onPowerOffCheckedChange(p0, p1);
      }
    });
    view = Utils.findRequiredView(source, R.id.device_settings_uart_get_btn, "method 'onViewClicked'");
    view2131165250 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.device_settings_uart_set_btn, "method 'onViewClicked'");
    view2131165253 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.device_settings_powerOffAfterReset_set_btn, "method 'onViewClicked'");
    view2131165247 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    DeviceSettingsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mDeviceSettingsUartStatusTv = null;

    ((CompoundButton) view2131165255).setOnCheckedChangeListener(null);
    view2131165255 = null;
    ((CompoundButton) view2131165248).setOnCheckedChangeListener(null);
    view2131165248 = null;
    view2131165250.setOnClickListener(null);
    view2131165250 = null;
    view2131165253.setOnClickListener(null);
    view2131165253 = null;
    view2131165247.setOnClickListener(null);
    view2131165247 = null;
  }
}

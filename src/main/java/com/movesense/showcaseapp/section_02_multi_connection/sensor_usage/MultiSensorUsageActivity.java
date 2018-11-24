package com.movesense.showcaseapp.section_02_multi_connection.sensor_usage;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.movesense.mds.Mds;
import com.movesense.mds.MdsException;
import com.movesense.mds.MdsNotificationListener;
import com.movesense.mds.MdsSubscription;
import com.movesense.mds.internal.connectivity.BleManager;
import com.movesense.mds.internal.connectivity.MovesenseConnectedDevices;
import com.movesense.showcaseapp.BaseActivity;
import com.movesense.showcaseapp.R;
import com.movesense.showcaseapp.bluetooth.MdsRx;
import com.movesense.showcaseapp.model.AngularVelocity;
import com.movesense.showcaseapp.model.LinearAcceleration;
import com.movesense.showcaseapp.model.MagneticField;
import com.movesense.showcaseapp.model.MdsConnectedDevice;
import com.movesense.showcaseapp.model.TemperatureSubscribeModel;
import com.movesense.showcaseapp.section_00_mainView.MainViewActivity;
import com.movesense.showcaseapp.section_01_movesense.tests.LinearAccelerationTestActivity;
import com.movesense.showcaseapp.utils.FormatHelper;
import com.movesense.showcaseapp.utils.ThrowableToastingAction;
import com.movesense.showcaseapp.csv.CsvLogger;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

public class MultiSensorUsageActivity extends BaseActivity implements MultiSensorUsageContract.View {

    @BindView(R.id.selectedDeviceName_Tv_1) TextView mSelectedDeviceNameTv1;
    @BindView(R.id.selectedDeviceInfo_Ll_1) LinearLayout mSelectedDeviceInfoLl1;
    @BindView(R.id.selectedDeviceName_Tv_2) TextView mSelectedDeviceNameTv2;
    @BindView(R.id.selectedDeviceInfo_Ll_2) LinearLayout mSelectedDeviceInfoLl2;
    @BindView(R.id.multiSensorUsage_selectedDevice_movesense1Ll) LinearLayout mMultiSensorUsageSelectedDeviceMovesense1Ll;
    @BindView(R.id.multiSensorUsage_selectedDevice_movesense2Ll) LinearLayout mMultiSensorUsageSelectedDeviceMovesense2Ll;
    @BindView(R.id.multiSensorUsage_linearAcc_textView) TextView mMultiSensorUsageLinearAccTextView;
    @BindView(R.id.multiSensorUsage_linearAcc_switch) SwitchCompat mMultiSensorUsageLinearAccSwitch;
    @BindView(R.id.multiSensorUsage_linearAcc_device1_x_tv) TextView mMultiSensorUsageLinearAccDevice1XTv;
    @BindView(R.id.multiSensorUsage_linearAcc_device1_y_tv) TextView mMultiSensorUsageLinearAccDevice1YTv;
    @BindView(R.id.multiSensorUsage_linearAcc_device1_z_tv) TextView mMultiSensorUsageLinearAccDevice1ZTv;
    @BindView(R.id.multiSensorUsage_linearAcc_device2_x_tv) TextView mMultiSensorUsageLinearAccDevice2XTv;
    @BindView(R.id.multiSensorUsage_linearAcc_device2_y_tv) TextView mMultiSensorUsageLinearAccDevice2YTv;
    @BindView(R.id.multiSensorUsage_linearAcc_device2_z_tv) TextView mMultiSensorUsageLinearAccDevice2ZTv;
    @BindView(R.id.multiSensorUsage_linearAcc_containerLl) LinearLayout mMultiSensorUsageLinearAccContainerLl;
    @BindView(R.id.multiSensorUsage_angularVelocity_textView) TextView mMultiSensorUsageAngularVelocityTextView;
    @BindView(R.id.multiSensorUsage_angularVelocity_switch) SwitchCompat mMultiSensorUsageAngularVelocitySwitch;
    @BindView(R.id.multiSensorUsage_angularVelocity_device1_x_tv) TextView mMultiSensorUsageAngularVelocityDevice1XTv;
    @BindView(R.id.multiSensorUsage_angularVelocity_device1_y_tv) TextView mMultiSensorUsageAngularVelocityDevice1YTv;
    @BindView(R.id.multiSensorUsage_angularVelocity_device1_z_tv) TextView mMultiSensorUsageAngularVelocityDevice1ZTv;
    @BindView(R.id.multiSensorUsage_angularVelocity_device2_x_tv) TextView mMultiSensorUsageAngularVelocityDevice2XTv;
    @BindView(R.id.multiSensorUsage_angularVelocity_device2_y_tv) TextView mMultiSensorUsageAngularVelocityDevice2YTv;
    @BindView(R.id.multiSensorUsage_angularVelocity_device2_z_tv) TextView mMultiSensorUsageAngularVelocityDevice2ZTv;
    @BindView(R.id.multiSensorUsage_angularVelocity_containerLl) LinearLayout mMultiSensorUsageAngularVelocityContainerLl;
    @BindView(R.id.multiSensorUsage_magneticField_textView) TextView mMultiSensorUsageMagneticFieldTextView;
    @BindView(R.id.multiSensorUsage_magneticField_switch) SwitchCompat mMultiSensorUsageMagneticFieldSwitch;
    @BindView(R.id.multiSensorUsage_magneticField_device1_x_tv) TextView mMultiSensorUsageMagneticFieldDevice1XTv;
    @BindView(R.id.multiSensorUsage_magneticField_device1_y_tv) TextView mMultiSensorUsageMagneticFieldDevice1YTv;
    @BindView(R.id.multiSensorUsage_magneticField_device1_z_tv) TextView mMultiSensorUsageMagneticFieldDevice1ZTv;
    @BindView(R.id.multiSensorUsage_magneticField_device2_x_tv) TextView mMultiSensorUsageMagneticFieldDevice2XTv;
    @BindView(R.id.multiSensorUsage_magneticField_device2_y_tv) TextView mMultiSensorUsageMagneticFieldDevice2YTv;
    @BindView(R.id.multiSensorUsage_magneticField_device2_z_tv) TextView mMultiSensorUsageMagneticFieldDevice2ZTv;
    @BindView(R.id.multiSensorUsage_magneticField_containerLl) LinearLayout mMultiSensorUsageMagneticFieldContainerLl;
    @BindView(R.id.multiSensorUsage_temperature_textView) TextView mMultiSensorUsageTemperatureTextView;
    @BindView(R.id.multiSensorUsage_temperature_device1_value_tv) TextView mMultiSensorUsageTemperatureDevice1ValueTv;
    @BindView(R.id.multiSensorUsage_temperature_containerLl) LinearLayout mMultiSensorUsageTemperatureContainerLl;
    @BindView(R.id.multiSensorUsage_temperature_device2_value_tv) TextView mMultiSensorUsageTemperatureDevice2ValueTv;
    @BindView(R.id.multiSensorUsage_temperature_switch) SwitchCompat mMultiSensorUsageTemperatureSwitch;


    private MultiSensorUsagePresenter mPresenter;
    private CompositeSubscription mCompositeSubscription;

    private final String TAG = MultiSensorUsageActivity.class.getSimpleName();

    private final String LINEAR_ACC_PATH = "Meas/Acc/26";
    private final String ANGULAR_VELOCITY_PATH = "Meas/Gyro/26";
    private final String MAGNETIC_FIELD_PATH = "Meas/Magn/26";
    private final String TEMPERATURE_PATH = "Meas/Temp";
    private MdsSubscription mMdsLinearAccSubscription1;
    private MdsSubscription mMdsLinearAccSubscription2;
    private MdsSubscription mMdsAngularVelocitySubscription1;
    private MdsSubscription mMdsAngularVelocitySubscription2;
    private MdsSubscription mMdsMagneticFieldSubscription1;
    private MdsSubscription mMdsMagneticFieldSubscription2;
    private MdsSubscription mMdsTemperatureSubscription1;
    private MdsSubscription mMdsTemperatureSubscription2;
    private CsvLogger mCsvLogger;
    private boolean isLogSaved = false;
    private boolean isTeacher = true;
    private String choreoPath;
    //private String[][] data;

    //For sensor one
    private List<Float> timestp1 = new ArrayList<Float>();
    private List<Float> totalAcc1 = new ArrayList<Float>();

    //For sensor two
    private List<Float> timestp2 = new ArrayList<Float>();
    private List<Float> totalAcc2 = new ArrayList<Float>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_sensor_usage);
        ButterKnife.bind(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Multi Sensor Usage");
        }
        if(isTeacher) {
            mCsvLogger = new CsvLogger();
        } else {
        }
        choreoPath = getIntent().getStringExtra("path");


        String line;
        System.out.println(choreoPath);
        try (BufferedReader br = new BufferedReader(new FileReader(choreoPath))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(";");

                //System.out.println(data[0] + ", " + data[1] + ", " + data[2] + ", " + data[3]);
                if (data[0].equals("1")) {
                    timestp1.add(Float.parseFloat(data[1]));

                    //Split the decimal separated by "," and rejoin them with "." as separator
                    //Then parse to float
                    String[] xparts;
                    xparts = data[2].split(",");
                    Float x1 = Float.parseFloat(xparts[0] + "." + xparts[1]);

                    String[] yparts;
                    yparts = data[3].split(",");
                    Float y1 = Float.parseFloat(yparts[0] + "." + yparts[1]);

                    String[] zparts;
                    zparts = data[4].split(",");
                    Float z1 = Float.parseFloat(zparts[0] + "." + zparts[1]);

                    totalAcc1.add((float)Math.sqrt(Math.pow(x1,2) + Math.pow(y1,2) + Math.pow(z1,2)));
                }
                else if (data[0].equals("2")) {
                    timestp2.add(Float.parseFloat(data[1]));

                    String[] xparts;
                    xparts = data[2].split(",");
                    Float x2 = Float.parseFloat(xparts[0] + "." + xparts[1]);

                    String[] yparts;
                    yparts = data[3].split(",");
                    Float y2 = Float.parseFloat(yparts[0] + "." + yparts[1]);

                    String[] zparts;
                    zparts = data[4].split(",");
                    Float z2 = Float.parseFloat(zparts[0] + "." + zparts[1]);

                    totalAcc2.add((float)Math.sqrt(Math.pow(x2,2) + Math.pow(y2,2) + Math.pow(z2,2)));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        mPresenter = new MultiSensorUsagePresenter(this);
        mCompositeSubscription = new CompositeSubscription();

        mSelectedDeviceNameTv1.setText(MovesenseConnectedDevices.getConnectedDevice(0).getSerial() + " " +
                MovesenseConnectedDevices.getConnectedDevice(0).getMacAddress());

        mSelectedDeviceNameTv2.setText(MovesenseConnectedDevices.getConnectedDevice(1).getSerial() + " " +
                MovesenseConnectedDevices.getConnectedDevice(1).getMacAddress());

        mCompositeSubscription.add(MdsRx.Instance.connectedDeviceObservable()
                .subscribe(new Action1<MdsConnectedDevice>() {
                    @Override
                    public void call(MdsConnectedDevice mdsConnectedDevice) {
                        if (mdsConnectedDevice.getConnection() == null) {

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    startActivity(new Intent(MultiSensorUsageActivity.this, MainViewActivity.class)
                                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                                }
                            }, 1000);
                        }
                    }
                }, new ThrowableToastingAction(this)));
    }

    /**
     * Linear Acceleration Switch
     *
     * @param buttonView
     * @param isChecked
     */
    @OnCheckedChanged(R.id.multiSensorUsage_linearAcc_switch)
    public void onLinearAccCheckedChange(final CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            Log.d(TAG, "=== Linear Acceleration Subscribe ===");

            isLogSaved = false;

            mCsvLogger.checkRuntimeWriteExternalStoragePermission(this, this);

            mMdsLinearAccSubscription1 = Mds.builder().build(this).subscribe("suunto://MDS/EventListener",
                    FormatHelper.formatContractToJson(MovesenseConnectedDevices.getConnectedDevice(0)
                            .getSerial(), LINEAR_ACC_PATH), new MdsNotificationListener() {
                        @Override
                        public void onNotification(String s) {
                            LinearAcceleration linearAccelerationData = new Gson().fromJson(
                                    s, LinearAcceleration.class);

                            if (linearAccelerationData != null) {

                                LinearAcceleration.Array arrayData = linearAccelerationData.body.array[0];
                                if(isTeacher) {

                                    mCsvLogger.appendHeader("Sensor; Timestamp (ms); X: (m/s^2); Y: (m/s^2); Z: (m/s^2)");

                                    mCsvLogger.appendLine(String.format(Locale.getDefault(),
                                            "1;%d;%.6f;%.6f;%.6f", linearAccelerationData.body.timestamp,
                                            arrayData.x, arrayData.y, arrayData.z));
                                } else {

                                }
                                mMultiSensorUsageLinearAccDevice1XTv.setText(String.format(Locale.getDefault(),
                                        "x: %.6f", arrayData.x));
                                mMultiSensorUsageLinearAccDevice1YTv.setText(String.format(Locale.getDefault(),
                                        "y: %.6f", arrayData.y));
                                mMultiSensorUsageLinearAccDevice1ZTv.setText(String.format(Locale.getDefault(),
                                        "z: %.6f", arrayData.z));
                            }
                        }

                        @Override
                        public void onError(MdsException e) {
                            buttonView.setChecked(false);
                            Toast.makeText(MultiSensorUsageActivity.this, "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });


            mMdsLinearAccSubscription2 = Mds.builder().build(this).subscribe("suunto://MDS/EventListener",
                    FormatHelper.formatContractToJson(MovesenseConnectedDevices.getConnectedDevice(1)
                            .getSerial(), LINEAR_ACC_PATH), new MdsNotificationListener() {
                        @Override
                        public void onNotification(String s) {
                            LinearAcceleration linearAccelerationData = new Gson().fromJson(
                                    s, LinearAcceleration.class);

                            if (linearAccelerationData != null) {

                                LinearAcceleration.Array arrayData = linearAccelerationData.body.array[0];

                                mCsvLogger.appendHeader("Sensor; Timestamp (ms); X: (m/s^2); Y: (m/s^2); Z: (m/s^2)");

                                mCsvLogger.appendLine(String.format(Locale.getDefault(),
                                        "2;%d;%.6f;%.6f;%.6f", linearAccelerationData.body.timestamp,
                                        arrayData.x, arrayData.y, arrayData.z));

                                mMultiSensorUsageLinearAccDevice2XTv.setText(String.format(Locale.getDefault(),
                                        "x: %.6f", arrayData.x));
                                mMultiSensorUsageLinearAccDevice2YTv.setText(String.format(Locale.getDefault(),
                                        "y: %.6f", arrayData.y));
                                mMultiSensorUsageLinearAccDevice2ZTv.setText(String.format(Locale.getDefault(),
                                        "z: %.6f", arrayData.z));
                            }
                        }

                        @Override
                        public void onError(MdsException e) {
                            buttonView.setChecked(false);
                            Toast.makeText(MultiSensorUsageActivity.this, "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });

        } else {
            mMdsLinearAccSubscription1.unsubscribe();
            mMdsLinearAccSubscription2.unsubscribe();
            if (!isLogSaved) {
                mCsvLogger.finishSavingLogs(this, TAG);
                isLogSaved = true;
            }
            Log.d(TAG, "=== Linear Acceleration Unubscribe ===");
        }

    }


    /**
     * Angular Velocity Switch
     *
     * @param buttonView
     * @param isChecked
    @OnCheckedChanged(R.id.multiSensorUsage_angularVelocity_switch)
    public void onAngularVelocityCheckedChange(final CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            Log.d(TAG, "=== Angular Velocity Subscribe ===");

            mMdsAngularVelocitySubscription1 = Mds.builder().build(this).subscribe("suunto://MDS/EventListener",
                    FormatHelper.formatContractToJson(MovesenseConnectedDevices.getConnectedDevice(0)
                            .getSerial(), ANGULAR_VELOCITY_PATH), new MdsNotificationListener() {
                        @Override
                        public void onNotification(String s) {
                            AngularVelocity angularVelocity = new Gson().fromJson(
                                    s, AngularVelocity.class);

                            if (angularVelocity != null) {

                                AngularVelocity.Array arrayData = angularVelocity.body.array[0];

                                mMultiSensorUsageAngularVelocityDevice1XTv.setText(String.format(Locale.getDefault(),
                                        "x: %.6f", arrayData.x));
                                mMultiSensorUsageAngularVelocityDevice1YTv.setText(String.format(Locale.getDefault(),
                                        "y: %.6f", arrayData.y));
                                mMultiSensorUsageAngularVelocityDevice1ZTv.setText(String.format(Locale.getDefault(),
                                        "z: %.6f", arrayData.z));
                            }
                        }

                        @Override
                        public void onError(MdsException e) {
                            buttonView.setChecked(false);
                            Toast.makeText(MultiSensorUsageActivity.this, "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });


            mMdsAngularVelocitySubscription2 = Mds.builder().build(this).subscribe("suunto://MDS/EventListener",
                    FormatHelper.formatContractToJson(MovesenseConnectedDevices.getConnectedDevice(1)
                            .getSerial(), ANGULAR_VELOCITY_PATH), new MdsNotificationListener() {
                        @Override
                        public void onNotification(String s) {
                            AngularVelocity angularVelocity = new Gson().fromJson(
                                    s, AngularVelocity.class);

                            if (angularVelocity != null) {

                                AngularVelocity.Array arrayData = angularVelocity.body.array[0];

                                mMultiSensorUsageAngularVelocityDevice2XTv.setText(String.format(Locale.getDefault(),
                                        "x: %.6f", arrayData.x));
                                mMultiSensorUsageAngularVelocityDevice2YTv.setText(String.format(Locale.getDefault(),
                                        "y: %.6f", arrayData.y));
                                mMultiSensorUsageAngularVelocityDevice2ZTv.setText(String.format(Locale.getDefault(),
                                        "z: %.6f", arrayData.z));
                            }
                        }

                        @Override
                        public void onError(MdsException e) {
                            buttonView.setChecked(false);
                            Toast.makeText(MultiSensorUsageActivity.this, "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
        } else {
            mMdsAngularVelocitySubscription1.unsubscribe();
            mMdsAngularVelocitySubscription2.unsubscribe();
            Log.d(TAG, "=== Angular Velocity Unsubscribe ===");
        }
    }

     */

    /**
     * Magnetic Field Switch
     *
     * @param buttonView
     * @param isChecked
    @OnCheckedChanged(R.id.multiSensorUsage_magneticField_switch)
    public void onMagneticFieldCheckedChange(final CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            Log.d(TAG, "=== Magnetic Field Subscribe ===");

            mMdsMagneticFieldSubscription1 = Mds.builder().build(this).subscribe("suunto://MDS/EventListener",
                    FormatHelper.formatContractToJson(MovesenseConnectedDevices.getConnectedDevice(0)
                            .getSerial(), MAGNETIC_FIELD_PATH), new MdsNotificationListener() {
                        @Override
                        public void onNotification(String s) {
                            MagneticField magneticField = new Gson().fromJson(
                                    s, MagneticField.class);

                            if (magneticField != null) {

                                MagneticField.Array arrayData = magneticField.body.array[0];

                                mMultiSensorUsageMagneticFieldDevice1XTv.setText(String.format(Locale.getDefault(),
                                        "x: %.6f", arrayData.x));
                                mMultiSensorUsageMagneticFieldDevice1YTv.setText(String.format(Locale.getDefault(),
                                        "y: %.6f", arrayData.y));
                                mMultiSensorUsageMagneticFieldDevice1ZTv.setText(String.format(Locale.getDefault(),
                                        "z: %.6f", arrayData.z));
                            }
                        }

                        @Override
                        public void onError(MdsException e) {
                            buttonView.setChecked(false);
                            Toast.makeText(MultiSensorUsageActivity.this, "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });

            mMdsMagneticFieldSubscription2 = Mds.builder().build(this).subscribe("suunto://MDS/EventListener",
                    FormatHelper.formatContractToJson(MovesenseConnectedDevices.getConnectedDevice(1)
                            .getSerial(), MAGNETIC_FIELD_PATH), new MdsNotificationListener() {
                        @Override
                        public void onNotification(String s) {
                            MagneticField magneticField = new Gson().fromJson(
                                    s, MagneticField.class);

                            if (magneticField != null) {

                                MagneticField.Array arrayData = magneticField.body.array[0];

                                mMultiSensorUsageMagneticFieldDevice2XTv.setText(String.format(Locale.getDefault(),
                                        "x: %.6f", arrayData.x));
                                mMultiSensorUsageMagneticFieldDevice2YTv.setText(String.format(Locale.getDefault(),
                                        "y: %.6f", arrayData.y));
                                mMultiSensorUsageMagneticFieldDevice2ZTv.setText(String.format(Locale.getDefault(),
                                        "z: %.6f", arrayData.z));
                            }
                        }

                        @Override
                        public void onError(MdsException e) {
                            buttonView.setChecked(false);
                            Toast.makeText(MultiSensorUsageActivity.this, "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
        } else {
            mMdsMagneticFieldSubscription1.unsubscribe();
            mMdsMagneticFieldSubscription2.unsubscribe();
            Log.d(TAG, "=== Magnetic Field Unsubscribe ===");
        }
    }

     */
    /**
     * Temperature Switch
     *
    */
    /*
     @OnCheckedChanged(R.id.multiSensorUsage_temperature_switch)
    public void onTemperatureCheckedChange(final CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            Log.d(TAG, "=== Temperature Subscribe ===");

            mMdsTemperatureSubscription1 = Mds.builder().build(this).subscribe("suunto://MDS/EventListener",
                    FormatHelper.formatContractToJson(MovesenseConnectedDevices.getConnectedDevice(0)
                            .getSerial(), TEMPERATURE_PATH), new MdsNotificationListener() {
                        @Override
                        public void onNotification(String s) {
                            TemperatureSubscribeModel temperature = new Gson().fromJson(s, TemperatureSubscribeModel.class);

                            if (temperature != null) {

                                mMultiSensorUsageTemperatureDevice1ValueTv.setText(String.format(Locale.getDefault(),
                                        "temperature: %.6f kelvins", temperature.getBody().measurement));
                            }
                        }

                        @Override
                        public void onError(MdsException e) {
                            buttonView.setChecked(false);
                            Toast.makeText(MultiSensorUsageActivity.this, "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });

            mMdsTemperatureSubscription2 = Mds.builder().build(this).subscribe("suunto://MDS/EventListener",
                    FormatHelper.formatContractToJson(MovesenseConnectedDevices.getConnectedDevice(1)
                            .getSerial(), TEMPERATURE_PATH), new MdsNotificationListener() {
                        @Override
                        public void onNotification(String s) {
                            TemperatureSubscribeModel temperature = new Gson().fromJson(s, TemperatureSubscribeModel.class);

                            if (temperature != null) {

                                mMultiSensorUsageTemperatureDevice2ValueTv.setText(String.format(Locale.getDefault(),
                                        "temperature: %.6f kelvins", temperature.getBody().measurement));
                            }
                        }

                        @Override
                        public void onError(MdsException e) {
                            buttonView.setChecked(false);
                            Toast.makeText(MultiSensorUsageActivity.this, "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });

        } else {
            mMdsTemperatureSubscription1.unsubscribe();
            mMdsTemperatureSubscription2.unsubscribe();
            Log.d(TAG, "=== Temperature Unsubscribe ===");
        }
    }


     */
    @Override
    public void setPresenter(MultiSensorUsageContract.Presenter presenter) {

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage(R.string.disconnect_dialog_text)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e(TAG, "TEST Disconnecting...");
                        BleManager.INSTANCE.disconnect(MovesenseConnectedDevices.getConnectedRxDevice(0));
                        BleManager.INSTANCE.disconnect(MovesenseConnectedDevices.getConnectedRxDevice(1));
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }
}

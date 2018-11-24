package com.movesense.showcaseapp.csv;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.movesense.mds.internal.connectivity.MovesenseConnectedDevices;
import com.movesense.showcaseapp.R;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.ArrayList;
import java.util.List;

public class CsvLogger {

    private final String TAG = CsvLogger.class.getSimpleName();

    private final StringBuilder mStringBuilder;
    public static final int REQUEST_WRITE_EXTERNAL_STORAGE_PERMISSION = 99;

    private boolean isHeaderExists = false;

    public CsvLogger() {
        mStringBuilder = new StringBuilder();
    }

    public void appendHeader(String header) {
        if (!isHeaderExists) {
            mStringBuilder.append(header);
            mStringBuilder.append("\n");
        }

        isHeaderExists = true;
    }

    public void appendLine(String line) {
        mStringBuilder.append(line);
        mStringBuilder.append("\n");
    }

    public void finishSavingLogs(Context context, String sensorName) {
        try {
            File file = createLogFile(sensorName);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(mStringBuilder.toString());
            fileWriter.close();

            MediaScannerConnection.scanFile(context, new String[]{file.getPath()}, null, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getLogFile() {
        String filename = "2018_11_24T18_48_14Z_589_1750300.csv"
        File file = new File(filename);
        BufferedReader reader = null;

        List<Float> timestp = new ArrayList<Float>();
        List<Float> x = new ArrayList<Float>();
        List<Float> y = new ArrayList<Float>();
        List<Float> z = new ArrayList<Float>();

        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;

            while ((line = reader.readLine()) != null) {
                //list.add(Integer.parseInt(text));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
    }

    public File createLogFile(String sensorName) {
        if (isExternalStorageWritable()) {
            File externalDirectory = Environment.getExternalStorageDirectory();
            File appDirectory = new File(externalDirectory, "Movesense");
            File logFile = new File(appDirectory, createFileNameIso8601(sensorName) + ".csv");

            // create app folder
            if (!appDirectory.exists()) {
                boolean status = appDirectory.mkdirs();
                Log.e(TAG, "appDirectory created: " + status);
            }

            // create log file
            if (!logFile.exists()) {
                boolean status = false;
                try {
                    status = logFile.createNewFile();
                    return logFile;
                } catch (IOException e) {
                    Log.e(TAG, "logFile.createNewFile(): ", e);
                    e.printStackTrace();
                }
                Log.e(TAG, "logFile.createNewFile() created: " + status);
            } else {
                return logFile;
            }
        } else {
            Log.e(TAG, "createFile isExternalStorageWritable Error");
        }
        return null;
    }

    private String createFileNameIso8601(String tag) {
        // timestamp (ISO 8601) + device serial + data type,
        StringBuilder sb = new StringBuilder();

        // Get Current Timestamp ISO 8601
        String currentISO8601Timestamp = String.format("%tFT%<tTZ.%<tL",
                Calendar.getInstance(TimeZone.getTimeZone("Z")));

        // Get connected device serial
        String deviceName = "Unknown";
        if (MovesenseConnectedDevices.getConnectedDevices().size() > 0) {
            deviceName = MovesenseConnectedDevices.getConnectedDevice(0).getSerial();
        }

        sb.append(currentISO8601Timestamp).append("_").
                append(deviceName).append("_")
                .append(tag);

        return sb.toString();
    }

    /* Checks if external storage is available for read and write */
    private boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    public boolean checkRuntimeWriteExternalStoragePermission(Context context, final Activity activity) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                new AlertDialog.Builder(activity)
                        .setTitle(R.string.write_external_storage_permission_title)
                        .setMessage(R.string.write_external_storage_permission_text)
                        .setPositiveButton(R.string.btn_ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                requestForWriteExternalStoragePermission(activity);
                            }
                        })
                        .create()
                        .show();

            } else {
                requestForWriteExternalStoragePermission(activity);
            }
            Log.e(TAG, "checkRuntimeWriteExternalStoragePermission() FALSE");
            return false;
        } else {
            Log.e(TAG, "checkRuntimeWriteExternalStoragePermission() TRUE");
            return true;
        }
    }

    private void requestForWriteExternalStoragePermission(Activity activity) {
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                REQUEST_WRITE_EXTERNAL_STORAGE_PERMISSION);
    }
}

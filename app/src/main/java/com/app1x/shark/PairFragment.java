package com.app1x.shark;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PairFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PairFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PairFragment extends Fragment {
//     TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String NEARBY = "nearbyDevices";
    private static final String USERNAME = "username";
    private static final String DEVICEID = "deviceID";
    private static final String PARTYID = "partyID";

    //Parameters
    public static final String TAG= "PairFragment";

    private List<String> nearbyDevices= new ArrayList<String>();
    private String mUsername;
    private String mDeviceId;
    private int mPartyId;

    private OnFragmentInteractionListener mListener;

//    // Create a Bluetooth Adapter
//    BluetoothAdapter mAdapter = BluetoothAdapter.getDefaultAdapter();
//
//    // Create a BroadcastReceiver for ACTION_FOUND
//    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
//        public void onReceive(Context context, Intent intent) {
//            String action = intent.getAction();
//            if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)) {
//                nearbyDevices.clear();
//                Log.i(TAG, "Discovery Started");
//            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
//                Log.i(TAG, "Discovery Finished");
//            } else if (BluetoothDevice.ACTION_FOUND.equals(action)) {
//                // Get the BluetoothDevice object from the Intent
//                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
//                // Add the name and address to an array adapter to show in a ListView
////                            mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
//                nearbyDevices.add(device.getAddress());
//                Log.i(TAG, nearbyDevices.toString());
//
//                Request request= new Request(mUsername, null, mDeviceId, nearbyDevices,
//                        mPartyId);
//                //TODO make http request to send request to server
//                //TODO set party id after request returns
//            }
//        }
//    };

    public PairFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PairFragment.
     */
    public static PairFragment newInstance(String username, String deviceID, int partyID) {
        PairFragment fragment = new PairFragment();
        Bundle args = new Bundle();
        args.putString(USERNAME, username);
        args.putString(DEVICEID, deviceID);
        args.putInt(PARTYID, partyID);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUsername = getArguments().getString(USERNAME);
            mDeviceId = getArguments().getString(DEVICEID);
            mPartyId = getArguments().getInt(PARTYID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pair, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onPairButtonPressed() {
        Log.i(TAG, "onButtonPressed");
        if (mListener != null) {
            mListener.onFragmentInteraction(MainActivity.DISCOVER_BLUEOOTH);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            Log.i(TAG, "djfy");
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        mListener.onFragmentInteraction(MainActivity.START_BLUEOOTH);

        getView().findViewById(R.id.pairButton).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                onPairButtonPressed();
                return true;
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();

        mListener.onFragmentInteraction(MainActivity.END_BLUEOOTH);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(int message);
    }
}

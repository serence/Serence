package org.nganga.sesame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.nganga.sesame.VolleyNetwork.VolleySingleton;

/**
 * Created by nganga on 9/22/15.
 */
public class MyFragment extends Fragment {

    public static MyFragment getInstance(int position){
        MyFragment myFragment = new MyFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.my_fragment, container, false);
        TextView textView = (TextView) layout.findViewById(R.id.tabFragmentText);
        Bundle bundle = getArguments();

        if (bundle != null) {

            textView.setText("You are on Page " + bundle.getInt("position"));
        }


      // Instantiate the RequestQueue.
        RequestQueue queue = VolleySingleton.getsInstance().getRequestQueue();
        String url ="http://www.google.com";

    // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Toast.makeText(getActivity(),response.substring(0, 1000), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
       // Add the request to the RequestQueue.
        queue.add(stringRequest);

        return layout;
    }
}

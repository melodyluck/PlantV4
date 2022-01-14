package com.example.plantv4;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ServiceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ServiceFragment extends Fragment {
    EditText etName;
    EditText etEmail;
    EditText etPhone;
    EditText etService;
    Button btnSubmit;
    private Spinner spinner;
    String choice;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ServiceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ServiceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ServiceFragment newInstance(String param1, String param2) {
        ServiceFragment fragment = new ServiceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_service, container,false);
        spinner = view.findViewById(R.id.spService);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        etName = view.findViewById(R.id.etName);
        etEmail = view.findViewById(R.id.etEmail);
        etPhone = view.findViewById(R.id.etPhone);
        etService = view.findViewById(R.id.etService);


        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(getActivity(),R.array.Service, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                choice = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etName.getText().toString().isEmpty()
                        || etEmail.getText().toString().isEmpty()
                        || etPhone.getText().toString().isEmpty()
                        || etService.getText().toString().isEmpty()
                        || choice.isEmpty()){
                    Toast.makeText(getActivity(), "Please enter all fields", Toast.LENGTH_LONG).show();
                }

                else{
                    String message = choice + "\n"
                            + etName.getText().toString().trim() + "\n"
                            + etEmail.getText().toString().trim() + "\n"
                            + etPhone.getText().toString().trim() + "\n"
                            + etService.getText().toString().trim() + "\r\n";
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL,
                            new String[]{"forbussinesslydia@gmail.com"});
                    email.putExtra(Intent.EXTRA_SUBJECT, "ApplicationTest");
                    email.putExtra(Intent.EXTRA_TEXT, message);
                    email.setType("message/rfc822");
                    startActivity(Intent.createChooser(email, "Success Submit"));

                }
                //Toast.makeText(getActivity(), "test", Toast.LENGTH_LONG).show();

            }
        });

        return view;

        //return inflater.inflate(R.layout.fragment_service, container, false);
    }
    /*public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        choice = parent.getItemAtPosition(pos).toString();
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }*/

}
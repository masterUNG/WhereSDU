package appewtc.masterung.wheresdu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import appewtc.masterung.wheresdu.MyAlert;
import appewtc.masterung.wheresdu.R;

/**
 * Created by masterUNG on 7/6/2017 AD.
 */

public class RegisterFragment extends Fragment {

    //Explicit
    private String nameString, userString, passwordString;


    public static RegisterFragment registerInstance() {
        RegisterFragment registerFragment = new RegisterFragment();
        Bundle bundle = new Bundle();
        registerFragment.setArguments(bundle);
        return registerFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.register_fragment_layout, container, false);

        return view;
    }   // onCreateView

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Back Controller
        backController();

        //New Register Controller
        newRegisterController();


    }   // onActivityCreate

    private void newRegisterController() {

        //Initial View
        final EditText nameEditText = (EditText) getView().findViewById(R.id.edtName);
        final EditText userEditText = (EditText) getView().findViewById(R.id.edtUser);
        final EditText passwordEditText = (EditText) getView().findViewById(R.id.edtPassword);
        Button button = (Button) getView().findViewById(R.id.btnNewRegister);

        //Get Event From Click New Register
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get Value for Edit Text
                nameString = nameEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();

                //Check Space
                if (nameString.length() == 0
                        || userString.length() == 0
                        || passwordString.length() == 0) {
                    //Have Space
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog("Have Space", "Please Fill All Every Blank");

                } else {
                    //No Space
                    uploadValueToServer();

                }

            }   // onClick
        });


    }   // newRegister

    private void uploadValueToServer() {

    }

    private void backController() {
        ImageView imageView = (ImageView) getView().findViewById(R.id.imvBack);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContent, MainFragment.mainInstance())
                        .commit();
            }
        });
    }

}   // Main Class

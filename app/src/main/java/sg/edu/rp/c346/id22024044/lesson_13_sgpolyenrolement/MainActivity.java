package sg.edu.rp.c346.id22024044.lesson_13_sgpolyenrolement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    ListView lvEnrolment;
    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.textViewDisplay);
        lvEnrolment = findViewById(R.id.listViewEnrolment);
        client = new AsyncHttpClient();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Enrolment> alEnrolment = new ArrayList<Enrolment>();
        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=fdd36db3-3317-4790-8c27-8e58f7dd1a42", new JsonHttpResponseHandler() {
            String year;
            String typeOfStudy;
            String enrolment;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    JSONObject jsonArrItems = response.getJSONObject("result");
                    JSONArray jsonArrEnrolments = jsonArrItems.getJSONArray("records");
                    for(int i = 0; i < jsonArrEnrolments.length(); i++) {
                        JSONObject jsonObjEnrolment = jsonArrEnrolments.getJSONObject(i);
                        year = jsonObjEnrolment.getString("year");
                        typeOfStudy = jsonObjEnrolment.getString("type_of_study");
                        enrolment = jsonObjEnrolment.getString("enrolment");

                        Enrolment enrolmentObj = new Enrolment(year, typeOfStudy, enrolment);
                        alEnrolment.add(enrolmentObj);
                    }
                }

                catch(JSONException e){
                }
                //POINT X – Code to display List View
                ArrayAdapter<Enrolment> adapter = new ArrayAdapter<Enrolment>(MainActivity.this, android.R.layout.simple_list_item_1, alEnrolment);
                lvEnrolment.setAdapter(adapter);

            }//end onSuccess
        });

    }//end onResume
}
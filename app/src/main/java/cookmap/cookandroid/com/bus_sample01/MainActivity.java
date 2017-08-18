package cookmap.cookandroid.com.bus_sample01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtBusNum;
    Button btnSearch;
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtBusNum = (EditText)findViewById(R.id.edtBusNum);
        btnSearch = (Button)findViewById(R.id.btnSearch);
        tvResult = (TextView)findViewById(R.id.tvResult);

        //new DownloadWebpageTask().execute(strUrl);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<BusInfos> bus = new ArrayList<BusInfos>();
                xmlBusInfo xml = new xmlBusInfo();
                xml.searchBusNum("20", bus);


//                for(int i = 0; i<bus.size(); i++){
//                    tvResult.append("결과값" + "\n");
//                    tvResult.append(bus.get(i).getBuslinenum() + ", ");
//                    tvResult.append(bus.get(i).getBustype() + "\n");
//                }

                int test = xml.businfoData.size();
                Log.d("test", Integer.toString(test));
//

//                for(int i = 0; i<xml.businfoData.size(); i++){
//                    tvResult.append("결과값" + "\n");
//                    tvResult.append(xml.businfoData.get(i).getBuslinenum() + ", ");
//                    tvResult.append(xml.businfoData.get(i).getBustype() + "\n");
//
//                }

            }
        });

    }

    /*
    private  class DownloadWebpageTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls) {
            try {
                return (String)downloadUrl((String)urls[0]);
            } catch (IOException e) {
                return "다운로드 실패";
            }
        }

        @Override
        protected void onPostExecute(String result) {



//            String resultCode = "";
//
//            String buslinenum = "";
//            String bustype = "";
//
//            boolean is_resultCode = false;
//            boolean is_buslinenum = false;
//            boolean is_bustype = false;
//
//            try{
//                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
//                factory.setNamespaceAware(true);
//                XmlPullParser xpp = factory.newPullParser();
//
//                xpp.setInput(new StringReader(result));
//                int eventType = xpp.getEventType();
//
//                while (eventType != XmlPullParser.END_DOCUMENT){
//                    if(eventType == XmlPullParser.START_DOCUMENT){
//                        ;
//                    }else if(eventType == XmlPullParser.START_TAG){
//
//                        String tag_name = xpp.getName();
//
//                        Log.d("test", "시작");
//                        Log.d("test", tag_name);
//
//                        if(tag_name.equals("resultCode")){
//                            is_resultCode = true;
//                        }
//                        if(tag_name.equals("buslinenum")){
//                            is_buslinenum = true;
//                        }
//                        if(tag_name.equals("bustype")){
//                            is_bustype = true;
//                        }
//                    }else if(eventType == XmlPullParser.TEXT){
//                        Log.d("test", "텍스트");
//                        Log.d("test", xpp.getText());
//
//                        if (is_resultCode){
//                            resultCode = xpp.getText();
//                            //tvResult.append();
//                            is_resultCode = false;
//                        }
//                        if(resultCode.equals("00")){
//                            if(is_buslinenum){
//                                tvResult.append(xpp.getText() + ", ");
//                                is_buslinenum = false;
//                            }else if(is_bustype){
//                                tvResult.append(xpp.getText() + "\n");
//                                is_bustype = false;
//                            }
//
//                        }
//                    }else if(eventType == XmlPullParser.END_TAG){
//                        Log.d("test", "종료");
//
//                    }
//
//                    Log.d("test", "다음");
//                    eventType = xpp.next();
//                }
//
//            }catch (Exception e){
//                tvResult.setText(e.getMessage());
//
//            }

        }

        private String downloadUrl(String myurl) throws IOException {

            HttpURLConnection conn = null;
            try {
                URL url = new URL(myurl);
                conn = (HttpURLConnection) url.openConnection();
                BufferedInputStream buf = new BufferedInputStream(conn.getInputStream());
                BufferedReader bufreader = new BufferedReader(new InputStreamReader(buf, "utf-8"));
                String line = null;
                String page = "";
                while((line = bufreader.readLine()) != null) {
                    page += line;
                }

                return page;
            } finally {
                conn.disconnect();
            }
        }
    }

    */
}

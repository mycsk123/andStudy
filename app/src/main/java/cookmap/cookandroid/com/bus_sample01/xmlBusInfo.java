package cookmap.cookandroid.com.bus_sample01;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by 8 on 2017-08-18.
 */

public class xmlBusInfo {

    private String serviceUrl;
    private String serviceKey;
    private String searchbuslinenum;
    private String strUrl;

    ArrayList<BusInfos> businfoData;

    public xmlBusInfo() {
        serviceUrl = "http://data.busan.go.kr/openBus/service/busanBIMS2/";
        serviceKey = "slg7RJ8L%2FCOauR%2FaIz85i2dqPOIbESUB2oT83luBfprZZQy5C5t9gdyOn7FwwPFHMAMpgwZadPce0vCiDFiQLg%3D%3D";
        searchbuslinenum = "";
        strUrl = "";
        businfoData = new ArrayList<BusInfos>();
    }

    public void searchBusNum(String busNum, ArrayList<BusInfos> busDataList) {
        searchbuslinenum = busNum;
        //strUrl = serviceUrl + "busInfo?serviceKey=" + serviceKey + "&lineno=" + searchbuslinenum;
        strUrl = "http://data.busan.go.kr/openBus/service/busanBIMS2/busInfo?serviceKey=slg7RJ8L%2FCOauR%2FaIz85i2dqPOIbESUB2oT83luBfprZZQy5C5t9gdyOn7FwwPFHMAMpgwZadPce0vCiDFiQLg%3D%3D&lineno=20";

        businfoData.add(new BusInfos());
        businfoData.get(0).setBuslinenum("20");
        new xmlParser().execute(strUrl);
    }

    public class xmlParser extends AsyncTask<String, Void, String> {
        private Activity context;

        //private ArrayList<BusInfos> busDataList;

        @Override
        protected String doInBackground(String... urls) {
            Log.d("test", "doInBackground");

            try {
                return (String) downloadUrl((String) urls[0]);
            } catch (IOException e) {
                Log.d("test", "다운로드 실패");
                return "다운로드 실패";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Log.d("test", "onPostExecute");

            String resultCode = "";
            String buslinenum = "";
            String bustype = "";

            boolean is_resultCode = false;
            boolean is_buslinenum = false;
            boolean is_bustype = false;

            try {
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(true);
                XmlPullParser xpp = factory.newPullParser();

                xpp.setInput(new StringReader(result));
                int eventType = xpp.getEventType();

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_DOCUMENT) {

                    } else if (eventType == XmlPullParser.START_TAG) {
                        String tag_name = xpp.getName();
                        if (tag_name.equals("resultCode")) {
                            is_resultCode = true;
                        }
                        if (tag_name.equals("buslinenum")) {
                            is_buslinenum = true;
                        }
                        if (tag_name.equals("bustype")) {
                            is_bustype = true;
                        }
                    } else if (eventType == XmlPullParser.TEXT) {
                        if (is_resultCode) {
                            resultCode = xpp.getText();
                            //tvResult.append();
                            is_resultCode = false;
                        }
                        if (resultCode.equals("00")) {
                            if (is_buslinenum) {
                                businfoData.add(new BusInfos());
                                buslinenum = xpp.getText();
                                businfoData.get(businfoData.size() - 1).setBuslinenum(buslinenum);
                                is_buslinenum = false;
                            } else if (is_bustype) {
                                bustype = xpp.getText();
                                businfoData.get(businfoData.size() - 1).setBustype(bustype);
                                is_bustype = false;
                            }


                        }

                    } else if (eventType == XmlPullParser.END_TAG) {

                    }
                    eventType = xpp.next();
                }

            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

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
                while ((line = bufreader.readLine()) != null) {
                    page += line;
                }

                return page;
            } finally {
                conn.disconnect();
            }
        }

    }
}





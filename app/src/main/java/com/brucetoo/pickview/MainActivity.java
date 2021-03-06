package com.brucetoo.pickview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bruce.pickerview.LoopScrollListener;
import com.bruce.pickerview.LoopView;
import com.bruce.pickerview.popwindow.DatePickerPopWin;
import com.bruce.pickerview.popwindow.TimePickerPopWin;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

//    private ArrayList<ProvinceModel> mProvinceList = null; // 省份列表
//    private String mProvince = null; // 省份
//    private String mCity = null; // 城市
    private LoopView loopView;
    TextView tv_time_changed;
    Button timepick;
    RelativeLayout rel_timepicker_rootview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        tv_time_changed= (TextView) findViewById(R.id.tv_time_changed);
        timepick= (Button) findViewById(R.id.timepick);

        findViewById(R.id.date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        timepick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerPopWin timePickerPopWin=new TimePickerPopWin.Builder(MainActivity.this, new TimePickerPopWin.OnTimePickListener() {
                    @Override
                    public void onTimePickCompleted(int hour, int minute, String AM_PM, String time) {
                        Toast.makeText(MainActivity.this, time, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onTimeScroll(int hour, int minute, String AM_PM, String time) {
                        System.out.println("TIME:: "+time);
//                        if (time.length()>0) {
//                            tv_time_changed.setText(time);
//                        }
                    }

                }).textConfirm("CONFIRM")
                        .textCancel("CANCEL")
                        .btnTextSize(16)
                        .viewTextSize(34)
                        .colorCancel(Color.parseColor("#999999"))
                        .colorConfirm(Color.parseColor("#009900"))
                        .build();
                timePickerPopWin.showPopWin(MainActivity.this);
            }
        });


        findViewById(R.id.province).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Working on...", Toast.LENGTH_SHORT).show();
//                if(null != mProvinceList) {
//                    ProvincePickPopWin pickPopWin = new ProvincePickPopWin(MainActivity.this,
//                            mProvince, mCity, mProvinceList, MainActivity.this);
//                    pickPopWin.showPopWin(MainActivity.this);
//                }
            }
        });

        loopView = (LoopView) findViewById(R.id.loop_view);
        loopView.setInitPosition(2);
        loopView.setCanLoop(false);
        loopView.setLoopListener(new LoopScrollListener() {
            @Override
            public void onItemSelect(int item) {

            }

            @Override
            public void onScrollSelectedItem(int item) {

            }
        });
        loopView.setTextSize(25);//must be called before setDateList
        loopView.setDataList(getList());
//        ((new ProvinceInfoParserTask(this, mHandler))).execute();// 解析本地地址信息文件
    }

    public ArrayList<String> getList(){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("DAY TEST:" + i);
        }
        return list;
    }


//    private Handler mHandler = new Handler(new Handler.Callback() {
//        @Override
//        public boolean handleMessage(Message msg) {
//            switch (msg.what) {
//                case ProvinceInfoParserTask.MSG_PARSE_RESULT_CALLBACK: // 解析地址完成
//                    mProvinceList = (ArrayList<ProvinceModel>) msg.obj;
//                    break;
//            }
//            return false;
//        }
//    });

//    @Override
//    public void onAddressPickCompleted(String province, String provinceId, String city, String cityId) {
////        Toast.makeText(this,province+"-"+provinceId+"-"+city+"-"+cityId,Toast.LENGTH_SHORT).show();
//        Toast.makeText(this,ProvinceInfoUtils.matchAddress(this,provinceId,cityId,mProvinceList),Toast.LENGTH_SHORT).show();
//        ProvinceInfoUtils.matchAddress(this,provinceId,cityId,mProvinceList);
//    }
}

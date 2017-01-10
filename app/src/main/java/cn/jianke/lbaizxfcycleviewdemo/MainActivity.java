package cn.jianke.lbaizxfcycleviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import cn.jianke.lbaizxfcycleview.model.CycleModel;
import cn.jianke.lbaizxfcycleview.widget.CycleView;

/**
 * @className: MainActivity
 * @classDescription: LbaizxfCycleView测试页
 * @author: leibing
 * @createTime: 2016/09/26
 */
public class MainActivity extends AppCompatActivity {
    // 显示轮播图片
    private CycleView lbaizxfCvw;
    // 数据源
    private List<CycleModel> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // findView
        lbaizxfCvw = (CycleView) findViewById(R.id.cvw_lbaizxf);
        // 初始化数据源
        mData = new ArrayList<>();
        // 添加数据源
        CycleModel cycleModel = new CycleModel("1",
                "http://img.mbp.jianke.com/46dcbfe339a9405c247fdfb25c291733");
        mData.add(cycleModel);
        cycleModel = new CycleModel("2",
                "http://img.mbp.jianke.com/13f13dfb29081b58381af3dbf9cb1b9b");
        mData.add(cycleModel);
        // 设置显示方式（居中,内边距离下24dp）
        lbaizxfCvw.setAlignParentCenter(24);
        // 设置为有轮播功能
        lbaizxfCvw.setIsHasWheel(true);
        // 设置数据源并设置监听
        lbaizxfCvw.setData(mData, MainActivity.this,new CycleView.CycleViewListener() {
            @Override
            public void onItemClick(int position) {
                position = position + 1;
                Toast.makeText(MainActivity.this, "这是第" + position + "个图",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}

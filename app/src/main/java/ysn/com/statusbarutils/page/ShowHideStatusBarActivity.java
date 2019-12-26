package ysn.com.statusbarutils.page;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ysn.com.statusbar.StatusBarUtils;
import ysn.com.statusbarutils.R;
import ysn.com.statusbarutils.utils.DeviceUtils;

/**
 * @Author yangsanning
 * @ClassName ShowHideStatusBarActivity
 * @Description 显示隐藏状态栏
 * @Date 2019/12/26
 * @History 2019/12/26 author: description:
 */
public class ShowHideStatusBarActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_hide_status_bar);

        findViewById(R.id.show_hide_status_bar_activity_show).setOnClickListener(this);
        Button hideBarView = findViewById(R.id.show_hide_status_bar_activity_hide);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) hideBarView.getLayoutParams();
        params.bottomMargin = DeviceUtils.getNavigationBarHeight(this);
        hideBarView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.show_hide_status_bar_activity_show:
                StatusBarUtils.showStatusBar(this);
                break;
            case R.id.show_hide_status_bar_activity_hide:
                StatusBarUtils.hideStatusBar(this);
                break;
            default:
                break;
        }
    }
}

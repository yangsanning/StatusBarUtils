package ysn.com.statusbarutils;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import ysn.com.statusbar.StatusBarUtils;
import ysn.com.statusbarutils.page.ColorActivity;
import ysn.com.statusbarutils.page.FragmentIndexActivity;
import ysn.com.statusbarutils.page.GradientActivity;
import ysn.com.statusbarutils.page.ShowHideStatusBarActivity;
import ysn.com.statusbarutils.page.TransparentActivity;
import ysn.com.statusbarutils.utils.DeviceUtils;
import ysn.com.statusbarutils.utils.ResUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.main_activity_tool_bar);
        StatusBarUtils.setColor(this, ResUtils.getColor(R.color.color_black), toolbar);

        TextView deviceInfoTextView = findViewById(R.id.main_activity_device_info);
        deviceInfoTextView.setText(ResUtils.getStringFormat(R.string.text_device_info,
            DeviceUtils.getDeviceBrand(),
            DeviceUtils.getSystemModel(),
            DeviceUtils.getSystemVersion()
        ));

        setOnClickListener(R.id.main_activity_skip_color,
            R.id.main_activity_skip_transparent,
            R.id.main_activity_skip_gradient,
            R.id.main_activity_skip_fragment,
            R.id.main_activity_light_mode,
            R.id.main_activity_dark_mode,
            R.id.main_activity_skip_color,
            R.id.main_activity_show_hide_status_bar);
    }

    private void setOnClickListener(@IdRes int... idResArray) {
        for (int idRes : idResArray) {
            findViewById(idRes).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_activity_skip_color:
                startActivity(ColorActivity.class);
                break;
            case R.id.main_activity_skip_transparent:
                startActivity(TransparentActivity.class);
                break;
            case R.id.main_activity_skip_gradient:
                startActivity(GradientActivity.class);
                break;
            case R.id.main_activity_skip_fragment:
                startActivity(FragmentIndexActivity.class);
                break;
            case R.id.main_activity_light_mode:
                StatusBarUtils.setColor(this, ResUtils.getColor(R.color.color_black), toolbar);
                StatusBarUtils.setLightMode(MainActivity.this);
                break;
            case R.id.main_activity_dark_mode:
                StatusBarUtils.setColor(this, ResUtils.getColor(R.color.color_black1), toolbar);
                StatusBarUtils.setDarkMode(MainActivity.this);
                break;
            case R.id.main_activity_show_hide_status_bar:
                startActivity(ShowHideStatusBarActivity.class);
                break;
            default:
                break;
        }
    }

    private void startActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}

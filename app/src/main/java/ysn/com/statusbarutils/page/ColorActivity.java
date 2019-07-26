package ysn.com.statusbarutils.page;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Random;

import ysn.com.statusbar.StatusBarUtils;
import ysn.com.statusbarutils.R;

/**
 * @Author yangsanning
 * @ClassName ColorActivity
 * @Description 颜色状态栏演示
 * @Date 2019/7/26
 * @History 2019/7/26 author: description:
 */
public class ColorActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        toolbar = findViewById(R.id.color_activity_tool_bar);
        findViewById(R.id.color_activity_change_color).setOnClickListener(this);

        setColor();
    }

    private void setColor() {
        int color = 0xff000000 | new Random().nextInt(0xffffff);
        StatusBarUtils.setColor(this, color, toolbar);
    }

    @Override
    public void onClick(View view) {
        setColor();
    }
}

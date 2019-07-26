package ysn.com.statusbarutils.page;

import android.graphics.drawable.GradientDrawable;
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
 * @ClassName GradientActivity
 * @Description 渐变状态栏演示
 * @Date 2019/7/26
 * @History 2019/7/26 author: description:
 */
public class GradientActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gradient);

        toolbar = findViewById(R.id.gradient_activity_tool_bar);
        findViewById(R.id.gradient_activity_change_gradient).setOnClickListener(this);

        setGradientColor();
    }

    private void setGradientColor() {
        Random random = new Random();
        int startColor = 0xff000000 | random.nextInt(0xffffff);
        int endColor = 0xff000000 | random.nextInt(0xffffff);
        int[] colors = {startColor, endColor};
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors);

        toolbar.setBackground(gradientDrawable);
        StatusBarUtils.setGradientColor(GradientActivity.this, toolbar);
    }

    @Override
    public void onClick(View view) {
        setGradientColor();
    }
}
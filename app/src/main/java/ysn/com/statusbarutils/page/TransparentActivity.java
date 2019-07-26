package ysn.com.statusbarutils.page;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import ysn.com.statusbar.StatusBarUtils;
import ysn.com.statusbarutils.R;

/**
 * @Author yangsanning
 * @ClassName TransparentActivity
 * @Description 状态栏设置透明演示
 * @Date 2019/7/26
 * @History 2019/7/26 author: description:
 */
public class TransparentActivity extends AppCompatActivity implements OnClickListener {

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent);

        StatusBarUtils.setTransparentForWindow(this);

        imageView = findViewById(R.id.transparent_activity_image);
        findViewById(R.id.transparent_activity_change_background).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getTag()==null) {
            view.setTag(true);
            imageView.setImageResource(R.mipmap.image1);
        }else {
            view.setTag(null);
            imageView.setImageResource(R.mipmap.image2);
        }
    }
}

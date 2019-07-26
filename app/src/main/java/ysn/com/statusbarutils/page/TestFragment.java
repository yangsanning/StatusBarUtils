package ysn.com.statusbarutils.page;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import ysn.com.statusbar.StatusBarUtils;
import ysn.com.statusbarutils.R;
import ysn.com.statusbarutils.utils.ResUtils;

/**
 * @Author yangsanning
 * @ClassName TestFragment
 * @Description 一句话概括作用
 * @Date 2019/7/26
 * @History 2019/7/26 author: description:
 */
public class TestFragment extends Fragment {

    private final static String EXTRA_POSITION = "extra_position";

    public static TestFragment newInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_POSITION, position);
        TestFragment fragment = new TestFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() == null || getActivity() == null) {
            return;
        }

        Toolbar toolbar = view.findViewById(R.id.test_activity_tool_bar);
        ImageView imageView = view.findViewById(R.id.test_activity_image);
        switch (getArguments().getInt(EXTRA_POSITION)) {
            case 1:
                StatusBarUtils.setTransparentForWindow(getActivity());
                StatusBarUtils.setPaddingTop(getActivity(), toolbar);
                toolbar.setBackgroundColor(ResUtils.getColor(R.color.colorPrimary));
                imageView.setImageResource(R.mipmap.image4);
                break;
            case 2:
                StatusBarUtils.setTransparentForWindow(getActivity());
                StatusBarUtils.setPaddingTop(getActivity(), toolbar);
                toolbar.setBackgroundColor(ResUtils.getColor(R.color.color_red));
                imageView.setImageResource(R.mipmap.image2);
                break;
            case 3:
                StatusBarUtils.setTransparentForWindow(getActivity());
                StatusBarUtils.setPaddingTop(getActivity(), toolbar);
                toolbar.setBackgroundColor(ResUtils.getColor(R.color.colorPrimaryDark));
                imageView.setImageResource(R.mipmap.image3);
                break;
            default:
                StatusBarUtils.setTransparentForWindow(getActivity());
                toolbar.setVisibility(View.GONE);
                imageView.setImageResource(R.mipmap.image1);
                break;
        }
    }
}
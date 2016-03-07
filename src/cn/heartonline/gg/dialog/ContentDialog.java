package cn.heartonline.gg.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by gaohaoqing
 * Date : 15/9/8
 * Time : 10:41
 */
public abstract class ContentDialog extends Dialog {

    private TextView tv_da_content;
    private TextView tv_da_left_content;
    private TextView tv_da_right_content;

    private LinearLayout ll_da_left_area;
    private LinearLayout ll_da_right_area;

    private Context mContext;

    /**
     * 中间的TestView
     *
     * @return
     */
    public TextView getTv_da_content() {
        return tv_da_content;
    }

    /**
     * 左边的TestView
     *
     * @return
     */
    public TextView getTv_da_left_content() {
        return tv_da_left_content;
    }

    /**
     * 右边的TestView
     *
     * @return
     */
    public TextView getTv_da_right_content() {
        return tv_da_right_content;
    }

    public ContentDialog(Context context, String centerContent, String leftContent, String rightContent) {
        super(context, R.style.CenterDialog);
        init(context);
        setTextView(centerContent, leftContent, rightContent);
    }

    public ContentDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init(context);
    }

    public ContentDialog(Context context, int theme) {
        super(context, theme);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View view = View.inflate(mContext, R.layout.gg_dialog_content, null);
        setContentView(view);
        setCancelable(true);

        getWindow().setGravity(Gravity.CENTER_VERTICAL);
        tv_da_content = (TextView) findViewById(R.id.tv_da_content);
        tv_da_left_content = (TextView) findViewById(R.id.tv_da_left_content);
        tv_da_right_content = (TextView) findViewById(R.id.tv_da_right_content);
        ll_da_left_area = (LinearLayout) findViewById(R.id.ll_da_left_area);
        ll_da_left_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftClick(v);
            }
        });
        ll_da_right_area = (LinearLayout) findViewById(R.id.ll_da_right_area);
        ll_da_right_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightClick(v);
            }
        });
    }

    private void setTextView(String content, String leftContent, String rightContent) {
        tv_da_content.setText(content);
        tv_da_left_content.setText(leftContent);
        tv_da_right_content.setText(rightContent);
    }

    public abstract void leftClick(View view);

    public abstract void rightClick(View view);

    public void showDialog() {
        if (!isShowing())
            show();
    }

    public void closeDialog() {
        if (isShowing())
            cancel();
    }
}

package cn.heartonline.gg.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by gaohaoqing
 * Date : 16/3/5
 * Time : 15:16
 */
public abstract class TipDialog extends Dialog{
    private TextView tv_dat_content;
    private TextView tv_dat_right_content;

    private Context mContext;

    /**
     * 中间的TestView
     *
     * @return
     */
    public TextView getTv_dat_content() {
        return tv_dat_content;
    }

    /**
     * 右边的TestView
     *
     * @return
     */
    public TextView getTv_dat_right_content() {
        return tv_dat_right_content;
    }

    public TipDialog(Context context, String centerContent, String rightContent) {
        super(context, R.style.CenterDialog);
        init(context);
        setTextView(centerContent, rightContent);
    }

    public TipDialog(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init(context);
    }

    public TipDialog(Context context, int theme) {
        super(context, theme);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View view = View.inflate(mContext, R.layout.gg_dialog_tip, null);
        setContentView(view);
        setCancelable(true);

        getWindow().setGravity(Gravity.CENTER_VERTICAL);
        tv_dat_content = (TextView) findViewById(R.id.tv_dat_content);
        tv_dat_right_content = (TextView) findViewById(R.id.tv_dat_right_content);
        tv_dat_right_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightClick(v);
            }
        });
    }

    private void setTextView(String content, String rightContent) {
        tv_dat_content.setText(content);
        tv_dat_right_content.setText(rightContent);
    }

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

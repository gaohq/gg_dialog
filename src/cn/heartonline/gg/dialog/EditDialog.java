package cn.heartonline.gg.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by gaohaoqing
 * Date : 15/10/22
 * Time : 16:41
 */
public abstract class EditDialog extends Dialog {

    private Context mContext;

    private TextView tv_de_title;
    private TextView tv_de_left_content;
    private TextView tv_de_right_content;
    private EditText edt_de_content;
    private LinearLayout ll_de_cancel;
    private LinearLayout ll_de_confirm;


    public EditDialog(Context context, String leftButtonContent, String rightButtonContent, String hint) {
        super(context, R.style.CenterDialog);
        init();
        this.mContext = context;
        setDialogContent(leftButtonContent, rightButtonContent, hint);
    }

    public void setDialogContent(String leftButtonContent, String rightButtonContent, String hint) {
        tv_de_left_content.setText(leftButtonContent);
        tv_de_right_content.setText(rightButtonContent);
        edt_de_content.setHint(hint);
    }

    public EditDialog(Context context) {
        super(context);
        init();
        mContext = context;
    }

    public EditDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
        mContext = context;
    }

    public EditDialog(Context context, int theme) {
        super(context, theme);
        init();
        mContext = context;
    }

    private void init() {
        View view = View.inflate(getContext(), R.layout.gg_dialog_edit, null);
        setContentView(view);
        setCancelable(true);

        getWindow().setGravity(Gravity.CENTER_VERTICAL);

        //初始化控件
        tv_de_title = (TextView) findViewById(R.id.tv_de_title);
        tv_de_left_content = (TextView) findViewById(R.id.tv_de_left_content);
        tv_de_right_content = (TextView) findViewById(R.id.tv_de_right_content);
        edt_de_content = (EditText) findViewById(R.id.edt_de_content);
        ll_de_cancel = (LinearLayout) findViewById(R.id.ll_de_cancel);
        ll_de_confirm = (LinearLayout) findViewById(R.id.ll_de_confirm);

        ll_de_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftClickEvent();
            }
        });
        ll_de_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightClickEvent();
            }
        });
    }

    public EditText getEdt_de_content() {
        return edt_de_content;
    }

    public TextView getTv_de_right_content() {
        return tv_de_right_content;
    }

    public TextView getTv_de_title() {
        return tv_de_title;
    }

    public TextView getTv_de_left_content() {
        return tv_de_left_content;
    }

    protected abstract void rightClickEvent();

    protected abstract void leftClickEvent();

}

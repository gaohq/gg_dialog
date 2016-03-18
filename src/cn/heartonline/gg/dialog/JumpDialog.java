package cn.heartonline.gg.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Paint;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by gaohaoqing
 * Date : 16/3/17
 * Time : 19:09
 */
public abstract class JumpDialog extends Dialog {

    private Context mContext;

    private TextView tv_dj_title;
    private TextView tv_dj_one_error;
    private TextView tv_dj_jump;
    private TextView tv_dj_left_content;
    private TextView tv_dj_right_content;

    private EditText edt_dj_one_content;

    private LinearLayout ll_dj_cancel;
    private LinearLayout ll_dj_confirm;


    public JumpDialog(Context context) {
        super(context);
        init();
    }

    protected JumpDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    public JumpDialog(Context context, int theme) {
        super(context, theme);
        init();
    }


    private void init() {
        View view = View.inflate(getContext(), R.layout.gg_dialog_jump, null);
        setContentView(view);
        setCancelable(true);

        getWindow().setGravity(Gravity.CENTER_VERTICAL);

        tv_dj_title = (TextView) view.findViewById(R.id.tv_dj_title);
        tv_dj_jump = (TextView) view.findViewById(R.id.tv_dj_jump);
        tv_dj_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumpOnclick();
            }
        });
        tv_dj_one_error = (TextView) view.findViewById(R.id.tv_dj_one_error);
        tv_dj_left_content = (TextView) view.findViewById(R.id.tv_dj_left_content);
        tv_dj_right_content = (TextView) view.findViewById(R.id.tv_dj_right_content);
        edt_dj_one_content = (EditText) view.findViewById(R.id.edt_dj_one_content);
        ll_dj_cancel = (LinearLayout) view.findViewById(R.id.ll_dj_cancel);
        ll_dj_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftOnClick();
            }
        });
        ll_dj_confirm = (LinearLayout) view.findViewById(R.id.ll_dj_confirm);
        ll_dj_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rightOnclick();
            }
        });
    }

    public void setDialogContent(int title, int oneHint, int oneError, int jumpContent, int leftActionText, int rightActionText) {
        tv_dj_title.setText(title);
        tv_dj_jump.setText(jumpContent);
        tv_dj_jump.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        edt_dj_one_content.setHint(oneHint);
        tv_dj_one_error.setText(oneError);
        tv_dj_left_content.setText(leftActionText);
        tv_dj_right_content.setText(rightActionText);
    }

    public String getOneEditText() {
        return edt_dj_one_content.getText().toString();
    }


    protected abstract void leftOnClick();

    protected abstract void rightOnclick();

    protected abstract void jumpOnclick();

    public void showDialog() {
        if (!isShowing())
            show();
    }

    public void closeDialog() {
        if (isShowing())
            cancel();
    }
}

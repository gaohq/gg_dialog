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
 * Date : 16/3/17
 * Time : 19:09
 */
public abstract class ThreeEditDialog extends Dialog {

    private Context mContext;

    private String mPhoneCode;

    private TextView tv_dte_title;
    private TextView tv_dte_content;
    private TextView tv_dte_one_error;
    private TextView tv_dte_two_error;
    private TextView tv_dte_left_content;
    private TextView tv_dte_right_content;

    private EditText edt_dte_one_content;
    private EditText edt_dte_two_content;
    private EditText btn_dte_code;

    private LinearLayout ll_dte_cancel;
    private LinearLayout ll_dte_confirm;

    public ThreeEditDialog(Context context) {
        super(context);
        init();
    }

    protected ThreeEditDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    public ThreeEditDialog(Context context, int theme) {
        super(context, theme);
        init();
    }


    private void init() {
        View view = View.inflate(getContext(), R.layout.gg_dialog_three_edit, null);
        setContentView(view);
        setCancelable(true);

        getWindow().setGravity(Gravity.CENTER_VERTICAL);
        tv_dte_title = (TextView) view.findViewById(R.id.tv_dte_title);
        tv_dte_content = (TextView) view.findViewById(R.id.tv_dte_content);
        tv_dte_one_error = (TextView) view.findViewById(R.id.tv_dte_one_error);
        tv_dte_one_error.setVisibility(View.GONE);
        tv_dte_two_error = (TextView) view.findViewById(R.id.tv_dte_two_error);
        tv_dte_two_error.setVisibility(View.GONE);
        tv_dte_left_content = (TextView) view.findViewById(R.id.tv_dte_left_content);
        tv_dte_right_content = (TextView) view.findViewById(R.id.tv_dte_right_content);

        edt_dte_one_content = (EditText) view.findViewById(R.id.edt_dte_one_content);
        edt_dte_two_content = (EditText) view.findViewById(R.id.edt_dte_two_content);
        btn_dte_code = (EditText) view.findViewById(R.id.btn_dte_code);
        btn_dte_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendPhoneCode();
            }
        });

        ll_dte_cancel = (LinearLayout) view.findViewById(R.id.ll_dte_cancel);
        ll_dte_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftOnClick();
            }
        });
        ll_dte_confirm = (LinearLayout) view.findViewById(R.id.ll_dte_confirm);
        ll_dte_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rightOnclick();
            }
        });
    }

    public void setDialogContent(int title, int oneError, int twoError, int oneHintContent, int twoHintContent, int leftActionText, int rightActionText) {
        tv_dte_title.setText(title);
        tv_dte_one_error.setText(oneError);
        tv_dte_two_error.setText(twoError);
        edt_dte_one_content.setHint(oneHintContent);
        edt_dte_two_content.setHint(twoHintContent);
        tv_dte_left_content.setText(leftActionText);
        tv_dte_right_content.setText(rightActionText);
    }

    public String getOneEditText() {
        return edt_dte_one_content.getText().toString();
    }

    public String getTwoEditText() {
        return edt_dte_two_content.getText().toString();
    }

    public String getPhoneCode() {
        return mPhoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.mPhoneCode = phoneCode;
    }

    public TextView getOneError() {
        return tv_dte_one_error;
    }

    public TextView getTwoError() {
        return tv_dte_two_error;
    }

    protected abstract void leftOnClick();

    protected abstract void rightOnclick();

    protected abstract void sendPhoneCode();

    public void showDialog() {
        if (!isShowing())
            show();
    }

    public void closeDialog() {
        if (isShowing())
            cancel();
    }
}

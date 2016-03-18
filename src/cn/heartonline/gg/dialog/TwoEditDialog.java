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
public abstract class TwoEditDialog extends Dialog {

    private Context mContext;

    private TextView tv_dde_title;
    private TextView tv_dde_sub_title;
    private TextView tv_dde_one_error;
    private TextView tv_dde_two_error;
    private TextView tv_dde_left_content;
    private TextView tv_dde_right_content;

    private EditText edt_dde_one_content;
    private EditText edt_dde_two_content;

    private LinearLayout ll_dde_cancel;
    private LinearLayout ll_dde_confirm;


    public TwoEditDialog(Context context) {
        super(context);
        init();
    }

    protected TwoEditDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    public TwoEditDialog(Context context, int theme) {
        super(context, theme);
        init();
    }


    private void init() {
        View view = View.inflate(getContext(), R.layout.gg_dialog_double_edit, null);
        setContentView(view);
        setCancelable(true);

        getWindow().setGravity(Gravity.CENTER_VERTICAL);

        tv_dde_title = (TextView) view.findViewById(R.id.tv_dde_title);
        tv_dde_sub_title = (TextView) view.findViewById(R.id.tv_dde_sub_title);
        tv_dde_one_error = (TextView) view.findViewById(R.id.tv_dde_one_error);
        tv_dde_two_error = (TextView) view.findViewById(R.id.tv_dde_two_error);
        tv_dde_left_content = (TextView) view.findViewById(R.id.tv_dde_left_content);
        tv_dde_right_content = (TextView) view.findViewById(R.id.tv_dde_right_content);
        edt_dde_one_content = (EditText) view.findViewById(R.id.edt_dde_one_content);
        edt_dde_two_content = (EditText) view.findViewById(R.id.edt_dde_two_content);
        ll_dde_cancel = (LinearLayout) view.findViewById(R.id.ll_dde_cancel);
        ll_dde_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftOnClick();
            }
        });
        ll_dde_confirm = (LinearLayout) view.findViewById(R.id.ll_dde_confirm);
        ll_dde_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rightOnclick();
            }
        });
    }

    public void setDialogContent(int title, int subTitle, int oneHint, int twoHint, int oneError, int twoError, int leftActionText, int rightActionText) {
        tv_dde_title.setText(title);
        if(subTitle < 0){
            tv_dde_sub_title.setVisibility(View.GONE);
        }else{
            tv_dde_sub_title.setVisibility(View.VISIBLE);
        }
        tv_dde_sub_title.setText(subTitle);
        edt_dde_one_content.setHint(oneHint);
        edt_dde_two_content.setHint(twoHint);
        tv_dde_one_error.setText(oneError);
        tv_dde_two_error.setText(twoError);
        tv_dde_left_content.setText(leftActionText);
        tv_dde_right_content.setText(rightActionText);
    }

    public String getOneEditText() {
        return edt_dde_one_content.getText().toString();
    }

    public String getTwoEditText() {
        return edt_dde_two_content.getText().toString();
    }

    public TextView getOneErrorView() {
        return tv_dde_one_error;
    }

    public TextView getTwoErrorView() {
        return tv_dde_two_error;
    }
    public TextView getSubTitleView(){
        return tv_dde_sub_title;
    }

    protected abstract void leftOnClick();

    protected abstract void rightOnclick();

    public void showDialog() {
        if (!isShowing())
            show();
    }

    public void closeDialog() {
        if (isShowing())
            cancel();
    }
}

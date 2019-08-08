package mvpsample.tongzhang.com.mvpsample.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.blankj.utilcode.util.ConvertUtils;

import mvpsample.tongzhang.com.mvpsample.R;


public class WaitingDialog extends Dialog {

    public WaitingDialog(Context context) {
        super(context);
    }

    public WaitingDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected WaitingDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class Builder {
        private Context context;
        private String message;
        private boolean isCancelable = true;
        private boolean isCancelOutside = true;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setMessage(String str) {
            this.message = str;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.isCancelable = cancelable;
            return this;
        }

        public Builder setCancelOutside(boolean cancelOutside){
            this.isCancelOutside = cancelOutside;
            return this;
        }

        public WaitingDialog create() {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.dialog_waiting, null);
            WaitingDialog waitingDialog = new WaitingDialog(context);
            TextView msgText = (TextView) view.findViewById(R.id.tv_waiting);
            msgText.setText(message);
            waitingDialog.setContentView(view);
            waitingDialog.setCancelable(isCancelable);
            waitingDialog.setCanceledOnTouchOutside(isCancelOutside);
            return waitingDialog;
        }
    }

    @Override
    public void show() {
        super.show();
        final WindowManager.LayoutParams params = this.getWindow().getAttributes();
        params.width = ConvertUtils.dp2px(320);
        params.height = ConvertUtils.dp2px(148);
        this.getWindow().setAttributes(params);
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }
}

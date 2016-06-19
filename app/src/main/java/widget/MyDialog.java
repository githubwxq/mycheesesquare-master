package widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

import com.support.android.designlibdemo.R;

/**
 * Created by Administrator on 2016/6/19.
 */
public class MyDialog  extends Dialog{
    private Window window = null;
    public MyDialog(Context context) {
        super(context);
    }

    public MyDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public MyDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
    public void showDialog(int layoutResID, int x, int y){
        setContentView(layoutResID);

        windowDeploy(x, y);

        //设置触摸对话框意外的地方取消对话框
        setCanceledOnTouchOutside(true);
        show();
    }

    private void windowDeploy(int x, int y) {
       window=getWindow();
    window.setWindowAnimations(R.style.dialogWindowAnim);
        window.setBackgroundDrawableResource(R.color.vifrification);
        WindowManager.LayoutParams wl=window.getAttributes();

        wl.x = x; //x小于0左移，大于0右移
        wl.y = y; //y小于0上移，大于0下移
//            wl.alpha = 0.6f; //设置透明度
//            wl.gravity = Gravity.BOTTOM; //设置重力
        window.setAttributes(wl);
    }


//use for activity
//    public void useInActivity(){
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        final AlertDialog dialog = builder.create();
//        View view = View.inflate(this, R.layout.dialog, null);
//
//        dialog.setView(view, 0, 0, 0, 0);//
//
//        dialog.show();
//
//        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
//        params.width = 1000;
//        params.height = 800;
//        dialog.getWindow().setAttributes(params);
//
//
//    }
//



}

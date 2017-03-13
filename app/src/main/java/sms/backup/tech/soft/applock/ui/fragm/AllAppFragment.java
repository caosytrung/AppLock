package sms.backup.tech.soft.applock.ui.fragm;

import android.app.Application;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import sms.backup.tech.soft.applock.R;
import sms.backup.tech.soft.applock.contr.ProcessManager;
import sms.backup.tech.soft.applock.model.AppRunning;
import sms.backup.tech.soft.applock.ui.adapter.AllAppAdapter;

/**
 * Created by dee on 11/03/2017.
 */

public class AllAppFragment extends BaseFragment implements View.OnClickListener,Runnable {
    private RecyclerView rvAllApp;
    private AllAppAdapter mAdapter;
    private List<AppRunning> mAppRunnings;
    private android.os.Handler mHandler;




    @Override
    public View getViews(LayoutInflater inflater, ViewGroup viewGroup) {
        return inflater.inflate(R.layout.fragment_all_app,viewGroup,false);
    }

    @Override
    public void initViews(View view) {
        rvAllApp = (RecyclerView) view.findViewById(R.id.rvAllApp);
        rvAllApp.setItemAnimator(new SlideInLeftAnimator());
       rvAllApp.getItemAnimator().setRemoveDuration(50);



        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvAllApp.setLayoutManager(manager);
        rvAllApp.setAdapter(mAdapter);
        view.findViewById(R.id.btnDelete).setOnClickListener(this);

        mHandler = new android.os.Handler(new android.os.Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                mAdapter.remove(0);
                return false;
            }
        });
    }
    private List<AppRunning> apps;



    public List<AppRunning> getInfoApps() {

        apps = new ArrayList<>();
        List<ProcessManager.Process> processes = ProcessManager.getRunningApps();
        Log.d("AASDASD",processes.size() + " ");
        for (ProcessManager.Process process : processes) {
            String p = process.getPackageName();

            try {

                ApplicationInfo app = process.getApplicationInfo(getContext(), PackageManager.GET_META_DATA);
                if ((app.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {

                    AppRunning appRunning = new AppRunning();

                    String packageName = app.packageName;
                    String nameapp = getContext().getPackageManager().getApplicationLabel(app).toString();
                    int uid = app.uid;
                    Drawable icon = getContext().getPackageManager().getApplicationIcon(packageName);
                    appRunning.setName(nameapp);
                    appRunning.setPacketName(packageName);
                    appRunning.setIco(icon);
                    appRunning.setuId(uid);
                    apps.add(appRunning);

                }

            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }

        return apps;
    }

    @Override
    public void initComponents() {
        getInfoApps();
        apps.addAll(apps);
        mAdapter = new AllAppAdapter(getContext(),apps);



    }

    @Override
    public void setEventViews() {

    }

    @Override
    public void onClick(View v) {
        (new Thread(this)).start();
    }

    @Override
    public void run() {
        int i = apps.size();
        while (true){
            try {
                if (0== i){
                    return;
                }
                i--;
                Message message = new Message();
                message.setTarget(mHandler);
                message.sendToTarget();

                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

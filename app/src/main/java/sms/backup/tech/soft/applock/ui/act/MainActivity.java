package sms.backup.tech.soft.applock.ui.act;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sms.backup.tech.soft.applock.R;
import sms.backup.tech.soft.applock.ui.adapter.VpMainAdapter;
import sms.backup.tech.soft.applock.ui.fragm.AllAppFragment;
import sms.backup.tech.soft.applock.ui.fragm.SettingAppFragment;
import sms.backup.tech.soft.applock.ui.fragm.SystemAppFragment;
import sms.backup.tech.soft.applock.ui.fragm.UserAppFragment;

public class MainActivity extends BaseActivity {
    private TabLayout tbMain;
    private ViewPager vpMain;
    private VpMainAdapter mVpMainAdapter;




    @Override
    protected void initComponents() {
        mVpMainAdapter = new VpMainAdapter(getSupportFragmentManager());
        addFragment();

    }

    private void addFragment(){
        mVpMainAdapter.addFragment(new AllAppFragment());
        mVpMainAdapter.addFragment(new SystemAppFragment());
        mVpMainAdapter.addFragment(new UserAppFragment());
        mVpMainAdapter.addFragment(new SettingAppFragment());
    }

    @Override
    protected void initViews() {
        vpMain = (ViewPager) findViewById(R.id.vpMain);
        tbMain = (TabLayout) findViewById(R.id.tbMain);

        vpMain.setAdapter(mVpMainAdapter);


        tbMain.setupWithViewPager(vpMain);

    }

    @Override
    protected void setEventViews() {

    }

    @Override
    protected void setViewRoot() {
        setContentView(R.layout.activity_main);
    }
}

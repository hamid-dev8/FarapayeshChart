package com.dimache.farapayeshchart.base.baseComponents;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by User on 1/10/2018.
 */

public abstract class BaseActivity extends DaggerAppCompatActivity
{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    /**
     * add fragment to a container or replace an existing fragment that was added to a container.
     *
     * @param fragment The new fragment to place in the container.
     * @param tag Optional tag name for the fragment, to later retrieve the
     * fragment with {@link #getFragment(String)}
     * @param backStack Determina that fragment add to backstack  or not
     */
    public void addFragment(Fragment fragment, String tag, Boolean backStack, int containerViewId) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment, tag);
        if (backStack)
            fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commitAllowingStateLoss();
    }

    /**
     * remove an existing fragment that was added.
     *
     * @param fragment The existing fragment to remove.
     */
    public void removeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        getSupportFragmentManager().popBackStack();
    }

    /**
     * @return true if fragment by @param tag is available
     *
     * @param tag is tag name of fragment
     */
    public boolean isAvailableFragment(String tag) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        return (fragment != null);
    }

    /**
     * @return fragment added by @param tag
     * @return null if fragment not available
     *
     * @param tag is tag name of fragment
     */
    public Fragment getFragment(String tag) {
        if (isAvailableFragment(tag))
            return getSupportFragmentManager().findFragmentByTag(tag);
        else
            return null;
    }

   /* public void startLogin()
    {
        Intent loginIntent = new Intent(this, RegisterActivity.class);
        startActivityForResult(loginIntent, RegisterActivity.REQUEST);
    }*/

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RegisterActivity.REQUEST)
        {
            if (resultCode == RESULT_OK)
                login();
            else
                faildLogin();
        }

    }*/



   // public void login(){};
   // public void faildLogin(){};
}

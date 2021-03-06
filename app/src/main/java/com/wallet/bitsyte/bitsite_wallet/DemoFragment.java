package com.wallet.bitsyte.bitsite_wallet;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.FrameLayout;

import com.wallet.bitsyte.bitsite_wallet.Adapters.HomeAdapter;
import com.wallet.bitsyte.bitsite_wallet.ListObjects.WalletObject;

import java.util.ArrayList;

/**
 *
 */
public class DemoFragment extends Fragment {

    private FrameLayout fragmentContainer;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager,layoutManager2;

    /**
     * Create a new instance of the fragment
     */
    public static DemoFragment newInstance(int index) {
        DemoFragment fragment = new DemoFragment();
        Bundle b = new Bundle();
        b.putInt("index", index);
        fragment.setArguments(b);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getArguments().getInt("index", 0) == 0) {
            View view = inflater.inflate(R.layout.fragment_home, container, false);
            initHome(view);
            return view;
        } else if (getArguments().getInt("index", 0) == 1) {
            View view = inflater.inflate(R.layout.fragment_scan, container, false);
            initScan(view);
            return view;
        } else if (getArguments().getInt("index", 0) == 2) {
            View view = inflater.inflate(R.layout.fragment_send, container, false);
            initSend(view);
            return view;
        } else if (getArguments().getInt("index", 0) == 3) {
            View view = inflater.inflate(R.layout.fragment_settings, container, false);
            initDemoSettings(view);
            return view;
        } else {
            View view = inflater.inflate(R.layout.fragment_demo_list, container, false);
            initDemoList(view);
            return view;
        }
    }

    /**
     * Init demo settings
     */
    private void initDemoSettings(View view) {

        final MainActivity demoActivity = (MainActivity) getActivity();
        final SwitchCompat switchColored = (SwitchCompat) view.findViewById(R.id.fragment_demo_switch_colored);
        final SwitchCompat switchFiveItems = (SwitchCompat) view.findViewById(R.id.fragment_demo_switch_five_items);
        final SwitchCompat showHideBottomNavigation = (SwitchCompat) view.findViewById(R.id.fragment_demo_show_hide);
        final SwitchCompat showSelectedBackground = (SwitchCompat) view.findViewById(R.id.fragment_demo_selected_background);
        final SwitchCompat switchForceTitleHide = (SwitchCompat) view.findViewById(R.id.fragment_demo_force_title_hide);
        final SwitchCompat switchTranslucentNavigation = (SwitchCompat) view.findViewById(R.id.fragment_demo_translucent_navigation);

        //switchColored.setChecked(demoActivity.isBottomNavigationColored());
        //switchFiveItems.setChecked(demoActivity.getBottomNavigationNbItems() == 5);
        //switchTranslucentNavigation.setChecked(getActivity()
        //		.getSharedPreferences("shared", Context.MODE_PRIVATE)
        //		.getBoolean("translucentNavigation", false));
        //switchTranslucentNavigation.setVisibility(
        //		Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? View.VISIBLE : View.GONE);

		/*switchTranslucentNavigation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				getActivity()
						.getSharedPreferences("shared", Context.MODE_PRIVATE)
						.edit()
						.putBoolean("translucentNavigation", isChecked)
						.apply();
				demoActivity.reload();
			}
		});
		switchColored.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				demoActivity.updateBottomNavigationColor(isChecked);
			}
		});
		switchFiveItems.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				demoActivity.updateBottomNavigationItems(isChecked);
			}
		});
		showHideBottomNavigation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				demoActivity.showOrHideBottomNavigation(isChecked);
			}
		});
		showSelectedBackground.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				demoActivity.updateSelectedBackgroundVisibility(isChecked);
			}
		});
		switchForceTitleHide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				demoActivity.setForceTitleHide(isChecked);
			}
		});*/
    }

    /**
     * Init the fragment
     */
    private void initDemoList(View view) {

        fragmentContainer = (FrameLayout) view.findViewById(R.id.fragment_container);
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_demo_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<String> itemsData = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            itemsData.add("Fragment " + getArguments().getInt("index", -1) + " / Item " + i);
        }

        DemoAdapter adapter = new DemoAdapter(itemsData);
        recyclerView.setAdapter(adapter);
    }


    private RecyclerView recyclerView_home;
    private RecyclerView recyclerView_steps;
    private RecyclerView recyclerView_Settings;

    private void initHome(View view) {
        recyclerView_home = (RecyclerView) view.findViewById(R.id.fragment_home_recycler_view);
        recyclerView_home.setHasFixedSize(true);
        recyclerView_steps = (RecyclerView) view.findViewById(R.id.fragment_home_recycler_view2);
        recyclerView_steps.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager2 = new LinearLayoutManager(getActivity());
        recyclerView_home.setLayoutManager(layoutManager);
        recyclerView_steps.setLayoutManager(layoutManager2);

        ArrayList<WalletObject> itemsData = new ArrayList<>();

        WalletObject wO = new WalletObject("Wallet 1", "0.00 BTC", "1");
        itemsData.add(wO);
        Log.e("doo","kists");

        ArrayList<WalletObject> itemsData2 = new ArrayList<>();

        WalletObject Next = new WalletObject("Buy Amazon", "", "2");
        itemsData2.add(Next);
        WalletObject Next2 = new WalletObject("Add Visa Card", "", "3");
        itemsData2.add(Next2);
        WalletObject Next3 = new WalletObject("Buy or sell Bitcoins", "", "4");
        itemsData2.add(Next3);


        HomeAdapter adapter = new HomeAdapter(itemsData);
        recyclerView_home.setAdapter(adapter);

        HomeAdapter adapter2 = new HomeAdapter(itemsData2);
        recyclerView_steps.setAdapter(adapter2);

    }

    private void initScan(View view) {
        final MainActivity demoActivity = (MainActivity) getActivity();
        //demoActivity.QrScanner();

    }

    private void initSend(View view) {

    }

    private void initSettings(View view) {

    }


    /**
     * Refresh
     */
    public void refresh() {
        if (getArguments().getInt("index", 0) > 0 && recyclerView != null) {
            recyclerView.smoothScrollToPosition(0);
        }
    }

    /**
     * Called when a fragment will be displayed
     */
    public void willBeDisplayed() {
        // Do what you want here, for example animate the content
        if (fragmentContainer != null) {
            Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
            fragmentContainer.startAnimation(fadeIn);
        }
    }

    /**
     * Called when a fragment will be hidden
     */
    public void willBeHidden() {
        if (fragmentContainer != null) {
            Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
            fragmentContainer.startAnimation(fadeOut);
        }
    }
}
